package otsi.voter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Appnew {
	
	private static final String FILE_NAME = "C:/Users/ssamnaboina/Desktop/tst.xlsx";
	private static final String FILE_NAMEs = "C:/Users/ssamnaboina/Desktop/testout.xlsx";

	
	public List<Voter> readexce(){
try {
    		
    		List<Voter> voters=new ArrayList<>();

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int totalRows=datatypeSheet.getPhysicalNumberOfRows();
            
            int rows=totalRows;
            Voter voter=new Voter();
            
            int cellcnt=0;
            int cntcnt=0;
            int i=0;
            while(i<rows) {
            	
            	Row currentRow = datatypeSheet.getRow(i);
            	int cells=currentRow.getPhysicalNumberOfCells();
            	
            	if(i%5==0){
            		
            		voter=new Voter();
            		
            		
            	}
            	
            	
            	
            	

                
                
                Cell cell=currentRow.getCell(cellcnt);
                
                switch (i%5) {
				case 0:
					String ids[]=cell.getStringCellValue().replaceAll("\\s+", " ").split(" ");
					voter.setId(cal(ids));
					i++;
					break;
				case 1:
					voter.setName(cell.getStringCellValue().replaceAll("\\s+", " ").replace("Elector's Name:", ""));
					i++;
					break;
				case 2:
					voter.setRelname(cell.getStringCellValue().replaceAll("\\s+", " ").replace("Father's Name:", "").replace("Husband's Name:", ""));
					i++;
					break;
				case 3:
					i++;
					break;
				case 4:
					
					String ag=cell.getStringCellValue().replaceAll("\\s+", " ").replace("Age:", "");
					
					voter.setAgedet(Age(ag));
					voter.setSex(male(ag));
					voters.add(voter);
					System.out.println(i+" vvv");
					if(cellcnt<2){
	            		
	            		i=cntcnt;
	            		System.out.println(cntcnt+" cntcnt");
	            		cellcnt++;
	            		if(i!=0)
	            		i++;
	            	}else{
	            		cntcnt=i;
	            		System.out.println(cntcnt+"else cntcnt");
	            		i=cntcnt;
	            		i++;
	            		System.out.println(i);
	            		cellcnt=0;
	            	}
					
					break;
				}
                
                
               
               
                //System.out.println(cell.getStringCellValue().replaceAll("\\s+", " ").replace("Elector's Name:", ""));
                
                
            }
            
           
            for(Voter voterr:voters)
            System.out.println(voterr.toString());
            return voters;
               
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        	return null;
            
        } catch (IOException e) {
        	e.printStackTrace();
        	return null;
            
        }
	}
	
	
    public static void main(String[] args) {
    	Appnew bb=new Appnew();
    	List<Voter>voters= bb.readexce();
    	bb. writetoexcel(voters);

    }
    
    public  String cal(String abc[]){
    	String res="NA";
    	for(String ab:abc){
    		if(ab.length()>5)
    		{
    			res= ab;
    		}
    	}
    	return res;
    }
    
    public  String Age(String txt){
    	String age[]=txt.split("Sex:");
    	if(age.length>0)
    	return age[0];
    	else
    		return "NA";
    }
    
    public  String male(String txt){
    	String age[]=txt.split("Sex:");
    	if(age.length>0)
    	return age[1];
    	else
    		return "NA";
    	
    	
    }
    
    
    
    
    	
public void writetoexcel(List<Voter> voters){
    	
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
       

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Voter vote : voters) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(vote.getId());
                cell = row.createCell(colNum++);
                cell.setCellValue(vote.getName());
                cell = row.createCell(colNum++);
                cell.setCellValue(vote.getRelname());
                cell = row.createCell(colNum++);
                cell.setCellValue(vote.getAgedet());
                cell = row.createCell(colNum++);
                cell.setCellValue(vote.getSex());
               
            
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAMEs);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
  

}
