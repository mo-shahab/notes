# what really happening is:
'''
Array nums = {3, 2, 2, 5} represents the number of characters in each word.
Line width k = 6, which means each line can have at most 6 characters.
Output: 10

Explanation:
    We want to format the given words into lines with a minimum cost. The cost of each line is calculated based on the extra spaces in that line.

    Line by Line Explanation:

        Line 1: From word no. 1 to 1

        Word length = 3
        Extra spaces = 6 - 3 = 3
        Cost = 3^2 = 9
        Line 2: From word no. 2 to 3

        Word lengths = 2, 2
        Extra spaces = 6 - 2 - 2 - 1 = 1
        Cost = 1^2 = 1
        Line 3: From word no. 4 to 4

        Word length = 5
        Extra spaces = 0 (no extra spaces at the end of the last line)
        Cost = 0^2 = 0
        Total Cost:

            Total cost = Cost of Line 1 + Cost of Line 2 + Cost of Line 3 = 9 + 1 + 0 = 10
            Explanation of the Chosen Lines:

                Placing the first word in the first line and the second and third words in the second line gives a cost of 9 (Line 1) + 1 (Line 2) = 10.
                If we placed the first and second words in the first line and the third word in the second line, it would cost 16 (0 spaces on the first line and 6 - 2 = 4 spaces on the second line), which is higher than the minimum cost of 10.
                The goal is to find the optimal way to break lines to minimize the total cost, considering the constraints on line width. In this example, Line 1 has 3 characters, Line 2 has 2 + 2 characters with 1 extra space, and Line 3 has 5 characters with no extra spaces.
'''

# this stuff is like stuffing, here is the code:
def min_cost(arr, k):
    n = len(arr)
    dp = [float('inf')]*n

    for i in range(n):
        total_length = 0
        for j in range(i, -1, -1):
            total_length += arr[j]
            spaces = i - j
            cost = (k - total_length + spaces)**2 if j== 0 else dp[j-1] + (k - total_length + spaces)**2
            dp[i] = min(dp[i], cost)

    print(sum(dp))
    return dp[n-1]

nums = [3,2,2]
k = 4
result = min_cost(nums, k)
print(result)
