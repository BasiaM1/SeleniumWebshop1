package Webshop;

import TestBase.TestBase;
import models.Contact;
import org.junit.jupiter.api.Test;
import pages.ContactPage;
import providers.ContactFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactUs4Test extends TestBase {

    @Test
    public void shouldFillContactUs() throws InterruptedException {
        Contact contact = new ContactFactory().getRandomDataContact();
        ContactPage contactPage = homePage.getMenu().openContactPage();
        contactPage.clickSend();

        String expectedTextAlert = "Invalid email address.";
        assertThat(contactPage.getAlertMessage(), equalTo(expectedTextAlert));

        contactPage.fillContactForm(contact);
        String expectedTextSuccess = "Your message has been successfully sent to our team.";
        assertThat(contactPage.getSuccessMessage(), equalTo(expectedTextSuccess));

    }
}
