public class FIndTheFirstOccurenceOfWordInGivenString {
    public static void main(String[] args) {
        String str = "Hello, this is a simple example. This is just an example.";
        String word = "example";
        int index = findFirstOccurrence(str, word);
        
        if (index != -1) {
            System.out.println("The first occurrence of the word '" + word + "' is at index: " + index);
        } else {
            System.out.println("The word '" + word + "' was not found in the string.");
        }
        // Example of case-insensitive search
        int indexIgnoreCase = findFirstOccurrenceIgnoreCase(str, word);
        if (indexIgnoreCase != -1) {
            System.out.println("The first occurrence of the word '" + word + "' (case-insensitive) is at index: " + indexIgnoreCase);
        } else {
            System.out.println("The word '" + word + "' was not found in the string (case-insensitive).");
        }
        // Example of regex search
        int indexRegex = findFirstOccurrenceWithRegex(str, word);
        if (indexRegex != -1) {
            System.out.println("The first occurrence of the word '" + word + "' using regex is at index: " + indexRegex);
        } else {
            System.out.println("The word '" + word + "' was not found in the string using regex.");
        }
        // Example of finding without built-in methods
        int indexWithoutBuiltIn = findFirstOccurrenceWithoutBuiltIn(str, word);
        if (indexWithoutBuiltIn != -1) {
            System.out.println("The first occurrence of the word '" + word + "' without built-in methods is at index: " + indexWithoutBuiltIn);
        } else {
            System.out.println("The word '" + word + "' was not found in the string without built-in methods.");
        }
        // Example of finding using substring
        int indexUsingSubstring = findFirstOccurrenceUsingSubstring(str, word);
        if (indexUsingSubstring != -1) {
            System.out.println("The first occurrence of the word '" + word + "' using substring is at index: " + indexUsingSubstring);
        } else {
            System.out.println("The word '" + word + "' was not found in the string using substring.");
        }
    }

    public static int findFirstOccurrence(String str, String word) {
        return str.indexOf(word);
    }

    public static int findFirstOccurrenceIgnoreCase(String str, String word) {
        return str.toLowerCase().indexOf(word.toLowerCase());
    }
    public static int findFirstOccurrenceWithRegex(String str, String word) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\b" + java.util.regex.Pattern.quote(word) + "\\b");
        java.util.regex.Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.start();
        }
        return -1;
    }
    //without built-in methods
    public static int findFirstOccurrenceWithoutBuiltIn(String str, String word) {
        int strLength = str.length();
        int wordLength = word.length();

        for (int i = 0; i <= strLength - wordLength; i++) {
            int j;
            for (j = 0; j < wordLength; j++) {
                if (str.charAt(i + j) != word.charAt(j)) {
                    break;
                }
            }
            if (j == wordLength) {
                return i; // Found the word
            }
        }
        return -1; // Word not found
    }
    //using substring
    public static int findFirstOccurrenceUsingSubstring(String str, String word) {
        int strLength = str.length();
        int wordLength = word.length();

        for (int i = 0; i <= strLength - wordLength; i++) {
            if (str.substring(i, i + wordLength).equals(word)) {
                return i; // Found the word
            }
        }
        return -1; // Word not found
    }
    
}
