package refactoring;

public class ChildrenMovie extends Movie{
    private static final double DAYS_THRESHOLD = 3;
    private static final double REGULAR_PRICE = 1.5;
    private static final double EXTRA_DAYS_PRICE_FACTOR = 1.5;

    public ChildrenMovie(String title) {
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
