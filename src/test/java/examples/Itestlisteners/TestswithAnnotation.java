package examples.Itestlisteners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ProgressReporter.class)
public class TestswithAnnotation {

	@Test
	public void Test1() {
		System.out.println("Test1 passed");
	}

	@Test
	public void TestLongDuration() {
		for(int i=0; i<100000; i++) {
			System.out.println("running");
		}
	}

	
	@Test
	public void Test2() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods="Test2")
	public void Test3() {
		Assert.assertTrue(false);
	}
	
}