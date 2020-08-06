def numSub(s):
    """
    :type s: str
    :rtype: int
    """
    from collections import Counter

    splitArr = s.split("0")
    counter = Counter(splitArr)
    result = 0

    for i in counter:
        if i == '':
            continue
        a = len(i)
        result += ((a + 1) * a / 2) * counter[i] # Gauss - 2S

    return int(result) % (10**9 + 7)

if __name__ == "__main__":
    s = "1111111111011010011"
    result = numSub(s)
    print(result)