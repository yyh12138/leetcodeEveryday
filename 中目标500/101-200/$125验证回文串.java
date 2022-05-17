/**
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 */

public class $125验证回文串 {
    // 双指针
    public boolean isPalindrome(String s) {
        String ss = s.toLowerCase().replaceAll("\\W|_", "");
        int len = ss.length();
        int i=0, j=len-1;
        while (i<=j) {
            if (ss.charAt(i)==ss.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
    // Character工具类
    public boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $125验证回文串().isPalindrome("ab_a"));
        System.out.println("ab_a".replaceAll("\\W|_", ""));
    }
}
