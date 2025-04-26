package Controller;

import Model.Book;
import Model.Loan;
import Model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanController {
    private static List<Loan> loans = new ArrayList<>();
    private static int nextId = 0;

    public static void registerLoan(User user, Book book) {
        if (!book.isAvailable()) {
            System.out.println("Livro indisponível.");
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(15);

        Loan loan = new Loan(user, book, today, returnDate);
        loan.setId(nextId++);
        loans.add(loan);

        book.setAvailable(false);
        System.out.println("Registro de empréstimo efetuado com sucesso.");
    }

    public static void listLoans() {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    public static void LoanUser(User user) {
        for (Loan loan : loans) {
            if (loan.getUser().equals(user)) {
                System.out.println(loan);
            }
        }
    }

    public static boolean returnLoan(int loanID) {
        for (Loan loan : loans) {
            if (loan.getId() == loanID) {
                loan.getBook().setAvailable(true);
                loans.remove(loan);
                System.out.println("Livro devolvido.");
                return true;
            }
        }
        System.out.println("Empréstimo não encontrado.");
        return false;
    }

    public static void listOverdueLoans() {
        LocalDate today = LocalDate.now();
        for (Loan loan : loans) {
            if (loan.getReturnDate().isBefore(today)) {
                System.out.println("📌 Empréstimo atrasado: " + loan);
            }
        }
    }
}
