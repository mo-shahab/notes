# https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
# THE ABOVE LINK EXPLAINS WHAT, THIS PROBLEM IS ALL ABOUT, IT CAN ALSO BE NOTED AS PRE-REQUISITE

# Start from the right side of the array and find the first pair of adjacent elements where the left element
# is smaller than the right element. Let's call the index of the left element k.

# If no such pair exists, it means the given permutation is already the last permutation.
# Once you find the index k, from the right side of the array, find the largest element greater than the element at index k.

# Let's call the index of this element l.
# Swap the elements at indices k and l.

# After swapping, reverse the sequence of elements from index k+1 to the end of the array.
# By following these steps, you can generate the next permutation lexicographically.

# Here's a simple example to illustrate the steps:
# Given the array [1, 3, 2]
# The pair of adjacent elements where the left element is smaller than the right element is 1 and 3, with index k=0.
# From the right side, the largest element greater than 1 is 2, with index l=2.
# Swap the elements at indices k=0 and l=2, resulting in [2, 3, 1].
# Reverse the sequence from index k+1=1 to the end of the array, resulting in [2, 1, 3].
# The final array [2, 1, 3] is the next permutation lexicographically.

class solution:
    def nextperm(self, nums):
        k = -1
        for i in range(len(nums) -1, -1, -1):
            if(nums[i-1] < nums[i]):
                k = i - 1
                l = i
                break
        if k == -1:
            nums.reverse()
            return nums 
        else:
            l - 1
            for i in range(len(nums) - 1, k, -1):
                if nums[i] > nums[k]:
                    l = i
                    break

        # could have used one line substitution but this can be used in diff languages too
            nums[k], nums[l] = nums[l], nums[k]

            nums[k + 1:] = reversed(nums[k + 1:])
        return nums 

p = solution()
nums = [100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1]
p.nextperm(nums)