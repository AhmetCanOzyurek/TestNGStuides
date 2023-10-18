package Tests.day10_TestNG;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_HardAssert extends TestBase {

    @Test(groups = {"e2e1","e2e2"})
    public void amazonTest(){

        /*
        TestNG JUnit'deki assertion methodlarinin tamamine sahiptir
        sadece sıralama JUnitten farklıdırr.

        Assert class'ından method'lar kullanarak yaptigimiz Assertion'larda
        failed olan ilk assertion'da cllas'in calismasi durur
        kod hata verir.

        siz o hatayı duzelttikten sonra yeniden calistirirsaniz
        sonraki hatalari bulabilirsiniz.
         */
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in https://www.amazon.com/ icerdigini test edin ve screenshot alin
        String expectedUrlIcerik = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrlIcerik);
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarının nutella icerdiegini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedICerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        System.out.println(actualSonucYazisi);
        Assert.assertTrue(actualSonucYazisi.contains(expectedICerik));

        // urun isminin Nutella icerdigini test edin ve screenshot alin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        // ilk urune tiklayin

        // urun isminin Nutella icerdigini test edin ve screenshot alin


    }
}
