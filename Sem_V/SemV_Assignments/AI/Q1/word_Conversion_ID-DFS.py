# Function to check if two words differ by exactly one character
def is_adjacent(word1, word2):
    diff_count = sum(c1 != c2 for c1, c2 in zip(word1, word2))
    return diff_count == 1

# Recursive Depth-First Search with depth limit
def dfs(node, target, dictionary, depth, max_depth, visited, path):
    if node == target:
        path.append(node)
        return path

    if depth == max_depth:
        return None

    visited.add(node)
    path.append(node)

    for word in dictionary:
        if is_adjacent(node, word) and word not in visited:
            result = dfs(word, target, dictionary, depth + 1, max_depth, visited, path)
            if result:
                return result

    path.pop()
    visited.remove(node)
    return None

# Iterative Deepening Depth-First Search
def iddfs(start, target, dictionary):
    max_depth = 0
    while max_depth <=len(dictionary):
        visited = set()
        path = []
        result = dfs(start, target, dictionary, 0, max_depth, visited, path)
        if result:
            return result
        max_depth += 1
    return None

# Input
K = int(input())
start, target = input().split()
dictionary = [input() for _ in range(K)]

# Find the smallest order of words using IDDFS
sequence = iddfs(start, target, dictionary)


# Output
if sequence:
    print(*sequence)
else:
    print("No transformation sequence found.")
