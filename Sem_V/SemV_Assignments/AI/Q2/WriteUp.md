## Greedy Best First Search Setup

1. **Problem Representation**:
   - The problem is represented as an 8x8 grid where each cell is either an open space (represented by '.') or an obstacle (represented by '#').
   - The goal is to navigate from the start point (0, 0) to the destination point (7, 7) in minimum time while avoiding obstacles.

2. **State Representation**:
   - Each cell in the grid is considered a state. A state is represented by its (x, y) coordinates.

3. **Action Representation**:
   - Actions correspond to movements from one cell to adjacent cells (up, down, left, right).

4. **Transition Model**:
   - The transition from one state to another occurs by moving to an adjacent, unobstructed cell.

5. **Cost Function**:
   - The cost of each action (movement) is 1 unit of time.

6. **Heuristic Function (h)**:
   - The heuristic function is the Manhattan distance between the current cell and the goal cell. It estimates the remaining distance to the goal using only horizontal and vertical movements.

7. **Goal State**:
   - The goal state is reached when the drone reaches the destination point (7, 7).

## A* Search Setup

1. **Problem Representation**:
   - Similar to Greedy Best First Search, the problem is represented as an 8x8 grid with open spaces and obstacles.

2. **State Representation**:
   - Each cell in the grid is considered a state, represented by its (x, y) coordinates.

3. **Action Representation**:
   - Actions correspond to movements from one cell to adjacent cells (up, down, left, right).

4. **Transition Model**:
   - The transition from one state to another occurs by moving to an adjacent, unobstructed cell.

5. **Cost Function**:
   - The cost of each action (movement) is 1 unit of time.

6. **Heuristic Function (h)**:
   - The heuristic function for A* is the Manhattan distance between the current cell and the goal cell.

7. **Goal State**:
   - The goal state is reached when the drone reaches the destination point (7, 7).

In both approaches, the goal is to minimize the total time taken to reach the destination while considering the obstacles and grid boundaries. The heuristics guide the search algorithms towards the goal efficiently, making them suitable for finding the optimal path in the given problem.



