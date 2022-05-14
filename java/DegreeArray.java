package histogram;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class DegreeArray {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Double> degree = new ArrayList<Double>();
		double summa = 0;
		
		Scanner sc = new Scanner (new File ("temp.txt"));
		while (sc.hasNext()) {
			String temp = sc.next();
			double value = Double.parseDouble(temp);
			degree.add(value);
		}
		for (int i=0; i < degree.size(); i=i+2) {
			summa = summa + degree.get(i);
		}

		System.out.println("Degree:" + "  Amount:" + "    Distribution:");
		for (int i=0; i < degree.size(); i=i+2) {
			System.out.printf(Math.round(degree.get(i+1)) + "        " + Math.round(degree.get(i))
			+"         " + "%.2f", degree.get(i)/summa);
			System.out.printf("\n");
		}
	}
}
