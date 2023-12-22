def chocolate_distribution(arr, num_of_friends):
    arr.sort()
    min_difference = float('inf')

    # the reason for the range is that we dont go beyond the length of the subarray, because thats what we are doing right
    for i in range(len(arr) - num_of_friends + 1):
        subarray = arr[i : i+num_of_friends]
        difference = subarray[num_of_friends - 1] - subarray[0]
        min_difference = min(min_difference, difference)
    
    return min_difference

# Example usage
chocolates = [7, 3, 2, 4, 9, 12, 56]
m = 3
result = chocolate_distribution(chocolates, m)
print(result)
