package bibliotecaparte3;

public class Estudante extends Usuario 
{
    private String curso;
    private int anoDeIngresso;

    public Estudante(int id, String nome, int idade, String sexo, String telefone, String curso, int anoDeIngresso) {
        super(id, nome, idade, sexo, telefone);
        this.curso = curso;
        this.anoDeIngresso = anoDeIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoDeIngresso() {
        return anoDeIngresso;
    }

    public void setAnoDeIngresso(int anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }
}