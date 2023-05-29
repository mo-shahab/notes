# kadane's algo basically

# Here's the step-by-step approach of Kadane's algorithm:

# Initialize two variables, max_so_far and max_ending_here, 
# to track the maximum subarray sum seen so far and the maximum 
# subarray sum ending at the current position, respectively. 
# Set both variables to the first element of the array.

# Iterate through the array starting from the second element.

# For each element, update max_ending_here by taking the maximum
# of the current element and the sum of the current element and max_ending_here.
# This step considers whether it is better to start a new subarray or extend the current subarray.

# Update max_so_far by taking the maximum of max_so_far and max_ending_here.
# This step keeps track of the maximum subarray sum seen so far.

# Repeat steps 3 and 4 for all elements in the array.

# After the iteration is complete, max_so_far will hold the maximum subarray sum.

def kadane(arr, n):
    max_so_far = arr[0]
    max_ending_here = arr[0]
    for i in range(1, n):
        max_ending_here = max(arr[i], max_ending_here + arr[i])
        max_so_far = max(max_so_far, max_ending_here)

    return max_so_far

a = [10, 2, 3, 4, 45, 12, -2, -10, -70]
print(kadane(a, len(a)))