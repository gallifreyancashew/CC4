import java.util.Scanner;
public class Dimensions{
	public static void main (String args []){
		double total=1.0, finalAdd=0, multi=1, preMulti=1, preAdd=0;
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter Dimension: ");
		int n = sc.nextInt();
		int [] UB = new int [n];
		int [] index = new int [n];

		for (int i=1; i<=n; i++){
			System.out.print ("Enter UB" +i+ ": ");
			UB [i-1] = sc.nextInt();
		}

		System.out.print ("Enter Starting Address: ");
		int start = sc.nextInt();
		System.out.print ("Enter esize: ");
		int esize = sc.nextInt();
		for (int i=0; i<n; i++){
			total = total * UB[i];
		}
		System.out.println ("Total elements in the Array: " + total );

		System.out.println ("\n*** SEARCH FOR MEMORY ADDRESS OF ith ELEMENT ***");
		for (int i = 1; i<=n; i++){
			System.out.print("Input search index at dimension " + i + ":" );
			index [i-1] = sc.nextInt ();
		}
		//calculation
		for (int i = 0; i<n; i++){
				for (int j = i+1; j<n; j++){
				preMulti = preMulti * UB [j]; //multiplying UB
				multi=preMulti*index[i]; //accumulated UB * index [i]
				//System.out.println (index [i] + " x Upper " + UB [j] + "= " + multi);
				}
				if (index [i] != 0){
					preAdd=preAdd+multi;
					preMulti=1;
					multi=1;
				}
		}
		finalAdd=start+(preAdd+index[n-1])*esize;
		System.out.println ("MEMORY ADDRESS: " + finalAdd);
	}
}

// 2000 + [(3)3*3  + (3) 3 + 0] 4