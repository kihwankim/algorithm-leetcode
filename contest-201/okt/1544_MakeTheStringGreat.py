class Solution(object):
    def makeGood(self, s):
        """
        :type s: str
        :rtype: str
        """
        self.length = len(s)
        self.result = []
        self.lenResult = 0
        for i in range(self.length):
            if(self.lenResult != 0):
                a = ord(s[i])
                b = ord(self.result[-1])
                if( (ord(self.result[-1]) == ord(s[i]) + 32 ) or
                    (ord(self.result[-1]) == ord(s[i]) - 32) ):
                    self.result.pop()
                    self.lenResult -= 1
                else:
                    self.result.append(s[i])
                    self.lenResult += 1
            else:
                self.result.append(s[i])
                self.lenResult += 1
                continue


        return "".join(self.result)


if __name__ == "__main__":
    sol = Solution()

    s = "abBAcC"

    result = sol.makeGood(s)
    print(result)
