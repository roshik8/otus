package statemachine;

public class StateMachine {

    private static final char[] ALPHABET = "ABC".toCharArray();
    private final int length;
    private int[][] delta;

    public StateMachine(String pattern) {
        this.length = pattern.length();
        createDelta(pattern);
    }

    public int search(String text) {
        int q = 0;
        for (int i = 0; i < text.length(); i++) {
            q = delta[q][text.charAt(i) - ALPHABET[0]];
            if (q == length) {
                return i - length + 1;
            }
        }
        return -1;
    }

    public int searchKmp(String text, String pattern) {

        int[] pf = createPrefix(pattern);
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            while (index > 0 && pattern.charAt(index) != text.charAt(i)) {
                index = pf[index - 1];
            }
            if (pattern.charAt(index) == text.charAt(i)) index++;
            if (index == pattern.length()) {
                return i - index + 1;
            }
        }
        return -1;
    }

    private void createDelta(String pattern) {
        delta = new int[length + 1][ALPHABET.length];
        for (int q = 0; q <= length; q++) {
            for (char c : ALPHABET) {
                int k = q + 1;
                if (q == length) k--;
                String line = pattern.substring(0, k) + c;
                while (!pattern.substring(0, k).equals(line.substring(line.length() - k))) {
                    k--;
                }
                delta[q][c - ALPHABET[0]] = k;
            }
        }

    }

    public int[] createPrefix(String pattern) {
        int[] pi = new int[pattern.length() + 1];
        pi[0] = 0;
        pi[1] = 1;
        for (int q = 1; q < pattern.length(); q++) {
            int len = pi[q];
            while (len > 0 && pattern.charAt(len) != pattern.charAt(q)) {
                len = pi[len];
            }
            if (pattern.charAt(len) == pattern.charAt(q)) len++;
            pi[q + 1] = len;
        }
        return pi;
    }
}
