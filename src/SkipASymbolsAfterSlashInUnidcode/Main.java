package SkipASymbolsAfterSlashInUnidcode;

public class Main {
  public static void main(String[] args) {
    System.out.println(SkipASymbolsAfterSlashInUnidcode(29));
  }
  static char SkipASymbolsAfterSlashInUnidcode(int a) {
    int slash = (int)'\\';
    return (char) (slash + a);
  }
}
