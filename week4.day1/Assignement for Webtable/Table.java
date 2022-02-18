package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
        driver.get("http://www.leafground.com/pages/table.html ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebElement element = driver.findElement(By.id("table_id"));
        List<WebElement> trows = element.findElements(By.tagName("tr"));
        System.out.println("Total Number of Rows in Table:-> "+trows.size());
        WebElement firstrow = trows.get(1);
        int tcols = firstrow.findElements(By.tagName("td")).size();
        System.out.println("Total Number Of Columns in Table:-> "+tcols);
        for (int i = 0; i < trows.size(); i++) {
        	WebElement row1 = trows.get(i);
        	List<WebElement> col1 = row1.findElements(By.tagName("td"));
			//System.out.println(trows.get(i).getText());
        	for (int j = 0; j < col1.size(); j++) {
        		if(col1.get(j).getText().contains("Learn to interact with Elements")){
	        		System.out.println("Progress value of 'Learn to interact with Elements:->"+col1.get(1).getText());
	         	}
        		else if(col1.get(j).getText().contains("Learn to interact using Keyboard, Actions")) {
					driver.findElement(By.xpath("(//tr[@class='even']//input)[2]")).click();
        		}
			}
			
		}

	}

}
