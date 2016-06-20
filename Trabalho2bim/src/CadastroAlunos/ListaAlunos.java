package CadastroAlunos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaAlunos {

    private ArrayList<Aluno> alunos = new ArrayList();
    private ArrayList<Aluno> reprovados = new ArrayList();
    private ArrayList<Aluno> aprovados = new ArrayList();

    public ListaAlunos() {

    }

    public void adicionar(Aluno aluno) {

        alunos.add(aluno);

    }

    public void remover(Aluno aluno) {
        alunos.remove(aluno);
    }

    public int tamanhoLista() {
        return this.alunos.size();
    }

    public void listaTodos() {
        String mensagem = "", coisa = "";
        int j = 0;
        for (int i = 0; i != tamanhoLista(); i++) {

            double[] notas;

            System.out.println(coisa);

            notas = this.alunos.get(i).getNotas();

            mensagem = mensagem
                    + "\n Nome: " + this.alunos.get(i).getNome()
                    + "\n RA: " + this.alunos.get(i).getRA()
                    + "\n Notas: \n " + this.alunos.get(i).converteNotasString()
                    + "\n -------------------------------------- \n";

        }
        JOptionPane.showMessageDialog(null, mensagem);

    }

    public Aluno getAluno(int i) {
        return this.alunos.get(i);
    }

    public void setAluno(int i, Aluno aluno) {
        this.alunos.set(i, aluno);
    }

    public ArrayList<Aluno> getAlunosReprovados() {

        for (int i = 0; i != tamanhoLista(); i++) {
            double soma = 0.0;
            double resultado = 0.0;
            double notas[] = this.alunos.get(i).getNotas();
            for (int j = 0; j != notas.length; j++) {
                soma = soma + notas[j];
            }
            resultado = soma / notas.length;

            if (resultado < 6.0) {
                reprovados.add(this.alunos.get(i));
            }

        }
        return this.reprovados;
    }

    public ArrayList<Aluno> getAlunosAprovados() {

        for (int i = 0; i != tamanhoLista(); i++) {
            double soma = 0.0;
            double resultado = 0.0;
            double notas[] = this.alunos.get(i).getNotas();
            for (int j = 0; j != notas.length; j++) {
                soma = soma + notas[j];
            }
            resultado = soma / notas.length;

            System.out.println("Resultado: " + resultado);
            this.alunos.get(i).setMedia(resultado);

            if (resultado > 6.0) {
                aprovados.add(this.alunos.get(i));
            }
        }

        return this.aprovados;
    }

}
