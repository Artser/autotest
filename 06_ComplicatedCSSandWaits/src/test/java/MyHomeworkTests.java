import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */
//
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*Задание 1*/
    @Test
    public void NewLocator() {
        var elementPLocator = By.cssSelector("p");
        var elementALocator = By.cssSelector("div.text > a");
        var elementSectionLocator = By.cssSelector("section > div: nth-of-type(2) > a:first-child");
    }

    /*Задание 2*/
    @Test
    public void TestTaxiWebsite() {
/*Найдите тег input, у которого нет атрибута id.
Найдите все теги p, у которых одновременно выполняются два условия:
class начинается на слово form;
class НЕ заканчивается на слово error.
Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.*/
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        var NotIdLocator = driver.findElement(By.cssSelector("input:not([id])"));
        var formNotErrorLocator = driver.findElement(By.cssSelector("p[class ^= 'form']:not([class $= 'error'])"));
        var formRowLocator = driver.findElement(By.cssSelector("div.form-inner p.form-row:first-child"));
    }

    /*задание 3*/
    @Test
    public void TestingDiary() {
        //Перейдите на страницу.
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");

        //Кликните на заметку из списка заметок по центру экрана.
        var noteCentralLocator = By.cssSelector("button.articlePreview__link");
        driver.findElement(noteCentralLocator).click();

        //Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
        var sectionLocator = By.cssSelector ( "div.articlePreview.pageArticle__articlePreview:nth-of-type(1)" );


        //Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
        var titleLocator = By.cssSelector("div.articlePreview:nth-of-type(1)>div.articlePreview__content>p.articlePreview__title");
        var textNoteLocator = By.cssSelector("div:nth-of-type(1) > div.articlePreview__content > p.articlePreview__text");

        var actualHeadNote = driver.findElement(titleLocator).getText();
        var actualTextNote = driver.findElement(textNoteLocator).getText();
        var expectedTitle = "План на следующий месяц";
        var expectedTextNote = "Прочитать книгу «Искусство цвета».";

        Assert.assertTrue("Не отобразился заголовок для записи", driver.findElement(titleLocator).isDisplayed());
        Assert.assertEquals("Неправильный заголовок для записи", expectedTitle, actualHeadNote);
        Assert.assertTrue("Не отобразился текст в записи", driver.findElement(textNoteLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст в записи", expectedTextNote, actualTextNote);



        // Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var buttonTrashLocator = By.cssSelector("div.pageArticle__contentHeader > div.pageArticle__buttons > button:nth-of-type(2)");
        driver.findElement(buttonTrashLocator).click();

        // В разделе «Все записи» выберите самую верхнюю запись (первую).
        var firstNoteLocator = By.cssSelector("div.pageArticle__sidebarList.vb.vb-invisible > div.vb-content > div > button");
        driver.findElement(firstNoteLocator).click();

        // Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var buttonTrash2Locator = By.cssSelector("div.pageArticle__contentHeader > div.pageArticle__buttons > button:nth-of-type(2)");
        driver.findElement(buttonTrash2Locator).click();

        // Дождитесь исчезновения записи в разделе «Все записи».
        // Проверьте, что справа в списке «Все записи» не видно записей.
        var nullNoteLocator = By.cssSelector("div.vb-content");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(nullNoteLocator));
    }

}
