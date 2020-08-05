class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        dataset = {}
        s = list(s)
        for i in range(len(indices)):
            dataset[indices[i]] = s[i]
        
        dataset = sorted(dataset.items())
        result = ''
        for i in range(len(dataset)):
            result += dataset[i][1]
        
        return result
