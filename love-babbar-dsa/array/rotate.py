# to cyclically rotate the array

def rotatecounter( arr, n):
    te = arr[0]
    i = 1
    while i < n:
        arr[i-1] = arr[i]
        i += 1
    arr[i-1] = te
    return arr

def rotateclock(arr, n):
    a = [0 for i in range(n)]
    i = 1
    j = 0
    while i < n:
        a[i] = arr[j]
        i += 1
        j += 1
    a[0] = arr[j] 
    arr = a
    return arr

a = [1, 2]
print(rotateclock(a, len(a)))