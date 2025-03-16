/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {

	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int arr[]=new int[n];
	for (int i=0;i<arr.length;i++)
	{
	    arr[i]=sc.nextInt();
	}
	Arrays.sort(arr);
	if(n%2!=0)
	{
	    int median=(n+1)/2;
	    System.out.println(arr[median]);
	}
	
	else{
	    int median=(arr[(n/2)-1] + arr[(n/2)]) / 2;
	    System.out.println((float)median);
	}
	}
}