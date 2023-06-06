class Solution:
    def commonElements(self, arr1, arr2, arr3):
        ptr1 = ptr2 = ptr3 = 0
        commonElements = []

        while ptr1 < len(arr1) and ptr2 < len(arr2) and ptr3 < len(arr3):
            if arr1[ptr1] == arr2[ptr2] == arr3[ptr3]:
                commonElements.append(arr1[ptr1])
                ptr1 += 1
                ptr2 += 1
                ptr3 += 1
            elif arr1[ptr1] <= arr2[ptr2] and arr1[ptr1] <= arr3[ptr3]:
                ptr1 += 1
            elif arr2[ptr2] <= arr1[ptr1] and arr2[ptr2] <= arr3[ptr3]:
                ptr2 += 1
            else:
                ptr3 += 1
    
        return commonElements
    
p = Solution()
a = [1, 5, 10, 20, 40, 80]
b = [6, 7, 20, 80, 100]
c = [3, 4, 15, 20, 30, 70, 80, 120]
print(p.commonElements(a, b, c))