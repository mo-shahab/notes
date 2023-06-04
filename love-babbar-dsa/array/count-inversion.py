# how many counts or how far is the array from being sorted
# use merge sort to sort and then use the counter variable to count the stuff

# In the merge sort algorithm, when we merge two sorted subarrays (left and right) 
# into a single sorted array, any remaining elements in the left subarray 
# (after all elements from the right subarray have been merged) are greater 
# than the current element from the right subarray. These remaining elements 
# form inversions with the current element from the right subarray.

# To count these inversions, we can calculate the number of remaining elements 
# in the left subarray by subtracting the current index i (which represents the 
# number of elements already merged from the left subarray) from the length of 
# the left subarray len(left). This gives us the count of inversions for the 
# current merging step, which is then added to the total inversion count count.

# In other words, len(left) - i represents the number of elements in the left 
# subarray that are greater than the current element from the right subarray, 
# and therefore, contribute to the inversion count.

def mergesort(arr):
    count = 0
    if len(arr) > 1:
        mid = len(arr)//2

        l = arr[:mid]
        r = arr[mid:]

        # i for l, j for r, k for arr
        i = j = k =  0

        left_count = mergesort(l)
        right_count = mergesort(r)
        count = left_count + right_count

        while i < len(l) and j < len(r):
            if l[i] <= r[j]:
                arr[k] = l[i]
                i += 1
            
            else:
                arr[k] = r[j]
                count += len(l) - i
                j += 1
            k += 1

        while i < len(l):
            arr[k] = l[i]
            i += 1
            k += 1
        
        while j < len(r):
            arr[k] = r[j]
            j += 1
            k += 1
    return count

arr = [1, 2, 3, 4]
print(mergesort(arr))