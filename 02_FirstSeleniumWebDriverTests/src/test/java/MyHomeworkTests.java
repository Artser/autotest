import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {
@Test
public void testHelloVasya() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
    driver.findElement(By.name("name")).sendKeys("Вася");
    driver.findElement(By.cssSelector("button")).click();
    var actualResult = driver.findElement(By.className("start-screen__res")).getText();
    var expectedResult = "Привет, Вася!";
    Assert.assertEquals(expectedResult, actualResult);
    driver.quit();
    }

@Test
  public void testClickEnter(){
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
    driver.findElement(By.className("button")).click();
    var actualResult = driver.findElement(By.className("start-screen__res")).getText();
    var expectedResul = "Привет, !";
    Assert.assertEquals(expectedResul, actualResult);
    driver.quit();

}



    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert > 240) return 100;
        if(hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if(hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }


}
