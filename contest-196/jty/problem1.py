class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        print(arr)
        gap = arr[1] - arr[0]
        print('gap: ', gap)
        need_reverse = False
        for i in range(1, len(arr)):
            if gap == arr[i] - arr[i-1]:
                continue
            else:
                need_reverse = True
        
        if need_reverse:
            arr.reverse()
            print(arr)
            gap = arr[1] - arr[0]
            print('reverse gap : ', gap)
            for i in range(1, len(arr)):
                if gap == arr[i] - arr[i-1]:
                    continue
                else:
                    return False
            return True
        else:
            return True
