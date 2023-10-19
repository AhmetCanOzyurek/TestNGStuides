package Tests.day10_TestNG;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C05_DataProvider extends TestBase {
    @DataProvider
    public static Object[][] listeYollayacakProvider() {

        String[][] aranacakUrunler = {{"Nutella"}, {"Java"}, {"Armut"}, {"elma"}, {"Erik"}, {"Malatya"}};
        return aranacakUrunler;
    }
    /*
    Data provider, @DataProvider notasyonu ile isaretlenmis
    ve bize iki katli bir object[][] donen bir method'dur
     */


    // data provider kendisine verilen array'deki elementleri
    // tek tek parametre olarak bizim test method'umuza yollar

    @Test(dataProvider = "listeYollayacakProvider")
    public void aramaTesti(String aranacakUrun){
// amazon anasayfaya gidin
        driver.get("https:amazon.com");
        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

            WebElement aramaSonucuElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
           String aramaSonucuStr = aramaSonucuElementi.getText();

            String[] aramaSonucKelimeleri = aramaSonucuStr.split(" ");
            String aramasonucSayisiStr;
            if (aramaSonucKelimeleri[2].equals("over")) {
                aramasonucSayisiStr = aramaSonucKelimeleri[3];
            } else {
                aramasonucSayisiStr = aramaSonucKelimeleri[2];
            }

            aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", "");
             int aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);
            Assert.assertTrue(aramaSonucSayisiInt > 1000);

    }

}
