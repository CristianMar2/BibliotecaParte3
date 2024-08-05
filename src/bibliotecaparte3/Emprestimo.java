package bibliotecaparte3;

import bibliotecaparte3.Livro;
import bibliotecaparte3.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimo {

    private int id;
    private LocalDate dataDoEmprestimo;
    private LocalTime horaDoEmprestimo;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(int id, LocalDate dataDoEmprestimo, LocalTime horaDoEmprestimo, Livro livro, Usuario usuario) {
        this.id = id;
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.horaDoEmprestimo = horaDoEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public void setDataDoEmprestimo(LocalDate dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public LocalTime getHoraDoEmprestimo() {
        return horaDoEmprestimo;
    }

    public void setHoraDoEmprestimo(LocalTime horaDoEmprestimo) {
        this.horaDoEmprestimo = horaDoEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}