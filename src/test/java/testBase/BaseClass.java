package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public Properties prop;
	
	@BeforeClass(groups= {"smoke","sanity","regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws InterruptedException, IOException

	{
		logger=LogManager.getLogger(this.getClass());
		
		FileReader f= new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(f);
		
		//to run TC's in remote -selenium GRID
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(br.toLowerCase())
		{
		case  "chrome" :
			driver=new ChromeDriver();
			break;
		case  "edge" :
			driver =new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}
		
		
		}
		
		//WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("appURL"));
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		
	}
	
	
	@AfterClass(groups= {"smoke","sanity","regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String getRandomString()
	{
		
		
		return RandomStringUtils.randomAlphabetic(6);
		
	}
	
	
	public String getRandomEmailid()
	
	{
		
		
		return RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
