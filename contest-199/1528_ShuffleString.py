def restoreString(s, indices):
    """
    :type s: str
    :type indices: List[int]
    :rtype: str
    """
    l = len(indices)
    str = [0]*l

    for i, n in zip(indices, range(l)):
        str[i] = s[n]
    result = "".join(str)

    return result

if __name__ == "__main__":
    s = "aaiougrt"
    indices = [4, 0, 2, 6, 7, 3, 1, 5]
    result = restoreString(s, indices)
    print(result)
