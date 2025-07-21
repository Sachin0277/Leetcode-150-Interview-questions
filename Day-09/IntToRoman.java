public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
    //Optimized solution using matching values and symbols
    /*
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            while (num >= entry.getKey()) {
                num -= entry.getKey();
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
    */

    public String IntToRomanOptimized(int num) {
         String oneDigit[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String twoDigit[] = { "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String threeDigit[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String fourDigit[] = {"","M","MM","MMM"};
        return fourDigit[num/1000]+threeDigit[(num%1000)/100]+twoDigit[(num%100)/10]+oneDigit[num%10];
    }
    // Main method for testing
    public static void main(String[] args) {
        IntToRoman converter = new IntToRoman();
        int number = 1994; // Example input
        String result = converter.intToRoman(number);
        System.out.println("The Roman numeral for " + number + " is: " + result); // Output: MCMXCIV
        // Testing the optimized method
        String optimizedResult = converter.IntToRomanOptimized(number);
        System.out.println("The optimized Roman numeral for " + number + " is: " + optimizedResult); // Output: MCMXCIV
    }
}
