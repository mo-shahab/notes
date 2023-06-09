# The idea is to process the array from left to right. 
# While processing, find the first out-of-place element
# in the remaining unprocessed array. An element is out
# of place if it is negative and at odd index (0-based index),
# or if it is positive and at even index (0-based index). 
# Once we find an out-of-place element, we find the first 
# element after it with an opposite sign. We right rotate 
# the subarray between these two elements (including these two).

def arrangealt(arr):
    i = 0
    j = 1

    while i < len(arr) and j < len(arr):
        if (arr[i] >= 0 and arr[j] >= 0) or (arr[i] < 0 and arr[j] < 0):
            j += 2
        else:
            k = j
            while k < len(arr) and (arr[i] >= 0 and arr[k] >= 0) or (arr[i] < 0 and arr[k] < 0):
                k += 1
            if k >= len(arr):
                break
            temp = arr[k]
            for l in range(k, i, -1):
                arr[l] = arr[l - 1]
            arr[i + 1] = temp
            i += 2
            j += 1
    
    return arr

arr = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]

print(arrangealt(arr))