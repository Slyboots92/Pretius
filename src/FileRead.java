import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {

	
	public ArrayList<String> loadFile(String filePath){
		
		ArrayList<String> result = new ArrayList<String>();
		FileInputStream inputStream = null;
		Scanner scanner= null;
		try {
			inputStream = new FileInputStream(filePath);
			scanner = new Scanner(inputStream);
			while(scanner.hasNextLine()){
				String line=scanner.nextLine();
				if(line!=null&&line.length()>0){
					result.add(line);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(inputStream!=null){
					inputStream.close();
				}
				if(scanner!=null){
					scanner.close();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		return result;
	}
}
