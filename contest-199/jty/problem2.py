class Solution:
    def minFlips(self, target: str) -> int:
        compare_value = '0'
        count = 0
        for i in target:
            if i == compare_value:
                continue
            else:
                count += 1
                compare_value = i
        return count
