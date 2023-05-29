# two pointer approach
class Solution:
    def moveneg(self, arr, n):
        right = 0
        i = 0
        left = n-1
        while i <= left:
            if arr[i] < 0:
                temp = arr[i]
                arr[i] = arr[right]
                arr[right] = temp
                i += 1
                right += 1
            elif arr[i] > 0:
                temp = arr[left]
                arr[left] = arr[i]
                arr[i] = temp
                left -= 1
                # here i+= 1 is not used 
            else:
                i += 1

        return arr

p = Solution()
arr = [-1, 2, -3, 4, 5, 6, -7, 8, 9]
print(p.moveneg(arr, len(arr)))