matrix = [[1, 2, 3, 4],
          [5, 6, 7, 8],
          [9, 10, 11, 12],
          [13, 14, 15, 16]]

top, bottom, left, right = 0, len(matrix)-1, 0, len(matrix[0])-1
while top <= bottom and left <= right:
    # top row
    for i in range(left, right+1):
        print(matrix[top][i])
    top = top +1
    
    # right col 
    for i in range(top, bottom+1):
        print(matrix[i][right])
    
    right = right -1
    
    # bottom row
    if top <= bottom:
        for i in range(right, left-1, -1):
            print(matrix[bottom][i])
        bottom = bottom -1
    
    # left col
    if left <= right:
        for i in range(bottom, top-1, -1):
            print(matrix[i][left])
        left = left + 1
