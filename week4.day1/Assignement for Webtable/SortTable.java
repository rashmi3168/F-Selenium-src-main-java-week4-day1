package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
        driver.get("http://www.leafground.com/pages/sorttable.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        List<String> nameList = new ArrayList<String>();
        WebElement tabledata = driver.findElement(By.id("table_id"));
        List<WebElement> trow = tabledata.findElements(By.tagName("tr"));
        
        for (int i = 1; i < trow.size(); i++) {
        	WebElement currentrow = trow.get(i);
        	List<WebElement> tcol = currentrow.findElements(By.tagName("td"));
			String text = tcol.get(1).getText();
			nameList.add(text);
			//System.out.println(text);
		}
        Collections.sort(nameList);
        System.out.println("Sorted Name List:-> ");
        for (String eachName : nameList) {
			System.out.println(eachName);
		}
        
        driver.findElement(By.xpath("//th[text()='Name']")).click();
        List<String> nextList = new ArrayList<String>();
        WebElement tabledata1 = driver.findElement(By.id("table_id"));
        List<WebElement> trow1 = tabledata1.findElements(By.tagName("tr"));
        
        for (int i = 1; i < trow1.size(); i++) {
        	WebElement currentrow1 = trow1.get(i);
        	List<WebElement> tcol1 = currentrow1.findElements(By.tagName("td"));
			String text1 = tcol1.get(1).getText();
			nextList.add(text1);
			System.out.println(text1);
		}
        
        if(nameList.equals(nextList))
        {
        	System.out.println("Both List Data are Sorted");
        }
        else
        {
        	System.out.println("Both List Data are not Sorted");
        }
	}

}
