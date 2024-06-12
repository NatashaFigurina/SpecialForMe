import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PayWrapper {
    protected WebDriver driver;


    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sum;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneNumber;


    @FindBy(xpath = "//form[@class='pay-form opened']//button[text()='Продолжить']")
    WebElement button;

    public PayWrapper(WebDriver driver) {
        this.driver = driver;
    }

    String phone = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).getAttribute("placeholder");
    String summa = driver.findElement(By.xpath("//input[@id='connection-sum']")).getAttribute("placeholder");
    String email = driver.findElement(By.xpath("//input[@id='connection-email']")).getAttribute("placeholder");
    String accountNumber44 = driver.findElement(By.xpath("//input[@id='score-instalment']")).getAttribute("placeholder");
    String accountNumber2063 = driver.findElement(By.xpath("//input[@id='score-arrears']")).getAttribute("placeholder");


    public void fillInTheField() {
        phoneNumber.sendKeys("297777777");
        sum.sendKeys("10");
    }

    public void pressButton() {
        button.click();
    }
}



