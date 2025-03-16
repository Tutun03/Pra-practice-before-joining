/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.


*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int [][] arr=new int[3][3];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
		    for(int j=0;j<3;j++)
		    {
		        arr[i][j]=sc.nextInt();
		    }
		}
		int sum=0;
		for(int j=0;j<3;j++)
		{
		    sum=sum+arr[j][j];
		}
		System.out.println(sum);
		int sum1=0;
		int j=2;
		for(int i=0;i<3;i++)
		{
		   sum1=sum1+arr[i][j];
		   j--;
		    
		}
		System.out.println(sum1);
		
		if(sum1>sum)
		{
		    System.out.println(sum1-sum);
		}
		else{
		    System.out.println(sum-sum1);
		}
		
		}
}
