package bibliotecaparte3;

public abstract class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String telefone;

    // Construtor
    public Usuario(int id, String nome, int idade, String sexo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método adicional
    public void lerLivro() {
        System.out.println("O usuário está lendo o livro.");
    }
}