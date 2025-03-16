/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        int n=121;
        int number=n;
        int rem=0;
        int sum=0;
        while(number!=0)
        {
            rem=number%10;
            sum=sum*10+rem;
            number=number/10;
        }
        if(sum==n)
        {
            System.out.println("palindrome");
            
        }
        else{
            System.out.println("not palindrome");
        }
    }
}
