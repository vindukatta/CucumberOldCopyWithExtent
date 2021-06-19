package cucumberRunner;

import static com.factory.mobile.driver.AppiumDriverManager.closeApplication;
import static com.factory.mobile.driver.AppiumDriverManager.*;
import com.factory.mobile.driver.AppiumDriverBase.AppType;

import static com.factory.data.manager.Database.*;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "feature-files/", glue = "lending/"
//		, tags = {"@DeclineOffer, @FinalOffer, @PreciseInputbox, @RemindmeLater, @SuitableOffer, @UserDecline"}
		, tags = { "@ManageOverdraftLimit" }
//		, dryRun=true
)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void setup() throws Exception {
//		printMissingLocators(AppType.IOSAPP);
	}

	@AfterSuite
	public void teardown() {
		closeApplication();
	}

	public static void main1(String[] args) {
		
//		System.out.println(encrypt("AshokDikshit"));
//		String s = Thread.currentThread().getStackTrace()[1].getClassName();
//		String[] r = StringUtils.capitalize(s).split("(?=\\p{Upper})");
//		System.out.println(r.length);
//		String cp = String.join("", r).toString();
//		System.out.println(cp);
//		System.out.println(cp.lastIndexOf("."));
//		System.out.println(String.join("", r));
		
		String[] arr = "ashok".split("==");
		System.out.println(arr.length);
	}
}
