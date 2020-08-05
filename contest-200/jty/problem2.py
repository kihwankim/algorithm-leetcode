class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        max_value = max(arr)
        target = arr[0]
        k_count = 0
        while k != k_count and target != max_value:
            if target > arr[1]:
                temp = arr[1]
                del arr[1]
                arr.append(temp)
                k_count += 1
            else:
                temp = arr[0]
                del arr[0]
                arr.append(temp)
                target = arr[0]
                k_count = 1
        
        return arr[0]
