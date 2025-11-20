import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		//  First: check if argument is provided
    if (args.length == 0) {
        System.out.println("Please provide a, r, ?, +, or c argument");
        return;
    }

    //  Then: put the LOGIC HERE
    String command = args[0];

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String reader = fileStream.readLine();
			String words[] = reader.split(",");			
			for(String  word : words) { System.out.println(word); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String reader = fileStream.readLine();
		
			String words[] = reader.split(",");	
			Random random = new Random();
				int randomIndex = random.nextInt(0, words.length);
					System.out.println(words[randomIndex]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter fileStream = new BufferedWriter(
					new FileWriter("students.txt", true));
			String argValue = args[0].substring(1);
	        Date date= new Date();
	        String dateFormatObj = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateFormatObj);
	        String formatDate= dateFormat.format(date);
			fileStream.write(", "+ argValue+"\nList last updated on "+formatDate);
			fileStream.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String reader = fileStream.readLine();
			String words[] = reader.split(",");	
			boolean done = false;
			String argValue = args[0].substring(1);
			for(int wordsdx = 0; wordsdx<words.length && !done; wordsdx++) {
				if(words[wordsdx].equals( argValue)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String reader = fileStream.readLine();
			char characters[] = reader.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char c:characters) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + characters.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
			}
			else {
			   // INVALID COMMAND
			   System.out.println("Invalid argument! Use a, r, ?, +, or c");
	   }
	}
}