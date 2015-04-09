package find.two.repeating.in.array;

/**
 * For find duplicate/missing issues
 * 1. XOR -- good at repeat either even or odd times
 * 2. array elements as index -- good at repeat any times, it's like a in-place hash table 
 * 
 * http://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array
 * http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 * 
 * **hard**http://www.geeksforgeeks.org/find-the-element-that-appears-once/ 
 */
public class Driver {

	public static void main(String [] args)
	{
	  int arr[] = {4, 2, 4, 5, 2, 3, 1};
	  int arr_size = arr.length;
	  printRepeating(arr, arr_size);
	}
	
	public static void printRepeating(int arr[], int size)
	{
	  int xor = arr[0]; /* Will hold xor of all elements */
	  int set_bit_no;  /* Will have only single set bit of xor */
	  int i;
	  int n = size - 2;
	  int x = 0, y = 0;
	   
	  /* Get the xor of all elements in arr[] and {1, 2 .. n} */
	  for(i = 1; i < size; i++)
	    xor ^= arr[i];  
	  for(i = 1; i <= n; i++)
	    xor ^= i;   
	 
	  /* Get the rightmost set bit in set_bit_no */
	  set_bit_no = xor & ~(xor-1);
	 
	  /* Now divide elements in two sets by comparing rightmost set
	   bit of xor with bit at same position in each element. */
	  for(i = 0; i < size; i++)
	  {
	    if((arr[i] & set_bit_no) != 0)
	      x = x ^ arr[i]; /*XOR of first set in arr[] */
	    else
	      y = y ^ arr[i]; /*XOR of second set in arr[] */
	  }
	  for(i = 1; i <= n; i++)
	  {
	    if((i & set_bit_no) != 0)
	      x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
	    else
	      y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
	  }
	   
	  System.out.printf("\n The two repeating elements are %d & %d ", x, y);
	}     
	
}
