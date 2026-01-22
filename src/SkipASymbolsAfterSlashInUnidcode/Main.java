package SkipASymbolsAfterSlashInUnidcode;

public class Main {
  public static void main(String[] args) {
    System.out.println(SkipASymbolsAfterSlashInUnidcode(29));
    System.out.println("A" + 12);
    System.out.println('A' + "12");
    System.out.println("A" + ('\t' + '\u0003'));
    System.out.println('A' + '1' + "2");
  }
  static char SkipASymbolsAfterSlashInUnidcode(int a) {
    int slash = (int)'\\';
    return (char) (slash + a);
  }
}
