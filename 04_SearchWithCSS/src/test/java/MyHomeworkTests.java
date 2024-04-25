import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestAuthorizationForm() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/index.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        var emailLocator = By.id("email");
        var passwordLocator = By.name("password");
        var buttonLocator = By.tagName("button");
        var errorLocator = By.className("form-error-password-email");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке!", driver.findElement(errorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(errorLocator).getText());
    }

    @Test
    public void selectorTest() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        var emailLocator = By.cssSelector(".input-data");
        var passwordLocator = By.cssSelector(".form-input.password");
        var buttonLocator = By.cssSelector(".form-submit");
        var errorLocator = By.className("form-error-password-email");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке!", driver.findElement(errorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(errorLocator).getText());
    }


    //    Используйте сценарий и тест как в задании 2, только
//    теперь ищите элементы с помощью By.cssSelector с поиском по тегу и одному или двум классам одновременно.

    @Test
    public void cssSelectorTest() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        var emailLocator = By.cssSelector("input.input-data");
        var passwordLocator = By.cssSelector("input.password");
        var buttonLocator = By.cssSelector("button.form-submit");
        var errorLocator = By.cssSelector("pre.form-error-password-email");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке!", driver.findElement(errorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(errorLocator).getText());

    }

    //    Используйте сценарий и тест как в задании 2, только теперь ищите элементы с
//    помощью By.cssSelector с поиском по ID.
    @Test
    public void idSelectorTest() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        var emailLocator = By.cssSelector("#email");
        var passwordLocator = By.cssSelector("#password");
        var buttonLocator = By.cssSelector("#submit");
        var errorLocator = By.cssSelector("#error");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке!", driver.findElement(errorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(errorLocator).getText());

    }

    //    Используйте сценарий и тест как в задании 2. Элементы с одним классом ищите с помощью
//    By.cssSelector с поиском по ID,
//    тегу и классу одновременно. Элементы с двумя классами ищите по ID, тегу и двум классам.
    @Test
    public void maxSelectorTest() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        var emailLocator = By.cssSelector("input#email.form-input.input-data");
        var passwordLocator = By.cssSelector("input#password.form-input.password");
        var buttonLocator = By.cssSelector("button#submit.form-submit");
        var errorLocator = By.cssSelector("pre#error.form-error-password-email");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке!", driver.findElement(errorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(errorLocator).getText());

    }
}
