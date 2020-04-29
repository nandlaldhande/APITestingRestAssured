package stepdefs;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class World {
    private Response response;
    private RequestSpecification request;
    private String requestString;

    public String getRequestString() {
        return requestString;
    }

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    public RequestSpecification getRequest() {
        return this.request;
    }

}
