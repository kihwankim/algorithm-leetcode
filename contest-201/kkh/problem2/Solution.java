class Solution { // 1545. Find Kth Bit in Nth Binary String
    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(4, 11));
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb;
        String now = "0";
        while (now.length() < k) {
            sb = new StringBuilder();
            sb.append(now);
            StringBuilder next = new StringBuilder();
            for (char data : now.toCharArray()) {
                if (data == '0') {
                    next.append("1");
                } else {
                    next.append("0");
                }
            }
            sb.append("1");
            sb.append(next.reverse().toString());
            now = sb.toString();
        }

        return now.charAt(k - 1);
    }
}