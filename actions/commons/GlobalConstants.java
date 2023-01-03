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
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles"; 
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles"; 
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "logBrowser"; 
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "DragAndDrop"; 
	
	//Database Account/ User/ Pass/ Port
	public static final String DB_DEV_URL ="192.168.1.15:19860";
	public static final String DB_DEV_USER ="minhtrang";
	public static final String DB_DEV_PASS ="password123";
	public static final String DB_TEST_URL ="192.168.1.15:19860";
	public static final String DB_TEST_USER ="minhtrang";
	public static final String DB_TEST_PASS ="password123";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
	
	
	
}
