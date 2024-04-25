# floyd's hare and tortoise algo
# so there is a thing with indefinite thing
# you can just ignore the infinite loop 
# because you will be given an array with a duplicate pair
# and the indefinite condition is not a problem
# so if the sizee of the array is n then you can only have integers in range 1 to n
'''
Floyd's Hare and Tortoise algorithm is an elegant way to find cycles in sequences or linked lists. In this specific context, the algorithm is adapted to find a duplicate number in an array where:

The array size is n.
Each element in the array is an integer within the range from 1 to n.
Logic and Intuition Behind the Algorithm:
The algorithm leverages the properties of a cycle detection method in linked lists. Imagine each element in the array as a pointer to the next node of a linked list. For instance, if arr[i] = j, then i points to j. This structure can form cycles due to the presence of a duplicate.

Here’s the step-by-step breakdown:

Initialization:
Both slow and fast pointers start at the first element of the array. This is akin to both starting at the head of a linked list.

Finding Intersection Point in the Cycle:
The algorithm progresses in two phases. In the first phase, slow moves one step at a time (slow = arr[slow]), and fast moves two steps at a time (fast = arr[arr[fast]]). This difference in speed ensures that if there is a cycle, the fast pointer will eventually meet the slow pointer inside the cycle after a number of steps. The point at which they meet is guaranteed to be within the cycle due to the properties of cycle detection in linked lists (specifically, Floyd's cycle-finding algorithm).

Identifying the Start of the Cycle:
Once a cycle is detected (i.e., when slow == fast), we need to find the entry point of the cycle, which corresponds to the duplicate number in the array. To do this, reset one pointer to the start of the array (let's say ptr1 = arr[0]) and set another (ptr2) at the meeting point within the cycle. Then move both pointers at the same speed (one step at a time). The point where they meet again is the start of the cycle, which is the duplicate number in the array.

Why This Works:
The reason this approach successfully identifies the duplicate is based on how duplicates in the array create cycles. The first occurrence of a number might act as an entry point to a cycle, and the second occurrence confirms the cycle's existence.

In your example with the array a = [2, 4, 5, 3, 5, 1]:

Starting from index 0, the values lead us through the array in a sequence determined by the index-to-value mapping.
Eventually, following the indices as dictated by their values leads into a cycle because the value 5 appears twice and it points back to itself.
'''
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
