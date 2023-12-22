# n = int(input())

#arr = list(map(int, input().split()))

arr = [3,0,0,2,0,4]

arr = sorted(arr, reverse=True)

sec_max = 0

for i in range(len(arr)):
    if arr[i] == arr[i+1]:
        continue
    else:
        sec_max = arr[i+1]
        break
    if i == len(arr):
        print("no water can be filled")

temp = []
for i in arr:
    if ( sec_max - i > 0):
        temp.append(sec_max - i)

print(temp)

print(sum(temp))
