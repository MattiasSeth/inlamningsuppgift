
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram2 {
	public  ArrayList<Integer> distribution = new ArrayList<Integer>();

	Histogram2() {
		
	}

	private void loadData() {

		try {
			File distribution_file = new File("/Users/harry/inlamningsuppgift/data/degree_result.txt");
			//File distribution_file = new File("degree_result.txt");
			
			Scanner sc = new Scanner(distribution_file);
			while (sc.hasNext()) {
				int c = sc.nextInt();
				distribution.add(c);
				int d = sc.nextInt();
				distribution.add(d);
				sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			System.err.println("Hittar inte filen:");
			System.err.println(e);
			System.exit(1);
		}

	}

	public static void main(String[] args) {

		Histogram2 histogram = new Histogram2();

		histogram.loadData();
		int length =  histogram.distribution.size();
		int[] degrees = new int[length/2];
		int[] amount = new int[length/2];
		int j = 0;
		int k = 0;
		for (int i = length-1; i > 0 ;i = i -2) {
			degrees[j] = histogram.distribution.get(i);
			amount[k] = histogram.distribution.get(i-1);
			j = j +1;
			k = k + 1;
		}

		ArrayList<String> out_left = new ArrayList<String>();
		ArrayList<String> out_right = new ArrayList<String>();
		out_left.add("Degree");
		out_right.add("Amount");
		//specialfall om det är färre än 10 rader. skriver då ut alla
		int längd = degrees.length;
		int rows = (längd -2)/6;
		int restrows = (längd -2)%6;
		if (degrees.length < 11) {

			for (int i = 0; i < längd ;i++) {
				out_left.add(String.valueOf(degrees[i]));
				out_right.add(String.valueOf(amount[i]));
			}

			
		 }
			else {
				out_left.add(String.valueOf(degrees[0]));
				out_right.add(String.valueOf(String.valueOf(amount[0])));
				out_left.add(String.valueOf(degrees[1]));
				out_right.add(String.valueOf(String.valueOf(amount[1])));
				for (int s = 2; s < längd -2-restrows ;s = s + rows) {
					int summa = 0;
					for (int i = 0; i < rows    ;i++) {
						summa = summa + amount[s +i];			
					}

					String s1 = String.valueOf(degrees[s]) +" - " +String.valueOf(degrees[s+rows-1]);
					out_left.add(s1);
					out_right.add(String.valueOf(summa));

				}	
				if (restrows > 0) {
					int sum = 0;			  
					for (int x = längd -1; x > längd - restrows -1 ; x-- ) {
						sum = sum + amount[x];
					}
					String s2 = String.valueOf(degrees[längd -restrows]) +" - " +String.valueOf(degrees[degrees.length -1 ]);
					out_left.add(s2);
					out_right.add(String.valueOf(sum));
				}
			}

			int antal2 = out_left.size();
			for (int i=0;i < antal2;i++) {
				String left = out_left.get(i);
				String right = out_right.get(i);
				
				int fältlängd = left.length(); 
				if (fältlängd < 8 ) {
					System.out.println(left + "\t" + "\t"  +  right);

				}else if (fältlängd >=8 && antal2 <=16 ) {
					System.out.println(left + "\t" + right);

				}else {
					System.out.println(left + right);				

				}
				
			}

			
	}
}