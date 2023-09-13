package api.utilities;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider(name="Alldata")
	public String [][] Alldataprovider(){
		
		
		String filename=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		System.out.println(filename);
		
		int ttlRowcount=ReadExcelFile.getRowCount(filename, "Sheet1");
		System.out.println("ttlRowcount in dataprovoder"+ttlRowcount);
		
		int ttlColcnt=ReadExcelFile.getRoColcount(filename, "Sheet1");
		System.out.println("ttlColcnt in dataprovoder"+ttlColcnt);
		
		
		String userData[][]=new String [ttlRowcount-1][ttlColcnt];
		
		
		for(int rowno=1;rowno<ttlRowcount;rowno++) {
			
			
			for (int colno=0;colno<ttlColcnt;colno++) {
				
				userData[rowno-1][colno]=ReadExcelFile.GetCellValue(filename, "Sheet1", rowno, colno);
				
				
			}
			
		}
		return userData;
		
	}
	
	
	
	
	
	
	
	
	
	
		
		
		
		@DataProvider(name="usernameData")
		public String [] UsernameDataprovider(){
			
			
			String filename=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
			
			int ttlRowcount=ReadExcelFile.getRowCount(filename, "Sheet1");
			
			//int ttlColcnt=ReadExcelFile.getRoColcount(filename, "Sheet1");
			String usernamesData[]= new String[ttlRowcount-1];
			
			
			
			//String userData[][]=new String [ttlRowcount][ttlColcnt];
			
			
			for(int rowno=1;rowno<ttlRowcount;rowno++) {
				
				
				
					
				usernamesData[rowno-1]=ReadExcelFile.GetCellValue(filename, "Sheet1", rowno, 1);
					
					
				}
				return usernamesData;
			}
			
			
			
}
	

	

