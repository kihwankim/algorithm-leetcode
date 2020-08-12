class Solution:
    def makeGood(self, s: str) -> str:
        if len(s) == 1:
            return s
        i = 0
        length = len(s) - 1
        while i < length and i >= 0:
            if (s[i].islower() and s[i + 1] == s[i].upper()) or (s[i].isupper() and s[i + 1] == s[i].lower()):
                print(s[:i], s[i+2:])
                s = s[:i] + s[i+2:]
                i = 0
            else:
                i += 1
            
            length = len(s) - 1
        
        return s
