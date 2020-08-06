def countGoodTriplets(arr, a, b, c):
    """
    :type arr: List[int]
    :type x: int
    :type y: int
    :type z: int
    :rtype: int
    """
    length = len(arr)
    count = 0

    for x in range(length - 1):
        for y in range(x + 1, length):
            if(abs(arr[x] - arr[y]) <= a):
                for z in range(y + 1, length):
                    if(not(abs(arr[x]-arr[z]) <= c)):
                        continue
                    if(abs(arr[y]-arr[z]) <= b):
                        count += 1
            else:
                continue
    return count

if __name__ == "__main__":
    arr = [3, 0, 1, 1, 9, 7]
    a = 7
    b = 2
    c = 3
    result = countGoodTriplets(arr, a, b, c)
    print(result)