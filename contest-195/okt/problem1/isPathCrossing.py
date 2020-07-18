def isPathCrossing(path):
        """
        :type path: str
        :rtype: bool
        """
        setOfPath = set()
        rowCount = 0
        colCount = 0
        setOfPath.add((rowCount, colCount))

        for i in range(len(path)):
            if(path[i] == "N"):
                colCount += 1
            elif(path[i] == "S"):
                colCount -= 1
            elif(path[i] == "E"):
                rowCount += 1
            elif(path[i] == "W"):
                rowCount -= 1

            if((rowCount,colCount) in setOfPath):
                return True
            else:
                setOfPath.add((rowCount, colCount))

        return False

# for checking
if __name__ == '__main__':

    str = "NES"
    s = set()

    answer = isPathCrossing(str)

    print(answer)