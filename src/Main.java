import test.FileTestTicket;
import ticket.HappyTicket;

public class Main {

    public static void main(String[] args) {
        HappyTicket happyTicket = new HappyTicket();
        System.out.println(happyTicket.getTicket6Count());
        System.out.println(happyTicket.getTicketCount(3));
        FileTestTicket.checkAllTestFromFolder("/Downloads/A01_Счастливые_билеты-1801-057a77/1.Tickets");
        FileTestTicket.in.forEach((test, value) -> {

            var result = happyTicket.getTicketCount(value);
            var printResult = test +" "+ (result == FileTestTicket.out.get(test) ? "true" : "false");
            System.out.print(printResult);
            System.out.println(" " + result);
        });
    }
}
