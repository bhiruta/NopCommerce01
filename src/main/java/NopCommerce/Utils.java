package NopCommerce;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {

//extends BasePage

    static String actualResult;

    //1. Clicking element
    public static void clickElementBy(By by) {
        driver.findElement(by).click();
    }
    //2. Clear Text form inout box/area
    public static void clearField(By by){
        driver.findElement(by).clear();
    }
    //3. Enter text in input field
    public static void enterText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    //4. Clear and enter text in input field
    public void clearAndEnter(By by,String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //5. Checking WebElement present in DOM
    public boolean isElementPresent(By by){
        try {
            driver.findElement(by).isEnabled();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    //6. Checking WebElement displayed or not
    public boolean isElementDisplayed(By  by){
        try {
            driver.findElement(by).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    //7. Wait for fixed time given in seconds
    public static void waitForWebElementToBeClickable(WebElement element, int Seconda){
        WebDriverWait wait = new WebDriverWait(driver,Seconda);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //8 Try to click element three times if not available in first go
    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3) {
            try {
                Thread.sleep(10);
                driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempt++;
        }
        return result;

    }
    //9. wait for locator to be clickable for given time in seconds
    public static void waitForLocatorToBeClickable(By by,int Seconds){
        WebDriverWait wait = new WebDriverWait(driver,Seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //10. wait for visibility of element with given time
    public static void explicitWaitForVisiblity(By by,int Seconds){
        WebDriverWait wait = new WebDriverWait(driver,Seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    //11. timestamp or date in to string conversation
    public static String ShortTimeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DD.MM.YY");
        Date date = new Date();
        String longdate = dateFormat.format(date);
        return longdate;
    }
    //12. timestamp or date in to string conversation
    public static String LongTimeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DD.MMM.YYYY.HH.MM.SS");
        Date date = new Date();
        String longdate = dateFormat.format(date);
        return longdate;
    }
    //15. wait for element to be invisible
    public static void elementToBeInvisible(WebElement element,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    //16. select from visible text
    public static void selectVisibleText(By by,String data){
        Select value = new Select(driver.findElement(by));
        value.selectByVisibleText(data);
    }
    //17. select from visible Number
    public static void selectVisibleNumber(By by,Integer data){
        Select value = new Select(driver.findElement(by));
        value.deselectByIndex(data);
    }
    //18. select text from value
    public static String getActualText(By by){
        return actualResult = driver.findElement(by).getText();
    }
    //19. get selected value from dropdown
    public static void selectByValue(By by,String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }
    //20. scroll to view element
    public void scrollToElement(By by,WebElement element,int seconds){
        try {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
            driver.findElement(by);
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //21. scroll to element and click
    public void scrollTillElementFoundAndClick(By by,WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(by).click();
    }
    //22. Wait for alert to display
    public boolean isAlertPresent(){
        boolean present = false;
        try {
            //check the presence of alert
            Alert alert = driver.switchTo().alert();
            //Alert present;set the flag
            present = true;
            //if present consume the alert
            alert.accept();
        }catch (NoSuchElementException ex){
            //Alert not present
            ex.printStackTrace();
        }
        return present;

    }
    //23. get attribute of element
    public static String getAttributeOfElement(WebElement element,String attr) {
        String value = element.getAttribute(attr);
        return value;
    }
    //24. get css property of element
    public String getCssPropOfElement(WebElement element,String css) {
        String Value = element.getCssValue(css);
        return Value;
    }
    //27. convert data to string
    public String dateToString(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ddmmyy");
        String strDate = dateFormat.format(date);
        return strDate;

    }
    //select by text name from dropdown
    public static void SelectByText(By by, String data){
        Select dob = new Select(driver.findElement(by));
        dob.deselectByIndex(Integer.parseInt(data));
    }
    //assert with expected and actual result
    public static void validation(String expectedResult,String actualResult){
        Assert.assertEquals(actualResult,expectedResult);
    }
    //assert URL with test
    public static void asserCurrentURL(String url){
        Assert.assertTrue( driver.getCurrentUrl().equals(url));
    }
    //assert Text with text
    public static String getActualResult(By by){
        return driver.findElement(by).getText();

    }


}

