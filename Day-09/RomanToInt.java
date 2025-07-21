public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = getValue(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }

        return result;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Invalid Roman numeral: " + c);
        }
    }
    //Use HashMap for better readability
    // Uncomment the following method if you want to use a HashMap instead of switch-case
    /*
    private int getValue(char c) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        if (!romanMap.containsKey(c)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + c);
        }
        return romanMap.get(c);
    }
    */
    //Main method for testing
    public static void main(String[] args) {
        RomanToInt converter = new RomanToInt();
        String roman = "MCMXCIV"; // Example input
        int result = converter.romanToInt(roman);
        System.out.println("The integer value of " + roman + " is: " + result); // Output: 1994
    }
}