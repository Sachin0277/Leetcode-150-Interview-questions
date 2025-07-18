import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom {
    // Data structure to hold the values
    // You can use a HashMap and an ArrayList for efficient insert, delete, and random access
    // Example implementation using Java Collections
    // Placeholder for the actual data structure
    ArrayList<Integer> arr ;
    HashMap<Integer,Integer> hm;
    java.util.Random random = new java.util.Random();
    public InsertDeleteGetRandom() {
        hm = new HashMap<>();
        arr = new ArrayList<>();
    }
    // Methods to insert, delete, and get a random value
     public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        hm.put(val,arr.size());
        arr.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int ind = hm.get(val);
        if(ind < arr.size()-1){
            int t = arr.get(arr.size()-1);
            arr.set(ind,t);
            hm.put(t,ind);
        }
        hm.remove(val);
        arr.remove(arr.size()-1);
        return true;
        
    }
    
    public int getRandom() {
        if(arr.isEmpty()) {
            throw new IllegalStateException("No elements present to get random value.");
        }
        return arr.get(random.nextInt(arr.size()));
    }
    public static void main(String[] args) {
       // Example usage of the InsertDeleteGetRandom class
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        System.out.println("Insert 1: " + obj.insert(1)); // true
        System.out.println("Insert 2: " + obj.insert(2)); // true
        System.out.println("Insert 3: " + obj.insert(3)); // true
        System.out.println("Remove 2: " + obj.remove(2)); // true
        System.out.println("Get Random: " + obj.getRandom()); // Randomly returns 1 or 3
        System.out.println("Insert 2 again: " + obj.insert(2)); // true
        System.out.println("Get Random after re-inserting 2: " + obj.getRandom()); // Randomly returns 1, 2, or 3
    }
}
