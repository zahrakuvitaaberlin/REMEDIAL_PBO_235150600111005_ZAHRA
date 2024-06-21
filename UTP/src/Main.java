package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Zahra Kuvita Aberlin", 10);
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("UTP ZAHRA KUVITA ABERLIN\n1. Login\n2. Register\n3. Exit");
            System.out.print("Pick your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Login to our system");
                    System.out.print("Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();

                    loggedInUser = cinema.authenticateUser(loginEmail, loginPassword);
                    if (loggedInUser != null) {
                        System.out.println("Login Success");
                        showDashboard(cinema, loggedInUser, scanner);
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                    break;

                case 2:
                    System.out.println("Register to our system");
                    System.out.print("Fullname: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    User newUser = new User(email, password, fullName, balance);
                    if (cinema.registerUser(newUser)) {
                        System.out.println("Successfully registered User!");
                    } else {
                        System.out.println("User registration failed.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showDashboard(Cinema cinema, User user, Scanner scanner) {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome " + user.getFullName() + " to " + cinema.getName() + "!");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Tampilkan Tiket milik Saya");
            System.out.println("3. Lihat Studio yang Ada");
            System.out.println("4. Lihat Detail Studio");
            System.out.println("5. Top Up Saldo");
            System.out.println("6. Exit Program");
            System.out.print("Pick your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter studio number: ");
                    int bookStudioNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter row (A-Z): ");
                    char row = scanner.nextLine().charAt(0);
                    System.out.print("Enter seat number: ");
                    int col = scanner.nextInt();
                    scanner.nextLine();  

                    if (cinema.bookTicket(user, bookStudioNumber, row, col)) {
                        System.out.println("Ticket booked successfully.");
                    } else {
                        System.out.println("Ticket booking failed.");
                    }
                    break;

                case 2:
                    user.displayAllTickets();
                    break;

                case 3:
                    cinema.displayListStudio();
                    break;

                case 4:
                    System.out.print("Enter studio number: ");
                    int studioNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    cinema.displayStudioDetail(studioNumber);
                    break;

                case 5:
                    System.out.println("Top Up saldo");
                    System.out.print("Masukkan saldo yang ingin ditopup : ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    user.setBalance(user.getBalance() + amount);
                    System.out.println("Top up berhasil");
                    System.out.println("Saldo sekarang : Rp "+ user.getBalance());
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
