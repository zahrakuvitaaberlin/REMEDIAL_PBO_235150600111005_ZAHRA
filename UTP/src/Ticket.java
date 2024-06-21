package src;
public class Ticket {
    private Movie movie;
    private int studioNumber;
    private double price;
    private String seat;

    public Ticket(Movie movie, int studioNumber, char row, int col) {
        this.movie = movie;
        this.studioNumber = studioNumber;
        this.price = Studio.getTicketPrice(movie.getTitle());
        this.seat = "" + row + col;
    }

    // 
    public String getTicketInfo() {
        return String.format("Studio Number: %d\nMovie Name: %s\nPrice: %.2f\nSeat: %s",
                studioNumber, movie.getTitle(), price , seat);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStudioNumber() {
        return studioNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getSeat() {
        return seat;
    }
}
