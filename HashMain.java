package BinaryAndHash;
import java.util.Arrays;

class MyMapNode {
    String key;
    int value;
    MyMapNode next;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashTable {
    int bucketSize;
    MyMapNode[] buckets;

    public MyHashTable(int size) {
        this.bucketSize = size;
        this.buckets = new MyMapNode[bucketSize];
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % bucketSize;
    }

    public void insert(String key) {
        int index = getHash(key);

        if (buckets[index] == null) {
            buckets[index] = new MyMapNode(key, 1);
        } else {
            MyMapNode current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value++;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value++;
            } else {
                current.next = new MyMapNode(key, 1);
            }
        }
    }

    public void display() {
        for (int i = 0; i < bucketSize; i++) {
            MyMapNode current = buckets[i];
            while (current != null) {
                System.out.println("Word: " + current.key + ", Frequency: " + current.value);
                current = current.next;
            }
        }
    }

    public void remove(String key) {
        int index = getHash(key);

        if (buckets[index] == null) {
            return;
        }

        MyMapNode current = buckets[index];
        MyMapNode prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    buckets[index] = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class HashMain {
    public static void main(String[] args) {

        String sentence = "To be or not to be";
        String[] words = sentence.split(" ");

        MyHashTable hashTable = new MyHashTable(words.length);

        for (String word : words) {
            hashTable.insert(word);
        }

        hashTable.display();

        System.out.println("--------------------");


        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        words = paragraph.split(" ");

        hashTable = new MyHashTable(words.length);

        for (String word : words) {
            hashTable.insert(word);
        }

        hashTable.display();

        System.out.println("--------------------");


        String wordToRemove = "avoidable";
        hashTable.remove(wordToRemove);

        hashTable.display();
    }
}
