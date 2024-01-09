package ayvens;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\resources\\Feaatures\\ayvens.feature",
        
        plugin={"json:target/cucumber.json","pretty","html:target/cucumber-reports"},
        tags= {"@randomUserEmail,@CreateandVerifypost,@Verify10UsersFirstandLastTitle"}
        )

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class EndTest {

}