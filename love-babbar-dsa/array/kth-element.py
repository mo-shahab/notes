# finding the kth smallest or greatest element in an array
class Solution:
    def kthSmallest(self,arr, l, r, k):
        arr.sort()
        return (arr[k-1]) # just the smallest kth element but is that valid
    

p = Solution()
arr = [3, 643, 23, 56, 2, 15, 6, 7, 34, 75, 443, 76, 11]
print(p.kthSmallest(arr, 0, len(arr), 5))