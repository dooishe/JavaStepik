package IsPolindrom;

public class Main {
  public static void main(String[] args) {
   
    
  }
  public static boolean isPalindrome(String text) {
    String editedString = text.replaceAll("\\p{Punct}", "").replaceAll("\\s+", "");
    StringBuilder str = new StringBuilder(editedString);
    String reverseEditedString = str.reverse().toString();
    return editedString.equalsIgnoreCase(reverseEditedString); 
}
}
