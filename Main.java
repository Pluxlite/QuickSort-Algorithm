package quicksortalgorithm;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		// original input {10,80,3,19,14,7,5,12}
		int[] question1 = {10,80,3,19,14,7,5,12};
		int[] question2 = new int[100];
		int[] question3 = new int[1000];
	
		//int testValue = partition(question1,0,(question1.length - 1));
		
		System.out.println("The time analysis of the Quicksort Algorithm is:");
		System.out.println("Worst case is O(n^2)");
		System.out.println("Average case is O(nLogn)");
		System.out.println("Best case is O(nLogn)");
		System.out.println("Keeping in mind that the algorithm is more stable when the pivot is near the center");
		System.out.println("As well as when the array is small as it becomes worse the longer the length of the array");
		System.out.println();
		
		case1(question1);
		case2(question2);
		case3(question3);
		
		
	
		
		//System.out.println(question1[question1.length - 1]);
	
	}
	
	public static void printArray( int[] x) {
		for(int i: x) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static int partition(int[] x ,int y ,int z ) {
		int lastElement = x[z];
		int firstPointer =  y - 1;
		int temp = 0;
		
		for(int j = y; j < z; j++) {
			if(x[j] < lastElement) {
				firstPointer = firstPointer + 1;
				temp = x[j];
				x[j] = x[firstPointer];
				x[firstPointer] = temp;
				
			}
		}
		temp = x[firstPointer + 1];
		x[firstPointer + 1] = x[z];
		x[z] = temp;
		
		return firstPointer + 1;
	}

	public static void quickSort(int[] x, int y, int z ) {
		if(y < z) {
			int pivot = partition(x,y,z);
			quickSort(x,y, pivot - 1);
			quickSort(x,pivot + 1, z);
			
		}
	}
	
	public static void populateArray(int[] x) {
		Random rnd = new Random();
		
		for(int i= 0;i < x.length; i++) {
			x[i] = rnd.nextInt(50);
		}
	}
	
	public static void populateAscending(int[] x) {
		
		for(int i= 0; i < x.length; i++) {
			x[i] = i + 1;
		}
	}
	
	public static void populateDescending(int[] x) {
		
		int counter = x.length + 1;
		
		for(int i = 0; i < x.length; i++) {
			x[i] = counter - 1;
			counter--;
		}
	}
	
	public static void case2(int[] x) {
		System.out.println("Worst case of 100 values ");
		populateDescending(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Average case of 100 values ");
		rearrangeArray(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Best case of 100 values ");
		populateAscending(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println();
	}

	public static void case1(int[] x) {
		System.out.println("Worst case of 8 values ");  
		descendingOrder(x);	
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Average case of 8 values ");
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Best case of 8 values ");
		quickSort(x,0,x.length-1);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println();
	}
	
	public static void case3(int[] x) {
		System.out.println("Worst case of 1000 values ");
		populateDescending(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Average case of 1000 values ");
		rearrangeArray(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println("Best case of 1000 values ");
		populateAscending(x);
		printArray(x);
		quickSort(x,0,x.length-1);
		printArray(x);
		System.out.println();
	}
	
	public static void descendingOrder(int[] x) {
		int swapSlot= x.length-1;
		quickSort(x,0,x.length-1);
		for(int i = 0; i < swapSlot; i++) {
			int temp;
			
			temp = x[i];
			x[i] = x[swapSlot];
			x[swapSlot] = temp;
			swapSlot--;
		}
		
	}
	
	public static void rearrangeArray(int[] x) {
		Random rnd = new Random();
	
		populateAscending(x);
		for(int i = 0; i < x.length;i++) {
			int swapTempNum;
			int temp;
			
			temp = rnd.nextInt(100);
			swapTempNum = x[i];
			x[i] = x[temp];
			x[temp] = swapTempNum;
		}
		
	
	}
	
}

/*
 Use Quicksort algorithm to sort the following sequences:

    10, 80, 3, 19, 14, 7, 5, 12
    Choose your sequence with 100 random digital numbers
    Choose your sequence with 1000 random digital numbers

Please include your pseudocode, input sequence and output in the report. 
Also, you need to analyze the computational time for different partition methods (e.g., best/worst/average cases) for sequences b and c.
 */
