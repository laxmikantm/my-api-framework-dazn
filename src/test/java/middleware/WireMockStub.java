package middleware;
/**************************
 *  (C) L Somni            *
 ***************************/

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;

import static Utils.Helper.LOCAL_URL;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static io.restassured.RestAssured.given;

public class WireMockStub {

    WireMockServer wireMockServer;


    public void setup () {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }

    public void setupStub() {
        wireMockServer.stubFor(get(urlEqualTo(LOCAL_URL))
                .willReturn(aResponse().withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBodyFile("data/met_Response.json")));
    }


    public void teardown () {
        wireMockServer.stop();
    }
}
