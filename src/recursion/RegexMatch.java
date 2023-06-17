package recursion;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character. Leetcode Regex matching problem
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */

public class RegexMatch {
    public static void main(String[] args) {
        String str = "aab";
        String pattern = "c*a*b";
        System.out.println(isMatched(str, pattern));

    }

    public static boolean isMatched(String str, String pattern){
//        check if the string and patter are empty
        if(pattern.isEmpty()) {
            return str.isEmpty();
        }
//        lets find the first match
        boolean firstMatch = !str.isEmpty() && (pattern.charAt(0) == str.charAt(0)
        || pattern.charAt(0) == '.');

//        check the consecutive matches after first match
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatched(str, pattern.substring(2)) || (firstMatch && isMatched(str.substring(1), pattern)));
        } else {
            return firstMatch && isMatched(str.substring(1), pattern.substring(1));
        }
    }
}
