class Solution(object):
    def findKthBit(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        count = 1   # Sn+1 = S1 + 2**n (n = 1,2,...)
        sum, s = 0, '011'
        if(n == 1 or k == 1): return '0'

        while(sum < k):
            sum += 1 + 2**count
            count += 1

        for i in range(2, count+1):
            m = len(s) // 2
            left, right = s[:m], s[m+1:]
            s = s + '1' + left + '0' + right

        return s[k-1]



if __name__ == "__main__":
    sol = Solution()

    n = 5
    k = 16

    result = sol.findKthBit(n, k)
    print(result)
