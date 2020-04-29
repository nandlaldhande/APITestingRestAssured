package pageObjects;

import gherkin.deps.com.google.gson.Gson;
import io.restassured.response.Response;
import model.request.Dates;
import model.request.Guest;
import model.request.Hotel;
import model.request.Room;
import org.junit.Assert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelPostPageObject extends BasePageObject {
    private final String HOTEL_ENDPOINT_PATH = "api/hotel/ahs/search/request";
    private Hotel defaultHotel;
    Gson gson = new Gson();

    public HotelPostPageObject() {
        super();
        defaultHotel = new Hotel("paris", "ChIJD7fiBh9u5kcRYJSMaMOCCwQ");
    }

    public String getPath() {
        return this.HOTEL_ENDPOINT_PATH;
    }

    public Response searchHotelWithBody(String body) {
        String url = getBaseUrl() + this.getPath();
        getRequestWithJSONHeaders().body(body);

        return sendRequest(getRequestWithJSONHeaders(), BasePageObject.POST_REQUEST, url, body);
    }

    public Dates setDates(String fromDate, String toDate) {
        Dates date = new Dates();
        date.setCheckin(fromDate);
        date.setCheckout(toDate);
        return date;
    }

    public List<Room> setRooms(String roomConfig) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/inputJsonFiles/" + roomConfig + ".json"));
        // convert JSON string to User object
        Map<String, Object> map = gson.fromJson(reader, Map.class);
        List<Room> rooms = (List<Room>) map.get("room");

        return rooms;
    }

    public void verifyPlaceIDisMatching(String requestString, Response response) {
        Hotel hotel = gson.fromJson(requestString, Hotel.class);
        String placeID = response.jsonPath().get("queryParametersObj.placeId");
        Assert.assertTrue(placeID.equalsIgnoreCase(hotel.getPlaceId()));
    }

    public void verifyTypeOfTheResponseIsHotel(String expectedReponseType, Response response) {
        Assert.assertTrue(responseType(response).equalsIgnoreCase(expectedReponseType));
    }

    public List<Room> createRoomsByConfigs(String roomConfig) {
        List<Room> rooms = new ArrayList<>();
        String[] g = roomConfig.split("/");
        for (String a : g) {
            int noOfGuests = Integer.valueOf(a.substring(0, a.indexOf("_")));
            List<Guest> guests = new ArrayList<>();
            for (int i = 0; i < noOfGuests; i++) {
                guests.add(new Guest("ADT"));
            }
            Room room = new Room();
            room.setGuest(guests);
            rooms.add(room);
        }
        return rooms;
    }
}
