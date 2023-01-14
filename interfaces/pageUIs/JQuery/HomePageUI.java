package pageUIs.JQuery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath= //li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath= //div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath= //li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text() = '%s']";
	public static final String TOTAL_PAGINATION = "css= ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath= //ul[@class='qgrd-pagination-ul']/li[%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath= //tbody/tr";
	
	
	//Index của côt mà mình cần enter/ click/ select vào
	public static final String COLUM_INDEX_BY_NAME = "xpath= //tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath= //tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath= //tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_INDEX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath= //tbody/tr[%s]/td[%s]//input";
	public static final String ICON_NAME_BY_ROW_NUMBER = "xpath= //tbody/tr[%s]//button[@title='%s']";
	
	public static final String LOAD_BUTTON = "xpath= //button[@id='load']";
	
}