package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setup Driver		
		WebDriverManager.chromedriver().setup();
		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();	
		
		//Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");	
		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Suganya");	
		
		//Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");	
		
		
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("SS");	
		

		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Dep");	
		
		
		// Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is test description");
		
		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Test@gmail.com");
		
		// Select State/Province as NewYork Using Visible Text
		
		 WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		 Select Stt = new Select(State);
		 Stt.selectByVisibleText("New York");
		 		 
		// Click on Create Button
		driver.findElement(By.name("submitButton")).click();	
			
		 
		// Get the Title of Resulting Page. refer the video  using driver.getTitle()
		
		String Title = driver.getTitle();
		
		System.out.println(Title);
				
		
		//WebElement Source = driver.findElement(By.id("createLeadForm_dataSourceId"));	
		
		//Select sor = new Select(Source);
		
		//sor.selectByValue("LEAD_CONFERENCE");
		
		//driver.findElement(By.name("submitButton")).click();	
		
			
	}

}
