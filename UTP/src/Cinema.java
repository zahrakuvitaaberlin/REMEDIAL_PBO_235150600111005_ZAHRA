package src;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private List<User> listUsers;
    private List<Studio> listStudio;
    private int studioCapacity;

    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new ArrayList<>();
        this.listStudio = new ArrayList<>(studioCapacity);
        init();
    }

    public void init() {
        addStudioWithMovies("Imax", "Inception", 9.5, new String[]{"Action", "Thriller", "Science Fiction"});
        addStudioWithMovies("Premiere", "The Godfather", 9.2, new String[]{"Crime", "Drama"});
        addStudioWithMovies("Reguler", "Toy Story", 8.3, new String[]{"Animation", "Adventure"});
        addStudioWithMovies("Imax", "Avengers: Endgame", 8.4, new String[]{"Action", "Adventure", "Science Fiction"});
        addStudioWithMovies("Premiere", "Titanic", 7.8, new String[]{"Romance", "Drama"});
        addStudioWithMovies("Reguler", "Frozen", 7.5, new String[]{"Animation", "Family", "Musical"});
        addStudioWithMovies("Imax", "Jurassic Park", 8.1, new String[]{"Adventure", "Science Fiction"});
        addStudioWithMovies("Premiere", "The Dark Knight", 9.0, new String[]{"Action", "Crime", "Drama"});
        addStudioWithMovies("Reguler", "Finding Nemo", 8.1, new String[]{"Animation", "Adventure"});
        addStudioWithMovies("Imax", "Interstellar", 8.6, new String[]{"Adventure", "Drama", "Science Fiction"});
    }

    public boolean registerUser(User user) {
        return listUsers.add(user);
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudio() {
        System.out.println("List Studio");
        for (int i = 0; i < listStudio.size(); i++) {
            Studio studio = listStudio.get(i);
            System.out.println("Studio : " + (i + 1));
            System.out.println("Type : " + studio.getType());
            System.out.println("Movie : " + studio.getMovie().getTitle());
            System.out.println("---------------------------------------------------------");
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            Studio studio = listStudio.get(studioNumber - 1);
            System.out.println(studio.getStudioInfo());
        } else {
            System.out.println("Invalid studio number.");
        }
    }

    public boolean addStudioWithMovies(String studioType, String movieTitle, double movieRating, String[] movieGenres) {
        if (listStudio.size() < studioCapacity) {
            Movie movie = new Movie(movieTitle, movieRating, movieGenres);
            Studio studio = new Studio(studioType);
            studio.setMovie(movie);
            listStudio.add(studio);
            return true;
        }
        return false;
    }

    public boolean bookTicket(User user, int studioNumber, char row, int col) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            Studio studio = listStudio.get(studioNumber - 1);
            if (studio.reserve(row, col)) {
                Ticket ticket = new Ticket(studio.getMovie(), studioNumber, row, col);
                return user.addTicket(ticket);
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
