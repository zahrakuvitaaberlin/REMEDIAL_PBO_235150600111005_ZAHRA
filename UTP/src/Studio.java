package src;
public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    public Studio(String type) {
        this.type = type;
        setSeats();
    }

    public int isBooked(char row, int col) {
        int rowIndex = row - 'A';
        if (rowIndex < 0 || rowIndex >= seats.length || col < 0 || col >= seats[0].length) {
            return -1;
        }
        return seats[rowIndex][col] ? 1 : 0;
    }

    public String getStudioInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Movie: ").append(movie.getTitle()).append("\n");
        info.append("Type: ").append(type).append("\n");
        info.append("Price: ").append(Studio.getTicketPrice(movie.getTitle())).append("\n");
        info.append("Seats: \n");
        info.append("- | 1 | 2 | 3 | 4 |\n");
        for (int i = 0; i < seats.length; i++) {
            info.append((char) ('A' + i)).append(" |");
            for (int j = 1; j < seats[i].length; j++) {
                info.append(seats[i][j] ? " X |" : " O |");
            }
            info.append("\n");
        }
        return info.toString();
    }

    public boolean reserve(char row, int col) {
        int rowIndex = row - 'A';
        if (rowIndex >= 0 && rowIndex < seats.length && col >= 0 && col < seats[0].length && !seats[rowIndex][col]) {
            seats[rowIndex][col] = true;
            return true;
        }
        return false;
    }

    private void setSeats() {
        switch (type) {
            case "Imax":
                seats = new boolean[8][10];
                break;
            case "Premiere":
                seats = new boolean[6][5];
                break;
            case "Reguler":
                seats = new boolean[5][6];
                break;
            default:
                throw new IllegalArgumentException("Invalid studio type");
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getType() {
        return type;
    }

    public void setSeats(boolean[][] seats) {
        this.seats = seats;
    }

    public static double getTicketPrice(String type) {
        switch (type) {
            case "Imax":
                return 100.0;
            case "Premiere":
                return 120.0;
            case "Reguler":
                return 50.0;
            default:
                return 120.0;
        }
    }
}
