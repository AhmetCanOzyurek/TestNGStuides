package Tests.day09_testNG;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import Utilities.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_dependOnMethods extends TestBaseClass {
@Test(groups = {"smoke","e2e1","e2e2"})
    public void amazonTesti(){
    // amazon anasayfaya gidin
    driver.get("https://www.amazon.com");
    // url'in amazon icerdigini test edin ve screenshot alin
    String expectedUrlIcerik = "amazon";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    ReusableMethods.tumSayfaFotografCek(driver,"Amazon");
}
    @Test(dependsOnMethods = "amazonTesti",groups = {"e2e1","smoke"})
    public void nutellaTesti(){
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Test(dependsOnMethods = "nutellaTesti",groups = {"smoke"})
    public void ılkUrunTesti(){
// ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        // urun isminin Nutella icerdigini test edin ve screenshot alin

        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik));
    }

}
