package acceptance;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.hhc.calculator.SpringBootGradleCalculatorApplication;

@ContextConfiguration(classes = SpringBootGradleCalculatorApplication.class)
@WebAppConfiguration
public class StepDefinitions {

	private String server = System.getProperty("calculator.url");

	private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);

	private RestTemplate restTemplate = new RestTemplate();
	private String a;
	private String b;
	private String result;

	@Given("^I have two numbers: (.*) and (.*)$")
	public void i_have_two_numbers(String a, String b) throws Throwable {
		LOGGER.info("***************************************************+");
		this.a = a;
		this.b = b;
	}

	@When("^the calculator sums them$")
	public void the_calculator_sums_them() throws Throwable {
		String url = String.format("%s/sum?a=%s&b=%s", server, a, b);
		result = restTemplate.getForObject(url, String.class);
	}

	@Then("^I receive (.*) as a result$")
	public void i_receive_as_a_result(String expectedResult) throws Throwable {
		assertEquals(expectedResult, result);
	}
}
