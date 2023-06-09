class Solution:
    def subArrayExists(self, arr, n):
        cumulative_sum = 0
        map = {}
        for i in arr:
            cumulative_sum += i
            if cumulative_sum in map:
                return True
            map[cumulative_sum] = i
        return False
    
arr = [4, 2, 0, 1, 6]

p = Solution()
print(p.subArrayExists(arr, len(arr)))