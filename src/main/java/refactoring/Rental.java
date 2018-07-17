package refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    private String getMovieTitle() {
        return movie.getTitle();
    }

    public double calculateAmount() {
        return movie.calculateAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        if (newReleaseMovieRentedForMoreThanADay())
            return 2;
        else
            return 1;
    }

    private boolean newReleaseMovieRentedForMoreThanADay() {
        return movie instanceof NewReleaseMovie && daysRented > 1;
    }

    public String generateStatementForThisRental() {
        return ("\t" + getMovieTitle() + "\t" + calculateAmount() + "\n");
    }

}
