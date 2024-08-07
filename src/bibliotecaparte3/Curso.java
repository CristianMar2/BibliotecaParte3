package bibliotecaparte3;

public class Curso 
{
    private AreaConhecimento areaConhecimento;
    private int codCurso;
    private String tituloCurso;

    public Curso(AreaConhecimento areaConhecimento, int codCurso, String tituloCurso) {
        this.areaConhecimento = areaConhecimento;
        this.codCurso = codCurso;
        this.tituloCurso = tituloCurso;
    }

    public Curso() {
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }
}