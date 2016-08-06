package Ex2;

import java.util.ArrayList;

public class ListaAlunos {

    private ArrayList<Aluno> al = new ArrayList();

    public void cadastroAluno(Aluno al) {
        this.al.add(al);
    }

    public Aluno getAluno(int RA) {
        for (int i = 0; i < this.al.size(); i++) {
            if (this.al.get(i).getRa() == RA) {
                return this.al.get(i);
            }
        }
        return null;
    }

    public int tamanhoLista() {
        return this.al.size();
    }

    public String tst() {
        String s = "";
        int i = 0;
        while (this.al.iterator().hasNext() && i != al.size()) {
            s += this.al.get(i).getNome();
            i++;
        }

        return s;
    }

    public Aluno getLista(int i) {
        return al.get(i);
        }
    }

