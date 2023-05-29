# floyd's hare and tortoise algo
# so there is a thing with indefinite thing
# you can just ignore the infinite loop 
# because you will be given an array with a duplicate pair
# and the indefinite condition is not a problem
# so if the sizee of the array is n then you can only have integers in range 1 to n
def duplicate(arr):
    slow = arr[0]
    fast = arr[0]

    while True:
        slow = arr[slow]
        fast = arr[arr[fast]]
        if slow == fast:
            break

    ptr1 = arr[0]
    ptr2 = slow
    while ptr1 != ptr2:
        ptr1 = arr[ptr1]
        ptr2 = arr[ptr2]

    return ptr1

a = [2, 4, 5, 3, 5, 1]
print(duplicate(a))