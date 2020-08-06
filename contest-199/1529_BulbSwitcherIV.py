def minFlips(target):
    """
    :type target: str
    :rtype: int
    """
    now, count = "0", 0
    for i in range(len(target)):
        if(target[i] == now):
            pass
        else:
            now = target[i]
            count += 1
    return count


if __name__ == "__main__":
    target = "001011101"
    result = minFlips(target)
    print(result)
