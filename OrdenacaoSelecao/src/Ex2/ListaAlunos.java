package Ex2;

import java.util.ArrayList;

public class ListaAlunos {

    private ArrayList<Aluno> al = new ArrayList();

    public void cadastroAluno(Aluno al) {
        this.al.add(al);
    }

    public Aluno getAluno(int RA) {
        for (int i = 0; i != this.al.size(); i++) {
            if (this.al.get(i).getRa() == RA) {
                return this.al.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        for (int i = 0; i != this.al.size(); i++) {
            return "[" + this.al.get(i).getNome() + "";
        }
        return "";
    }
}
