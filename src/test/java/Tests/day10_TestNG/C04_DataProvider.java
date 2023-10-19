package Tests.day10_TestNG;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_DataProvider extends TestBase {
    @Test
    public void amazonTopluArama() {

        // amazon anasayfaya gidin
        driver.get("https:amazon.com");
        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        String[] aranacakUrunler = {"Nutella", "Java", "Armut", "elma", "Erik", "Malatya"};

        String[] aramaSonucKelimeleri;
        String aramasonucSayisiStr;
        String aramaSonucuStr;
        int aramaSonucSayisiInt;

        for (int i = 0; i < aranacakUrunler.length; i++) {
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.clear();
            aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            WebElement aramaSonucuElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            aramaSonucuStr = aramaSonucuElementi.getText();

            aramaSonucKelimeleri = aramaSonucuStr.split(" ");

            if (aramaSonucKelimeleri[2].equals("over")) {
                aramasonucSayisiStr = aramaSonucKelimeleri[3];
            } else {
                aramasonucSayisiStr = aramaSonucKelimeleri[2];
            }

            aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", "");
            aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);
            Assert.assertTrue(aramaSonucSayisiInt > 100);
        }
    }
}