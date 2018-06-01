import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class PageObject {

        private WebDriver driver;

        public PageObject(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        public WebDriver getDriver() {
            return driver;
        }

        public WebElement getLoginField() {
            return loginField;
        }

        public WebElement getPasswordField() {
            return passwordField;
        }

        public WebElement getLoginBtn() {
            return loginBtn;
        }

        public WebElement getWriteEmailBtn() {
            return writeEmailBtn;
        }

        public WebElement getToAddressField() {
            return toAddressField;
        }

        public WebElement getTextArea() {
            return textArea;
        }

        public WebElement getSendBtn() {
            return sendBtn;
        }

        public WebElement getBody() {
            return body;
        }

        @FindBy(id = "mailbox:login")
        private WebElement loginField;

        @FindBy(id = "mailbox:password")
        private WebElement passwordField;

        @FindBy(id = "mailbox:submit")
        private WebElement loginBtn;

        @FindBy(css = "div[id=LEGO] a")
        private WebElement writeEmailBtn;

        @FindBy(css = "textarea[data-original-name=To]")
        private WebElement toAddressField;

        @FindBy(xpath = "//iframe[starts-with(@id,'toolkit-')]")
        private WebElement textArea;

        @FindBy(id = "tinymce")
        private WebElement body;

        @FindBy(css = "div[data-name=send]")
        private WebElement sendBtn;

    }


