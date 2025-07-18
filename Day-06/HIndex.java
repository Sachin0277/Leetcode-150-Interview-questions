import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        // Count the number of papers for each citation level
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // Calculate the h-index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }

    public int hIndexBruteforce(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        while(hIndex < citations.length && citations[citations.length-1-hIndex] > hIndex ){
            hIndex++;
           
        }
        return hIndex;
    }
    public static void main(String[] args) {
        HIndex hIndexCalculator = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println("H-Index: " + hIndexCalculator.hIndex(citations)); // Output: 3
        //for brute force
        System.out.println("H-Index (Brute Force): " + hIndexCalculator.hIndexBruteforce(citations)); // Output: 3
    }


}