package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	// Hàm khởi tạo- Contructors
	//1- Cùng tên với class
	//2- Không có kiểu trả về
	//3- Có access modifier
	//4- Khi 1 class được gọi thì nó sẽ vào hàm khởi tạo đầu tiên
	//5- 1 class có thể có nhiều hàm khởi tạo
	//Nếu như không khai báo rõ ràng hàm khởi tạo thì trình biên dịch sẽ tạo ra cho Class 1 hàm default (empty)
	// 6- Nếu trong 1 Class có nhiều hàm cùng tên thì đây chính là nguyên tắc đa hình thái (Polymorphims) - overloading
	//7- Không cho phép cùng tên kết hợp cùng kiểu tham số
	// Cho phép cùng tên nhưng phải khác kiểu tham số
	// Cho phép cùng tên nhưng phải khác số lượng tham số
	
	public HomePageObject(WebDriver driver) {
		//this: tham chiếu tới biến toàn cục của Class
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public void clickToMyAccountlink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

}
