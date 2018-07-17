package com.thoughtworks.refactoring.movie;

import com.thoughtworks.refactoring.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Customer deepanshu;
    private Movie loveSimon;
    private Movie blueIsTheWarmestColor;
    private Movie theRockyHorroPictureShow;

    @Before
    public void setUp() {
        deepanshu = new Customer("Deepanshu");

        blueIsTheWarmestColor = new ChildrenMovie("Blue is The Warmest Color");
        loveSimon = new NewReleaseMovie("Love Simon");
        theRockyHorroPictureShow = new RegularMovie("The Rocky Horror Picture Show");
    }

    @Test
    public void calculateAmountWhenRegularMovieRentedForMoreThanTwoDays() {
        assertEquals(3.5, theRockyHorroPictureShow.calculateAmount(3), 0.10);
    }

    @Test
    public void calculateAmountWhenRegularMovieRentedForLessThanTwoDays() {
        assertEquals(2, theRockyHorroPictureShow.calculateAmount(1), 0.10);
    }

    @Test
    public void calculateAmountWhenNewReleaseMovieRented() {
        assertEquals(9, loveSimon.calculateAmount(3), 0.10);
    }

    @Test
    public void calculateAmountWhenChildrenMovieRentedForMoreThanThreeDays() {
        assertEquals(3, blueIsTheWarmestColor.calculateAmount(4), 0.10);
    }

    @Test
    public void calculateAmountWhenChildrenMovieRentedForLessThanThreeDays() {
        assertEquals(1.5, blueIsTheWarmestColor.calculateAmount(2), 0.10);
    }
}