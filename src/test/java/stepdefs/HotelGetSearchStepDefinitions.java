package stepdefs;

import cucumber.api.java.en.When;
import pageObjects.HotelGetPageObject;


public class HotelGetSearchStepDefinitions {

	private World world;
	private HotelGetPageObject hotelGetPageObject = new HotelGetPageObject();

	public HotelGetSearchStepDefinitions(World world) {
		this.world = world;
	}

	@When("^user send the search Hotel request for destination '(.*?)'$")
	public void userSendTheSearchHotelRequestForDestinationParis1(String destination) {
		world.setResponse(hotelGetPageObject.getHotelCityName(destination));
	}

	@When("^user send the search Hotel request for destination \"([^\"]*)\"$")
	public void userSendTheSearchHotelRequestForDestinationParis(String destination) {
		world.setResponse(hotelGetPageObject.getHotelCityName(destination));
	}
}
