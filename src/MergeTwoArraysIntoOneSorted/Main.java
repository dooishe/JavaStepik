package MergeTwoArraysIntoOneSorted;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      System.out.println(Arrays.toString(mergeArrays(new int[] {1, 3}, new int[] {0, 2, 2})));
    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
    int counterA1 = 0;
    int counterA2 = 0;
    int rezLength = a1.length + a2.length;
    int[] rez = new int[rezLength];
    for (int counterRez = 0; counterRez < rezLength; counterRez++) {
      if(counterA2 == a2.length || (counterA1 < a1.length && a1[counterA1] <= a2[counterA2])) {
        rez[counterRez] = a1[counterA1]; 
        counterA1++;
      } else {
        rez[counterRez] = a2[counterA2]; 
        counterA2++;
      }
    }
    return rez; 
    }
}