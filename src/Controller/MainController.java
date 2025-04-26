package Controller;

import Model.Book;
import Model.User;
import Model.UserType;

import java.util.Scanner;

public class MainController {

    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("=== Sistema Biblioteca ===");
        System.out.println("1. Fazer Login");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                login();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }


    private static void showUserMenu() {
        System.out.println("\nBem-vindo, " + currentUser.getName());
        System.out.println("1. Listar Livros");
        System.out.println("2. Emprestar Livro");
        System.out.println("3. Devolver Livro");
        System.out.println("4. Meus Empréstimos");
        if (currentUser.getClassification() == UserType.ADMIN) {
            System.out.println("5. Cadastrar Livro");
            System.out.println("6. Cadastrar Usuário"); // <<< novo
            System.out.println("7. Listar Usuários");
        }
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                BookController.listBooks();
                break;
            case 2:
                loanBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                LoanController.LoanUser(currentUser);
                break;
            case 5:
                if (currentUser.getClassification() == UserType.ADMIN)
                    registerBook();
                break;
            case 6:
                if (currentUser.getClassification() == UserType.ADMIN)
                    registerUser();
                break;
            case 7:
                if (currentUser.getClassification() == UserType.ADMIN)
                    UserController.listUsers();
                break;
            case 0:
                currentUser = null;
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }


    private static void registerUser() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        System.out.print("Tipo (1 - ADMIN, 2 - COMUM): ");
        int typeOption = scanner.nextInt();
        scanner.nextLine();
        UserType type = typeOption == 1 ? UserType.ADMIN : UserType.COMUM;

        UserController.addUser(name, email, password, type);
    }

    private static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        User user = UserController.login(email, password);
        if (user != null) {
            currentUser = user;
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    private static void registerBook() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();

        // Correção aqui, utilizando o método generateId() para gerar um novo ID.
        int bookId = BookController.generateId();
        BookController.addBook(title, author);
    }

    private static void loanBook() {
        System.out.print("ID do livro para empréstimo: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        // Correção aqui para usar o método findById
        Book book = BookController.findById(bookId);

        if (book != null) {
            LoanController.registerLoan(currentUser, book);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void returnBook() {
        System.out.print("ID do empréstimo: ");
        int loanId = scanner.nextInt();
        scanner.nextLine();
        LoanController.returnLoan(loanId);
    }
}
