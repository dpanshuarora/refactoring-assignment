package refactoring;

public class RegularMovie extends Movie{
    private static final double DAYS_THRESHOLD = 2;
    private static final double REGULAR_PRICE = 2;
    private static final double EXTRA_DAYS_PRICE_FACTOR = 1.5;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int numberOfDaysRented) {
        double amount = REGULAR_PRICE;
        if (numberOfDaysRented > DAYS_THRESHOLD)
            amount += (numberOfDaysRented - DAYS_THRESHOLD) * EXTRA_DAYS_PRICE_FACTOR;
        return amount;
    }
}
