package rle;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rle {
    public static String rleEncode(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int runLength = 1;
            while (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                runLength++;
                i++;
            }
            result.append(runLength);
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static String[] rleEncodeLines(String[] lines, int dataSize) {
        String[] compressedArr = new String[dataSize];

        for (int i = 0; i < dataSize; i++) {
            compressedArr[i] = rleEncode(lines[i]);
        }
        return compressedArr;
    }

    public static String rleDecode(String text) {
        StringBuilder result = new StringBuilder();
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char s = charArray[i];
            if (!Character.isDigit(s)) {
                result.append(s);
            } else {
                int num = Integer.parseInt(String.valueOf(s));
                result.append(String.valueOf(charArray[i + 1]).repeat(Math.max(0, num - 1)));
            }
        }
        return result.toString();
    }

    public static void rleEncodeFile(String fileName) throws IOException {
        Scanner scan = new Scanner(new FileReader(fileName));
        String line = null;
        String[] decompressed = new String [100];
        int dataSize = 0;
        while(scan.hasNext()){
            line = scan.next();
            if(line != null && line.length()>0)
                decompressed[dataSize]=line;
            dataSize++;
        }
        scan.close();
        String[] compressed = rleEncodeLines(decompressed, dataSize);
        writeFile(String.join("\n", compressed), "testRle.txt");
    }

    public static void writeFile(String data, String fileName) throws IOException{
        PrintWriter pw = new PrintWriter(fileName);
        pw.print(data);
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        rleEncodeFile("C:/Users/User/IdeaProjects/otus/src/rle/test.txt");
        String test = "aabccaabaad";
        System.out.println(test);
        System.out.println(rleEncode(test));
        System.out.println(rleDecode("2a1b2c2a1b2a1d"));
        System.out.println(test.equals(rleDecode(rleEncode(test))));
    }
}
