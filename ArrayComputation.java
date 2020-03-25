package arraycomputation;
import java.util.Scanner;
public class ArrayComputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print ("Enter Dimension: ");
        int n = sc.nextInt();
        int ub [] = new int [n];
        int oneDim = 0;
        if (n>1){
            for (int i=0; i<n; i++){
                System.out.print ("Enter UB"+(i+1)+" : ");
                ub[i] = sc.nextInt();            
            }
        }else if (n==1){
            System.out.print ("Enter UB: ");
            oneDim = sc.nextInt();
        }
        System.out.print ("Enter starting address : ");
        int startAdd = sc.nextInt();
        System.out.print ("Enter esize : ");
        int esize = sc.nextInt();
        System.out.print ("Total number of elements in the array : ");
        int tot = 1;
        if (n>1){
            for (int i=0; i<n; i++){
                tot = tot * ub[i];
            }
        } else if (n==1) tot=oneDim;    
        System.out.print (tot+"\n");
        //computations
        int index [] = new int [n];
        int search=0, finale=0;
        if (n>1){
            System.out.println ("***** SEARCH FOR MEMORY ADDRESS OF ith ELEMENT *****");
            //input search index
            for (int i=0; i<n;i++){
                System.out.print ("Input search index at dimension "+(i+1)+":");
                index[i]=sc.nextInt();
                    if (index [i]>ub[i]){
                        System.out.println ("Your input should be lower than "+ub[i]+
                                "\nPlease enter a new value for dimension "+(i+1)+": ");
                        index [i]=sc.nextInt();
                    }
            }
            //computations
            int bounds, prebounds=1, calc=0;
            for (int i=0; i<n; i++){
                for (int j=i+1; j<n; j++){
                    prebounds = prebounds*ub[j];
                    }
                bounds = prebounds * index [i];
                calc = calc + bounds;
                prebounds=1;
            } 
            finale = startAdd + (calc)* esize;   
        } else if (n==1) {
            System.out.print ("Input search index : ");
            search = sc.nextInt();
            if (search>oneDim){
                System.out.println ("Your input should be lower than "+oneDim+
                            "\nPlease enter a new value: ");
                    search=sc.nextInt();
            }
            finale = startAdd + (search)*esize;
        }
        //display 
        System.out.println ("\nMEMORY ADDRESS : "+finale);
    }
}
