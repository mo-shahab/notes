# two pointer approach  
# The reason for using `i <= left` as the condition for the `while` loop instead of `i < n` 
# is because in the two-pointer approach, you are swapping elements to move 0s to the left and
# 2s to the right. The elements between `right` and `left` are the unknown elements that need to 
# be sorted.

# Initially, `right` is pointing to the start of the array (0 index) and `left` is pointing 
# to the end of the array (n-1 index). The purpose of the loop is to traverse the unknown elements 
# and move them towards their correct positions. 

# When you encounter a `2` at `arr[i]`, you swap it with `arr[left]` and decrement `left` by 
# 1 to move it towards the right side. But you don't increment `i` in this case because the 
# swapped element at `arr[i]` still needs to be checked.

# By using `i <= left` as the loop condition, you ensure that the loop continues until `i` 
# reaches `left`, covering all the unknown elements that need to be sorted.

# In your previous code, when you used `i < n` as the loop condition, it terminated prematurely 
# before reaching the last element of the unknown section, resulting in the incorrect placement 
# of the last `1` in the sorted array.

# By using `i <= left`, you ensure that the loop continues until all the unknown elements have 
# been traversed and sorted, leading to the correct placement of all the elements.

# Understanding the problem constraints and keeping track of the two pointers (`right` and `left`) 
# during the sorting process is crucial in this approach.
class Solution:
    def sort012(self, arr, n):
        right = 0
        i = 0
        left = n - 1
        while i <= left:
            if arr[i] == 0:
                temp = arr[i]
                arr[i] = arr[right]
                arr[right] = temp
                i += 1
                right += 1
            elif arr[i] == 2:
                temp = arr[left]
                arr[left] = arr[i]
                arr[i] = temp
                left -= 1
            else:
                i += 1

        return arr

p = Solution()
arr = [0, 2, 2, 1, 1, 0, 1, 2]
print(p.sort012(arr, len(arr)))