package Sanity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;



public class Login {
	
	static WebDriver w;
	
	
	public void launchFirefox()
	
	{
		
		System.setProperty(Util.DName,Util.FirefoxPath);
		//Set up the FireFox
		
		ProfilesIni prof= new ProfilesIni();
		FirefoxProfile ffprofile = prof.getProfile("Test");
		ffprofile.setAcceptUntrustedCertificates(true); 
		ffprofile.setAssumeUntrustedCertificateIssuer(false);
		w = new FirefoxDriver(ffprofile);
		// Launching the URL
		w.get(Util.BaseURL);
	}
	
	public static void main (String[] args) throws Exception
	{
		
		Login a = new Login();
		a.launchFirefox();
		Thread.sleep(5000);
		
		int i ;int j=0;
		String UserName;
		String Password;
//		
		ExcelData d = new ExcelData("C:\\Users\\shres\\Desktop\\Backup\\Selenium\\TestData.xlsx");
		
		
		
			for(i=0;i<=3;i++)
			{
				UserName=ExcelData.getData(0,i,j);
				j= j+1;
				Password= ExcelData.getData(0,i,j);
				j=0;
			//Enter user name
			w.findElement(By.name("uid")).clear();
			w.findElement(By.name("uid")).sendKeys(UserName);
			w.findElement(By.name("password")).clear();
			w.findElement(By.name("password")).sendKeys(Password);
			//Click Login
			w.findElement(By.name("btnLogin")).click();
			Thread.sleep(5000);
		     try {
				Alert a1=(w.switchTo().alert());
				String message =(a1.getText());
				System.out.println(message);
				Thread.sleep(5000);
				a1.accept();			
				System.out.println("Login successful");
				if(message.contains(Util.Error))
				{
					System.out.println("Passed");
					Thread.sleep(5000);
				}
				else
				{
					System.out.println("Failed");
				}
		     } 
		     catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
				
			}
		     
			}
			
			String actualTitle = w.getTitle();
			System.out.println(actualTitle);
			if(actualTitle.contains(Util.ExpectedName) )
			{
				System.out.println("Test Case: Passed");
			}
			
			else
			{
				System.out.println("Test Case:Failed");
			}
			
		}
		
	}
		
		


