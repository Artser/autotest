import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

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

    /*Задание 1*/
    @Test
    public void XPathLocator1() {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        //Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
        var arrowsPrevLocator = By.xpath("//span[@class='da-arrows-prev']");
        //Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам. <a href="#" class="da-link button">Узнать больше</a>
        var buttonLocator = By.xpath("//a[@class='da-link button']");
        //Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
        var notActiveLocator = By.xpath("//ul[@class=nav nav-pills]//li[not(@class='filter active')]");
        //Все элементы, у которых класс начинается на слова button.
        var startButtonLocator = By.xpath("//*[start-with(@class,'button')]");
        //Кнопка «Подписаться сейчас».
        var currentlocator = By.xpath("//*[.='Подписаться сейчас']");
        //Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание ближайшего родительского элемента с ID.
        var clientsImgLocator = By.xpath("//div[@id='clients']//img");

    }

    /*Задание 2*/

    @Test
    public void XPathLocator2() {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        //Заголовок пятого курса.
        var fiveCourse = By.xpath("(//span)[5]");
        //Элемент с учебным периодом последнего курса.
        var periodLastCourse = By.xpath("(//div[@class='baseCondition'])[last()]//p");
    }

    /*Задание 3*/
    @Test
    public void XPathLocator3() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");

        //Ссылка «О магазине» в футере.
        var aboutFooter = By.xpath("//footer//a[@test-info='about-us']");
        //Заголовок «Бестселлеры».
        var bestsellersLocator = By.xpath("(//li[.='Бестселлеры'])");
        //Строка поиска.
        var stringSearch = By.xpath("//input");
        //Итоговая сумма заказа в корзине.
        driver.navigate().to("http://qajava.skillbox.ru/checkout.html");
        var totalOrderLocator = By.xpath("//div[@id='total']");
        //Заголовок «Ваш заказ: в корзине.
        var headingLocator = By.xpath("//div[@class='order-info']//div[1]");
        //Кнопка «Отменить» на странице поиска.
        driver.navigate ().to ( "https://qajava.skillbox.ru/search.html" );
        var buttonCancel = By.xpath("//button[@class='filter-button']");

    }

}
