package hashtable;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Hashtable<T1, T2> {
    private LinkedList<String>[] buckets;

    //Constructor requires a size to create the table
    public Hashtable (int size) {
        this.buckets = new LinkedList[size];
    }

    //private method to generate hash values for the table
    private int getHash(T1 key) {
       int hashValue = 0;
       String keyToHash = key.toString();
       for (int i = 0; i < keyToHash.length(); i++) {
           hashValue += keyToHash.codePointAt(i);
       }
       hashValue = hashValue * 167 % this.buckets.length;
       return hashValue;
    }

    //takes in a key and a value, gets the keys hash, stores the key + value at the hashed index
    public void add(T1 key, T2 value) {
        int idx = getHash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }
        buckets[idx].add(key + ": " + value);
    }

    //Takes in a key, returns true if the given key is already in the table, false if not.
    public boolean contains(T1 key) {
        int idx = getHash(key);
        if (buckets[idx] == null) {
            return false;
        } else {
            LinkedList<String> ll = buckets[idx];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).contains(key.toString())) {
                    return true;
                }
            }
            return false;
        }
    }

    //Takes in a key and returns the value associated with that key. Throws a NoSuchElementException if no values are found for that key
    //TODO: try to figure out why this can return things that aren't of type T2
    public T2 find(T1 key) throws NoSuchElementException {
        int idx= getHash(key);
        if (buckets[idx].peek() == null) {
            throw new NoSuchElementException("No such value found for the key " + key);
        }
        for (int i = 0; i < buckets[idx].size(); i++) {
            String current = buckets[idx].get(i);
            if (current.contains(key.toString())) {
                T2 value = (T2) (current.split(": ")[1]);
                return value;
            }
        }
        return (T2) buckets[idx].peek().split(": ")[1];
    }

    //Returns the size of the Hashtable
    public int size() {
        return buckets.length;
    }
}
