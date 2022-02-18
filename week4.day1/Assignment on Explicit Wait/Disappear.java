package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args) throws IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		
		WebDriverWait ExplicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		ExplicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn")));
		boolean Button = driver.findElement(By.xpath("//button[@id = 'btn']")).isDisplayed();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/Img001.jpg");
		FileUtils.copyFile(source, dest);
		if (Button != true) {
			System.out.println("The button has Disappeared");
		} else {
			System.out.println("The button has not disappeared");
		}
		System.out.println(driver.findElement(By.tagName("strong")).getText());

	}

}
