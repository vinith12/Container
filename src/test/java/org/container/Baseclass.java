package org.container;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	
	public static void chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void Firelaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void urllaunch(String a) {
		driver.get(a);
	}

	public static void clikk(WebElement a) {
		a.click();
	}

	public static void quitt() {
      driver.quit();
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void waitt() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void sendkeys(WebElement a, String b) {
		a.sendKeys(b);
	}
	public static String gettext(WebElement b) {
		String text = b.getText();
		return text;
	}
	
	public static String getatt(WebElement x) {
		String atr = x.getAttribute("value");
		return atr;
	}

	public static void movetoelement(WebElement a) {
		Actions c = new Actions(driver);
		c.moveToElement(a).perform();
	}
	public static void context(WebElement a) {
		Actions c = new Actions(driver);
		c.contextClick().perform();
	}
	public static void aclick(WebElement a) {
		Actions c = new Actions(driver);
		c.click().perform();
	}
	public static void doubleclick(WebElement a) {
		Actions c = new Actions(driver);
		c.doubleClick().perform();
	}

	public static void drgdrp(WebElement a, WebElement b) {
		Actions c = new Actions(driver);
		c.dragAndDrop(a, b).perform();
	}

	public static void alert() {
      Alert v = driver.switchTo().alert();
      v.accept();
	}
	public static void alert2() {
	      Alert d = driver.switchTo().alert();
	      d.dismiss();
	}
	public static void selebyind(WebElement x, int v) {
		Select s = new Select(x);
		s.selectByIndex(v);
	}

	public static void selebyval(WebElement x, String a) {
		Select s = new Select(x);
		s.selectByValue(a);
	}
	
	public static void selebyvisitext(WebElement x, String a) {
		Select s = new Select(x);
		s.selectByVisibleText(a);
	}
	
	public static void frames(Integer x) {
     driver.switchTo().frame(x);
	}
	public static void windowhandle(Integer a) {
     Set<String> wh = driver.getWindowHandles();
      
     List<String> l = new LinkedList<String>();
     l.addAll(wh);
     driver.switchTo().window(l.get(a));

}
	public static String ex(int x,int y ) throws IOException {
		
	File f =new File("C:\\Users\\DELL\\eclipse-workspace\\MavenFrameWrk\\src\\test\\resources\\Excel\\Datagrens.xlsx");

	FileInputStream fi = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet s = wb.getSheet("Sheet1");
	Row r = s.getRow(x);
	Cell cel = r.getCell(y);
	int type = cel.getCellType();
	String value =null;
	if (type==1) {
		 value = cel.getStringCellValue();
	}
	else {
		if(DateUtil.isCellDateFormatted(cel)) {
			Date dc = cel.getDateCellValue();
			SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
			 value = sd.format(dc);
		}
		else {
			double ncv = cel.getNumericCellValue();
			long num = (long)ncv;
			 value = String.valueOf(num);
		}
		
	}
	return value;
	}
}
