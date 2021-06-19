package lending.overdrafts.utils;

import static com.factory.data.manager.Database.fetchSingleValue;
import static com.factory.data.manager.Database.updateTable;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import java.time.LocalDateTime;
import org.json.JSONObject;

import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

public class LendingDatabase extends CommonLibrary {
	@Then("^user update the application modified date or psedecision datetime to more than 60 days$")
	public void call_rest_end_point_to_get_application_id_from_and_store(String endPoint, String jPath) {
		setStepName("Then");
		String pseDecision = fetchSingleValue(
				"select psedecision from application where id = (select max(id) from application);");
		if (!pseDecision.equals("null")) {
			JSONObject pseDecisionObj = new JSONObject(pseDecision);
			String dateTime = pseDecisionObj.getString("datetime");
			updateTable("update application set psedecision=replace(psedecision::TEXT,'\"" + dateTime
					+ "\"','\"2018-01-01T00:00:00.000Z\"')::json;");
		} else {
			updateTable("update application set datemodified='2018-01-01 11:42:20.712+00';");
		}
	}

	@Then("^decrease application datemodified column by (\\d+) days in application table$")
	public void decrease_application_datemodified_column_by_days_in_application_table_of_database(int days) {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime modifiedDate = today.minusDays(days);
		updateTable("update application set datemodified='" + modifiedDate + "' where id=" + applicationID + ";");
	}

	@Then("^decrease psedecision datetime by (\\d+) days in application table$")
	public void decrease_psedecision_datetime_by_days_in_application_table_of_database(int days) {
		LocalDateTime modifiedDate = LocalDateTime.now().minusDays(days);
		String pseDecision = fetchSingleValue("select psedecision from application where id=" + applicationID + ";");
		JSONObject pseDecisionObj = new JSONObject(pseDecision);
		String dateTime = pseDecisionObj.getString("datetime");
		updateTable("update application set psedecision=replace(psedecision::TEXT,'\"" + dateTime + "\"','\""
				+ modifiedDate + "\"')::json where id=" + applicationID + ";");
	}

	@Then("^increase application datemodified column by (\\d+) days in application table$")
	public void increase_application_datemodified_column_by_days_in_application_table(int days) {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime modifiedDate = today.plusDays(days);
		updateTable("update application set datemodified='" + modifiedDate + "' where id=" + applicationID + ";");
	}

	@Then("^increase psedecision datetime by (\\d+) days in application table$")
	public void increase_psedecision_datetime_by_days_in_application_table(int days) {
		LocalDateTime modifiedDate = LocalDateTime.now().minusDays(days);
		String pseDecision = fetchSingleValue("select psedecision from application where id=" + applicationID + ";");
		JSONObject pseDecisionObj = new JSONObject(pseDecision);
		String dateTime = pseDecisionObj.getString("datetime");
		updateTable("update application set psedecision=replace(psedecision::TEXT,'\"" + dateTime + "\"','\""
				+ modifiedDate + "\"')::json where id=" + applicationID + ";");
	}

}
