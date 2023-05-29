# really simple but that is not it
def merge(a: list[int], b: list[int]):
    a.extend(b)
    return a

# function is not quite right
def merge2(a: list[int], b: list[int]):
    ptr1 = 0
    ptr2 = 0
    while ptr1 < len(a) or ptr2 < len(b):
        if a[ptr1] <= b[ptr2]:
            ptr1 += 1
        else:
            a.insert(ptr1, b[ptr2])
            ptr2 += 1
    
    return a

a = [1, 3, 5, 6, 7]
b = [3, 5, 6, 7, 8]
print(merge2(a, b))