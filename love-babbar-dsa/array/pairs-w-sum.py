class Solution:
    def getPairsCount(self, arr, n, k):
        pairs = 0
        freq = {}

        for i in arr:
            if i not in freq:
                freq[i] = 1
            else:
                freq[i] += 1

        for i in arr:
            complement = k - i

            if complement in freq:
                pairs += freq[complement]
                
                if complement == i:
                    pairs -= 1  # Adjust pairs count if complement is equal to i

        return pairs // 2  # Divide by 2 to account for double counting


p = Solution()
arr = [1, 1, 1, 1]

print(p.getPairsCount(arr, len(arr), 2))