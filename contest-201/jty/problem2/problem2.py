class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        
        
        def switches(s):
            res = ''
            for i in reversed(s):
                if i == '1':
                    res += '0'
                else:
                    res += '1'
            return res
        
        
        
        string_value = '0'
        
        for i in range(1, n):
            string_value = string_value + '1' + switches(string_value)
        
        return string_value[k-1]
