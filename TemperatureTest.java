/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {


	// Test cases for getUnits(), one test case for each unit:
	@Test
	public void testGetUnitsCelsius() {
		Temperature temp = new Temperature(25.0, Temperature.Units.CELSIUS);	
		Temperature.Units expectedValue = Temperature.Units.CELSIUS;
		Temperature.Units actualValue = temp.getUnits();
		assertTrue("Method FAILS to retrieve the temperature in Celsius.", expectedValue == actualValue);
	}

	@Test
	public void testGetUnitsFahrenheit() {
		Temperature temp = new Temperature(25.0, Temperature.Units.FAHRENHEIT);
		Temperature.Units expectedValue = Temperature.Units.FAHRENHEIT;
		Temperature.Units actualValue = temp.getUnits();
		assertTrue("Method FAILS to retrieve the temperature in Fahrenheit", expectedValue == actualValue);
	}

	@Test
	public void testGetUnitsKelvin() {
		Temperature temp = new Temperature(25.0, Temperature.Units.KELVIN);
		Temperature.Units actualValue = temp.getUnits();
		Temperature.Units expectedValue = Temperature.Units.KELVIN;
		assertTrue("Method FAILS to retrieve the temperature in Kelvin", expectedValue == actualValue);
	}

	/* 1 basic test for getValue() should be enough, given that the conversions between the different temperature
	 * scales will be tested thoroughly. Therefore, a simple test case proved that (for a general case) getValue() functions
	 * correctly.
	 */
	// Test case for getValue():
	@Test
	public void testGetValue() {
		Temperature temp = new Temperature(25.0, Temperature.Units.CELSIUS);
		double expectedValue = 25.0;
		double actualValue = temp.getValue();
		assertEquals("Method FAILS to convert back from Kelvin to Celsius", expectedValue, actualValue, 0.000001);
	}

	// Basic test cases for the conversion between units:
	@Test
	public void convertCelsiusToKelvin() {
		Temperature temp = new Temperature(25.0, Temperature.Units.CELSIUS);
		temp.changeUnits(Temperature.Units.KELVIN);
		double expectedValue = 298.15;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Celsius to Kelvin", expectedValue, actualValue, 0.000001);
	}

	@Test
	public void convertCelsiusToFahrenheit() {
		Temperature temp = new Temperature(25.0, Temperature.Units.CELSIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue = 77;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Celsius to Fahrenheit", expectedValue, actualValue, 0.000001);
	}

	@Test
	public void convertKelvinToCelsius() {
		Temperature temp = new Temperature(350.0, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue = 76.85;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Kelvin to Celsius", expectedValue, actualValue, 0.000001);
	}

	@Test
	public void convertKelvinToFahrenheit() {
		Temperature temp = new Temperature(350.0, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue = 170.33;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Kelvin to Fahrenheit", expectedValue, actualValue, 0.000001);
	}

	@Test
	public void convertFahrenheitToCelsius() {
		Temperature temp = new Temperature(50.0, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue = 10.0;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Fahrenheit to Celsius", expectedValue, actualValue, 0.000001);
	}

	@Test
	public void convertFahrenheitToKelvin() {
		Temperature temp = new Temperature(120.0, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		double expectedValue = 322.038888;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Fahrenheit to Kelvin", expectedValue, actualValue, 0.000001);
	}

	// Extra test cases, to check for corner-values:

	// Create a Temperature object that would lead to a negative Kelvin
	// ..from Celsius
	@Test(expected = AssertionError.class)
	public void initializeBadCelsius() {
		Temperature temp = new Temperature(-274.0, Temperature.Units.CELSIUS);
		fail();
	}

	// ..from Fahrenheit
	@Test(expected = AssertionError.class)
	public void initializeBadFahrenheit() {
		Temperature temp = new Temperature(-460.0, Temperature.Units.FAHRENHEIT);
		fail();
	}

	// Trying to convert from a negative Kelvin temperature
	@Test(expected = AssertionError.class)
	public void convertNegativeKelvin() {
		Temperature temp = new Temperature(-10.0, Temperature.Units.KELVIN);
		fail();
	}

	/* Convert from Celsius and Fahrenheit values that would lead to a negative
	 * Kelvin
	 */

	// Convert from a Celsius temperature that would lead to a negative Kelvin
	@Test(expected = AssertionError.class)
	public void convertCelsiusToNegativeKelvin() {
		Temperature temp = new Temperature(-274.0, Temperature.Units.CELSIUS);
		temp.changeUnits(Temperature.Units.KELVIN);
		fail();
	}

	// Convert from a Fahrenheit temperature that would lead to a negative Kelvin
	@Test(expected = AssertionError.class)
	public void convertFahrenheitToNegativeKelvin() {
		Temperature temp = new Temperature(-460.0, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		fail();
	}

	// Check for thresholds between negative and positive values
	// Corner case: Test for -0.00001 Celsius
	// Convert from Kelvin to the first relevant negative Celsius value
	@Test
	public void convertKelvinToNearestNegativeCelsius() {
		Temperature temp = new Temperature(273.149999, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue =  -0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Celsius", expectedValue, actualValue, 0.000001);		
	}

	// Convert from Fahrenheit to the first relevant negative Celsius value
	@Test
	public void convertFahrenheitToNearestNegativeCelsius() {
		Temperature temp = new Temperature(31.999998, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue =  -0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Celsius", expectedValue, actualValue, 0.000001);		
	}

	// Corner case: Test for 0.00001 Celsius
	// Convert from Kelvin to the first relevant positive Celsius value
	@Test
	public void convertKelvinToNearestPositiveCelsius() {
		Temperature temp = new Temperature(273.150001, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue =  0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Celsius", expectedValue, actualValue, 0.000001);		
	}

	// Convert from Fahrenheit to the first relevant positive Celsius value
	@Test
	public void convertFahrenheitToNearestPositiveCelsius() {
		Temperature temp = new Temperature(32.000002, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.CELSIUS);
		double expectedValue =  0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Celsius", expectedValue, actualValue, 0.000001);		
	}

	// Corner case: Test for -0.00001 Fahrenheit
	// Convert from Kelvin to the first relevant negative Fahrenheit value
	@Test
	public void convertKelvinToNearestNegativeFahrenheit() {
		Temperature temp = new Temperature(255.372222, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue =  -0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Fahrenheit", expectedValue, actualValue, 0.000001);		
	}

	// Convert from Celsius to the first relevant negative Fahrenheit value
	@Test
	public void convertCelsiusToNearestNegativeFahrenheit() {
		Temperature temp = new Temperature(-17.777778, Temperature.Units.CELSIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue =  -0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Fahrenheit", expectedValue, actualValue, 0.000001);		
	}

	//Corner case: Test for 0.00001 Fahrenheit
	// Convert from Kelvin to the first relevant positive Fahrenheit value
	@Test
	public void convertKelvinToNearestPositiveFahrenheit() {
		Temperature temp = new Temperature(255.372223, Temperature.Units.KELVIN);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue =  0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Fahrenheit", expectedValue, actualValue, 0.000001);		
	}

	// Convert from Celsius to the first relevant positive Fahrenheit value
	@Test
	public void convertCelsiusToNearestPositiveFahrenheit() {
		Temperature temp = new Temperature(-17.777777, Temperature.Units.CELSIUS);
		temp.changeUnits(Temperature.Units.FAHRENHEIT);
		double expectedValue =  0.000001;
		double actualValue = temp.getValue();
		assertEquals("Failed conversion at thershold for Fahrenheit", expectedValue, actualValue, 0.000001);		
	}
}
