package boyer;

public class SearchSubStringTest {

    public static void main(String[] args) {
        SearchSubString search = new SearchSubString();
        String text = "трикотаж";
        String mask = "кот";
        int result = search.searchFullScan(text, mask);
        System.out.println(result);
        result = search.searchBmh(text, mask);
        System.out.println(result);
    }
}
