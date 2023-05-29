class Solution:
    def minJumps(self, arr, n):
        jump = 1
        m = arr[0]
        step = arr[0]
        if n <= 1:
            return 0
        if arr[0] == 0:
            return -1
        for i in range(1, n - 1):
            m = max(m, i + arr[i])
            step -= 1
            if m == n:
                return jump + 1
            if step == 0:
                jump += 1
                if i > m - 1:
                    return -1
                step = m - i
        return jump
        
    
p = Solution()
a = [2, 3, 1, 1, 2, 4, 2, 0, 1, 1]
print(p.minJumps(a, len(a)))