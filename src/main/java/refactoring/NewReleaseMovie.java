package refactoring;

public class NewReleaseMovie extends Movie{
    private static final double NEW_RELEASE_PRICE_FACTOR = 3;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int numberOfDaysRented) {
        return numberOfDaysRented * NEW_RELEASE_PRICE_FACTOR;
    }
}
