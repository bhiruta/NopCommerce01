package NopCommerce;

import org.openqa.selenium.By;

public class HomePage extends Utils {


    public Object clickonLoginLink;
    private By _registrLink = By.linkText("Register");
        private By _CoumputerLink = By.linkText("Computer");
        private By _electronicsLink = By.linkText("Electronics");
        private By _appareLink = By.linkText("Apparel");

        public void clickOnRegisterButton(){
            clickonElement(_registrLink);
        }
        public void clickOnCategoryLinks(String link)
        {
            clickonElement(By.linkText(link));
        }
        public void searchForAnyProduct(){

        }

        private void clickonElement(By registrLink) {
        }

        private void clickonElement() {
        }


    public void clickonLoginLink() {
    }
}

