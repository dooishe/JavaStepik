package IsPowerOfTwo;
public class Main {
  public static void main(String[] args) {
    System.out.println(IsPowerOfTwo(0));
    System.out.println(IsPowerOfTwo(-6));
    System.out.println(IsPowerOfTwo(-128));
    System.out.println(IsPowerOfTwo(-256));
  } 

  static boolean IsPowerOfTwo(int value) {
    int absolutValue = Math.abs(value);
    return Integer.bitCount(absolutValue) == 1;
  }
}
