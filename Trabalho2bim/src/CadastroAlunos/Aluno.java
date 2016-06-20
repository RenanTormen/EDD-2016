package CadastroAlunos;

import javax.swing.JOptionPane;

public class Aluno {

    private String nome;
    private int RA;
    private double[] notas = new double[4];
    private double media;

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Aluno() {

    }

    public String getNome() {

        return this.nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public int getRA() {

        return this.RA;

    }

    public void setRA(int RA) {

        this.RA = RA;
    }

    public double[] getNotas() {
        /*for(int i = 0; i != notas.length; i++){
        System.out.println(notas[i]);
    }*/
        return notas;
    }

    public void setNotas(double notas, int i) {
        this.notas[i] = notas;
    }

    public String converteNotasString() {
        String retorno = "";
        for (int i = 0; i != this.notas.length; i++) {
            retorno = retorno + String.valueOf(this.notas[i]) + " ";
        }
        return retorno;
    }

    @Override
    public String toString() {

        return "Nome: " + getNome() + " \n RA: " + getRA();

    }
}
