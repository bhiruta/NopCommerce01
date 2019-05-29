package NopCommerce;

import org.openqa.selenium.By;

public class LoginPage extends Utils {
    
    LoadProp loadProp = new LoadProp();
    
    By _Email = By.id("Email");
    By _Password = By.id("Password");
    By _loginButton = By.xpath("//input[@class = 'button-1 login-button']");
    private Object enterElements;
    //By errorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");
    
    
    public void verifyUserIsOnLoginPage(){
        assertUrl("login");

                
    }

    private void assertUrl(String login) {
    }

    public void userentersLogInDetails(String Email,String Password){
        enterElements(_Email,Email);

        enterElements(_Password,Password);

        clickElementBy(_loginButton);

    }

    private void enterElements(By email, String email1) {
    }


}


