package commons;

import java.io.File;

public class GlobalConstants {
	//Infor dùng cho toàn bộ tất cả các class khác trong Framework có thể truy cập được
	//Biến dùng chung
	//Ví dụ, thông tin User/Password đăng nhập vào App, database
	// Database
	//Server
	//Environment
	//...
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir"); 
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles"; 
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles"; 
	
	
}
