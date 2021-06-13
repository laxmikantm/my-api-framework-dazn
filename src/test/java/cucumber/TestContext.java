package cucumber;
import io.restassured.response.Response;
import middleware.Controller;
import middleware.WireMockStub;

/**************************
 *  (C) L Somni            *
 ***************************/

public class TestContext {

	private Response response;
	private Controller controller;
	private WireMockStub wireMockStub;
	private boolean isMock;

	public TestContext() {
	}
	public Response getResponse() {
		return response;
	}
	public Controller getController() {return controller;}
	public WireMockStub getWireMockStub() { return wireMockStub;}
	public boolean isMock() {
		return isMock;
	}

	public void setMock(boolean mock) {
		isMock = mock;
	}
}