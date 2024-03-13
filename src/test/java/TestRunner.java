import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.SharedDriver;

@CucumberOptions(
        features = {"src/test/resources/"},
        plugin = { "pretty", "html:target/cucumber-reports/" },
        glue = {"steps"}
)

@RunWith(Cucumber.class)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        SharedDriver.getWebDriver();
    }

    @AfterClass
    public static void tearDown(){
        SharedDriver.closeDriver();
    }
}
