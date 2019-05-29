import NopCommerce.HomePage;
import NopCommerce.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

         @Given("^user is on Login page$")
            public void userIsOnLoginPage(){
            homePage.clickonLoginLink();
        }

    @When("^user enters invalid\"([^\"]*)\" or \"([^\"]*)\"$")
    public void userEntersInvalidOr(String Email, String Password)  {
             loginPage.userentersLogInDetails(Email, Password);

    }

    @Then("^user should able to see the \"([^\"]*)\"$")
    public void userShouldAbleToSeeThe(String errormessage) {
        boolean b;
        if (errormessage.contains("No customer account found"))
            errormessage.contains("The credential provided are incorrect");
        {
            b = true;

        }
        else
        {
            b = false;
        }
        Assert.assertTrue(b);
    }
}





