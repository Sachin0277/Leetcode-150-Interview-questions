public class ReverseWordOfString {
    public static void main(String[] args) {
        String str = "Hello World";
        String reversed = reverseWords(str);
        System.out.println(reversed); // Output: "olleH dlroW"
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedString.append(reversedWord.reverse().toString()).append(" ");
        }

        return reversedString.toString().trim();
    }

    public String reverseWordsOptimized(String s) {
        String res = "";
        int n = s.length();
        int i=0;
        while(i < n){
            while(i < n && s.charAt(i) == ' ') i++;
            if(i >= n) break;
            int j = i+1;
            while(j < n && s.charAt(j) != ' ') j++;
            String subStr = s.substring(i,j);
            if(res.length() == 0) res = subStr;
            else res = subStr+ " " +res ;
            i = j+1;
        } 
        return res;
    }
}