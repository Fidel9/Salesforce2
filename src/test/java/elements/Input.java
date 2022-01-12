package elements;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {
    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";

    String inputTextarea = "//textarea[@class=' textarea']";
    String inputEmployees = "//input[@data-aura-class='uiInputSmartNumber']";

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.debug("Writing text '%s' into input with label '%s'", text, this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
    }

    public void writeTextarea(String text) {
        log.debug("Writing text '%s' into input with label '%s'", text, this.label);
        driver.findElement(By.xpath(String.format(inputTextarea, this.label))).sendKeys(text);
    }

    public void writeEmployees(String text) {
        System.out.printf("Writing text '%s' into input with label '%s'", text, this.label);
        driver.findElement(By.xpath(String.format(inputEmployees, this.label))).sendKeys(text);
    }

}
