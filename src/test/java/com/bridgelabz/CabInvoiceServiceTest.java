package com.bridgelabz;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceServiceTest {
	CabInvoiceService cabInvoiceService = new CabInvoiceService();

	@Before
	public void setUp() {
		cabInvoiceService = new CabInvoiceService();
	}

	@Test
	public void givenDistanceAndTime_shouldReturn_totalFare() {
		double distance = 5.0;
		int time = 15;
		double fare = cabInvoiceService.calculatorFare(distance, time);
		Assert.assertEquals(65, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 2;
		double fare = cabInvoiceService.calculatorFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1), new Ride(4.1, 25) };
		double totalFare = cabInvoiceService.calculateFareForMultipleRides(rides);
		Assert.assertEquals(96, totalFare, 0);
	}

	@Test
    public void givenUserIdAndRide_shouldReturnInvoiceSummary() {
        String userId = "adsure@gmail.com";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(4.1, 25)
        };
        cabInvoiceService.addRides(userId);
        InvoiceSummary invoiceSummary = cabInvoiceService.getInvoiceSummary(rides);
        InvoiceSummary fare = new InvoiceSummary(3, 96);
        Assert.assertEquals(fare, invoiceSummary);
        Assert.assertEquals(rides.length, cabInvoiceService.getRidesByUserId(userId).size());
    }
}
