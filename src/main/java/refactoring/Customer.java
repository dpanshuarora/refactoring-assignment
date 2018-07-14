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
        int frequentRenterPoints = 0;
        double totalAmount = 0;
        StringBuilder statement = new StringBuilder();

        statement.append("Rental record for " + name + "\n");
        for (Rental rental : rentals) {
            double amount = rental.calculateAmount();

            frequentRenterPoints += rental.updateFrequentRenterPoints();
            statement.append(rental.generateStatementForThisRental());
            totalAmount += amount;
        }

        statement.append("Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points");

        return statement.toString();
    }

}
