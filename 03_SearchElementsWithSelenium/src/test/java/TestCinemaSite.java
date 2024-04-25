import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCinemaSite {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void TestingSaveButton(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var bestFilmsElement = driver.findElement(By.id("films"));
        var bestSerialElement = driver.findElement(By.id("serials"));
        var bestFilms = "Мебиус";
        var bestSerials = "White Collar";
        bestFilmsElement.sendKeys(bestFilms);
        bestSerialElement.sendKeys(bestSerials);
        var buttonSave = driver.findElement(By.id("save"));
        buttonSave.click();
        var buttonTwo = driver.findElement(By.id("two"));
        buttonTwo.click();
        var buttonEnter = driver.findElement(By.className("section__button"));
        buttonEnter.click();
        var buttonOk = driver.findElement(By.id("ok"));
        buttonOk.click();
        var bestFilmsResult = driver.findElement(By.id("best_films")).getText();
        var bestSerialsResult = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("неверно указан любимый фильм", bestFilms, bestFilmsResult);
        Assert.assertEquals("неверно указан любимый сериал", bestSerials, bestSerialsResult);
    }

    @Test
    public void TestingCheckbox(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("Мебиус");
        driver.findElement(By.id("serials")).sendKeys("White Collar");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        var checkBox =   driver.findElements(By.className("fake-checkbox"));
        Assert.assertEquals("Неправильный текст", 4, checkBox.size());
    }
    @Test
    public void TestingRadioButton(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        var radioButton =  driver.findElements(By.className("fake-radiobutton"));
        Assert.assertEquals("Неправильный текст", 5, radioButton.size());
    }
}
