package com.blazeDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author ADMIN
 * @Description To maintain all the reusable methods
 * @CreationDate 29/06/2022
 *
 */

public class BaseClass {
	
	public static WebDriver driver;

	/**
	 * 
	 * @param browserType
	 * @Description Used to launch browser
	 * @CreationDate 29/06/2022
	 * 
	 */
	public static void getDriver(String browserType) {

	switch (browserType) {
	case "Chrome":
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		break;
	case "IE":
		WebDriverManager.iedriver().setup(); 
		driver=new InternetExplorerDriver();
		break;
	case "Firefox":
		WebDriverManager.firefoxdriver().setup(); 
		driver=new FirefoxDriver();
		break;
	case "Edge":
		WebDriverManager.edgedriver().setup(); 
		driver=new EdgeDriver();
		break;

	default:
		break;
		}	
	}

	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description To find a locator by using Id
	 * @CreationDate 29/06/2022
	 * 
	 */
	public WebElement findElementById(String name) {

		WebElement findElement = driver.findElement(By.id(name));
		return findElement;

	}
	
	/**
	 * 
	 * @return String
	 * @Description To get a Title from WebElement
	 * @CreationDate 29/06/2022
	 */
	public String getTitle() {

		String title = driver.getTitle();
		return title;

	}

	/**
	 * 
	 * @return String
	 * @Description To get current URL from WebPage
	 * @CreationDate 29/06/2022
	 * 
	 */
	public String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	/**
	 * 
	 * @return String
	 * @Description To get launch URL from WebPage
	 * @CreationDate 29/06/2022
	 * 
	 */
	public static void launchUrl(String url) {

		driver.get(url);
	}
	/**
	 * 	
	 * @param element
	 * @Description To clear the text in particular WebElement 
	 * @CreationDate 29/06/2022
	 */
	public void clearText(WebElement element) {

		element.clear();

	}
	/**
	 * 	
	 * @return String
	 * @Description To handle the single window
	 * @CreationDate 29/06/2022
	 * 
	 */
	public String windowHandle() {

		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
	/**
	 * 
	 * @return String
	 * @Description To get Page Source
	 * @CreationDate 29/06/2022
	 */
	public String getPageSource() {

		String pageSource = driver.getPageSource();
		return pageSource;

	}
	/**
	 * @Description To close the current window
	 * @CreationDate 29/06/2022
	 */
	public void closeWindow() {

		driver.close();

	}
	/**
	 * @Description To close all the Windows
	 * @CreationDate 29/06/2022
	 */
	public static void closeAllWindow() {

		driver.quit();

	}
	/**
	 * 
	 * @param element
	 * @param data
	 * @Description To send the values for inputs
	 * @CreationDate 29/05/2022
	 */
	//9.to type text
	public static void typeText(WebElement element, String data) {

		element.sendKeys(data);

	}
	/**
	 * 
	 * @param element
	 * @Description To use click the button
	 * @CreationDate 29/06/2022
	 */
	public void clickButton(WebElement element) {

		element.click();

	}
	/**
	 * 
	 * @param element
	 * @Description To use Submit the button
	 * @CreationDate 29/06/2022
	 */
	public void submit(WebElement element) {

		element.submit();

	}
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description To get property from properties file
	 * @CreationDate 29/06/2022
	 */
	public String getpropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+ "\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	/**
	 * 
	 * @param element
	 * @return String
	 * @Description To get the Location of file
	 * @CreationDate 29/06/2022
	 */
	public Point getLocation(WebElement element) {

		Point location = element.getLocation();
		return location;

	}
	/**
	 * 
	 * @param element
	 * @param value
	 * @return String
	 * @Description To get attribute value
	 * @CreationDate 29/06/2022
	 */
	public static String getAttribute(WebElement element, String value) {

		String attribute = element.getAttribute(value);
		return attribute;

	}
	/**
	 * 
	 * @param element
	 * @return string
	 * @Description To get attribute value
	 * @CreationDate 29/06/2022
	 */
	public static String getAttribute(WebElement element) {

		String attribute = element.getAttribute("value");	
		return attribute;

	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description To check it is enabled
	 * @CreationDate 29/06/2022
	 */
	public boolean isEnabled(WebElement element) {

		boolean enabled = element.isEnabled();
		return enabled;

	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description To check it is displayed
	 * @CreationDate 29/06/2022
	 */
	public boolean isDisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		return displayed;

	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @Description To check it is Selected
	 * @Creationdate 29/06/2022
	 */
	public boolean isSelected(WebElement element) {

		boolean selected = element.isSelected();
		return selected;

	}
	/**
	 * 
	 * @param element
	 * @return string
	 * @Description To get the text
	 * @CreationDate 29/06/2022
	 */
	public String getText1(WebElement element) {

		String text = element.getText();
		return text;

	}
	/**
	 * @Description To get the TagName
	 * @CreationDate 29/06/2022
	 */
	public String toGetTagName(WebElement element) {

		String tagName = element.getTagName();
		return tagName;

	}
	/**
	 * @Description To maximize the window
	 * @CreationDate 29/06/2022
	 */
	public static void maximize() {

		driver.manage().window().maximize();

	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return point
	 * @Description To set the point of window
	 * @CreationDate 29/06/2022
	 */
	public Point setPoint(int x, int y) {

		Point p=new Point(x, y);
		driver.manage().window().setPosition(new Point(x, y));
		return p;

	}
	/**
	 * 
	 * @param width
	 * @param height
	 * @return Dimension
	 * @Description To set the dimensions of the window
	 * @CreationDate 29/06/2022
	 */
	public Dimension setDimension(int width, int height) {

		Dimension d=new Dimension(width, height);
		return d;

	}
	/**
	 * 
	 * @param element
	 * @Description To perform MouseOver action
	 * @CreationDate 29/06/2022
	 */
	public void performMouseover(WebElement element) {

		Actions a=new Actions(driver);
		a.moveToElement(element).perform();

	}
	/**
	 * 
	 * @param element
	 * @Description To perform click action
	 * @CreationDate 29/06/2022
	 */
	public void click(WebElement element) {

		Actions a=new Actions(driver);
		a.click(element).perform();

	}
	/**
	 * 
	 * @param element
	 * @Description To perform Double click action
	 * @CreationDate 29/06/2022
	 */
	public void doubleClick(WebElement element) {

		Actions a=new Actions(driver);
		a.doubleClick(element).perform();

	}
	/**
	 * 
	 * @param element
	 * @Description To perform a RightClick action
	 * @CreationDate 29/06/2022
	 */
	public void rightClick(WebElement element) {

		Actions a=new Actions(driver);
		a.contextClick(element).perform();

	}
	/**
	 * 
	 * @param source
	 * @param target
	 * @Description To perform a Drag and Drop
	 * @CreationDate 29/06/2022
	 */
	public void dragAndDrop(WebElement source, WebElement target) {

		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();

	}
	/**
	 * 
	 * @param keycode
	 * @throws AWTException
	 * @Description To perform key press
	 * @CreationDate 29/06/2022
	 */
	public void keyPress(int keycode) throws AWTException {

		Robot r=new Robot();
		r.keyPress(keycode);

	}
	/**
	 * 
	 * @param keycode
	 * @throws AWTException
	 * @Description To perform key release
	 * @DateCreation 29/06/2022
	 */
	public void keyRelease(int keycode) throws AWTException {

		Robot r=new Robot();
		r.keyRelease(keycode);

	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @Description To pass text using JavaScript
	 * CreationDate 29/06/2022
	 */
	public void typeJs(WebElement element, String text) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].('value','"+text+"')", element);

	}
	/**
	 * 
	 * @param element
	 * @Description To perform click using JavaScript
	 * @CreationDate 29/06/2022
	 */
	public void Button(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].click()", element);

	}
	/**
	 * 
	 * @param location
	 * @throws IOException
	 * @Description To take ScreenShot
	 * @CreationDate 29/06/2022
	 */
	public void takeScreeenshot(String location) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(location));

	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @Description To perform DropDown using Visible Text
	 * @CreationDate 29/06/2022
	 */
	public void dDnByText(WebElement element, String text) {

		Select s=new Select(element);
		s.selectByVisibleText(text);

	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @Description To perform DropDown using Attribute
	 * @CreationDate 29/06/2022
	 */
	public void dDnByValue(WebElement element, String text) {

		Select s=new Select(element);
		s.selectByValue(text);

	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @Description To perform DropDown operation using Index
	 * @CreationDate 29/06/2022
	 */
	public void dDnByIndex(WebElement element, int index) {

		Select s=new Select(element);
		s.selectByIndex(index);

	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @Description To perform DropDown operation by DeSelect using Visible Text 
	 * @CreationDate 29/06/2022
	 */
	public void deselectByVisibleText(WebElement element, String text) {

		Select s=new Select(element);
		s.deselectByVisibleText(text);

	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @Description To perform DropDown operation by DeSelect using Attribute
	 * @CreationDate 29/06/2022
	 */
	public void deselectByValue(WebElement element, String text) {

		Select s=new Select(element);
		s.deselectByValue(text);

	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @Description To perform DropDown operation by DeSelect using Index
	 * @CreationDate 29/06/2022
	 */
	public void deselectByIndex(WebElement element, int index) {

		Select s=new Select(element);
		s.deselectByIndex(index);

	}
	/**
	 * 
	 * @param element
	 * @Description To perform DropDown operation by DeSelectAll
	 * @CreationDate 29/06/2022
	 */
	public void deselectByAll(WebElement element) {

		Select s=new Select(element);
		s.deselectAll();

	}
	/**
	 * 
	 * @param element
	 * @Description To check Multiple option in DropDown
	 * @Creationdate 29/06/2022
	 */
	public void isMultiple(WebElement element) {

		Select s=new Select(element);
		s.isMultiple();

	}
	/**
	 * 
	 * @param url
	 * @Description To Navigate one to another URL
	 * @Creationdate 29/06/2022
	 */
	public void navigateUrl(String url) {

		driver.navigate().to(url);

	}
	/**
	 * @Description To Navigate forward URL
	 * @Creationdate 29/06/2022
	 */
	public void navigateForward() {

		driver.navigate().forward();

	}
	/**
	 * @Description To Navigate Backward URL
	 * @Creationdate 29/06/2022
	 */
	public void navigateBackward() {

		driver.navigate().back();

	}
	/**
	 * @Description To Navigate refresh in URL page
	 * @Creationdate 29/06/2022
	 */
	public void navigateRefresh() {

		driver.navigate().refresh();

	}
	/**
	 * 
	 * @param time
	 * @throws InterruptedException
	 * @Description To stop temporary execution for while
	 * @Creationdate 29/06/2022
	 */
	public void sleep(int time) throws InterruptedException {

		Thread.sleep(time);

	}
	/**
	 * 
	 * @param time
	 * @Description To stop the time being execution till end
	 * @Creationdate 29/06/2022
	 */
	public static void implicitWaits(long time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}
	/**
	 * 
	 * @param index
	 * @Description Switch to frame using Index
	 * @Creationdate 29/06/2022
	 */
	public void frameIndex(int index) {

		driver.switchTo().frame(index);

	}
	/**
	 * 
	 * @param text
	 * @Description Switch to frame using FrameValue
	 * @Creationdate 29/06/2022
	 */
	public void frameValue(String text) {

		driver.switchTo().frame(text);

	}
	/**
	 * @Description Switch to Parent frame
	 * @Creationdate 29/06/2022
	 */
	public void frameParent() {

		driver.switchTo().parentFrame();

	}
	/**
	 * 
	 * @param element
	 * @Description Switch to Frame using Reference Element
	 * @Creationdate 29/06/2022
	 */
	public void frameReference(String element) {

		driver.switchTo().frame(element);

	}
	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @Description To FindElement using Id
	 * @Creationdate 29/06/2022
	 */
	public WebElement findElementById1(String id) {

		WebElement element = driver.findElement(By.id(id));
		return element;

	}
	/**
	 * 
	 * @param name
	 * @return webElement
	 * @Description To FindElement using Name
	 * @Creationdate 29/06/2022
	 */
	public WebElement findElementByName(String name) {

		WebElement element = driver.findElement(By.name(name));
		return element;

	}
	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description To FindElement using ClassName
	 * @Creationdate 29/06/2022
	 */
	public WebElement findElementByclassName(String name) {

		WebElement element = driver.findElement(By.className(name));
		return element;

	}
	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @Description To FindElement using TagName
	 * @Creationdate 29/06/2022
	 */
	public WebElement findElementByTagName(String name) {

		WebElement element = driver.findElement(By.tagName(name));
		return element;

	}
	/**
	 * 
	 * @param xpathExpression
	 * @return WebElement
	 * @Description To FindElement using AttributeName
	 * @Creationdate 29/06/2022
	 */
	public WebElement findElementByAttributeValue(String xpathExpression) {

		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;

	}
	/**
	 * @Description Switch to Alert Click OK
	 * @Creationdate 29/06/2022
	 */
	public void simpleAlerts() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	/**
	 * @Description Switch to Alert Click OK for Dismiss
	 * @Creationdate 29/06/2022
	 */
	public void confirmAlert() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}
	/**
	 * 
	 * @param element
	 * @param tagName
	 * @return List<WebElement>
	 * @Description To FindElements using TagName
	 * @Creationdate 29/06/2022
	 */
	public List<WebElement> findElementsUsingTagName(WebElement element, String tagName) {

		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;

	}
	
}
