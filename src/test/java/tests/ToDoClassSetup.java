package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.extentreports.ExtentTestManager.startTest;

public class ToDoClassSetup extends BaseTest{



    @Test
    public void toDoListTest(Method m) throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        startTest(m.getName(), "testing Extent Report ");
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li4")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys("List Item 6");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys("List Item 7");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys("List Item 8");
        driver.findElement(By.id("addbutton")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li6")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li7")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li8")).click();



        Thread.sleep(300);



        // Let's also assert that the todo we added is present in the list.

        spanText = driver.findElement
                (By.xpath("/html/body/div/div/div/ul/li[8]/span")).getText();
        Assert.assertEquals( spanText,"List Item 8");

        Thread.sleep(150);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
