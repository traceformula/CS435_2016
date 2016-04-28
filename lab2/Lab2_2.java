import java.util.*;
import java.io.*;
import java.math.*;
/* 
A) Algorithm Design 

procedure merge(a: int[], b: int[])
1) if a is null return b
2) if b is null return a
3) create array c which has length = a.length + b.length
4) set pointerA <- 0, pointerB <- 0, pointerC <- 0
5) while pointerA<a.length and pointerB <b.length
6)    if(a[pointerA] > b[pointerB])
7)         set c[pointerC] <- b[pointerB]
8)         increment pointerC and pointerB
9)    else 	set c[pointerC] <- a[pointerA]
10)        increment pointerC and pointerB
11)   put all the remaining elements in array a to array c if there are any
12)   put all the remaining elements in array a to array c if there are any
13) return array c

B) Algorithm Analysis
Line 1 and 2 take time 1 each
Line 3 takes maximum time a.length+b.length to initialize the array
Line 4 takes time 3

Line 6 take 1 for comparison, and lines 7 & 8 takes time 3, similarly lines 9 & 10
also takes time 3. Since the while loop on line 5 take maximum (a.length + b.length),
then the while loop from line 5 to 10 takes maximum time (a.length + b.length) * (1+3)  
= 4*(a.length + b.length)

line 11 put all the remaining elements in array a into c, and line 12 put all the remaining elements
in array b into c, so we see that these times will add to the time taken by the while loop on line 5
to be 4*(a.length + b.length)

So the total running time (assymptotically) is 
O(4(a.length+b.length)) + O(2) + O(a.length+b.length) + O(3) = O(a.length + b.length)

(The other way of thinking is: each element in array a will be put to c only one time, 
each element in array b will be put to c only one time, so the assymptotic running time is O(a.length+b.length))
*/
public class Lab2_2 {
	
	public static void main(String[] args){
		int[] a = new int[]{1, 4, 5, 8, 17};
		int[] b = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
		int[] c = merge(a, b);
		print(c);
	}
	
	public static int[] merge(int a[], int b[]){
		
		//check if one of the array is null, if yes, return the other
		if(a == null) return b;
		if(b == null) return a;
		
		//new int array has the length equals sum of the 2 original arrays
		int c[] = new int[a.length + b.length];
		
		//2 pointers pointerA & pointerB to keep track of which element in each array has been 
		//put into the result array
		//pointerC is to keep track of the current location in the result array
		int pointerA = 0, pointerB = 0, pointerC = 0;
		
		while(pointerA < a.length && pointerB < b.length){
			if(a[pointerA] > b[pointerB]) 
				c[pointerC++] = b[pointerB++];
			else c[pointerC++] = a[pointerA++];
		}
		
		//put all the remaining elements (if any) of array a into array c
		while(pointerA < a.length){
			c[pointerC++] = a[pointerA++];
		}
		
		//put all the remaining elements (if any) of array b into array c
		while(pointerB < b.length){
			c[pointerC++] = b[pointerB++];
		}

		return c;
	}
	public static void print(Object... objects){
		System.out.println(Arrays.deepToString(objects));
	}
}