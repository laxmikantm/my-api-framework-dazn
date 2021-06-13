package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**************************
 *  (C) L Somni            *
 ***************************/

public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		this.testContext = context;
	}

	//TODO: Implement Wiremock server start and stop through cucumber hook implementation

	@Before
	public void BeforeSteps() {
//		testContext.getWireMockStub().setup();
	}
 
	@After
	public void AfterSteps() {
//		testContext.getWireMockStub().teardown();
	}
}
