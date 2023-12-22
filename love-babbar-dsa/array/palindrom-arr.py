arr = list(map(int, input().split()))
print(arr)

# arr = sorted(arr)
def palindrome_(arr):
    for i in arr:
        tmp = [int(d) for d in str(i)]
        print(tmp)
        rev_tmp = list(reversed(tmp))
        print(rev_tmp)
        if tmp == rev_tmp:
            print(tmp)
        else:
            return 0
    
    return 1


palindrome_(arr)
if palindrome_(arr):
    print("all the digits in it are palindrom")
else:
    print("there was some number that arent palindrome")
