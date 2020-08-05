class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        numFull = numBottles
        numEmpty = 0
        result = 0
        
        while True:
            result += numFull
            numEmpty += numFull
            numFull = 0
            numFull = int(numEmpty / numExchange)
            numEmpty -= (numFull * numExchange)
            if numFull == 0 and numEmpty < numExchange:
                break
        
        return result
