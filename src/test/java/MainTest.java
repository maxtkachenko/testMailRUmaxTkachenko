
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class MainTest {
    private static WebDriver driver;
    Properties pr = new Properties();
    private  WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        setPropetry();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://mail.ru/desktop/login");//go to login page
    }

    @Test
    public void testMain() {
        PageObject driverChrome = new PageObject(driver);
        System.out.println("######START########");
        System.out.println("User_Login: " + pr.getProperty("LOGIN"));
        driverChrome.getLoginField().sendKeys(pr.getProperty("LOGIN"));//input login
        System.out.println("User_Password: " + pr.getProperty("PASSWORD"));
        driverChrome.getPasswordField().sendKeys(pr.getProperty("PASSWORD"));//input password
        driverChrome.getLoginBtn().click();//submit

        driverChrome.getWriteEmailBtn().click();//create new email
        driverChrome.getToAddressField().click();
        System.out.println("Send_To: " + pr.getProperty("TOEMAIL"));
        driverChrome.getToAddressField().sendKeys(pr.getProperty("TOEMAIL"));//input email address

        driver.switchTo().frame(driverChrome.getTextArea());

        driverChrome.getBody().click();
        driverChrome.getBody().clear();
        System.out.println("Email_Body: " + pr.getProperty("TEXTBODY"));
        driverChrome.getBody().sendKeys(pr.getProperty("TEXTBODY"));//input email text

        driver.switchTo().defaultContent();

        driverChrome.getSendBtn().click();//send email
        //assertTrue(driver.getTitle().equals("Письмо отправлено - Почта Mail.Ru"));//email sending verification
        System.out.println("#######THE#END#######");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    private void setPropetry() {
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            pr.load(input);
        }
        catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
