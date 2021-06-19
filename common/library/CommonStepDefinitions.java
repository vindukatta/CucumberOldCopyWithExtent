package lending.common.library;

import static com.factory.mobile.driver.AppiumDriverManager.*;

import com.factory.mobile.driver.AppiumDriverBase.AppType;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class CommonStepDefinitions extends CommonLibrary {
	public static String screenTitle;
	public static String screenQuestion;
	public static String nextButton;
	public static String lendingPrimaryButton;
	public static String lendingSecondaryButton;
	public static String more;
	public static String logout;
	public static String creditAndLending;
	public static String manageOverdraft;
	public static String yesButton;
	public static String noButton;
	public static String backButton;
	public static String webViewDone;

	@Before
	public void startTestReport(Scenario scenario) throws Exception {
		startTest(scenario.getName());
	}

	@After
	public void endTestReport(Scenario scenario) {
		System.out.println(categoryName+" >> "+scenario.getName()+" is: "+scenario.getStatus().toUpperCase()+"\n");
		endTest();
	}

	@Given("^that user is on the Iceberg Homescreen$")
	public static void that_user_is_on_the_Iceberg_Homescreen() throws Throwable {
		setStepName("Given");
		launchMobileApplication(AppType.IOSAPP, "0.0.0.0:4723");
		driver = (IOSDriver<MobileElement>) getAppiumDriverMobileElement();
		loginWithTestUser("TESTUSER", "TESTPASSWORD");
		deleteApplication = true;
	}

	@Then("^close existing open application for the next scenario$")
	public void close_existing_open_application_for_the_next_scenario() {
		setStepName("Then");
		updateApplicationDate();
	}

	@When("^user clicks on the More and then Lending button$")
	public static void user_clicks_on_the_Credit_and_Lending_link() throws Throwable {
		setStepName("When");
		findByAny(more).click();
		sleep(500);
		findByAny(creditAndLending).click();
		sleep(4000);
	}

	@Then("^verify that homescreen is visible on the screen$")
	public void verify_that_homescreen_is_visible_on_the_screen() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(more).isDisplayed();
	}
	
	@When("^user clicks on More and then Manage Overdraft button$")
	public void user_clicks_on_More_and_then_Manage_Overdraft_button() {
		setStepName("When");
		findByAny(more).click();
		sleep(500);
		findByAny(manageOverdraft).click();
		sleep(4000);
	}

	@Then("^user exit the iceberg application and relaunch$")
	public static void user_exit_the_iceberg_application_and_reopen() throws Throwable {
		setStepName("When");
		restartMobileApplication(AppType.IOSAPP);
		alreadyLoggedIn = false;
		deleteApplication = false;
	}

	@When("^user clicks on the More and Logout link$")
	public static void user_clicks_on_the_More_and_Logout_link() throws Throwable {
		setStepName("When");
		findByAny(more).click();
		sleep(500);
		findByAny(logout).click();
		alreadyLoggedIn = false;
		deleteApplication = false;
	}

	@Given("^that category \"([^\"]*)\" is added for below scenarios$")
	public void that_category_is_added_for_below_sceanios(String category) {
		categoryName = category;
		addTestCategory(category);
	}

	@When("^user clicks on continue button on the screen$")
	public void user_clicks_on_continue_button_on_the_screen() throws Throwable {
		setStepName("When");
		findByAny(nextButton).click();
		sleep(500);
	}

	@Then("^verify that Credit & Lending option is displayed on screen$")
	public void verify_that_Credit_And_Lending_option_is_displayed_on_screen() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(creditAndLending).isDisplayed();
	}

	@Then("^verify that continue button is enabled$")
	public void verify_that_continue_button_is_enabled() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(nextButton).isEnabled();
	}

	@Then("^verify that continue button is disabled$")
	public void verify_that_continue_button_is_disabled() {
		setStepName("Then");
		captureScreenshot();
		findByAny(nextButton).isDisabled();
	}

	@Then("^verify that Yes button is displayed on lending question screen$")
	public void verify_that_Yes_button_is_displayed_on_lending_question_screen() {
		setStepName("Then");
		findByAny(yesButton).isDisplayed();
	}

	@Then("^verify that No button is displayed on lending question screen$")
	public void verify_that_No_button_is_displayed_on_lending_question_screen() {
		setStepName("Then");
		findByAny(noButton).isDisplayed();
	}

	@Then("^verify that Yes button is not selected on lending question screen$")
	public void verify_that_Yes_button_is_not_selected_on_lending_question_screen() {
		setStepName("Then");
		findByAny(yesButton).verifyAttributesEqualsTo("value", "0");
	}

	@Then("^verify that No button is not selected on lending question screen$")
	public void verify_that_No_button_is_not_selected_on_lending_question_screen() {
		setStepName("Then");
		findByAny(noButton).verifyAttributesEqualsTo("value", "0");
	}

	@Then("^verify that Yes button is selected on lending question screen$")
	public void verify_that_Yes_button_is_selected_on_lending_question_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(yesButton).verifyAttributesEqualsTo("value", "1");
	}

	@Then("^verify that No button is selected on lending question screen$")
	public void verify_that_No_button_is_selected_on_lending_question_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(noButton).verifyAttributesEqualsTo("value", "1");
		sleep(5000);
	}

	@When("^user clicks on No button on lending question screen$")
	public void user_clicks_on_No_button_on_lending_question_YesNo_screen() {
		setStepName("Then");
		findByAny(noButton).click();
		findByAny(nextButton).click();
		sleep(2000);
	}

	@When("^user clicks on Yes button on lending question screen$")
	public void user_clicks_on_Yes_button_on_lending_question_YesNo_screen() {
		setStepName("Then");
		findByAny(yesButton).click();
		findByAny(nextButton).click();
		sleep(2000);
	}

	@Then("^user clicks on back button on lending question screen$")
	public void user_clicks_on_back_button_on_lending_question_screen() {
		setStepName("Then");
		findByAny(backButton).click();
		sleep(1000);
	}
	@Then("^user clicks on done button on web view on the screen$")
	public void user_clicks_on_done_button_on_web_view_on_the_screen() {
		setStepName("Then");
		findByAny(webViewDone).click();
		sleep(2000);
		captureScreenshot();
	}
	
	@Then("^captures updated screenshot for execution results$")
	public void captures_updated_screenshot_for_execution_results() {
		captureScreenshot();
	}

}
