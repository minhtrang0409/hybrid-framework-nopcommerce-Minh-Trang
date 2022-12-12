package pageUIs.nopCommerce.user;

public class HomePageUI {
	public static final String REGISTER_LINK ="class=ico-register";
	//Public: chia sẻ cho 1 package khác sử dụng mà không cần kế thừa
	//Static: không cần khởi tạo HomePageUI lên vẫn sử dụng được
	//final: define 1 lần không được sửa trong quá trình chạy test case
	//static+ final = hằng số (constant) => Tên biến viết hoa phân cách bởi dấu gạch nối

	public static final String LOGIN_LINK ="xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK ="xpath=//a[@class='ico-account']";




}