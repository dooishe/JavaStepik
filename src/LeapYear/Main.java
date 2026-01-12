package LeapYear;

public class Main {
    public static void main(String[] args) {
      System.out.println(leapYearCount(1));
      System.out.println(leapYearCount(4));
      System.out.println(leapYearCount(100));
      System.out.println(leapYearCount(400));
    }
    static int leapYearCount(int year) {
      return ((year/4) - (year/100) + (year/400));
    }
}
