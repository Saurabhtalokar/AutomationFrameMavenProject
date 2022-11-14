package util;

import java.io.FileInputStream;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import testBase.Base;

public class Utilities extends Base {
	public static Actions act;
	//public static WebDriver driver;
	public static XSSFWorkbook workbook;
	
	
	public static String[][] getData() {
	try {
		FileInputStream file= new FileInputStream("C:\\Users\\DINESH\\eclipse-workspace\\AutomationFrame\\Info.xlsx");
		workbook = new XSSFWorkbook(file);
		
	}
	catch(Exception e) {
		System.out.println("Workbook file is missing");
	}
	XSSFSheet sheet = workbook.getSheet("Sheet2");
		int row=sheet.getLastRowNum();
		int column=sheet.getRow(0).getLastCellNum();
		String data[][]= new String[row][column];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

	public static void swichtoMainpanelFrame() {
		driver.switchTo().frame("mainpanel");
		
	}
	
	
	public static void windowHandlechild() {
		String parentWindow =driver.getWindowHandle();
		Set<String> childWindow =driver.getWindowHandles();
		
		for(String window:childWindow) {
			
			if(!parentWindow.contains(window)) {
				
				driver.switchTo().window(window);
				}
		}
		
	}
	
	public static void actionmouseover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
}
