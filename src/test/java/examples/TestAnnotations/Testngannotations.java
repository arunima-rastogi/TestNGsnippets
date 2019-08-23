package examples.TestAnnotations;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngannotations {

	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
	}

	@BeforeTest
	public void bt() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void bc() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("Before Method");
	}

	@Test
	public void t() {
		System.out.println("Test");
	}

	@Test(priority = 1)
	public void p1t() {
		System.out.println("Priority 1 test");
	}

	@Test(dependsOnMethods = "p1t")
	public void don() {
		System.out.println("Depends on");
	}

	@Test(enabled = false)
	public void ef() {
		System.out.println("This test will not be executed");
	}

	@Test(expectedExceptions = { IOException.class, ArithmeticException.class })
	public void ee() {
		System.out.println("Expected exception ");
		int x = 1 / 0;
	}

	@Test(expectedExceptions = { ArithmeticException.class }, expectedExceptionsMessageRegExp = ".*zero")
	public void eeRegex() {
		System.out.println("expected exception Message RegEx");
		int x = 1 / 0;
	}

	@Test(dependsOnMethods = "ee", alwaysRun = true)
	public void ar() {
		System.out.println("Always run");
	}

	@Test(description = "This is short description of test")
	public void des() {
		System.out.println("Test for short description");
	}

	@Parameters({ "suite-param" }) // to be executed from Annotationstestng.xml
	@Test
	public void parameterTest(@Optional("This is printed if executed from test") String param) {
		System.out.println("Parameter value is: " + param);
	}

	@Test(timeOut = 4)
	public void to() throws InterruptedException {
		Thread.sleep(3);
		// org.testng.internal.thread.ThreadTimeoutException: Method
		// examples.TestAnnotations.Testngannotations.to() didn't finish within the
		// time-out 1
		System.out.println("Timeout.... ");
	}

	@Test(dependsOnMethods = { "method2" }, ignoreMissingDependencies = true) // will execute if method are not defined
	public void dependencies() {
		System.out.println("Ignore dependencies.. ");
	}

	/**
	 * invocationTimeOut: This is a TestNG attribute that defines the maximum period
	 * of time that a test method with invocationCount should take to execute/invoke
	 * a test method. If the invocationTimeOut has reached before invoking the test
	 * method for invocationCount then an exception (ThreadTimeOutException) will be
	 * thrown.
	 * 
	 * @throws ThreadTimeoutException
	 */
	@Test(invocationCount = 4, invocationTimeOut = 1)
	public void invocationTimeout() throws InterruptedException {
		Thread.sleep(2);
		System.out.println("Invocation timeout exception ..");
	}

	@Test(invocationCount = 3, successPercentage=98)
	public void successpercentage() {
		System.out.println("Success percentage...");
		assertTrue(false);
	}
}
