class Solution:
    def merge(self, intervals):
        intervals.sort()
        merged = []
        
        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])
        
        return merged

intervals = [[1,3],[2,6],[8,10],[9,18]]
p = Solution()
merged_intervals = p.merge(intervals)
print(merged_intervals)


# In the first iteration, since merged is empty, the condition if not merged is True,
#  and the current interval [1,3] is appended to merged.

# In the second iteration, the condition merged[-1][1] < interval[0] is False (3 < 2),
#  so we move to the else block.

# The end value of the last interval in merged is updated to the maximum of its original
# end value 3 and the end value of the current interval 6. So, the interval [2,6] becomes [1,6].

# In the third iteration, the condition merged[-1][1] < interval[0] is True (6 < 8),
# so the current interval [8,10] is appended to merged.

# In the fourth iteration, the condition merged[-1][1] < interval[0] is False (10 < 9),
# so we move to the else block.

# The end value of the last interval in merged is updated to the maximum of its original 
# end value 10 and the end value of the current interval 18. So, the interval [9,18] becomes [9,18].