import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.runners.MethodSorters;

public class LogowanieTest {

  WebDriver driverChrome;
  WebDriver driverFirefox;
  WebDriver driverIe;
  WebDriver driverEdge;
  JavascriptExecutor jsChrome;
  JavascriptExecutor jsFirefox;
  JavascriptExecutor jsIe;
  JavascriptExecutor jsEdge;
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setupChromeDriver() {
    WebDriverManager.chromedriver().setup();
    driverChrome = new ChromeDriver();
    jsChrome = (JavascriptExecutor) driverChrome;
  }
  @Before
  public void setupGeckoDriver() {
    WebDriverManager.firefoxdriver().setup();
    driverFirefox = new FirefoxDriver();
    jsFirefox = (JavascriptExecutor) driverFirefox;
  }
  @Before
  public void setupIeDriver() {
    WebDriverManager.iedriver().setup();
    driverIe = new InternetExplorerDriver();
    jsIe = (JavascriptExecutor) driverIe;
  }
  @Before
  public void setupEdgeDriver() {
    WebDriverManager.edgedriver().setup();
    driverEdge = new EdgeDriver();
    jsEdge = (JavascriptExecutor) driverEdge;
  }
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
    driverChrome.quit();
    driverFirefox.quit();
    driverIe.quit();
  }

  public void loadPage(WebDriver driver,String url){
    driver.get(url);
    driver.manage().window().setSize(new Dimension(945, 1020));
  }

  public void logIn(WebDriver driver,String username,String password, String selector){
    if (selector.equals("css")) {
      driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys(username);
      driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(password);
      driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    }
    if (selector.equals("xpath")) {
      driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
      driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }
    if (selector.equals("name")) {
      driver.findElement(By.name("user-name")).sendKeys(username);
      driver.findElement(By.name("password")).sendKeys(password);
      driver.findElement(By.name("login-button']")).click();
    }
  }

  @Test
  public void gotoaddress() {
    loadPage(driverEdge, "https://www.saucedemo.com/");
    {
      List<WebElement> elements = driverEdge.findElements(By.cssSelector(".login_logo"));
      assert (elements.size() > 0);
    }
    driverEdge.close();
  }

  @Test()
  public void correctLogin() {
    loadPage(driverFirefox, "https://www.saucedemo.com/");
    logIn(driverFirefox,"standard_user","secret_sauce","xpath");
    {
      List<WebElement> elements = driverChrome.findElements(By.cssSelector(".app_logo"));
      assert(elements.size() > 0);
    }
    driverFirefox.close();
  }

    @Test
    public void addtocart() {
      loadPage(driverChrome, "https://www.saucedemo.com/");
      logIn(driverChrome,"standard_user","secret_sauce","xpath");
      addToCart(driverChrome,"*[data-test=\"add-to-cart-sauce-labs-backpack\"]","css");
      driverChrome.findElement(By.linkText("1")).click();
      assertEquals(driverChrome.findElement(By.cssSelector(".inventory_item_name")).getText(), ("Sauce Labs Backpack"));
      driverChrome.close();
    }
}
