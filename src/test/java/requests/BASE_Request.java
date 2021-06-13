package requests;
/**************************
 *  (C) L Somni            *
 ***************************/

import Utils.Helper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;


public class BASE_Request {
    RequestSpecification httpRequest = RestAssured.given();
    Response response;

    public void chooseEndPoint() {
        httpRequest.baseUri(Helper.URL);
    }

    public void chooseEndPoint(final String sEndPoint) {
        switch (sEndPoint.toLowerCase()){
            case "base-postcode-check" : httpRequest.baseUri(Helper.URL + Helper.API);
                break;
            default: throw new Helper.ConfigurationException("ERROR: Invalid Endpoint supplied");
        }
    }

    public Response getRequest() {
        Response request = httpRequest.request(Method.GET);
        return request;
    }

    public Response postRequest(final JSONObject payload, final String path){
        httpRequest.header("Content-Type", "application/json");
        return httpRequest.body(payload.toJSONString()).request(Method.POST, path);
    }

}
