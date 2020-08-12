class Solution:
    def maxNonOverlapping(self, nums: List[int], target: int) -> int:
        
        def find_recursive(left, right, res):
            
            if left < 0 or right >= len(nums):
                return res
            
            if nums[left] == target:
                return find_recursive(left + 1, left + 1, res + 1)
            
            elif nums[right] == target:
                return find_recursive(right + 1, right + 1, res + 1)
            
            temp = sum(nums[left:right+1])
            if temp == target:
                return find_recursive(right + 1, right + 1, res + 1)
            
            else:
                r1 = find_recursive(left, right + 1, res)
                r2 = find_recursive(left + 1, left + 1, res)
                return max(r1, r2, res)
                
        return find_recursive(0, 0, 0)
