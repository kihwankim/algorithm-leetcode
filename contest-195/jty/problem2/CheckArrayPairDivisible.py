class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        counter = {}
        for num in arr:
            if num % k in counter:
                counter[num % k] += 1
            else:
                counter[num % k] = 1

        if 0 in counter and counter[0] % 2 != 0:
            return False

        for key in counter.keys():
            if key > 0:
                if k - key not in counter:
                    return False
                elif k - key in counter and counter[key] != counter[k - key]:
                    return False

        return True
