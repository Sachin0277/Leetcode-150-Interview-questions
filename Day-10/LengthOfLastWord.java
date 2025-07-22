public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        String[] words = s.trim().split("\\s+");
        if (words.length == 0) {
            return 0;
        }
        
        return words[words.length - 1].length();
    }
     public int lengthOfLastWordOptimized(String s) {
       int len = 0;
        for(int i= s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                len++;
            }
            else{
            if(len>0) return len;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World")); // Output: 5
        System.out.println(solution.lengthOfLastWord("   ")); // Output: 0
        System.out.println(solution.lengthOfLastWord("a ")); // Output: 1
        System.out.println(solution.lengthOfLastWord("Hello")); // Output: 5
        System.out.println(solution.lengthOfLastWordOptimized("Hello World")); // Output: 5
        System.out.println(solution.lengthOfLastWordOptimized("   ")); // Output: 0
        System.out.println(solution.lengthOfLastWordOptimized("a ")); // Output: 1
        System.out.println(solution.lengthOfLastWordOptimized("Hello")); // Output: 5

    }
}