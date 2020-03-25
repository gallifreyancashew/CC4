public class IterativeQuickSort{
	public static void main(String[] args) {
		int arr[] = {4, 3, 5, 2, 1, 3, 2, 3}; 
	    int n = arr.length; 
	    
	    int l = 0;
	    int h = n-1;
	    
	    int[] stack = new int[h-l+1]; 
	    int top = -1; 
	    stack[++top] = l; 
	    stack[++top] = h; 
	    
	    while (top >= 0){ 
	        h = stack[top--]; 
	        l = stack[top--]; 
	    
	        int pivot = arr[h]; 
	        int i = (l-1);  
	        for (int j = l; j <= h-1; j++){ 
	        	if (arr[j] <= pivot){ 
	                i++;
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        
	        }
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[h]; 
	        arr[h] = temp;
	        int p = i+1;
	    
	        if (p-1 > l){ 
	            stack[++top] = l; 
	            stack[++top] = p - 1; 
	        } 
	        if (p+1 < h){ 
	            stack[++top] = p + 1; 
	            stack[++top] = h; 
	        } 
	        
	    }
	    for(int i = 0; i < n; i++){ 
	        System.out.print(arr[i] + " "); 
	}
}
}

