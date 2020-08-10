from collections import Counter
import math

def numIdenticalPairs(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    counter = Counter(nums)
    result = 0

    for num in counter:
        data = counter[num]
        if data >= 2:
            result += math.factorial(data) / (math.factorial(data - 2) * 2)
    return int(result)

if __name__ == "__main__":
    # nums = [1, 2, 3, 1, 1, 3]
    nums = [1, 1, 1, 1]
    result = numIdenticalPairs(nums)
    print(result)