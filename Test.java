package justforfun.encoding.byStringBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * String - immutable. Если необходимо отредактировать по месту, нужно воспользоваться объектом StringBuffer
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            System.out.print(">");
            line = bufferedReader.readLine();
            if (line == null || line.equalsIgnoreCase("quit")) break;
            StringBuffer stringBuffer = new StringBuffer(line);
            for (int i = 0; i < stringBuffer.length(); i++)
                stringBuffer.setCharAt(i, rotate(stringBuffer.charAt(i)));
            System.out.println(stringBuffer);
        }
    }

    public static char rotate(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch += 13;       // Для заглавных букв сдвигает вперед на 13
            if (ch > 'Z') ch -= 26;   // и вычитает при необходимости
        } else if (ch >= 'А' && ch <= 'Я') {
            ch += 10;
            if (ch > 'Я') ch -= 33;
        }
        if (ch >= 'a' && ch <= 'z') {
            ch += 13;
            if (ch > 'z') ch -= 26;
        } else if (ch >= 'а' && ch <= 'я') {
            ch += 10;
            if (ch > 'я') ch -= 33;
        }
        return ch;
    }
}