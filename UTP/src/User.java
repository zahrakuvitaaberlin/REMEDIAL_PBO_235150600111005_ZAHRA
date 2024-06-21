package src;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String fullName;
    private double balance;
    private List<Ticket> ticketLists;
    public static final int MAX_TICKET = 20;

    public User(String email, String password, String fullName, double balance) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.ticketLists = new ArrayList<>(MAX_TICKET);
    }

    public boolean addTicket(Ticket ticket) {
        if (ticketLists.size() < MAX_TICKET && balance >= ticket.getPrice()) {
            ticketLists.add(ticket);
            balance -= ticket.getPrice();
            return true;
        }
        return false;
    }

    public void displayAllTickets() {
        for (Ticket ticket : ticketLists) {
            System.out.println(ticket.getTicketInfo());
        }
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
