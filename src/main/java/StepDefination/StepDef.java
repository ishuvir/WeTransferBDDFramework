package StepDefination;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	static WebDriver driver;
	
	@Given("^user is already on WeTransfer page$")
	public void user_is_already_on_WeTransfer_page() {
		 System.setProperty("webdriver.chrome.driver", "D:\\lib\\libs\\chromedriver.exe");
		driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://wetransfer.com/");
	}

	@When("^T&C screen is displayed$")
	public void t_C_screen_is_displayed() {
	    System.out.println("User is on WeTransfer Screen");
	    WebElement Welcome_Title=driver.findElement(By.className("welcome__title"));
		//To verify welcome title is displayed
		Welcome_Title.isDisplayed();
		System.out.println(Welcome_Title.getText());
	    WebElement TCButton=driver.findElement(By.xpath("//button[text()='I agree']"));
	boolean buttonStatus = TCButton.isDisplayed();
	System.out.println("Button status"+buttonStatus);
	    System.out.println("T&C Button is displayed as"+TCButton.getText());
	    }

	@Then("^User clicks on Accept button$")
	public void user_clicks_on_Accept_button()  {
		 WebElement TCButton=driver.findElement(By.xpath("//button[text()='I agree']"));
		    if(TCButton.isDisplayed())
		    {
		    	System.out.println("Accept the T & C of WeTransfer");
		    	TCButton.click();
		    
		}
		    else
		    {
		    	System.out.println("User has already accepted the T&C of WeTransfer");
		    }
	   
	}

	@Then("^User upload a file from local system$")
	public void user_upload_a_file_from_local_system() throws AWTException, InterruptedException{
	    WebElement FileUploadSection=driver.findElement(By.xpath("//*[@class='uploader__files']"));
	    boolean FileSectionStatus=FileUploadSection.isDisplayed();
	    System.out.println("Is file Uploader sections is displayed: "+FileSectionStatus);
	    System.out.println(FileUploadSection.getText());
	    Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//*[text()='Or select a folder']")).sendKeys();
	    driver.findElement(By.xpath("//*[text()='Or select a folder']")).sendKeys("C:\\Users\\Ishuvir singh\\Downloads\\CucumberSeleniumFramework-master\\WeTransfer_AutomationFramework\\Testfolder");
        StringSelection ss = new StringSelection("C:\\Users\\Ishuvir singh\\Downloads\\CucumberSeleniumFramework-master\\WeTransfer_AutomationFramework\\Testfolder");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Thread.sleep(3000);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.setAutoDelay(2000);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.setAutoDelay(2000);
	    robot.keyPress(KeyEvent.VK_LEFT);
	    robot.keyRelease(KeyEvent.VK_LEFT);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    //Thread.sleep(5000);
String Fileuploadcount= driver.findElement(By.xpath("(//span[@class='file-system-entry__detail'])[2]")).getText();
	  System.out.println("No of Files Upload="+Fileuploadcount);
	}
	
	

	@Then("^User select Get Transfer link option$")
	public void user_select_Get_Transfer_link_option() throws InterruptedException {
		
	  WebElement DotButton =driver.findElement(By.xpath("//button[@class='transfer__toggle-options']"));
	  DotButton.sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
	  WebElement transferlinkOp=driver.findElement(By.xpath("(//div[@class='radioinput__check'])[2]"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", transferlinkOp);	 
	  Thread.sleep(2000);
	boolean LinkbuttonStatus=driver.findElement(By.xpath("//button[@class='transfer__button']")).isEnabled();
	   System.out.println("TransferLink status is enable :"+LinkbuttonStatus);
	   driver.findElement(By.xpath("//button[@class='transfer__button']")).sendKeys(Keys.ENTER);
	}

	@Then("^User saves the Transfer link$")
	public void user_saves_the_Transfer_link() throws InterruptedException {
	   Thread.sleep(10000);
String LinkUrl=driver.findElement(By.xpath("//input[@class='transfer-link__url']")).getAttribute("value");
	   System.out.println("Transfer Link Url is= "+LinkUrl);
	   driver.close();
	}
}
