package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generateStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Rental record for " + name + "\n");
        rentals.stream().map(Rental::generateStatementForThisRental).forEach(statement::append);
        statement.append("Amount owed is " + calculateTotalAmount() + "\n" +
                "You earned " + calculateFrequentRenterPointsForAllRentals() + " frequent renter points");

        return statement.toString();
    }

    private int calculateFrequentRenterPointsForAllRentals() {
        return rentals.stream()
                .mapToInt(Rental::updateFrequentRenterPoints)
                .sum();
    }

    private double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::calculateAmount)
                .sum();
    }

}
