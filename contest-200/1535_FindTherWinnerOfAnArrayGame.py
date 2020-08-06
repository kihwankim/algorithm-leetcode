def getWinner(arr, k):
    """
    :type arr: List[int]
    :type k: int
    :rtype: int
    """
    # len-1 보다 k가 크면 제일 큰 값 반환
    length = len(arr)
    count = 1
    winner = 0
    if(length-1 < k):
        return max(arr)
    else:
        for i in range(1, length):
            if(arr[winner] < arr[i]):
                winner = i
                count = 0
            count += 1

            if (count == k): break

        return arr[winner]

if __name__ == "__main__":
    arr = [1,25,35,42,68,70]
    k = 1
    result = getWinner(arr, k)
    print(result)