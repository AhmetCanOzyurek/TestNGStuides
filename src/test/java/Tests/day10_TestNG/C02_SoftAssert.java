package Tests.day10_TestNG;

import Utilities.TestBase;
import org.bouncycastle.util.io.TeeInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_SoftAssert extends TestBase {

    /*
    TestNG bir method'da birden fazla assertion oldugunda tum assertion'lari
    tek seferde raporlama icin
    bize SoftAssertion class'ından methodlar sunmustur.


    SoftAssert ile assertion'lari yapmak icin
    1- softAssert objesi olustur
    2- istenilen tum assertion'lari yap
    3- tum assertionlar bittikten sonra, sonucu raporlatmak icin softAssert.assertAll() kullan
     */
    @Test(groups = {"smoke"})
    public void test01() {


        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in https://www.amazon.com/ icerdigini test edin
        String expectedUrlIcerik = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrlIcerik,"Url test");
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarının nutella icerdiegini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedICerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();

        softAssert.assertTrue(actualSonucYazisi.contains(expectedICerik),"nutella arama");

        // ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        // urun isminin Nutella icerdigini test edin ve screenshot alin
        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();
        softAssert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik),"ilk urun isim");

        softAssert.assertAll();//raporlama
        System.out.println("failed olan assertion olursa bu satir calismaz");
        /*
        softAssert birden fazla assertion failed olsa da calismaya devam etmesi icin kullanilir
        biz assertAll() kullanincaya kadar, buldugu hatalari kendisi not eder, calismayi durdurmaz

        assertAll() satirina geldiginde tum assertion sonuclarini rapor eder
        ve failed olan assertion varsa assertAll() calistiginda kodun calismasi durur
        ve tum failed olan assertion'lar raporlanir

        assertion'lardan sonra assertAll() yazılmazsa
        failed olan assertion'lar olsa da test passed olur

         */
    }
}