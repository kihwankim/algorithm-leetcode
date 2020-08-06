import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution { // 1520. Maximum Number of Non-Overlapping Substrings
    public static void main(String[] args) {
        System.out.println(new Solution().maxNumOfSubstrings("adefaddaccc"));
    }

    public List<String> maxNumOfSubstrings(String s) {
        List<String> result = new LinkedList<>(); // result
        int length = s.length(); // length of string
        int[] min = new int[26]; // min index of each lower case character in string s
        int[] max = new int[26]; // max index of each lower case character in string s
        Arrays.fill(min, length); // you just fill with min for Integer.MAX_VALUE or length

        for (int nowIndex = 0; nowIndex < length; ++nowIndex) {
            char nowChar = s.charAt(nowIndex);
            int changeIndex = nowChar - 'a';
            min[changeIndex] = Math.min(min[changeIndex], nowIndex);
            max[changeIndex] = Math.max(max[changeIndex], nowIndex);
        } // fill with the real index

        int slidMax = -1; // slidMax -> rightside of index
        for (int start = 0; start < length; ++start) {
            int nowChar = s.charAt(start) - 'a'; // now index char
            if (start == min[nowChar]) { // check there are same character in smaller index than now index ex) a(nowchar)a(start)a -> x
                int tempSlidMax = max[nowChar];
                boolean isSubStr = true; // flag add new thing or replace
                for (int slidMin = start; slidMin <= tempSlidMax; ++slidMin) {
                    int nowMinDataIndex = min[s.charAt(slidMin) - 'a'];
                    int nowMaxDataIndex = max[s.charAt(slidMin) - 'a'];
                    if (nowMinDataIndex < start) { // overlap case
                        isSubStr = false;
                        break;
                    }
                    if (nowMaxDataIndex > tempSlidMax) {
                        tempSlidMax = nowMaxDataIndex;
                    } // it have to extend cuz there are other large sub string in string s
                }
                if (isSubStr) { // I can make or replace new substring
                    if (start > slidMax) { // new sub string
                        result.add(s.substring(start, tempSlidMax + 1));
                        slidMax = tempSlidMax;
                    } else { // replace substring -> cuz there are more shorter sub string in here
                        slidMax = tempSlidMax;
                        result.remove(result.size() - 1);
                        result.add(s.substring(start, slidMax + 1));
                    }
                }
            }
        }
        return result;
    }
}