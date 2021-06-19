package lending.overdrafts.utils;

import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import static com.factory.services.wrapper.RestAssuredManager.*;

import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

public class LendingAPI extends CommonLibrary {
	
	@Then("^call rest end point \"([^\"]*)\" to get application id from \"([^\"]*)\" and save$")
	public void call_rest_end_point_to_get_application_id_from_and_store(String endPoint, String jPath) {
		setStepName("Then");
		httpGet(endPoint, true);
		System.out.println("applicationID: "+applicationID);
	}
	
	@Then("^user call rest end point \"([^\"]*)\" to get and save the response$")
	public void user_call_rest_end_point_to_get_and_store_the_response(String endPoint) {
		setStepName("Then");
		httpGet(endPoint, "applicationID", applicationID.toString(), true);
	}
	
	@Then("^user call rest end point \"([^\"]*)\" to set Amount of Borrowing \"([^\"]*)\" for lending question$")
	public void user_call_rest_end_point_to_set_Amount_of_Borrowing_for_lending_question(String endPoint, String borrowingAmt) {
		setStepName("Then");
		httpGet("product-categories", false);
		System.out.println("applicationID: "+applicationID);
		httpPatch(endPoint, "applicationID", applicationID.toString(), "{\"answers\":[1],\"questionId\":1}", false);
		httpPatch(endPoint, "applicationID", applicationID.toString(), "{\"answers\":["+borrowingAmt+"],\"questionId\":2}", false);
	}
	
	@Then("^verify that expected json \"([^\"]*)\" is equals to \"([^\"]*)\" except \"([^\"]*)\" key$")
	public void verify_that_expected_json_file_is_equal_to_end_point_response(String jsonFile, String jsonPath, String except) throws Throwable {
		setStepName("Then");
//		verifyResponseFileEqualsTo("jsonArrayTest", "data/application/answers", "dateModified");
		verifyResponseFileEqualsTo(jsonFile, jsonPath, except);
	}

}
