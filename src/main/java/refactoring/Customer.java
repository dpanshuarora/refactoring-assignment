package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generateStatement() {
        String statement = "Rental record for " + name + "\n";
        statement += generateStatementsForAllRentals();
        statement += "Amount owed is " + calculateTotalAmount() + "\n" +
                "You earned " + calculateFrequentRenterPointsForAllRentals() + " frequent renter points";

        return statement;
    }

    private String generateStatementsForAllRentals() {
        StringBuilder statementsForAllRentals = new StringBuilder();
        rentals.stream()
                .map(Rental::generateStatementForThisRental)
                .forEach(statementsForAllRentals::append);
        return statementsForAllRentals.toString();
    }

    private int calculateFrequentRenterPointsForAllRentals() {
        return rentals.stream()
                .mapToInt(Rental::calculateFrequentRenterPoints)
                .sum();
    }

    private double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::calculateAmount)
                .sum();
    }

}
