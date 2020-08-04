def getLastMoment(n, left, right):
    """
    :type n: int
    :type left: List[int]
    :type right: List[int]
    :rtype: int
    """
    left_m, right_M = 0, 0
    if(len(left) != 0):
        left_m = max(left)
    if(len(right) != 0):
        right_M = n - min(right)

    return max(left_m, right_M)

if __name__ == '__main__':
    n = 1000
    left = [0]
    right = []
    # arr = [-14,14,-2,-6]
    answer = getLastMoment(n, left, right)

    print(answer)