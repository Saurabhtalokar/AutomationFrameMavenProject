package testBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public static void initialize() {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\DINESH\\eclipse-workspace\\AutomationFrame\\config.properties");
		prop = new Properties();
		prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver107.exe");
		//driver= new ChromeDriver();
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			}
		else {
			System.out.println("Enter correct browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	public static void colse() {
		driver.close();
	}
}
