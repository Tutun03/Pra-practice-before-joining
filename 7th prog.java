/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.*;

public class Main{
    public static void main(String args[])
    {
        String[] arr=new String[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            arr[i]=sc.nextLine();
        }
                Arrays.sort(arr, Comparator.comparingInt((String s) -> Integer.parseInt(s.split("-")[1])) // Sort by year
                                   .thenComparingInt(s -> Integer.parseInt(s.split("-")[0])));  // Sort by month if year is same

        
        for(int i=0;i<5;i++)
        {
            System.out.println(arr[i]);
        }
    }
}