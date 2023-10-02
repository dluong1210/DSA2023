public class BalanceBracker {
    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') temp.push(s.charAt(i));
            else {
                if ( temp.empty() || (s.charAt(i) == '}' && temp.peek() != '{') || (s.charAt(i) == ')' && temp.peek() != '(') || (s.charAt(i) == ']' && temp.peek() != '[')) {
                    return "NO";
                }
                temp.pop();
            }
        }
        if (temp.empty()) return "YES";
        return "NO";
    }
}