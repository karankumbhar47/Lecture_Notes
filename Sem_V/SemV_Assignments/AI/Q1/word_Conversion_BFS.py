from collections import deque

# Function to check if two words differ by exactly one character
def is_adjacent(word1, word2):
    diff_count = sum(c1 != c2 for c1, c2 in zip(word1, word2))
    return diff_count == 1

# Breadth-First Search
def find_smallest_order(start, target, dictionary):
    queue = deque()
    visited = set()
    parent = {}
    
    queue.append(start)
    visited.add(start)
    
    while queue:
        current_word = queue.popleft()
        
        for word in dictionary:
            if is_adjacent(current_word, word) and word not in visited:
                queue.append(word)
                visited.add(word)
                parent[word] = current_word
                
                if word == target:
                    sequence = []
                    while word != start:
                        sequence.append(word)
                        word = parent[word]
                    sequence.append(start)
                    sequence.reverse()
                    return sequence
    
    return None

# Input
K = int(input())
start, target = input().split()
dictionary = [input() for _ in range(K)]

# Finding the smallest order of words
sequence = find_smallest_order(start, target, dictionary)

# Output
if sequence:
    print(*sequence)
else:
    print("No transformation sequence found.")
