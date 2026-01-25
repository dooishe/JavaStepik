package IsPolindrom;

public class Main {
  public static void main(String[] args) {
   System.out.println(isPalindrome("  text! ,3223fa;"));
   System.out.println(isPalindrome("к1 2б,  б2   1 К  !    "));
  }
  public static boolean isPalindrome(String text) {
    String editedString = text.replaceAll("[^A-Za-z0-9]", "");
    return editedString.equalsIgnoreCase(new StringBuilder(editedString).reverse().toString()); 
}
}
