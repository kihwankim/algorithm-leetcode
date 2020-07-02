class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        while True:
            if len(nums) and nums[0] + nums[-1] > target:
                nums.remove(nums[-1])
            else:
                break
        if len(nums) == 0:
            return 0

        if nums[-1] * 2 <= target:
            return (2 ** len(nums) - 1) % (10 ** 9 + 7)

        return_value = 0

        for i in range(-1, -1 * len(nums) - 1, -1):
            if nums[-1] + nums[i] > target:
                value = i
            else:
                start = len(nums) + value
                end = len(nums) - 1
                return_value = -1 * (2 ** (end - start) - 1)
                break

        for i in range(-1, -1 * len(nums) - 1, -1):
            if nums[i] * 2 > target:
                return_value -= 1

        return (2 ** len(nums) - 1 + return_value) % (10 ** 9 + 7)
