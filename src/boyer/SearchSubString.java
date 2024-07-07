package boyer;

import java.util.Arrays;

public class SearchSubString {

    public int searchFullScan(String text, String mask) {
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = 0;
            while (m < mask.length() && text.charAt(t + m) == mask.charAt(m)) {
                m++;
            }
            if (m == mask.length())
                return t;
            t++;
        }
        return -1;
    }
    public int searchBmh(String text, String mask) {
        int[] shift = createShift(mask);
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while (m >= 0 && text.charAt(t + m) == mask.charAt(m)) {
                m--;
            }
            if (m < 0)
                return t;
            t+= shift[text.charAt(t + mask.length() - 1)];
        }
        return -1;
    }
    private int[] createShift(String mask) {
        final int ALPHABET_SIZE = Character.MAX_VALUE + 1;
        int[] shift = new int[ALPHABET_SIZE];
        Arrays.fill(shift, mask.length());
        for (int i = 0; i < mask.length() - 1; i++) {
            shift[mask.charAt(i)] = mask.length() - i - 1;
        }
        return shift;
    }
}
