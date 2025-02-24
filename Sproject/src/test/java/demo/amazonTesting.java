package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class amazonTesting {
    public static void main(String[] args) {

    	// Set WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Navigate to Netflix
        driver.get("https://www.netflix.com/");

        // Click "Sign In" button
        driver.findElement(By.linkText("Sign In")).click();

        // Fill in login form
        driver.findElement(By.name("userLoginId")).sendKeys("youremail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("your_password"); 
        System.out.println("test case 1: Login in Successfully!!!!!");

        // Find and click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-uia='login-submit-button']")));
        loginButton.click();

        // Select Profile "Ravi"
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//*[@id=\"appMountPoint\"]/div/div/div[1]/div[1]/div[2]/div/div/ul/li[1]/div/a/span")));
        profileLink.click();
        System.out.println("test case 2: Profile Selected");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Initiate search
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.searchTab[aria-label='Search']")));
        searchButton.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Titles, people, genres']")));
        searchInput.sendKeys("Animal");
        System.out.println("test case 3: Movie Searched");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Click on the first "Friends" search result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='title-card-0-0']/div[1]/a")));
        driver.findElement(By.xpath("//*[@id='title-card-0-0']/div[1]/a")).click();
        System.out.println("test case 4: click on the first movie");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Close the preview popup (if present)
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-uia='previewModal-closebtn']")));
        closeButton.click();
        System.out.println("test case 5: close pop-up Window ");

        // Hover over the profile icon and sign out
        WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/YourAccount']")));

        Actions actions = new Actions(driver);
        actions.moveToElement(profileIcon).perform();
        System.out.println("test case 6: click on the profile icon");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Sign out of Netflix')]")));
        signOutButton.click();
        WebElement goNowButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[data-uia='continue-logout']")));
        goNowButton.click();
        System.out.println("test case 7: Logout Successfully!!!!!");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        driver.quit(); 
    }
}
