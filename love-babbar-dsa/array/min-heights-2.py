class Solution:
    def getMinDiff(self, arr, n, k):
        arr.sort()
        max_height = arr[n-1]
        min_height = arr[0]
        min_difference = max_height - min_height
        for i in range(1, n-1):
            addk = arr[i] + k
            subk = arr[i] - k
            if addk < min_height:
                min_height = addk
            if subk > max_height:
                max_height = subk
            updated_min_diff = max_height - min_height
            
        addk = arr[n-1] + k
        subk = arr[n-1] - k
        if addk < min_height:
            min_height = addk
        if subk > max_height:
            max_height = subk

        updated_min_diff = max_height - min_height
        if updated_min_diff < min_difference:
            min_difference = updated_min_diff
        if updated_min_diff < min_difference:
            min_difference = updated_min_diff

        return min_difference

p = Solution()
l = [2, 6, 3, 4, 7, 2, 10, 3, 2, 1]
print(p.getMinDiff(l, len(l), 5))
