def numWaterBottles(numBottles, numExchange):
    """
    :type numBottles: int
    :type numExchange: int
    :rtype: int
    """
    import math
    result, new, rest = numBottles, 0, numBottles

    while(rest >= numExchange):
        new = math.floor(rest/numExchange)
        result += new
        rest = rest % numExchange + new

    return int(result)

if __name__ == "__main__":
    numBottles = 5
    numExchange = 5
    result = numWaterBottles(numBottles, numExchange)
    print(result)