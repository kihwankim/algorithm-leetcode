class Solution(object):
    def maxNonOverlapping(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        result, sum = 0, 0
        stored = {0}            # stored is set(no duplication) -> time saving
                                # 0 is exist for when the sum is the target
        for i in nums:
            sum += i
            needless= sum - target
            if needless in stored:
                result += 1
                stored = {0}
                sum = 0
            stored.add(sum)
        return result

if __name__ == "__main__":
    sol = Solution()

    nums = [-2,6,6,3,5,4,1,2,8]
    target = 10

    result = sol.maxNonOverlapping(nums, target)
    print(result)