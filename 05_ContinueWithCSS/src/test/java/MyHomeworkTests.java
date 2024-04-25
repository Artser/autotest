import org.junit.After;
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
    public void FindLocators() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");
        var aboutUsLocator = By.cssSelector("[test-info = 'about-us']");
        var hrefLocator = By.cssSelector("a[href = '']");
        var bookPriceLocator = By.cssSelector("div.book-price");
        var allButtonBookLocator = By.cssSelector("button[class ^= 'book']");
        var allMainEndLocator = By.cssSelector("[class $= 'main']");
        var allMenuLocator = By.cssSelector("a[class *= 'menu']");
    }

    @Test
    public void searchPageLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        var selectedLocator = By.cssSelector("[selected = '']");
    }

    /*Задание 2*/
    @Test
    public void mainPageNextLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");

        var footerLocator = By.cssSelector("footer[id='footer'] > div");
        var firstGenresLocator = By.cssSelector("li[id='genres'] +* ");
    }

    @Test
    public void searchPageNextLocators() {
        var allContainerLocator = By.cssSelector("div.filter-container ~*");
    }

    /*Задание 3*/
    @Test
    public void pageSocksLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        var firstChildLocator = By.cssSelector("section.important-section-block[for='main-header-page'] >h1 :first-child");
        var lastChildLocator = By.cssSelector(".form#login-form > p:last-child");
        var thirdChildLocator = By.cssSelector("body > *nth-child(3)");
        var firstLinkLocator = By.cssSelector("div.footer__menuList> a:first-child");

    }
}