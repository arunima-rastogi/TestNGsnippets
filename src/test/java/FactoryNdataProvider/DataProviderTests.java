package FactoryNdataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/** Same class Dataprovider
 * 
 */
public class DataProviderTests {
	private int param;

	@Factory(dataProvider = "dataMethod")
	public DataProviderTests(int param) {
		this.param = param;
	}

	@DataProvider
	public static Object[][] dataMethod() {
		return new Object[][] { { 0 }, { 1 } };
	}

	@Test
	public void testMethodOne() {
		int opValue = param + 1;
		System.out.println("Test method one output: " + opValue);
	}


}