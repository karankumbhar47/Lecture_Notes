import sys

# Input
n, m = map(int, input().split())  # n --> row, m --> column
weightGrass = 1
weightDirt = 2
weightRock = 5

grid = []  # grid is a list of lists containing information about terrain
for i in range(n):
    row = list(input().split())
    for j in range(m):
        if row[j] == "F":
            Dest = [i, j]
        elif row[j] == "S":
            Src = [i, j]
    grid.append(row)


def isValid(row, col):
    return 0 <= row < n and 0 <= col < m


def isDestination(row, col, Dest):
    return row == Dest[0] and col == Dest[1]


def calculateHValue(row, col, Dest):
    return abs(Dest[0] - row) + abs(Dest[1] - col)


def calculateFValue(matrix, row, col, gScore, hScore, weightGrass, weightDirt, weightRock):
    terrain = matrix[row][col]
    if terrain == "G":
        return (gScore + hScore * weightGrass)
    elif terrain == "D":
        return (gScore + hScore * weightDirt)
    elif terrain == "R":
        return (gScore + hScore * weightRock)
    else:
        return sys.maxsize


def tracePath(cellDetails, Src, Dest):
    row, col = Dest
    path = []

    while (cellDetails[row][col][0] != Src[0] or cellDetails[row][col][1] != Src[1]):
        path.append((row, col))
        row, col = cellDetails[row][col][0], cellDetails[row][col][1]

    path.append((row, col))
    print("The length of path is",len(path))
    while (len(path) != 0):
        print(path.pop(), end=" ")

    print()
    return


def aStarSearch(matrix, Src, Dest, n, m, weightGrass, weightDirt, weightRock):
    closedList = [[0] * m for _ in range(n)]
    cellDetails = [[[None, None, sys.maxsize, sys.maxsize, sys.maxsize] for _ in range(m)] for _ in range(n)]

    i, j = Src
    cellDetails[i][j][2] = 0
    cellDetails[i][j][3] = 0
    cellDetails[i][j][4] = 0
    cellDetails[i][j][0] = i
    cellDetails[i][j][1] = j

    openList = []

    openList.append([0, i, j])

    foundDest = False

    while (len(openList) != 0):
        openList.sort()  # Sort the openList based on fScore
        p = openList[0]
        openList.pop(0)

        i, j = p[1], p[2]
        closedList[i][j] = 1

        # Directions: Up, Down, Left, Right
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for dr, dc in directions:
            if isValid(i + dr, j + dc):
                if isDestination(i + dr, j + dc, Dest):
                    cellDetails[i + dr][j + dc][0] = i
                    cellDetails[i + dr][j + dc][1] = j

                    tracePath(cellDetails, Src, Dest)
                    foundDest = True
                    return

                elif closedList[i + dr][j + dc] == 0:
                    gScore = cellDetails[i][j][3] + (weightGrass if matrix[i + dr][j + dc] == "G" else
                                                     (weightDirt if matrix[i + dr][j + dc] == "D" else weightRock))
                    hScore = calculateHValue(i + dr, j + dc, Dest)
                    fScore = gScore + hScore

                    if cellDetails[i + dr][j + dc][2] == sys.maxsize or cellDetails[i + dr][j + dc][2] > fScore:
                        openList.append([fScore, i + dr, j + dc])
                        cellDetails[i + dr][j + dc] = [i, j, fScore, gScore, hScore]

    if not foundDest:
        print("Failed to reach the Destination")


aStarSearch(grid, Src, Dest, n, m, weightGrass, weightDirt, weightRock)

