package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStepDefinitions {

	public WebDriver driver;
	@Given("user is logged onto the Elearning website as an admin user with valid username is {string} & password is {string} entered")
	public void user_is_logged_onto_the_elearning_website_as_an_admin_user_with_valid_username_is_password_is_entered(String userName, String password) {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	        driver.manage().window().maximize();
	        driver.get("http://elearning.upskills.in/");
	        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(userName);
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
	}

	@When("user Clicks on Courses Categories link")
	public void user_clicks_on_courses_categories_link() {
		driver.findElement(By.xpath("//a[@href='course_category.php']")).click();
	}

	@When("user Clicks on Add Category icon")
	public void user_clicks_on_add_category_icon() {
		driver.findElement(By.xpath("//img[@title='Add category']")).click();
	}

	@When("user Enters valid credentials in {string} and {string} textbox")
	public void user_enters_valid_credentials_in_and_textbox(String categorycode, String categoryname) {
		 driver.findElement(By.xpath("//input[contains(@id,'code')]")).sendKeys(categorycode);
	        driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys(categoryname);
	}

	@When("user Selects Yes radio button and Clicks on Add Category button")
	public void user_selects_yes_radio_button_and_clicks_on_add_category_button() {
		driver.findElement(By.xpath("//input[@checked='checked']")).click();		
		driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@When("user Clicks on Administration Link")
	public void user_clicks_on_administration_link() {
		driver.findElement(By.xpath("//a[@title='Administration']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@When("user Clicks on Create a Course link")
	public void user_clicks_on_create_a_course_link() {
		driver.findElement(By.xpath("//a[@href='course_add.php']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@When("user Enters valid credential in {string} {string} {string} textbox")
	public void user_enters_valid_credential_in_textbox(String title, String code, String category) {
		driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys(title);
		driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys(code);
		driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//div[@class='filter-option-inner-inner'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(category);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}

	@When("user Selects {string} {string} list box")
	public void user_selects_list_box(String teacher, String language) {
		
		  driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).click();
		  driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).sendKeys(teacher);
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		  //Select drpCategory = new Select(driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")));
		  //drpCategory.selectByIndex(1);
		  driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).
		  sendKeys(Keys.ENTER);
		  
		  Select drpLanguage = new Select(driver.findElement(By.xpath(
		  "(//div[@class='filter-option-inner-inner'])[2]")));
		  drpLanguage.selectByValue(language);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 
	}

	@Then("user Clicks on Create a course button.")
	public void user_clicks_on_create_a_course_button() {
		driver.findElement(By.xpath("//button[@id='update_course_submit']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("(//img[@class='img-circle'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//a[@id='logout_button']")).click();
		driver.quit();
	}


}
