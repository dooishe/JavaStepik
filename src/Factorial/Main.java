package Factorial;

import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    try {
      System.out.println(factorial(0));
      System.out.println(factorial(5));
      System.out.println(factorial(10));
      System.out.println(factorial(-1));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static BigInteger factorial(int value) {
    if (value < 0) throw new IllegalArgumentException("factorial for negative number can not be calculated");
    if (value <= 1) return BigInteger.ONE;
    return BigInteger.valueOf(value).multiply(factorial(value - 1)); 
  }
}
