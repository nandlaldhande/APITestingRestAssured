package stepdefs;

import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.request.Hotel;
import pageObjects.HotelPostPageObject;

public class HotelPostSearchStepDefinitions {

	private World world;
	private HotelPostPageObject hotelPostPageObject = new HotelPostPageObject();

	public HotelPostSearchStepDefinitions(World world) {
		this.world = world;
	}

	@When("^user send the search Hotel request with \"([^\"]*)\" till \"([^\"]*)\" and room config \"([^\"]*)\"$")
	public void userSendTheSearchHotelRequestWithTillAndRoomConfig(String fromDate, String toDate, String roomConfig) throws Throwable {
		Hotel hotel = new Hotel("paris", "ChIJD7fiBh9u5kcRYJSMaMOCCwQ");
		hotel.setDates(hotelPostPageObject.setDates(fromDate,toDate));
		hotel.setRoom(hotelPostPageObject.setRooms(roomConfig));
		world.setRequestString(new Gson().toJson(hotel));
		world.setResponse(hotelPostPageObject.searchHotelWithBody(new Gson().toJson(hotel)));
	}
	@Then("^verify Status code of response is (\\d+) Ok$")
	public void verifyStatusCodeOfResponseIsOk(int statusCode) {
		hotelPostPageObject.verifyResponseStatusValue(world.getResponse(), hotelPostPageObject.SUCCESS_STATUS_CODE);
	}

	@And("^verify user get expected response as per the hotel search request$")
	public void verifyUserGetExpectedResponseAsPerTheHotelSearchRequest() {

	}


    @And("^verify user get expected response as per the given request$")
    public void verifyUserGetExpectedResponseAsPerTheGivenRequest() {

    }

	@And("^verify type of the Response is '(.*?)'$")
	public void verifyTypeOfTheResponseIsHotel(String expectedReponseType) {
		hotelPostPageObject.verifyTypeOfTheResponseIsHotel(expectedReponseType,world.getResponse());
		}


	@And("^verify placeID at request and response is matching$")
	public void verifyPlaceAtResponseAndRequestIsMatching() {
		hotelPostPageObject.verifyPlaceIDisMatching(world.getRequestString(),world.getResponse());
	}
}
