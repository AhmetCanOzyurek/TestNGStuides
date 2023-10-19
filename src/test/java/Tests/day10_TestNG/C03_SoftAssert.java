package Tests.day10_TestNG;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;

public class C03_SoftAssert extends TestBase {
    @Test
    public void test01(){//kontrol et
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@*='icon-signin']")).click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        // 6. sayfanin duzelmesi icin geri tusuna basalim
        driver.navigate().back();
        //    Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
WebElement currencyDDM = driver.findElement(By.xpath("//*[@id='pc_currency']"));
Select select = new Select(currencyDDM);
select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedSecim ="Eurozone (euro)";
        String actualSecim = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecim,expectedSecim);
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    String[] optionsElementArr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
    List<String> expectedOptionsElementList = Arrays.asList(optionsElementArr);
    List<WebElement> OptionsElementList = select.getOptions();
    List<String> stringActualElementList = new ArrayList<>();
        for (int i = 0; i < expectedOptionsElementList.size() ; i++) {
            stringActualElementList.add(OptionsElementList.get(i).getText());
        }
        softAssert.assertEquals(expectedOptionsElementList,stringActualElementList);
        softAssert.assertAll();
    }
}
