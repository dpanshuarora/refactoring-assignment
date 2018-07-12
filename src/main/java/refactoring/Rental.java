package refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int updateFrequentRenterPoints(int frequentRenterPoints) {
        frequentRenterPoints++;
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

}
