/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package pageObjects;


import io.restassured.response.Response;

/**
 * @author Nandlal
 * Interface to a Hotel page
 */
public class HotelGetPageObject extends BasePageObject {
    private final String ORDER_ENDPOINT_PATH = "api/hotel/ahs/v2/geo-suggest/";

    public String getPath() {
        return this.ORDER_ENDPOINT_PATH;
    }

    public Response getHotelCityName(String destination) {
        String url = getBaseUrl() + this.getPath();
        return sendRequest(getRequestWithJSONHeaders().queryParam("query", destination), BasePageObject.GET_REQUEST, url, "");
    }

}



