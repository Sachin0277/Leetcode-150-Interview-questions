public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }

    //Brute force solution
    public boolean isPalindromeBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        
        String str = filtered.toString();
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        System.out.println(vp.isPalindrome(test1)); // true
        System.out.println(vp.isPalindrome(test2)); // false
        System.out.println(vp.isPalindromeBruteForce(test1)); // true
        System.out.println(vp.isPalindromeBruteForce(test2)); // false
    }
    
}