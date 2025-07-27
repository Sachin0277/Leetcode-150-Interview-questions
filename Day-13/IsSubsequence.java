public class IsSubsequence {
    //Optimized solution
    //Time Complexity: O(n + m) where n is the length of s and m is the length of t
    //Space Complexity: O(1)
    private boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        int sIndex = 0;
        int tIndex = 0;
        
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        
        return sIndex == s.length();
    }
    //Brute force solution
    //Time Complexity: O(n * m) where n is the length of s and m is the length of t
    //Space Complexity: O(1)
    private boolean isSubsequenceBruteForce(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        int sIndex = 0;
        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            if (sIndex < s.length() && s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }
        
        return sIndex == s.length();
    }
    public static void main(String[] args) {
        IsSubsequence isSubseq = new IsSubsequence();
        String s1 = "abc";
        String t1 = "ahbgdc";
        String s2 = "axc";
        String t2 = "ahbgdc";

        System.out.println(isSubseq.isSubsequence(s1, t1)); // true
        System.out.println(isSubseq.isSubsequence(s2, t2)); // false
    }
}
