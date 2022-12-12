package javaOOP;

public class Topic_14_StringFomart {
	
	public static String CUSTOMER_INFOR_HEADER  = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My account - Customer info']";
	public static String ADDRESS_LINK  = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK  = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK  = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	//1 biến đại diện cho cả 14 page của n page ( format giống nhau- chỉ khác nhau bởi tên page)
	public static String DYNAMIC_SIDEBAR_BY_PAGE_NAME  = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	// 1 locator đại diện cho các page ( Heander, side bar, footer
	public static String DYNAMIC_LINK_BY_PAGE_NAME  = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";

	//1 locator có tới 3-4-5 tham số động thì sao?
	
	public static void main(String[] args) {
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"Customer info");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"Addresses");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"My product reviews");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"Reward points");
		
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Customer info");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My account");
	}
	
	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}
//	1 tham số động
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		//DynamicLocator = //div[contains(@class,'account-navigation')]//a[text()='%s']"
//		// pageName = Customer info
//		String locator = dynamicLocator.format(dynamicLocator, pageName);
//		System.out.println("Click to: " + locator);
//	}
	// 2 tham số động
//	public static void clickToLink(String dynamicLocator,String areaName, String pageName) {
//		String locator = dynamicLocator.format(dynamicLocator, areaName, pageName);
//		System.out.println("Click to: " + locator);
//	}
	//n tham số động
	//Rest parameter Object.../Int.../ String....
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = dynamicLocator.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
}
