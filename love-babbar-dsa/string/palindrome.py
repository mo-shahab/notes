str = input()

list_str = [d for d in str]
print(list_str)

rev_str = list(reversed(str))
print(rev_str)
if(str == rev_str):
    print("the strings are palindrom")
else:
    print("the strings are not palindrome")
