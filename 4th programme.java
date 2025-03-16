/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Integer arr[] = {5, 8, 9, 10, 34}; // Use Integer[] instead of int[] because Arrays.asList() works with objects.
        Arrays.asList(arr).forEach(element -> System.out.println(element));
        Arrays.stream(arr).forEach(System.out::println);
        Stream.of(arr).forEach(element->System.out.println(element));
    
        
    }
}
