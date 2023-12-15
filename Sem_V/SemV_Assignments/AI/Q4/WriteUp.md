# Robot-Navigation

## Question 1
**Assumptions**
- plane is infinite(containing infinte points) 

**Number of States:**
- The state space consists of all positions (x, y) in the plane.
- Since the plane is infinite, there are infinitely many possible positions.
- Therefore, the number of states is infinite.

**Number of Paths to the Goal:**
- Let's assume that the goal is to reach a specific point (x_goal, y_goal) in the plane.
- We need to consider the obstacles in the plane while calculating paths.
- There are two obstacles in the plane.
- To reach the goal, we can have multiple paths: one that avoids the first obstacle and one that avoids the second obstacle.
- For each of these paths, we can have infinitely many subpaths since the plane is infinite.
- Therefore, there are infinitely many paths to the goal.

## Question 2

- The most direct path between two points is typically a straight line. However, when obstacles or hindrances make a straight path impractical, the next best option is to navigate through a series of connected line segments. These segments are selected to deviate from a straight line as minimally as possible, aiming for the shortest alternative route.

- In practical terms, this means that when faced with barriers or challenging terrain, the objective is to discover a path that minimizes deviation from a straight line to the greatest extent possible. This strategy optimizes efficiency in travel and reduces the total distance traveled while efficiently maneuvering around obstacles.

<div style="display: flex; justify-content: center; align-items: center; flex-wrap: wrap;">
    <img src="./Q4_1.png" alt="Image 1" title="" width="45%" style="margin: 10px;" />
    <img src="./Q4_2.png" alt="Image 2" width="45%" style="margin: 10px;" />
    <img src="./Q4_3.png" alt="Image 3" width="45%" style="margin: 10px;" />
    <img src="./Q4_4.png" alt="Image 4" width="45%" style="margin: 10px;" />
</div>

The successor function is as follows:
<div align="center">
    <img src="./equation.png" alt="Equation" width="50%" />
</div 

## Question 4

- Hill-climbing serves as a simple optimization algorithm employed to reach a specific endpoint within a search space. It commences at an initial state and proceeds by transitioning to a neighboring state that minimizes a chosen heuristic function, with the goal of reaching the endpoint possessing the lowest heuristic value. However, it's important to note that hill-climbing does not guarantee finding the optimal path to the endpoint in all scenarios. Its efficacy is contingent on the shape of the search space and the accuracy of the heuristic function. In cases where the search space contains multiple local minima, the algorithm might become stuck in one of them, failing to reach the global optimum. Furthermore, an inadequately defined or inaccurate heuristic function can mislead the algorithm.

In summary, hill-climbing offers a straightforward approach to reaching an endpoint, but its success is not assured in non-convex search spaces where it may get trapped in local optima or when the heuristic function is unreliable.

The Python code I've utilized showcases a path planning algorithm utilizing a hill climbing approach. It commences with a specified starting and goal point, iteratively explores neighboring points by generating a set of points around the current position in a circular manner. The objective function being optimized is the Euclidean distance between the current position and the goal. What sets this problem apart is the existence of obstacles represented as triangles. The algorithm steers clear of points falling inside these obstacles. It assesses potential neighboring points, filters out those within obstacles, and selects the one with the lowest objective function value, effectively "climbing" towards the goal. The ultimate path is plotted, illustrating the trajectory from the start to the goal while circumventing obstacles. This code offers an illustrative demonstration of how a hill climbing algorithm can be tailored for path planning in environments replete with obstacles.


<p align="center">
  <img src="./Q4_final.png" width="700" />
</p>  

## Question 5

- In geometry and mathematics, a shape or region is considered non-convex if it does not possess the property of convexity. Convexity characterizes a set of points in Euclidean space where any line segment connecting two points within the set remains entirely within the set itself. Essentially, a shape is convex if, for any two points within the shape, all points along the straight line connecting them are also within the shape.

- Non-convex obstacles present a challenge for hill-climbing algorithms as they can trap the algorithm in local minima (in this context). This situation hampers the algorithm's ability to discover optimal paths. In scenarios involving non-convex obstacles, like narrow passages or grooves, the algorithm may initially progress well but can become stuck in these constrained regions. It often fails to recognize that better paths may exist beyond the immediate vicinity, resulting in suboptimal solutions. This limitation stems from hill climbing's reliance on local information, preventing it from considering paths beyond nearby obstacles. Consequently, non-convex obstacles pose significant challenges, showcasing how local minima can obstruct the algorithm from reaching global optima in path planning problems.

<p align="center">
  <img src="./Q4_img2.png" width="700" />
</p>  

- In this modified scenario, minor adjustments have been made to introduce a non-convex obstacle. When the agent encounters this obstacle, it finds itself restricted to exploring a semicircular neighborhood. This limitation arises because the other half of the neighborhood is within the obstacle, making it inaccessible.

- In this constrained position, the agent faces a dilemma. Any movement it makes results in an increase in the Euclidean distance to the goal, contradicting its objective of moving closer to the goal. Consequently, the agent becomes immobilized and unable to progress further.

- The resolution to this challenge lies in adopting a different optimization approach, such as simulated annealing. Simulated annealing allows for more flexible exploration by occasionally accepting moves that increase the objective function (distance to the goal) to escape local minima, like the one encountered here. This flexibility enables the agent to navigate effectively through complex environments with non-convex obstacles, providing a promising solution to this problem.
