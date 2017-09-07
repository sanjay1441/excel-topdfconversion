package otsi.voter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(FileInputStream inputStream = new FileInputStream("C:/Users/ssamnaboina/Desktop/test.txt")) {     
    	    String everything = IOUtils.toString(inputStream);
    	    printStr(everything);
    	    //pdfgt();
    	    //System.out.println(everything.indexOf("Elector's Name:"));
    	    // do something with everything string
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    /*public static void pdfgt() throws IOException{
    	PDDocument doc = PDDocument.load(new File("C:/Users/ssamnaboina/Desktop/PDFGeneration.pdf"));
    	String ps=new PDFTextStripper().getText(doc);
         FileUtils.writeStringToFile(new File("C:/Users/ssamnaboina/Desktop/test.txt"), ps);
    }*/
    
    public static void printStr(String tesxt){
    	
    	String str = "Elector's Name: SADHANANDAM PATHIPATI Father's Name: YESU PATHIPATI House No: - Age: 32 Sex: Male Elector's Name: YESU NELAPATI Father's Name: JOHN NELAPATI House No: - Age: 23 Sex: Male Elector's Name: MARIYAMMA NELAPATI Husband's Name:ROOBEN NELAPATI House No: - Age: 26 Sex: Female 4 YDR0571134 5 YDR0661315 6 YDR0311449 Elector's Name:";
    	Pattern pattern = Pattern.compile("Elector's Name:(.*?)Elector's Name:");
    	//Pattern pattern2 = Pattern.compile("Elector's Name(.+?)Husband's Name");
    	String abc[]=tesxt.split("Elector's Name:");
    	for(String as:abc){
    		System.out.println(as);
    	}
    	Matcher matcher = pattern.matcher(tesxt.replaceAll("\\s+", " "));
    	//matcher=pattern2.matcher(tesxt);
    	int i=0;
    	while (matcher.find()) {
    		i++;
    	    //System.out.println(matcher.group(1));
    	}
    	System.out.println(i);
    	
    	
    	/*//String str = "Elector's Name: SADHANANDAM PATHIPATI Father's Name: YESU PATHIPATI House No: - Age: 32 Sex: Male Elector's Name: YESU NELAPATI Father's Name: JOHN NELAPATI House No: - Age: 23 Sex: Male Elector's Name: MARIYAMMA NELAPATI Husband's Name:ROOBEN NELAPATI House No: - Age: 26 Sex: Female 4 YDR0571134 5 YDR0661315 6 YDR0311449 Elector's Name:";
    	Pattern patterns = Pattern.compile("[Father's Name|Husband's Name](.*?)House No");
    	//patterns = Pattern.compile("Husband's Name(.*?)House No");
    	//Pattern pattern2 = Pattern.compile("Elector's Name(.+?)Husband's Name");
    	Matcher matchers = patterns.matcher(tesxt);
    	matcher=pattern2.matcher(tesxt);
    	while (matchers.find()) {
    	    System.out.println("father: "+matchers.group(1));
    	}*/
    	
    	
    	
    	
    	
    	/*String input = "abcabc pattern1foopattern2 abcdefg pattern1barpattern2 morestuff";
        List<String> strings = Arrays.asList( input.replaceAll("^.*?pattern1", "").split("pattern2.*?(pattern1|$)"));
    	List<String> strings = Arrays.asList( tesxt.replaceAll("^.*?\"Elector's Name", "").split("Father's Name.*?(\"Elector's Name:|$)"));
    	System.out.println( strings);*/
    }
}
