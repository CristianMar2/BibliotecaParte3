package bibliotecaparte3;

import java.util.Date;

public class Trabalho 
{
    private long id;
    private int score, quantVotos;
    private Professor professor;
    private Estudante aluno;
    private Curso curso;
    private Faculdade faculdade;
    private String titTrabalho, localArquivo;
    private Date dataConclusao;

    public Trabalho() {
    }

    public Trabalho(long id, int score, int quantVotos, Professor professor, Estudante aluno, Curso curso, Faculdade faculdade, String titTrabalho, String localArquivo, Date dataConclusao) {
        this.id = id;
        this.score = score;
        this.quantVotos = quantVotos;
        this.professor = professor;
        this.aluno = aluno;
        this.curso = curso;
        this.faculdade = faculdade;
        this.titTrabalho = titTrabalho;
        this.localArquivo = localArquivo;
        this.dataConclusao = dataConclusao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuantVotos() {
        return quantVotos;
    }

    public void setQuantVotos(int quantVotos) {
        this.quantVotos = quantVotos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Estudante getAluno() {
        return aluno;
    }

    public void setAluno(Estudante aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public String getTitTrabalho() {
        return titTrabalho;
    }

    public void setTitTrabalho(String titTrabalho) {
        this.titTrabalho = titTrabalho;
    }

    public String getLocalArquivo() {
        return localArquivo;
    }

    public void setLocalArquivo(String localArquivo) {
        this.localArquivo = localArquivo;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}