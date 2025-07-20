
public class Candy {
    // Distribute candies to children such that each child gets at least one candy
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] candies = new int[n];
        // Each child gets at least one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // Calculate the total candies needed
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
    //Brute force approach
    public int candyBruteForce(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        // Initialize candies to 1 for each child

        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < n - 1; i++) {
                if (ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
                    candies[i + 1] = candies[i] + 1;
                    changed = true;
                } else if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    changed = true;
                }
            }
        } while (changed);
        // Calculate the total candies needed
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
        //Main method for testing
        public static void main(String[] args) {
            Candy solution = new Candy();
            int[] ratings = {1, 0, 2};
            int result = solution.candy(ratings);
            System.out.println("Minimum candies needed: " + result);

            // Example with more ratings
            int[] ratings2 = {1, 2, 2};
            int result2 = solution.candy(ratings2);
            System.out.println("Minimum candies needed for ratings [1, 2, 2]: " + result2);
            // Brute force example
            int bruteForceResult = solution.candyBruteForce(ratings);
            System.out.println("Minimum candies needed using brute force: " + bruteForceResult);
        }
}
