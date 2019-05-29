package NopCommerce;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils {

        LoadProp loadProp = new LoadProp();
        private By _register = By.linkText("Register");
        private By _email = By.id("Email");
        private By _register_Btn = By.id("register-button");
        //private By _logoutBtn = By.linkText("Log out");
        private By _firstName = By.id("FirstName");
        private By _lastName = By.id("LastName");
        private boolean actualResult;

        //send Text(_firstName,LoadProp.getProperty("firstName"));
        public void registration() {
            //click on register button

            clickElementBy(_register);
            //select the male gender option
            clickElementBy(By.id("gender-male"));

            //enter "MyFirstName" in First name field
            Object enterText;
            enterText(_firstName, loadProp.getProperty("firstname"));
            //enter "MySurname" in Last name field
            enterText(_lastName, loadProp.getProperty("lastname"));
            //select the value"20" for Day field of Date of Birth

            Object selectByValue;
            selectByValue(By.name("DateOfBirthDay"), loadProp.getProperty("DOBDay"));
            //select the value"Febuary" for the Month field of Date of Birth
            Object selectByIndex;
            selectByIndex(By.name("DateOfMonth"), 2);
            //select the value "1981"for the year field of Date of Birth year
            selectByValue(By.name("DateOfBirthYear"), loadProp.getProperty("DOBYear"));
            emailWithTimeStamp(_email);
            //enter the value "My Company" in the company field
            enterText(By.id("Company"), loadProp.getProperty("Company Name"));
            //tick the Newsletter check box
            //selectBy(By.id("Newsletter"));
            //enter the value "mypass" in the password field

            enterText(By.id("Password"), loadProp.getProperty("password"));
            //enter the value "my pass" in the confirm Password field
            enterText(By.id("ConfirmPassword"), loadProp.getProperty("password"));
            //clikc on register button
            clickElementBy(_register_Btn);
        }

        private void emailWithTimeStamp(By email) {
        }

        private void selectByIndex(By dateOfMonth, int i) {
        }

        public void registrationConfirmation() {
            getActualText(By.xpath("//div[@class='result']"));
            //user should be able to see the message "Your registration completed" if sucessful
            
            validation(loadProp.getProperty("confirmRegistration"));
            //print Results
            System.out.println(actualResult);
            //click on Log out button
            //findElementBy(logoutButton);

        }

    private void validation(String confirmRegistration) {
    }
    /*
     public void screenshotForFailTest(){
     //click on register button
     clickElementBy(_register);
     //select the male gender option
     clickElementBy(By.id("gander-male"));
     }
     */
    }





















