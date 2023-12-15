## Problem Description

We have a grid-based maze representing different types of terrain (Grass, Dirt, Rocks), each with an associated traversal cost. The goal is to find the path from the starting point (S) to the destination point (F) that minimizes the total traversal cost while obeying the rules of movement (up, down, left, right) and avoiding walls or impassable terrain.

### State Representation

For both A* and Weighted A* algorithms, we represent the state as a combination of the current cell and the cumulative traversal cost to reach that cell. The state representation is:

- **State**: (current row, current column, cumulative traversal cost)

### Heuristic Function (h)

The heuristic function estimates the cost from the current cell to the goal cell. In this case, we use the Manhattan distance between the current cell and the goal cell as our heuristic. It's weighted by the terrain type because different terrains have different traversal costs. The heuristic function is defined as:

- **Heuristic Function (h)**: `h = abs(Dest_row - current_row) + abs(Dest_col - current_col)`

### Cost Function (g)

The cost function calculates the cumulative traversal cost from the start to the current cell. The cost is updated based on the terrain type. We define the cost function as:

- **Cost Function (g)**:
  - If the current cell is Grass (G): `g = previous_g + 1`
  - If the current cell is Dirt (D): `g = previous_g + 2`
  - If the current cell is Rocks (R): `g = previous_g + 5`

### A* Search Algorithm

The A* search algorithm explores cells based on their estimated total cost, which is the sum of the cumulative traversal cost (g) and the heuristic cost (h). It maintains an open list and a closed list to keep track of explored and unexplored cells. The algorithm iteratively selects cells with the lowest estimated total cost and expands them. The path is traced back from the destination cell to the start cell once the destination is reached.

### Weighted A* Search Algorithm

The Weighted A* search algorithm is a variation of A* where we introduce a weight factor for the heuristic function. This weight influences the algorithm's behavior. In this case, the weight factor is applied to the heuristic cost. The weighted A* algorithm is implemented similarly to A*, but the heuristic cost in the open list is multiplied by the weight factor. This can make the algorithm prioritize either the cost (low weight) or the heuristic (high weight) more when selecting cells to explore.
