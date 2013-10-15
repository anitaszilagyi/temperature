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
		Temperature temp = new Temperature(80.0, Temperature.Units.FAHRENHEIT);
		temp.changeUnits(Temperature.Units.KELVIN);
		double expectedValue = 299.82;
		double actualValue = temp.getValue();
		assertEquals("Failed to convert from Fahrenheit to Kelvin", expectedValue, actualValue, 0.000001);
	}
	
}
