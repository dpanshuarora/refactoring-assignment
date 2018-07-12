package refactoring;

public class NewReleaseMovie extends Movie {
    private static final double BASE_PRICE = 3;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int numberOfDaysRented) {
        return numberOfDaysRented * BASE_PRICE;
    }
}
