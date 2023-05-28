def rev(array, start, end):
    while start < end:
        array[start], array[end] = array[end], array[start]
        start = start + 1
        end = end - 1
        
array = [1, 2, 3, 4, 5, 6]
print(array)
rev(array, 0, 5)
print(array)