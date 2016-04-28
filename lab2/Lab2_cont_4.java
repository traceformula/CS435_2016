import java.util.*;
import java.math.*;
import java.io.*;

/*
A) Algorithm Design 
procedure recursiveFactorial(n):
    Input: A non-negative integer n 
	Output: n!
	
1	if(n == 0 || n == 1) then return 1 //initial values
2	dp <- array of (n+1) long numbers
3	dp[0] <- 1
4	dp[1] <- 1
5	for(int i=2; i<=n; i++){
6		dp[i] = dp[i-1] + dp[i-2]
7	}
8	return dp[n]
	
the loop on line 5 takes (n-1) times.
All the line from 1 to 4 take O(1) time.
So totally the running time should be O(n)
 	
B) Proof correctness of the algorithm:
if n == 0 or n == 1, line 1 return 1, which is correct 
Now, we have the loop variant (for the loop on line 5):
after step i, dp[i] is the ith Fibonacci number
We can prove this easily by induction. 
dp[0] and dp[1] are Fibonaci 0 & 1 (F(0) & F(1) )
Before step i, dp[i-1] and dp[i-2] are F(i-1) and F(i-2),
Hence dp[i] = F(i-1) + F(i-2) = F(i)
*/
public class Lab2_cont_4 {
	
	public static void main(String[] args){
		int n= 100;
		System.out.println("The " + n + "th Fibonacci:" + fibonacci(n));
	}
	
	public static long fibonacci(int n){
		if(n == 0 || n == 1) return 1;
		long[] dp = new long[n+1];
		dp[0] = dp[1] = 1;
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}