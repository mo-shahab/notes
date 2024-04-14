def mergesort(arr):
    if len(arr) > 1:
        

        left_arr = arr[:len(arr)//2]
        right_arr = arr[len(arr)//2:]

        mergesort(left_arr)
        mergesort(right_arr)

        # merge the stuff now 

        i = 0 # lehht_arr
        j = 0 # right_arr
        k = 0 # merged_arr

        while i < len(left_arr) and j < len(right_arr):
            if left_arr[i] < right_arr[j]:
                arr[k] = left_arr[i]
                i+=1
            else:
                arr[k] = right_arr[j]
                j+=1
            k+=1

        # adding the leftoever elems in the sorted array

        while i < len(left_arr):
            arr[k] = left_arr[i]
            i+=1
            k+=1
    
        while j < len(right_arr):
            arr[k] = right_arr[j]
            j+=1
            k+=1


arr_test = [2, 3, 5, 1, 7, 4, 4, 4, 2, 6, 0]
mergesort(arr_test)
print(arr_test)

