package ticket;

public class HappyTicket {

    public HappyTicket() {
    }

    public void calc(int n, int p, int x, long[] arr) {
        p++;
        for (int i = 0; i <= 9; i++) {
            int sum = x + i;
            if (p < n) {
                calc(n, p, sum, arr);
            } else {
                arr[sum]++;
            }
        }
    }

    public long getTicketCount(int n) {
        int len = 9 * n + 1;
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = 0;
        }
        calc(n, 0, 0, arr);
        long count = 0;
        for (int i = 0; i < len; i++) {
            long r = arr[i];
            count += r*r;
        }

        return count;
    }

    public int getTicket6Count() {
        int count = 0;
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                int sum1 = a + b;
                for (int d = 0; d <= 9; d++) {
                    for (int e = 0; e <= 9; e++) {
                        int sum2 = (d + e);
                        int abs = Math.abs(sum1 - sum2);
                        if (abs < 10) {
                            count += 10 - abs;
                        }
                    }
                }
            }
        }
        return count;
    }
}
