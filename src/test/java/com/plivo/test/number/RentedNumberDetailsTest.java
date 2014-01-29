package com.plivo.test.number;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class RentedNumberDetailsTest extends AbstractTest {

	@Test
	public void test() {

		getParameters().put("number", "123456789");
		// Scanner scanner = new Scanner(System.in);
		// System.out.print("enter the rented number : ");

		// rentedNumber = scanner.nextLine();
		try {
			GenericResponse numberDetails = getRestApi().rentNumber(
					getParameters());
			Assert.assertNotNull(numberDetails.apiId);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}

	}
}
