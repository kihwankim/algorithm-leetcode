def canArrange(arr, k):
    """
    :type arr: List[int]
    :type k: int
    :rtype: bool
    """
    listOfModConter = [0 for i in range(k)]
    for i in range(len(arr)):
        tempMod = arr[i] % k
        listOfModConter[tempMod] += 1

    if((listOfModConter[0] % 2) != 0):
        return False
    if(((len(listOfModConter) % 2) == 0) and ((listOfModConter[k//2] % 2) != 0)):
        return False
    for i in range(1, k//2 + 1):
        if(listOfModConter[i] != listOfModConter[k - i]):
            return False
    return True

# for checking
if __name__ == '__main__':

    arr = [3,8,7,2]
    answer = canArrange(arr, 10)

    print(answer)