package Tests;



import Driver.DriverFactory;
import Pages.CreatePage;
import Pages.LoginPage;
import Pages.MailPage;
import Pages.ValidateFormPage;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static Common.Constants.BASE_URL;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class EmailTest {

    @AfterClass
    public static void tearDown(){
        DriverFactory.driver.quit();
    }



    @Test
    public void test2EmailValid() throws Exception {

        LoginPage login = new LoginPage();
        MailPage mail = new MailPage();
        login.loginValidUser();
        String userName = mail.getTextUserName();
        Assert.assertEquals("Incorrect user name", "Daria",userName );

    }

    @Test
    public void test1EmailInvalid() throws Exception {

        LoginPage login = new LoginPage();
        ValidateFormPage validate = new ValidateFormPage();

        login.loginInvalidUser();
        String errorText = validate.getTextInvalidErr();
        Assert.assertEquals("Incorrect invalid error",
                "Неверный логин или пароль",errorText );
        DriverFactory.driver.navigate().to(BASE_URL);

    }


    @Test
    public void test3CreateEmail() throws Exception {

        LoginPage login = new LoginPage();
        MailPage mail = new MailPage();
        //login.loginValidUser();
        mail.createMail();
        CreatePage create = new CreatePage();
        String subj = "Subject" + System.currentTimeMillis();
        create.sendMail("daria.krynytsyna@i.ua", subj, "This is test e-mail");
        create.goToInputMails();
        Assert.assertTrue(mail.findSubject(subj));


    }
}
