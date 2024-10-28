	package chromebrowser;
	
	import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	
	public class LoginVerification {
		public static void main(String[] args) {
			// instance of chromedriver
			WebDriver driver = new ChromeDriver();
			// navigate to facebook.com
			driver.get("https://www.facebook.com/");
			// To maximise the browser
			driver.manage().window().maximize();
			// To verify the website redirected to facebook.com
			String currenturl = driver.getCurrentUrl();
	
			if (currenturl.contains("facebook.com")) {
				System.out.println("The website redirected to facebbok homepage");
			} else {
				System.out.println("The website not redirected to facebook homepage");
			}
	
			// To create a new account using xpath with text
			driver.findElement(By.xpath("//a[text()='Create new account']")).click();
			// Enter First mane using locator "name"
			driver.findElement(By.name("firstname")).sendKeys("Test");
	
			driver.findElement(By.name("lastname")).sendKeys("User");
	
			driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
	
			driver.findElement(By.name("reg_passwd__")).sendKeys("VJkavi@123");
		
			driver.findElement(By.xpath("//label[text()='Female']")).click();
			WebElement date = driver.findElement(By.id("day"));
			Select select = new Select(date);
			select.selectByIndex(10);
			
			WebElement month = driver.findElement(By.id("month"));
			Select selectMonth = new Select(month);
			selectMonth.selectByVisibleText("May");
			
			WebElement year = driver.findElement(By.id("year"));
			Select selectYear = new Select(year);
			selectYear.selectByValue("1985");
			
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			
			WebElement errorMsg = driver.findElement(By.cssSelector("div._58mo"));
			System.out.println(errorMsg);
			WebElement profileIcon = driver.findElement(By.cssSelector("div[aria-label='Account']"));
            if (profileIcon.isDisplayed()) {
                System.out.println("Login successful: Redirected to Facebook homepage.");
            } else {
                System.out.println("Login unsuccessful: Profile icon not displayed.");
            }
			
		}
	
	}
