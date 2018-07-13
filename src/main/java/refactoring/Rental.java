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

    public int updateFrequentRenterPoints(int frequentRenterPoints) {
        frequentRenterPoints++;
        frequentRenterPoints = addBonusPointsIfNewReleaseMovieRentedForMoreThanADay(frequentRenterPoints);
        return frequentRenterPoints;
    }

    private int addBonusPointsIfNewReleaseMovieRentedForMoreThanADay(int frequentRenterPoints) {
        if (movie instanceof NewReleaseMovie && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public String generateStatementForThisRental() {
        return ("\t" + getMovieTitle() + "\t" + calculateAmount() + "\n");
    }

}
