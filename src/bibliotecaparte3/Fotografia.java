package bibliotecaparte3;

public class Fotografia extends Obra
{
    private int tamanho;
    private String resolução, formato;

    public Fotografia() {
    }

    public Fotografia(int tamanho, String resolução, String formato) {
        this.tamanho = tamanho;
        this.resolução = resolução;
        this.formato = formato;
    }

    public Fotografia(int tamanho, String resolução, String formato, String titulo, String area, String autores, String editora, int ano) {
        super(titulo, area, autores, editora, ano);
        this.tamanho = tamanho;
        this.resolução = resolução;
        this.formato = formato;
    }
    
    public void abrir()
    {
        System.out.println("A fotografia está sendo visualizada!");
    }
    
    public void fechar()
    {
        System.out.println("A visualização foi fechada!");
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getResolução() {
        return resolução;
    }

    public void setResolução(String resolução) {
        this.resolução = resolução;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}