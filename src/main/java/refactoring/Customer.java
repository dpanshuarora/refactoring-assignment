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
        StringBuilder amountForThisRental = new StringBuilder();

        statement.append("Rental record for " + name + "\n");
        for (Rental rental : rentals) {
            double amount = rental.calculateAmount();

            frequentRenterPoints = rental.updateFrequentRenterPoints(frequentRenterPoints);
            amountForThisRental.append("\t" + rental.getMovieTitle() + "\t" + amount + "\n");
            totalAmount += amount;
        }

        statement.append(amountForThisRental +
                "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points");

        return statement.toString();
    }
}
