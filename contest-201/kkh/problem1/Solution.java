import java.util.Stack;

class Solution { // 1544. Make The String Great
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() > 0) {
            stack.push(s.charAt(0));
        }

        for (int index = 1; index < s.length(); index++) {
            char tryData = s.charAt(index);
            int lowercase = (int) tryData - 32;
            int uppercase = (int) tryData + 32;
            if (stack.isEmpty()) {
                stack.push(tryData);
            } else {
                char before;
                before = stack.peek();
                if (((int) before == lowercase || uppercase == (int) before)) {
                    stack.pop();
                } else {
                    stack.push(tryData);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char input : stack) {
            sb.append(input);
        }

        return sb.toString();
    }
}