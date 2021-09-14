package JustPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Xls_Reader;

public class Test1 {
private static final String dependsOnMethod = null;
WebDriver driver;
	
	
   // @BeforeMethod
	public void main() throws IOException {
		FileInputStream reads=new FileInputStream("C:\\Users\\SHIV\\eclipse-workspace\\Practice\\Data.properties");
		Properties reader=new Properties();
		reader.load(reads);
		
		
		String name=reader.getProperty("browser");
	System.out.println(name);
	if(name.equals("Firefox"))
	{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium Project\\geckodriver.exe");
		     driver=new FirefoxDriver();
		    driver.get("https://www.google.com/");
	}	
	else
	{
		System.out.println("wrong");
	}
	
    }
	
	@BeforeSuite
	public void stest()
	{
		System.out.println("I am a suite");
	}
	
	@BeforeClass
	public void ctest() {
		System.out.println("I am a class");
	}
	
   @BeforeTest
   public void btest() {
	   System.out.println("Hi I am there");
   }
	
	@Test(priority=1,enabled=true)
	public void test2() {
		System.out.println("My name is Manzil");
	}
    
    
	@Test(priority=2,dataProvider="dataprovider",groups="G")
	public void test(String value) {
		System.out.println(value);
		
	}
	
	
	
	@Test(priority=4,dependsOnMethods="test")
	public void test3()
	{
		System.out.println("I am from saduthala");
	}
	
	@Test(priority=3,groups="G")
	public void test4() {
		System.out.println("I live currently in brampton");
	}
	

	@DataProvider(name="dataprovider")
	public static Object[][] data() {
		
		return new Object[][] {{"Manzil"},{"Saduthala"}};
		
		}
	

	
	
	//@AfterMethod
	public void close() {
		driver.quit();
	}
	
	
	
	
}
