/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
     String str="I love my country very much ";
     System.out.println(str.length());
     
     if((str.charAt(str.length()-1))!=' ')
     
     {
         int count=0;
         for(int i=0;i<str.length();i++)
         {
             if(str.charAt(i)==' ')
             {
                 count++;
             }
         }
         System.out.println("no of words"+(count+1));
         
     }
     else{
          int count=0;
         for(int i=0;i<str.length();i++)
         {
             if(str.charAt(i)==' ')
             {
                 count++;
             }
         }
         System.out.println("no of words"+(count));
         
     }
	}
}