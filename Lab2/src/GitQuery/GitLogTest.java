package GitQuery;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;

public class GitLogTest {

	private WebDriver driver;

	private static void everyTest(WebDriver driver, String url, String key, String value) {
		driver.get(url);
		driver.manage().window().setSize(new Dimension(550, 693));
		driver.findElement(By.name("user_number")).click();
		driver.findElement(By.name("user_number")).sendKeys(key);
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(value);
		driver.findElement(By.cssSelector(".btn")).click();
		driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).click();
		assertThat(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText(), is(value));

	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\AboutEclipse\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void gitQuery() {
		try {

			Workbook book = Workbook.getWorkbook(new File("E:\\AboutEclipse\\softwaretest\\src\\Selenium+Lab2020.xls"));
			HashMap<String, String> map = new HashMap<String, String>();
			Sheet sheet = book.getSheet(0);
			int index = 0;
			while (!sheet.getCell(1, index).getContents().equals("")) {
				index++;
			}

			for (int i = 0; i < index; i++) {
				map.put(sheet.getCell(1, i).getContents(), sheet.getCell(2, i).getContents());
			}

			book.close();
			Set<Map.Entry<String, String>> set = map.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> ele = (Entry<String, String>) it.next();
				everyTest(driver, "http://103.120.226.190/selenium-demo/git-repo", ele.getKey(), ele.getValue());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
