package Testss;
import Hook.Hook;


import Pages.LoginPage;

import org.testng.annotations.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;;

public class LoghinTest extends Hook {

    @Test(description = "login with valid data", priority = 3, dataProvider = "dataLogin")
    public void login(String name, String password) throws IOException, InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.usernameField.sendKeys(name);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
        assertTrue(driver.getTitle().contains("Swag Labs"));
        if (dataLogin() != null) {
            driver.navigate().back();

        }
    }

    @DataProvider
    public Object[][] dataLogin() {
        return new Object[][]{
                new Object[]{"standard_user", "secret_sauce"},
               //   new Object[]{"locked_out_user", "secret_sauce"},
                new Object[]{"problem_user", "secret_sauce"},
                new Object[]{"performance_glitch_user", "secret_sauce"}
        };

    }


}

