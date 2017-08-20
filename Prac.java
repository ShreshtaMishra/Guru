package Sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\shres\\\\Desktop\\\\Backup\\\\Softwares\\\\SeleniumAPI\\\\geckodriver-v0.17.0-win64\\\\geckodriver.exe");
			WebDriver w = new FirefoxDriver();
			w.get(Util.BaseURL);
		String a = w.getTitle();
		System.out.println(a);
		w.findElement(By.name("uid")).clear();
		w.findElement(By.name("uid")).sendKeys("mngr92049");
		//Enter Password
		w.findElement(By.name("password")).clear();
		w.findElement(By.name("password")).sendKeys("jErarUv");
		//Click Login
		w.findElement(By.name("btnLogin")).click();
		String actualTitle = w.getTitle();
		System.out.println(actualTitle);
	}

}
