class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        row, column = len(mat), len(mat[0])
        dp = [[None for j in range(column)] for i in range(row)]
        
        for i in range(row):
            count = 0
            for j in range(column - 1, -1, -1):
                if mat[i][j]:
                    count +=1
                else:
                    count = 0
                dp[i][j] = count
        
        result = 0
        
        for i in range(row):
            for j in range(column):
                min_val = float('inf')
                for temp in range(i, row):
                    min_val = min(min_val, dp[temp][j])
                    result += min_val
        
        return result
