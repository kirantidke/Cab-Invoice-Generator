package com.bridgelabz;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceServiceTest 
{
	 CabInvoiceService cabInvoiceService = new CabInvoiceService();

	    @Test
	    public void givenDistanceAndTime_shouldReturn_totalFare(){
	        double  distance = 5.0;
	        int time = 15;
	        double fare = cabInvoiceService.calculatorFare(distance, time);
	        Assert.assertEquals(65,fare,0.0);
	    }
	    @Test
	    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
	        double distance = 0.1;
	        int time = 2;
	        double fare = cabInvoiceService.calculatorFare(distance, time);
	        Assert.assertEquals(5, fare,0.0);
	    }
}
