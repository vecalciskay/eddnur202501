package nur.prog3.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String expresion = "^GET (.+) HTTP\\/([0-9]\\.[0-9])$";
        Pattern pattern = Pattern.compile(expresion);
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        String texto = "GET /Index.html HTTP/1.1";
        Matcher matcher = pattern.matcher(texto);
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group(1));
        }
    }
}
