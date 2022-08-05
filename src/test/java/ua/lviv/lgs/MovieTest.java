package ua.lviv.lgs;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class MovieTest {

	public Movie movie;
	
	@Rule
	public TestWatcher testWathcer = new TestWatcher() {
		protected void succeed(org.junit.runner.Description description) {
			System.out.println("Executing " + description.getMethodName() + "...SUCCEED!");
		};
		
		protected void failed(Throwable exception, org.junit.runner.Description description) {
			System.out.println("Executing " + description.getMethodName() + "...FAILED!");
		};
	};
	
	@Before
	public void beforeTest() {
		Time time = new Time(20,10);
		movie = new Movie("Test", time);
	}
	
	@After
	public void afterTest() {
		movie = null;
	}
	
	@Test
	public void getTitle() {
		String realData = movie.getTitle();
		String expectedValue = "Test";
//		String expectedValue = "Test2"; Failed
		Assert.assertEquals(realData, expectedValue);
	}
	
}
