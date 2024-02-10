package ticket;

public class HappyTicket {

    private final int n;

    public HappyTicket() {
        this.n = 6;
    }

    public HappyTicket(int n) {
        this.n = n;
    }

    public int getTicketCount() {
        if (n == 6) {
            return getTicket6Count();
        }

        return 0;
    }

    private int getTicket6Count() {
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
