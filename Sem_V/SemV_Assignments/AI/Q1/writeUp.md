# CONVERSION ORDER Problem - Search Setup

In this document, we describe how to convert the "CONVERSION ORDER" problem into a search setup using the provided algorithms: Breadth-First Search (BFS) and Iterative Deepening Depth-First Search (ID-DFS).

## Problem Representation

### State Representation
- A state is represented by a word.
- All words have the same length as the start and target words.

### Initial State
- The initial state is the start word provided in the input.

### Goal State
- The goal state is the target word provided in the input.

### Actions
- Actions represent changing one word to another word from the dictionary.
- Actions must result in words differing by exactly one character.

### Transition Model
- Given a word, you can transition to another word from the dictionary if they are adjacent (differ by exactly one character).

## Breadth-First Search (BFS)

- BFS starts from the initial state (start word) and explores all possible transitions (actions) to reach the goal state (target word).
- It maintains a queue to store the states (words) to be explored in a breadth-first manner.
- The algorithm continues until it finds the target word or exhausts all possible transitions.
- The sequence of transitions from the start word to the target word is tracked using a parent dictionary.

## Iterative Deepening Depth-First Search (ID-DFS)

- ID-DFS is a depth-first search algorithm with a depth limit.
- It starts with a depth limit of 0 and gradually increases the depth limit until the goal state is found.
- At each depth limit, it performs a depth-first search, exploring all possible paths up to that depth.
- If it reaches the depth limit without finding the goal state, it increases the depth limit and continues the search.
- This process repeats until the goal state is found or the depth limit exceeds the length of the dictionary.
