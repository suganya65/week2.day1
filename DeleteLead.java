package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
        driver.findElement (By.xpath ( "(//span[@class='x-tab-strip-text '])[2]" ) ).click ( );

        //9	 Enter phone number
        driver.findElement (By.xpath ( "//input[@name='phoneCountryCode']" ) ).clear ( );
        driver.findElement (By.xpath ( "//input[@name='phoneCountryCode']" ) ).sendKeys ( "44" );
        driver.findElement (By.xpath ( "//input[@name='phoneAreaCode']" ) ).clear ( );
        driver.findElement (By.xpath ( "//input[@name='phoneAreaCode']" ) ).sendKeys ( "12" );
        driver.findElement (By.xpath ( "//input[@name='phoneNumber']" ) ).clear ( );
        driver.findElement (By.xpath ( "//input[@name='phoneNumber']" ) ).sendKeys ( "23124124" );

        //10 Click find leads button
        driver.findElement (By.xpath ( "//button[text()='Find Leads']" ) ).click ( );

        
        Thread.sleep(2000);
        
        
       // Capture lead ID of First Resulting lead
        WebElement eleLeadId = driver.findElement ( By.xpath ( "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a" ) );

        String Element = eleLeadId.getText();
		System.out.println("First lead id is "+Element);
        
        //Click First Resulting lead
        eleLeadId.click ( );
        
        //13 Click Delete
        driver.findElement (By.xpath ("//a[@class='subMenuButtonDangerous']" ) ).click ( );

        //14 Click Find leads
        driver.findElement (By.xpath ("//ul[@class='shortcuts']/li/a[text()='Find Leads']" ) ).click ( );

        //15 Enter captured lead ID
        driver.findElement (By.xpath ("(//div[@class='x-form-item x-tab-item']/div/input[@class=' x-form-text x-form-field'])[1]" ) ).sendKeys (Element);
       
        //16 Click find leads button
        driver.findElement ( By.xpath ( "//button[text()='Find Leads']" ) ).click ( );
        
        Thread.sleep ( 2000 );

        //17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
        WebElement Element2=driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		
        String Ele=Element2.getText();
		System.out.println("Result is " +Ele );
		
		
		//	18	Close the browser (Do not log out)
		driver.close();
	}

}
