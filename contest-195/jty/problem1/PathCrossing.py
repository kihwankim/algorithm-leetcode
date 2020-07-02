class Solution:
    def isPathCrossing(self, path: str) -> bool:
        x, y = 0, 0
        points = []
        points.append([0, 0])
        for s in path:
            if s == 'N':
                y += 1
            elif s == 'S':
                y -= 1
            elif s == 'E':
                x += 1
            elif s == 'W':
                x -= 1
            if [x, y] in points:
                return True
            points.append([x, y])
        return False
