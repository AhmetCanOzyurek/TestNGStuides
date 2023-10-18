package Tests.day09_testNG;

import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_Priority extends TestBase {
    /*
    TestNG'de birden fazla test method'u calisacaksa, isim sirasina gore calisir.

    eger priority ile siralama yapilmissa, priority degeri kucukten buyuge gore calisir
    eger ayni priority degerine sahip olan varsa isim sirasina goer calisir
    eger priority degeri atanmamissa, default deger olan priority = 0 a gore calisir
     */

    @Test(priority = 1)
    public void amazonTesti(){
        driver.get("https:amazon.com");
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test(groups = {"smoke","regression","e2e1"})
    public void youtubeTesti(){
        driver.get("https:youtube.com");
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test(groups = {"smoke"})//priority =0;
    public void facebookTesti(){
        driver.get("https:facebook.com");
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }


}
