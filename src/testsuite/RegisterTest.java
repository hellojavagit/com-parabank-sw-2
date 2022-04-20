package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.html";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //clicking on the register link
         driver.findElement(By.linkText("Register")).click();
         //verifying the text

        String expectedMessage = "Signing up is easy!";
       String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Signing up is easy!']")).getText();
        Assert.assertEquals("Messages Does Not Match", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        // click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        //Enter First name
        driver.findElement(By.id("customer.firstName")).sendKeys("Hello");
        //Enter Last name
        driver.findElement(By.name("customer.lastName")).sendKeys("Hi");
        //Enter Address
        driver.findElement(By.name("customer.address.street")).sendKeys("\"123TheAvenue\"");
        //Enter City
        driver.findElement(By.name("customer.address.city")).sendKeys("\"London\"");
        //Enter State
        driver.findElement(By.name("customer.address.state")).sendKeys("Arizona");
        //Enter Zip Code
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        //Enter Phone
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("0123432121");
        //Enter SSN
       driver.findElement(By.name("customer.ssn")).sendKeys("123456789");
        //Enter Username
        driver.findElement(By.name("customer.username")).sendKeys("tsel72576@gmail.com");
        //Enter Password
       driver.findElement(By.name("customer.password")).sendKeys("abcd123");
        //Enter Confirm
       driver.findElement(By.name("repeatedPassword")).sendKeys("abcd123");
        //Click on REGISTER button
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
        //Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMessage ="Your account was created successfully. You are now logged in.";
      String actualMessage =  driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
       Assert.assertEquals("Not Equal messages",expectedMessage,actualMessage);
    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}
