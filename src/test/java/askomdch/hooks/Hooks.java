package askomdch.hooks;

import askomdch.utils.DriverFactory;
import askomdch.utils.TakeScreenShoot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks {
    private static final ExtentReports extent= new ExtentReports();
    private static final ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter("/report/extentSparkReporter.html");
    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            TakeScreenShoot.takeScreenshot(DriverFactory.getDriver(), scenario.getName());
            extent.attachReporter(extentSparkReporter);
            extent.createTest(scenario.getName())
                    .log(Status.FAIL,"test failed");
            extent.flush();
        }
        DriverFactory.quitDriver();
    }
}
