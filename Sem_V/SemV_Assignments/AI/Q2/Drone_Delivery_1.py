import heapq

# Constants for directions: up, down, left, right
DIRECTIONS = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# Ensuring drone doesn't go out of bounds
def is_valid_move(x, y):
    return 0 <= x < 8 and 0 <= y < 8


def greedy_best_first_search(grid):
    # Stating Start and Goal co-ordinates
    start = (0, 0)
    goal = (1, 3)

    if grid[start[0]][start[1]]=="#":
        print("Source is Blocked.")
        return
    
    if not is_valid_move(start[0],start[1]) or not is_valid_move(goal[0],goal[1]):
        print("Co-ordinates are out of bounds.")
        return

    priority_queue = []  # (heuristic, (x, y), time)
    heapq.heappush(priority_queue, (0, start, 0))
    
    # To keep track of visited cells and avoid to revisit them
    visited = set()


    while priority_queue:
        _, current, time = heapq.heappop(priority_queue)
        x, y = current
        
        # When reached the goal co-ordinates
        if current == goal:
            print(f"Minimum travel time to reach the {goal}:",time)
            return

        visited.add(current)
                             
        for dx, dy in DIRECTIONS:
            new_x, new_y = x + dx, y + dy

            if is_valid_move(new_x, new_y) and grid[new_x][new_y] == '.' and (new_x, new_y) not in visited:
                # Manhattan Distance
                heuristic = abs(new_x - goal[0]) + abs(new_y - goal[1])
                heapq.heappush(priority_queue, (heuristic, (new_x, new_y), time + 1))
         
    print("Destination is unreachable")

# Input grid representing the city
grid = []
for _ in range(8):
    row = list(input().split())
    grid.append(row)

greedy_best_first_search(grid)

# . . . . . . # .
# . . # # # . # .
# . . # . # . # .
# . . # # # . # .
# . . # . # . # .
# . . # . # . # .
# . . . . . . # .
# . . . . . . . .