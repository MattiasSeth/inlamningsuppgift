import java.io.*;
import java.util.*;

public class IntNodeFile {

    IntNodeFile() {
    }

    private void hashnode() {
    	try {
  		File course_file = new File("25000.txt");
  		File node_file = new File("int_temp.txt");
  		
//           SCANNER OCH WRITERWS/PRINTERS 		
    		Scanner sc = new Scanner(course_file);
    		FileWriter file_Write = new FileWriter (node_file);
    		PrintWriter print = new PrintWriter (file_Write);
    		
    		while (sc.hasNext()) {
    			print.println (sc.next().hashCode());
    			print.println (sc.next().hashCode());
    			sc.nextLine();
    		}
    		print.close();
    		sc.close();
    	} 
    	catch (Exception e) {
    		System.err.println("Wrong file name");
    		System.err.println(e);
    		System.exit(1);
    	}
         
    }
    public static void main(String[] args) {
    	IntNodeFile nodes = new IntNodeFile();
        nodes.hashnode();
    }
}

