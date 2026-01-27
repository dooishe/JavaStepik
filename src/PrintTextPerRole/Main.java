package PrintTextPerRole;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) {
    String [] roles= {
        "Городничий","Аммос Федорович",
        "Артемий Филиппович",
        "Лука Лукич"};
    String [] textLines={
        "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
        "Артемий Филиппович: Вот не было заботы, так подай!",
        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
    String result = printTextPerRole(roles, textLines);
    try (Writer writer = new OutputStreamWriter(
      new FileOutputStream("PrintTextPerRole.txt"),
      StandardCharsets.UTF_8
    )) {
      writer.write(result); 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String printTextPerRole(String[] roles, String[] textLines) {
    StringBuilder rezult = new StringBuilder();
    for (String role : roles) {
      rezult.append(role + ":\n");
      for (int i = 0; i < textLines.length; i++) {
        if(textLines[i].startsWith(role + ":")) {
          rezult.append((i + 1) + ")" + textLines[i].substring(role.length() + 1) + "\n");
        }
      }
      rezult.append("\n");
    }
    return rezult.toString();
  }
}
