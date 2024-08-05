package bibliotecaparte3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    // Constante que define o arquivo de credenciais
    private static final String CREDENTIALS_FILE = "credenciais.txt";
    // Lista para armazenar credenciais de funcionários
    private static List<String[]> funcionarios = new ArrayList<>();
    // Lista para armazenar credenciais de usuários
    private static List<String[]> usuarios = new ArrayList<>();
    // Variável que indica se o usuário logado é funcionário
    private static boolean isFuncionario;
    // Lista para armazenar os livros
    private static List<Livro> livros = new ArrayList<>();
    // Lista para armazenar os usuários (objeto Usuario)
    private static List<Usuario> usuariosLista = new ArrayList<>();
    // Lista para armazenar os empréstimos
    private static List<Emprestimo> emprestimos = new ArrayList<>();
    // Scanner para leitura de entrada do usuário
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tenta carregar as credenciais ao iniciar
        try {
            carregarCredenciais();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Chama o método de login
        login();

        int opcao;
        do {
            // Verifica o tipo de usuário logado e mostra o menu apropriado
            if (isFuncionario) {
                mostrarMenuFuncionario();
            } else {
                mostrarMenuUsuario();
            }
            // Lê a opção escolhida pelo usuário
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                // Processa a opção escolhida conforme o tipo de usuário
                if (isFuncionario) {
                    processarOpcaoFuncionario(opcao);
                } else {
                    processarOpcaoUsuario(opcao);
                }
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0); // Continua até que a opção de sair seja escolhida
    }

    // Método para carregar as credenciais do arquivo
    private static void carregarCredenciais() throws IOException {
        // Abre o arquivo de credenciais para leitura
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String linha;
            // Lê cada linha do arquivo
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em partes (tipo, username, password)
                String[] partes = linha.split(",");
                String tipo = partes[0];
                String username = partes[1];
                String password = partes[2];

                // Adiciona as credenciais à lista apropriada
                if (tipo.equals("funcionario")) {
                    funcionarios.add(new String[]{username, password});
                } else {
                    usuarios.add(new String[]{username, password});
                }
            }
        }
    }

    // Método para realizar o login
    private static void login() {
        // Loop até o login ser bem-sucedido
        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Verifica se as credenciais são válidas
            if (validarCredenciais(username, password, funcionarios)) {
                isFuncionario = true;
                System.out.println("Login successful!");
                break;
            } else if (validarCredenciais(username, password, usuarios)) {
                isFuncionario = false;
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
    }

    // Método para validar credenciais
    private static boolean validarCredenciais(String username, String password, List<String[]> lista) {
        // Verifica se as credenciais estão na lista fornecida
        for (String[] credenciais : lista) {
            if (credenciais[0].equals(username) && credenciais[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Mostra o menu para funcionários
    private static void mostrarMenuFuncionario() {
        System.out.println("Menu Funcionario:");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Realizar Empréstimo");
        System.out.println("4. Realizar Devolução");
        System.out.println("5. Listar Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Mostra o menu para usuários
    private static void mostrarMenuUsuario() {
        System.out.println("Menu Usuário:");
        System.out.println("1. Listar Livros");
        System.out.println("2. Realizar Empréstimo");
        System.out.println("3. Realizar Devolução");
        System.out.println("4. Listar Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Processa as opções do menu de funcionários
    private static void processarOpcaoFuncionario(int opcao) throws IOException {
        switch (opcao) {
            case 1:
                cadastrarLivro();
                break;
            case 2:
                cadastrarUsuario();
                break;
            case 3:
                realizarEmprestimo();
                break;
            case 4:
                realizarDevolucao();
                break;
            case 5:
                listarEmprestimos();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // Processa as opções do menu de usuários
    private static void processarOpcaoUsuario(int opcao) throws IOException {
        switch (opcao) {
            case 1:
                listarLivros();
                break;
            case 2:
                realizarEmprestimo();
                break;
            case 3:
                realizarDevolucao();
                break;
            case 4:
                listarEmprestimos();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // Método para cadastrar um novo livro
    private static void cadastrarLivro() throws IOException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Número de páginas: ");
        int paginas = scanner.nextInt();
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Livro livro = new Livro(id, titulo, area, autor, editora, ano, edicao, paginas, false);
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.salvar(livro);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    // Método para cadastrar um novo usuário
    private static void cadastrarUsuario() throws IOException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Tipo de Usuário (1-Aluno, 2-Professor, 3-Funcionário): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Usuario usuario;
        switch (tipo) {
            case 1:
                System.out.print("Curso: ");
                String curso = scanner.nextLine();
                System.out.print("Ano de Ingresso: ");
                int anoDeIngresso = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                usuario = new Estudante(id, nome, idade, sexo, telefone, curso, anoDeIngresso);
                break;
            case 2:
                System.out.print("Departamento: ");
                String departamento = scanner.nextLine();
                System.out.print("Especialização: ");
                String especializacao = scanner.nextLine();
                usuario = new Professor(id, nome, idade, sexo, telefone, departamento, especializacao);
                break;
            case 3:
                System.out.print("Setor: ");
                String setor = scanner.nextLine();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                usuario = new Funcionario(id, nome, idade, sexo, telefone, setor, cargo);
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usuario);
        usuariosLista.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Método para realizar um empréstimo
    private static void realizarEmprestimo() throws IOException {
        System.out.print("ID do Empréstimo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("ID do Livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Livro livro = new LivroDAO().ler(idLivro);
        Usuario usuario = new UsuarioDAO().ler(idUsuario);

        if (livro == null || usuario == null) {
            System.out.println("Livro ou Usuário não encontrado.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(id, LocalDate.now(), LocalTime.now(), livro, usuario);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimoDAO.salvar(emprestimo);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    // Método para realizar a devolução de um livro
    private static void realizarDevolucao() throws IOException {
        System.out.print("ID do Empréstimo: ");
        int idEmprestimo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        Emprestimo emprestimo = emprestimoDAO.ler(idEmprestimo);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = emprestimo.getLivro();
        livroDAO.atualizarStatus(livro.getId(), false);

        emprestimoDAO.excluir(idEmprestimo);
        emprestimos.remove(emprestimo);

        System.out.println("Devolução realizada com sucesso!");
    }

    // Método para listar todos os empréstimos
    private static void listarEmprestimos() {
        System.out.println("Lista de Empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    // Método para listar todos os livros
    private static void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}