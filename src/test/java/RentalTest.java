import org.junit.Before;
import org.junit.Test;
import refactoring.Movie;
import refactoring.NewReleaseMovie;
import refactoring.RegularMovie;
import refactoring.Rental;

import static org.junit.Assert.assertEquals;

public class RentalTest {
    private Movie loveSimon;
    private Movie theRockyHorroPictureShow;

    private Rental loveSimonRental;
    private Rental theRockyHorroPictureShowRental;

    @Before
    public void setUp() {
        loveSimon = new NewReleaseMovie("Love Simon");
        theRockyHorroPictureShow = new RegularMovie("The Rocky Horror Picture Show");

        loveSimonRental = new Rental(loveSimon, 2);
        theRockyHorroPictureShowRental = new Rental(theRockyHorroPictureShow, 4);
    }

    @Test
    public void frequentRenterPointsUpdatesCorrectlyWithNewReleaseMovieRentedForMoreThanADay() {
        assertEquals(2, loveSimonRental.calculateFrequentRenterPoints(), 0.1);
    }

    @Test
    public void frequentRenterPointsUpdatesCorrectly() {
        assertEquals(1, theRockyHorroPictureShowRental.calculateFrequentRenterPoints(), 0.1);
    }

    @Test
    public void ShouldCalculateCorrectAmount() {
        assertEquals(6, loveSimon.calculateAmount(2), 0.1);
    }
}