def numSubseq(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    nums.sort()
    lengthOfArr = len(nums) - 1
    index = 0
    modValue = 10**9 + 7
    result = 0

    while(index <= lengthOfArr):
        if(nums[index] + nums[lengthOfArr] > target):
            lengthOfArr -= 1
        else:
            result += pow(2, lengthOfArr - index) % modValue
            index += 1

    return result % modValue

# for checking
if __name__ == '__main__':

    arr = [2,3,3,4,6,7]
    answer = numSubseq(arr, 12)

    print(answer)