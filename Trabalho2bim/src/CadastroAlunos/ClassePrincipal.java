/*

Unipar - Universidade Paranaense
Aluno: Renan de Oliveira Tormen
Turma: 2º Ano - Sistemas de informação
Estrutura e Classificação de dados - Trabalho bimestral referente ao segundo bimestre.

 */
package CadastroAlunos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClassePrincipal {

    static ListaAlunos alunos = new ListaAlunos();

    public static void main(String[] args) {

        String jop = JOptionPane.showInputDialog(null,
                "Digite a opção desejada: "
                + " \n 1 - Cadastro de Aluno"
                + " \n 2 - Cadastro de Notas por Aluno"
                + " \n 3 - Listar todos os alunos"
                + " \n 4 - Listar alunos Reprovados"
                + " \n 5 - Listar alunos Aprovados"
                + " \n 6 - Pesquisar aluno por nome"
                + " \n 7 - Sair da aplicação"
                + " \n ", "Seleção de opções", 1);

        switch (jop) {
            case "1":
                alunos.adicionar(cadastrarAluno());
                main(args);
            case "2":
                int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno: "));
                //buscaBinariaporRA(ra);
                cadastrarNotas(ra);
                main(args);
                ;
            case "3":
                alunos.listaTodos();
                main(args);
                ;
            case "4":
                ArrayList<Aluno> reprovados;

                reprovados = alunos.getAlunosReprovados();
                String mensagem = " ";
                for (int i = 0; i != reprovados.size(); i++) {
                    mensagem = mensagem + "Aluno: " + reprovados.get(i).getNome() + " Com a média de: " + reprovados.get(i).getMedia();
                }
                JOptionPane.showMessageDialog(null, "Alunos Reprovados: " + mensagem);
                reprovados.removeAll(reprovados);
                main(args);
                ;
            case "5":

                ArrayList<Aluno> aprovados;

                aprovados = alunos.getAlunosAprovados();
                String mensagem2 = "";
                for (int i = 0; i != aprovados.size(); i++) {
                    mensagem2 = mensagem2 + "Aluno: " + aprovados.get(i).getNome() + " Com a média de: " + aprovados.get(i).getMedia();
                }
                JOptionPane.showMessageDialog(null, "Alunos Aprovados: " + mensagem2);
                aprovados.removeAll(aprovados);
                main(args);

                ;
            case "6":
                String nome = JOptionPane.showInputDialog("Digite o nome do aluno a ser procurado: ");
                buscaNome(nome);
                main(args);
                ;
            case "7":
                System.exit(1);
                ;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                main(args);
        }
    }

    public static void buscaNome(String nome) {

        for (int i = 0; i != alunos.tamanhoLista(); i++) {
            if (alunos.getAluno(i).getNome().equals(nome)) {
                JOptionPane.showMessageDialog(null, "O Aluno: " + alunos.getAluno(i).getNome() + " Foi encontrado. Seu RA é :" + alunos.getAluno(i).getRA());
                i = alunos.tamanhoLista() - 1;
            } else {

                JOptionPane.showMessageDialog(null, "O aluno não foi encontrado");
            }
        }
    }

    public static Aluno cadastrarAluno() {
        Aluno c = new Aluno();
        c.setNome(JOptionPane.showInputDialog("Digite o nome do aluno: "));
        c.setRA(Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno: ")));
        JOptionPane.showMessageDialog(null, "O aluno: " + c.getNome() + " com o RA: " + c.getRA() + " Foi cadastrado com sucesso!");
        return c;
    }

    public static int buscaBinariaporRA(int ra) {

        ordenarAlunos();
        boolean executa = false;
        int esquerda = 0;
        int direita = alunos.tamanhoLista() - 1;
        int meio;
        int retorno = 0;

        while (executa == false) {
            //System.out.println("TESTE LOOP");

            meio = (esquerda + direita) / 2;

            if (ra == alunos.getAluno(meio).getRA()) {
                //System.out.println("NO MEIO CARALHO");
                return meio;
            } else if (ra < alunos.getAluno(meio).getRA()) {
                //System.out.println(" ERROU VEIO PRA ESQUERDA ");
                direita = meio - 1;
            } else if (ra > alunos.getAluno(meio).getRA()) {
                //System.out.println(" ERROU VEIO PRA dIREITA ");
                esquerda = meio + 1;
            }

        }
        return -1;
    }

    public static void ordenarAlunos() {

        Aluno aux = null;

        for (int i = 0; i != alunos.tamanhoLista() - 1; i++) {
            for (int j = 0; j != alunos.tamanhoLista() - 1; j++) {
                if (alunos.getAluno(j).getRA() > alunos.getAluno(j + 1).getRA()) {
                    aux = alunos.getAluno(j);
                    alunos.setAluno(j, alunos.getAluno(j + 1));
                    alunos.setAluno(j + 1, aux);
                }
            }

            //     alunos.listaTodos();
        }
    }

    public static void cadastrarNotas(int ra) {

        double nota;
        int bimestre;
        int busca = buscaBinariaporRA(ra);
        System.out.println("Busca:" + busca);

        bimestre = Integer.parseInt(JOptionPane.showInputDialog("Em qual bimestre deseja lançar a nota? (1,2,3,4)"));
        nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota desejada: "));
        alunos.getAluno(busca).setNotas(nota, (bimestre - 1));

        System.out.println("Aluno: " + alunos.getAluno(busca).getNome() + " Notas: " + alunos.getAluno(busca).getNotas());
    }
}
