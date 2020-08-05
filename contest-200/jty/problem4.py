class Solution:
    def maxSum(self, nums1: List[int], nums2: List[int]) -> int:
        l_1, l_2 = len(nums1), len(nums2)
        test = 0
        for i in nums1:
            test += i
        i, j = 0, 0
        sum_list = []
        sum_list.append([sum(nums1), sum(nums2), -1])
        while i < l_1 and j < l_2:
            if nums1[i] == nums2[j]:
                sum_list.append([sum(nums1[i:l_1]), sum(nums2[j:l_2]), nums1[i]])
                i, j = i+1, j+1
            elif nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
        
        if len(sum_list) == 1:
            return max(sum_list[0][0], sum_list[0][1])
        print(sum_list)
        res = 0
        for i in range(len(sum_list)-1):
            res += max(sum_list[i][0] - sum_list[i+1][0], sum_list[i][1] - sum_list[i+1][1])
        return (res + max(sum_list[-1][0], sum_list[-1][1])) % (10**9 + 7)
