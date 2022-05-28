package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			//Setup Driver		
			WebDriverManager.chromedriver().setup();
			
			//Open the browser
			ChromeDriver driver = new ChromeDriver();
			
			// Maximise the window
			driver.manage().window().maximize();
			
			
		//* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
			driver.get("http://leaftaps.com/opentaps/control/login");
			
		 //* 2. Enter UserName and Password Using Id Locator
		  driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		  
		 //* 3. Enter UserName and Password Using Id Locator
		  driver.findElement(By.id("password")).sendKeys("crmsfa");
			
		 //* 4. Click on Login Button using Class Locator
		  driver.findElement(By.className("decorativeSubmit")).click();
			
		 //* 5. Click on CRM/SFA Link
		  driver.findElement ( By.linkText ( "CRM/SFA" ) ).click ( );


	        //6	 Click Leads link
	        driver.findElement (By.linkText ( "Leads" ) ).click ( );

	        //7	 Click Find leads
	        driver.findElement (By.linkText ( "Find Leads" ) ).click ( );

	        //8	 Click on Phone
	        driver.findElement (By.xpath ( "(//span[@class='x-tab-strip-text '])[3]" ) ).click ( );
	        
	        Thread.sleep(2000);

	        //9	 Enter Email address
	        driver.findElement (By.xpath ( "//input[@name='emailAddress']" ) ).sendKeys ( "test@gmail.com" );
	       
	        //10 Click find leads button
	        driver.findElement (By.xpath ( "//button[text()='Find Leads']" ) ).click ( );

	        
	        Thread.sleep(2000);
	        
	        
	       // 11 Capture lead ID of First Resulting lead
	        WebElement eleLeadId = driver.findElement ( By.xpath ( "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a" ) );

	        String Element = eleLeadId.getText();
			System.out.println("First lead id is "+Element);
	        
	        //12 Click First Resulting lead
	        eleLeadId.click ( );
	        

	      //13 Click duplicate button
	        driver.findElement (By.linkText("Duplicate Lead")).click ( );
	        
	        //14 get title
	        String title =driver.getTitle();
	        
	        System.out.println("Title is :" + title);
	        
	        //15 click on create lead
	        driver.findElement (By.name("submitButton")).click ( );   
	        
	        // 16 Confirm the duplicated lead name is same as captured name
	        String FirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if (FirstName.equals(Element)) {
				System.out.println("Duplicate Lead Name");
			} else {
				System.out.println("Its not duplicate name");
			}

	        System.out.println();
	        
		
		
	}

}
