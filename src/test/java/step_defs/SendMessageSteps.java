package step_defs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.InboxPage;
import pojo.InboxMessageDataContainer;
import utils.Driver;
import java.util.List;
import java.util.Map;

public class SendMessageSteps {
    WebDriver driver = Driver.getDriver();
    InboxPage inboxPage = new InboxPage(driver);

    @DataTableType
    public InboxMessageDataContainer loginEntry(Map<String, String> entry) {
        return new InboxMessageDataContainer(
                entry.get("message")
        );
    }

    @Given("Available chats in the inbox")
    public void available_chats_in_the_inbox() throws InterruptedException {
        inboxPage.listOfNavItems.click();
    }

    @When("User clicks on any of them")
    public void user_clicks_on_any_of_them() {
        inboxPage.listOfEmailsInInbox.get(0).click();
    }

    @Then("User should be able to reply below message inside the modal window")
    public void user_should_be_able_to_reply_below_message_inside_the_modal_window(List<InboxMessageDataContainer> dataTable) {
        InboxMessageDataContainer messageDataContainer = dataTable.get(0);
        inboxPage.replyButton.click();
        inboxPage.textField.sendKeys(messageDataContainer.getMessage());
        inboxPage.sendButton.click();
    }
}
