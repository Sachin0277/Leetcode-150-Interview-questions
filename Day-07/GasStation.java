public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentGas = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If current gas is negative, reset the start index
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, return -1
        return totalGas < totalCost ? -1 : startIndex;
    }
    //brute force approach
    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int currentGas = 0;
            boolean canComplete = true;

            for (int i = 0; i < n; i++) {
                int index = (start + i) % n;
                currentGas += gas[index] - cost[index];

                if (currentGas < 0) {
                    canComplete = false;
                    break;
                }
            }

            if (canComplete) {
                return start;
            }
        }

        return -1; // Cannot complete the circuit
    }
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = solution.canCompleteCircuit(gas, cost);
        
        if (result != -1) {
            System.out.println("Starting index to complete the circuit: " + result);
        } else {
            System.out.println("Cannot complete the circuit.");
        }
        // Brute force example
        int bruteForceResult = solution.canCompleteCircuitBruteForce(gas, cost);
        if (bruteForceResult != -1) {
            System.out.println("Brute force starting index to complete the circuit: " + bruteForceResult);
        } else {
            System.out.println("Cannot complete the circuit using brute force.");
        }
    }
}
