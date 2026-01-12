package BooleanExpression;
public class Main {
  public static void main(String[] args) {
    boolean[] values = {false, true};
    for(boolean a : values) {
      for(boolean b : values) {
        for(boolean c : values) {
          for(boolean d : values) {
            boolean rezult = booleanExpression(a, b, c, d);
            System.out.println(
              "Params: " 
              + a + " ,"
              + b + " ,"
              + c + " ,"
              + d + " "
              + "Rezult -> " + rezult
            );
          }
        }
      }
    }
  }
  static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
    boolean[] massiv = new boolean[] {a,b,c,d};
    for(int i = 0; i < 4; i++) {
      if(!massiv[i]) continue; 
        for(int j = i + 1; j < 4; j++) {
            if(!massiv[j]) continue;
              for(int k = j + 1; k < 4; k++) {
                if(massiv[k]) return false;
              }  
            return true;
        }  
    }
    return false;
    /* самый легкий способ
      int s = 0;
      if(a)s++;
      if(b)s++;javac -encoding UTF-8 .\Main.java
      if(c)s++;
      if(d)s++;
      return s == 2;
    */
  }
}
