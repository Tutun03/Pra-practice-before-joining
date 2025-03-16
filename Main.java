import java.util.*;
public class Main
{
	public static void main(String[] args) {
	int arr1[]=new int[10];
	Scanner sc=new Scanner(System.in)
	int j=1;
	for(int i=0;i<arr1.length;i++)
	{
	    arr1[i]=sc.nextInt();
	   
	    
	}
	for(int i=0;i<arr1.length;i++)
	{
	     if(j%2!=0)
	    {
	        System.out.println(arr1[i]);
	    }
	    j++;
	}
	
	}
}