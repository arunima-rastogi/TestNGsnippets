package examples.IRetryAnalyzer;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TestsForRetryAnalyzer {
	@Test(retryAnalyzer = examples.IRetryAnalyzer.RetryAnalyzer.class)
	@RetryCountIfFailed(1)
	public void Test1() {
		assertTrue(false);
	}

}
