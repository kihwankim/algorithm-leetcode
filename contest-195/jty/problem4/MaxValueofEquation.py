class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        max_value = (-10) ** 9
        while len(points) != 0:
            max_index_of_y = points.index(max(points, key=lambda x: x[1]))
            left_index = max_index_of_y - 1
            right_index = max_index_of_y + 1
            while left_index >= 0 and abs(points[left_index][0] - points[max_index_of_y][0]) <= k:
                max_value = max(max_value,
                                abs(points[left_index][0] - points[max_index_of_y][0]) + points[left_index][1] +
                                points[max_index_of_y][1])
                left_index -= 1
            while right_index < len(points) and abs(points[right_index][0] - points[max_index_of_y][0]) <= k:
                max_value = max(max_value,
                                abs(points[right_index][0] - points[max_index_of_y][0]) + points[right_index][1] +
                                points[max_index_of_y][1])
                right_index += 1

            if right_index == max_index_of_y + 1 and left_index == max_index_of_y - 1 or len(points) != 0:
                del points[max_index_of_y]
            else:
                break
        return max_value
