import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ready to launch the browser");
        System.setProperty("web driver.chrome.driver", "/home/natasha/IdeaProjects/sel2/src/main/resources/selenium-chrome- driver-4.21.0");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }
}
