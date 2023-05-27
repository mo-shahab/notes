# if the built in methods can be used
def maxmin(array):
    array.sort()
    print("max: " + str(array[-1]) + " min: " + str(array[0]))

# if built in methods cannot be used, use the linear search method
def linmaxmin(array):
    max = array[0]
    min = array[0]
    for i in range(len(array)):
        if(array[i] > max):
            max = array[i]

        elif(array[i] < min):
            min = array[i]

    return (max, min)

array = [3, 6, 2, 234, 62, 1, 0]
maxmin(array) 
max, min = linmaxmin(array)
print(max, min)