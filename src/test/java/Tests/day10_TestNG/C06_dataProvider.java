package Tests.day10_TestNG;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class C06_dataProvider extends TestBase {
    @DataProvider
    public static Object[][] emailPassword() {
        Faker faker = new Faker();
        String[][] emailPassword = new String[2][2];
        for (int i = 0; i <emailPassword.length ; i++) {
            emailPassword[i][0] = faker.internet().emailAddress();
            emailPassword[i][1] = faker.internet().password();
        }
        return emailPassword;
    }

    @Test(dataProvider = "emailPassword")
    public void negatifLoginTesti(String email, String password){
        // qualitydemy anasayfaya gidin
        driver.get("https://www.qualitydemy.com");
        // login linkine basin
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        // bir liste olarak verilen yanlis kullanici email ve password'lerini deneyerek
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        // sisteme giris yapilamadigini test edin
        // login butonuna basalim
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        // giris yapilamadigini test edelim
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@name='email']"));
        Assert.assertTrue(emailKutusu.isDisplayed());

    }
}
