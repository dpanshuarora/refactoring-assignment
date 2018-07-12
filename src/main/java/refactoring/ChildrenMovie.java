package refactoring;

public class ChildrenMovie extends Movie {
    private static final double DAYS_THRESHOLD = 3;
    private static final double BASE_PRICE = 1.5;

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int numberOfDaysRented) {

        double amount = BASE_PRICE;
        if (numberOfDaysRented > DAYS_THRESHOLD)
            amount += (numberOfDaysRented - DAYS_THRESHOLD) * BASE_PRICE;
        return amount;
    }
}
