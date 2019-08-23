package FactoryNdataProvider;

import org.testng.annotations.Test;

/**
 * Dataprovider for this class is defined in DataProviderClass.class
 *
 */
public class TestClass {
	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void testMethod(String data) {
		System.out.println("Data is: " + data);
	}
}