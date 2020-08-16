package managers;

import utils.Xls_Reader;

public class ExcelFileManager {
	
	static Xls_Reader obj;
	
	public static String getData(String excelName, String sheetName, String colName, int rowNum) {
	obj = new Xls_Reader("src\\test\\resources\\excelFiles\\"+excelName+".xlsx");
	return obj.getCellData(sheetName, colName, rowNum);
		
		
//		obj.setCellData("Sheet1", "ID", 3, "5");
//		obj.setCellData("Sheet1", "Name", 3, "Deepa");
//		
//		obj.setCellData("Sheet1", "ID", 4, "4");
//		obj.setCellData("Sheet1", "Name", 4, "Karan");
//		
		
	//	System.out.println(obj.getCellData("Sheet1", "ID", 4)+"------>"+obj.getCellData("Sheet1", "Name", 4));
		
	//	System.out.println(obj.getRowCount("Sheet1"));
		
//		for(int i=2;i<=obj.getRowCount("Sheet1");i++) {
//			System.out.println(obj.getCellData("Sheet1", "ID", i)+"------>"+obj.getCellData("Sheet1", "Name", i));
//		}
	}
	

}
