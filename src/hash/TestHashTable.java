package hash;

public class TestHashTable {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>(4);
        var t1 = hashTable.put("Гендальф", "Ты не пройдешь!");
        hashTable.put("Фродо", "Оно ушло, кончено!");
        hashTable.put("Гендальф", "Бегите, глупцы!");
        hashTable.put("Голлум", "Моя прелесть");
        System.out.println(hashTable.get("Голлум"));
        hashTable.remove("Голлум");
        System.out.println(hashTable);
    }
}
