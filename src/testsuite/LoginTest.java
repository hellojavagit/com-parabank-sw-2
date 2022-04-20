package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.html";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    // * Enter valid username
    //* Enter valid password
    //* Click on ‘LOGIN’ button
    //* Verify the ‘Accounts Overview’ text is display
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // sending the emial and password fields
        driver.findElement(By.name("username")).sendKeys("tsel72678@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abcd123");
        //clicking the login link
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
        //verifying the Accounts Overview text
        String expectedMessage = "Accounts Overview";
        String actualMessage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }

    /*  * Enter invalid username
     * Enter invalid password
     * Click on Login button
     * Verify the error message ‘The username and password could not be verified.’
     */
    @Test
    public void verifyTheErrorMessage() {
          //sending the invalid email and password fields
        driver.findElement(By.name("username")).sendKeys("Tsel726275@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abcd1234");
        //clicking the login link
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
        //verifying the Error messages
        String expectedMessage = "The username and password could not be verified.";
        String actualMessage = driver.findElement(By.className("error")).getText();
        Assert.assertEquals("Not matching Error Messages",expectedMessage,actualMessage);

    }

    /* Enter valid username
     * Enter valid password
     * Click on ‘LOGIN’ button
     * Click on ‘Log Out’ link
     * Verify the text ‘Customer Login’
     */
    @Test
    public void userShouldLogOutSuccessfully() {
        //sending the email and password fields
        driver.findElement(By.name("username")).sendKeys("tsel72629@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abcd123");
        //clicking the login link
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
        //clicking the logout link
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
        //verifying the Customer Login text
        String expectedText = "Customer Login";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/h2")).getText();
        Assert.assertEquals(expectedText,actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
