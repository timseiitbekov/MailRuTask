package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InboxPage {

    public InboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Почта']")
    public WebElement listOfNavItems;

    @FindBy(xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal']")
    public List<WebElement> listOfEmailsInInbox;

    @FindBy(xpath = "//td[@class='layout__content']//span[text()='Ответить']")
    public WebElement replyButton;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")
    public WebElement textField;

    @FindBy(xpath = "//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']//span[@class='button2__txt']")
    public WebElement sendButton;
}
