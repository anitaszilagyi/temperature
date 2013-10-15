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
		assertTrue("Method FAILS to retrieve the temperature in Celsius.", Temperature.Units.CELSIUS == temp.getUnits() );
	}

	@Test
	public void testGetUnitsFahrenheit() {
		Temperature temp = new Temperature(25.0, Temperature.Units.FAHRENHEIT);
		assertTrue("Method FAILS to retrieve the temperature in Fahrenheit", Temperature.Units.FAHRENHEIT == temp.getUnits() );
	}

	@Test
	public void testGetUnitsKelvin() {
		Temperature temp = new Temperature(25.0, Temperature.Units.KELVIN);
		assertTrue("Method FAILS to retrieve the temperature in Kelvin", Temperature.Units.KELVIN == temp.getUnits() );
	}
	
	/* 1 basic test for getValue() should be enough, given that the conversions between the different temperature
	 * scales will be tested thoroughly. Therefore, a simple test case proved that (for a general case) getValue() functions
	 * correctly.
	 */
	// Test case for getValue():
	@Test
	public void testGetValue() {
		Temperature temp = new Temperature(25.0, Temperature.Units.CELSIUS);
		double expected = 25.0;
		double actual = temp.getValue();
		assertEquals("Method FAILS to convert back from Kelvin to Celsius", expected, actual, 0.000001);
	}
}