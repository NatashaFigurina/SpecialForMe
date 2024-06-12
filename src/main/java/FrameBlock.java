import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class FrameBlock {

    protected  WebDriver driver;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[1]")
    private WebElement amountInscription;

    @FindBy(css = "span[class=pay-description__text] ")
    private WebElement phoneInscription;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement InscriptionInButton;


    public void start(){
    driver.switchTo().frame(0);
}

    String creditCard = driver.findElement(By.cssSelector("input[id=cc-number]")).getAttribute("placeholder");
    String expirationDate = driver.findElement(By.cssSelector("input[formcontrolname=expirationDate]")).getAttribute("placeholder");
    String cvc  = driver.findElement(By.cssSelector("input[formcontrolname=cvc]")).getAttribute("placeholder");
    String ccName = driver.findElement(By.cssSelector("input[formcontrolname=holder]")).getAttribute("placeholder");


    public String getInscriptionsSum() {
        return amountInscription.getText();

    }
    public String getInscriptionsPhone() {
        return phoneInscription.getText();
    }
}
