# use hashset
class Solution:    
    # Function to return the count of number of elements in the union of two arrays.
    def doUnion(self, a, n, b, m):
        ptr1 = 0
        ptr2 = 0
        sol = []
        while ptr1 < n and ptr2 < m:
            if a[ptr1] == b[ptr2]:
                sol.append(a[ptr1])
                ptr1 += 1
                ptr2 += 1
            elif a[ptr1] < b[ptr2]:
                sol.append(a[ptr1])
                ptr1 += 1
            else:
                sol.append(b[ptr2])
                ptr2 += 1
        
        # Check if there are any remaining elements in array a
        while ptr1 < n:
            sol.append(a[ptr1])
            ptr1 += 1
        
        # Check if there are any remaining elements in array b
        while ptr2 < m:
            sol.append(b[ptr2])
            ptr2 += 1
        
        return sol
    
    def doIntersection(self, a, n, b, m):
        ptr1 = 0
        ptr2 = 0
        sol = []
        while ptr1 < n and ptr2 < m:
            if a[ptr1] == b[ptr2]:
                sol.append(a[ptr1])
                ptr1 += 1
                ptr2 += 1
            elif a[ptr1] < b[ptr2]:
                ptr1 += 1
            else:
                ptr2 += 1
        return sol

p = Solution()
a = [2, 4, 6, 8, 10]
b = [1, 2, 3]

print(p.doUnion(a, 5, b, 3))
print(p.doIntersection(a, 5, b, 3))