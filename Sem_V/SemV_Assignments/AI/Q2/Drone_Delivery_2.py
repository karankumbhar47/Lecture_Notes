
# Input 
matrix = []
for _ in range(8):
    row = list(input().split())
    matrix.append(row)

# Checking whether the cell is out of range or not.
def isValid(row, col):
    
    return ((row >= 0 and row < 8 ) and (col >= 0 and col < 8 ))

# Checking whether the cell is blocked or not.
def isUnBlocked(matrix, row, col):
    
    if matrix[row][col] != "#":
        return True
    return False

def isDestination(row, col):
    
    return (row ==7) and (col == 7)

# calculating the heuristic  value .
def calculateHValue(row, col):
    return abs((7-row)) +abs((7 - col))

def tracePath(cellDetails):
    
    row = 7
    col = 7
    path = []

    while (cellDetails[row][col][0] != 0 or cellDetails[row][col][1] != 0 ):
        path.append((row, col))
        row, col = cellDetails[row][col][0], cellDetails[row][col][1] 
    
    path.append((row,col))

    print(len(path))
    return

def aStarSearch(matrix):

    if isUnBlocked(matrix, 0, 0) == False:
        print("Source is blocked")
        return
        
    if isUnBlocked(matrix, 7, 7) == False:
        print("Destination is blocked")
        return 
    
    # Store the state of the cell as visited --> 1 and unvisited --> 0 
    closedList = [[0]*8 for _ in range(8)]
    
    # store the details of the cell like (parent_row, parent_col, fscore, gscore, hscore)
    cellDetails = [[[-1,-1,100, 100, 100]]*8 for _ in range(8)]

    openList = []
    # store the details like (fscore, row,columns) and it is the list which store this details of the cell which need to explore. 
    openList.append([0,0,0])

    foundDest = False  # found Destination boolean

    while (len(openList) != 0):
        
        p = openList[0]
        openList.pop(0)

        i = p[1]
        j = p[2]
        closedList[i][j] = 1 

        # Direction Up 

        if isValid(i-1, j):
            if isDestination(i-1, j):
                cellDetails[i-1][j][0] = i
                cellDetails[i-1][j][1] = j
                # if we reach the Destination it tracepath 
                tracePath(cellDetails)
                foundDest = True
                return
            
            elif closedList[i-1][j] == 0 and isUnBlocked(matrix, i-1, j) :
                gScore = cellDetails[i][j][3]+1
                hScore = calculateHValue(i-1, j)
                fScore = gScore + hScore

                if  cellDetails[i-1][j][2] == 100 or cellDetails[i-1][j][2] > fScore: 
                    openList.append([fScore, i-1, j])
                    cellDetails[i-1][j] = [i, j, fScore, gScore, hScore]

        # Direction Down 

        if isValid(i+1, j):
            if isDestination(i+1, j):
                cellDetails[i+1][j][0] = i
                cellDetails[i+1][j][1] = j

                tracePath(cellDetails)
                foundDest = True
                return
            
            elif closedList[i+1][j] == 0 and isUnBlocked(matrix, i-1, j) :
                gScore = cellDetails[i][j][3]+1
                hScore = calculateHValue(i+1, j)
                fScore = gScore + hScore

                if  cellDetails[i+1][j][2] == 100 or cellDetails[i+1][j][2] > fScore: 
                    openList.append([fScore, i+1, j])
                    cellDetails[i+1][j] = [i, j, fScore, gScore, hScore]

        # Direction Left


        if isValid(i, j-1):
            if isDestination(i,j-1):
                cellDetails[i][j-1][0] = i
                cellDetails[i][j-1][1] = j

                tracePath(cellDetails)
                foundDest = True
                return 

            elif closedList[i][j-1] == 0 and  isUnBlocked(matrix, i, j-1) :
                gScore = cellDetails[i][j][3]+1
                hScore = calculateHValue(i, j-1)
                fScore = gScore + hScore

                if cellDetails[i][j-1][2] == 100 or cellDetails[i][j-1][2] > fScore:
                    openList.append([fScore, i, j-1])
                    cellDetails[i][j-1] = [i, j, fScore, gScore, hScore]
         
        # Direction Right


        if isValid(i, j+1):
            if isDestination(i,j+1):
                cellDetails[i][j+1][0] = i
                cellDetails[i][j+1][1] = j

                tracePath(cellDetails)
                foundDest = True
                return 

            elif closedList[i][j+1] == 0 and  isUnBlocked(matrix, i, j-1) :
                gScore = cellDetails[i][j][3]+1
                hScore = calculateHValue(i, j+1)
                fScore = gScore + hScore

                if cellDetails[i][j+1][2] == 100 or cellDetails[i][j+1][2] > fScore:
                    openList.append([fScore, i, j+1])
                    cellDetails[i][j+1] = [i, j, fScore, gScore, hScore]


    if foundDest == False:
        print("We failed to reach to the Destinaion")
    


aStarSearch(matrix)
