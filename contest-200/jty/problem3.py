class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        
        
        def find_row_index(loop, start, end):
            is_zero = False
            for i in range(loop, len(grid)):
                for j in range(start, end):
                    if grid[i][j] == 1:
                        is_zero = False
                        break
                    else:
                        is_zero = True
                if is_zero:
                    return i
                is_zero = False
            
            return -1
        
        start, end = 1, len(grid)
        count = 0
        loop = 0
        while start < end:
            row_idx = find_row_index(loop, start, end)
            if row_idx != -1:
                count = count + (row_idx - loop)
                if row_idx - loop != 0:
                    while row_idx - loop != 0:
                        grid[row_idx], grid[row_idx - 1] = grid[row_idx - 1], grid[row_idx]
                        row_idx -= 1
                loop += 1
            else:
                return -1
            start += 1
        
        return count
        
