class Solution:
    def numSub(self, s: str) -> int:
        one_list = []
        result = 0
        count = 0
        
        for i in s:
            if i == '0':
                if count != 0:
                    for num in range(1, count + 1, 1):
                        result += num
                count = 0
            else:
                count += 1
        if count != 0:
            for num in range(1, count + 1, 1):
                result += num
        
        return result % int(1e9+7)
