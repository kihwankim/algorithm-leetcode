def canMakeArithmeticProgression(arr):
    """
    :type arr: List[int]
    :rtype: bool
    """
    arr.sort()
    left, right = 0, len(arr) - 1  # ex) 4 -> 3
    before = arr[left] + arr[right]

    while(left < right):
        left += 1
        right -= 1
        after = arr[left] + arr[right]
        if(before != after):
            return False
    return True

# for checking
if __name__ == '__main__':
    arr = [-14,14,-2,-6]
    answer = canMakeArithmeticProgression(arr)

    print(answer)