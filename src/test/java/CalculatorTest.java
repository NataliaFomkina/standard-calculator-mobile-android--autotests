import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
/*Написать тест для стандартного прилоджения калькулятора на любом телефоне с ОС Android
(тест проверяет нажатие цифровых клавиш и клавиш с арифметическими действиями, а также
делается по одной проверки на каждое арифметическое действие).
 */
public class CalculatorTest {
    private AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Copy_of_Pixel 4 API 30 2");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "11.0");
    capabilities.setCapability("udid", "emulator-5554");
    capabilities.setCapability("appPackage", "com.google.android.calculator");
    capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }
    @Test
    public void testAddition(){
        WebElement formulaInput = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));
        WebElement resultPreview = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        WebElement clear = driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr"));
// клавиши арифметических действий
        WebElement buttonPlus = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
        WebElement buttonMinus = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub"));
        WebElement buttonMultiplication = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul"));
        WebElement buttonDivision = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_div"));
        WebElement buttonPercent = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_pct"));
        WebElement buttonEqual = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
// клавиши цифр
        WebElement button0 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0"));
        WebElement button1 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1"));
        WebElement button2 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2"));
        WebElement button3 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3"));
        WebElement button4 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_4"));
        WebElement button5 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5"));
        WebElement button6 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_6"));
        WebElement button7 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7"));
        WebElement button8 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_8"));
        WebElement button9 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9"));

        //сложение
        button7.click();
        Assert.assertEquals("7", formulaInput.getText());
        buttonPlus.click();
        Assert.assertEquals("7+",formulaInput.getText());
        button0.click();
        Assert.assertEquals("7+0",formulaInput.getText());
        Assert.assertEquals("7",resultPreview.getText());
        clear.click();

        //вычитание
        button3.click();
        Assert.assertEquals("3", formulaInput.getText());
        buttonMinus.click();
        Assert.assertEquals("3−",formulaInput.getText());
        button9.click();
        Assert.assertEquals("3−9",formulaInput.getText());
        Assert.assertEquals("−6",resultPreview.getText());
        clear.click();

        //умножение
        button4.click();
        Assert.assertEquals("4", formulaInput.getText());
        buttonMultiplication.click();
        Assert.assertEquals("4×",formulaInput.getText());
        button5.click();
        Assert.assertEquals("4×5",formulaInput.getText());
        Assert.assertEquals("20",resultPreview.getText());
        clear.click();

        //деление
        button6.click();
        Assert.assertEquals("6", formulaInput.getText());
        buttonDivision.click();
        Assert.assertEquals("6÷",formulaInput.getText());
        button1.click();
        Assert.assertEquals("6÷1",formulaInput.getText());
        Assert.assertEquals("6",resultPreview.getText());
        clear.click();

        //проценты
        button2.click();
        Assert.assertEquals("2", formulaInput.getText());
        buttonPercent.click();
        Assert.assertEquals("2%",formulaInput.getText());
        Assert.assertEquals("0.02",resultPreview.getText());
        button8.click();
        Assert.assertEquals("2%8",formulaInput.getText());
        Assert.assertEquals("0.16",resultPreview.getText());

        //проверка =
        buttonEqual.click();
        WebElement resultFinal = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        Assert.assertEquals("0.16", resultFinal.getText());

    }
    @After
    public void clear(){driver.quit();}
}
