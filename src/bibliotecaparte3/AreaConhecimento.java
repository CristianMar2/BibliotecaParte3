package bibliotecaparte3;

public class AreaConhecimento
{
    private int codigo;
    private String titulo;

    public AreaConhecimento(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public AreaConhecimento() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}