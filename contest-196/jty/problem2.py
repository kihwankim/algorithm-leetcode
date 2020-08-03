class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        if len(left) and len(right):
            left_max = max(left)
            right_min = min(right)
            return max(left_max, n - right_min)
        
        if len(left):
            return max(left)
        
        if len(right):
            return n - min(right)
