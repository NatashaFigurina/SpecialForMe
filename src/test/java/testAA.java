import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testAA {

    @BeforeClass

    public static void setup() {
        System.setProperty("web driver.chrome.driver", "/home/natasha/IdeaProjects/Aston.TestNg/seleniumToo/src/main/resources/selenium-chrome- driver-4.21.0");
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.switchTo().frame(0);
    }

    @AfterTest
    public static void afterTest() {
        driver.quit();
    }

    public static WebDriver driver = new ChromeDriver();
    PayWrapper payWrapper = PageFactory.initElements(driver, PayWrapper.class);
    FrameBlock frameBlock = PageFactory.initElements(driver, FrameBlock.class);

    @Test(description = "Проверка надписи в полях")

    public void testInscriptionInTheField() {

        Assert.assertEquals(payWrapper.phone, "Номер телефона");
        Assert.assertEquals(payWrapper.summa, "Сумма");
        Assert.assertEquals(payWrapper.email, "E-mail для отправки чека");
        Assert.assertEquals(payWrapper.accountNumber44, "Номер счета на 44");
        Assert.assertEquals(payWrapper.accountNumber2063, "Номер счета на 2073");
        driver.switchTo().defaultContent();
    }

    @Test(description = "Проверка надписей плейхолдера ")

    public void testCheckingPlaceholder() {
        payWrapper.fillInTheField();
        payWrapper.pressButton();
        driver.switchTo().frame(0);
        Assert.assertEquals(frameBlock.creditCard, "Номер карты");
        Assert.assertEquals(frameBlock.expirationDate, "Срок действия");
        Assert.assertEquals(frameBlock.cvc, "CVC");
        Assert.assertEquals(frameBlock.ccName, "Имя держателя (как на карте)");
        driver.switchTo().defaultContent();
    }

    @Test(description = "Проверка надписи суммы и номера телефона")

    public void testCheckingInscriptions() {
        payWrapper.fillInTheField();
        payWrapper.pressButton();
        driver.switchTo().frame(0);
        Assert.assertEquals(frameBlock.getInscriptionsSum(), "10.00 BYN");
        Assert.assertEquals(frameBlock.getInscriptionsPhone(), "Оплата: Услуги связи Номер:375297777777");
        driver.switchTo().defaultContent();
    }
}

