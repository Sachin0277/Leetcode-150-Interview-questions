public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public String longestCommonPrefixOptimized(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
        }
        
        return prefix.toString();
    }
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Output: "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // Output: ""
        System.out.println(solution.longestCommonPrefix(new String[]{"a", "a", "b"})); // Output: ""
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"})); // Output: "a"
        System.out.println(solution.longestCommonPrefixOptimized(new String[]{"flower", "flow", "flight"})); // Output: "fl"
        System.out.println(solution.longestCommonPrefixOptimized(new String[]{"dog", "racecar", "car"})); // Output: ""
        System.out.println(solution.longestCommonPrefixOptimized(new String[]{"a", "a"," b"})); // Output: ""
        System.out.println(solution.longestCommonPrefixOptimized(new String[]{"ab", "a"})); // Output: "a"
        System.out.println(solution.longestCommonPrefixOptimized(new String[]{})); // Output: ""
    }
}
