package DDT;


import org.openqa.selenium.chrome.ChromeDriver;

public class DebuggingEx {

	public static void main(String[] args) {
		
		 ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

}
