import matplotlib.pyplot as plt
from collections import Counter

# Sample string
text = "hello world"
alpha_small    = "abcdefghijklmnopqrstuvwxyz"

# Count the frequency of each letter
letter_counts = Counter(text.replace(" ", "").lower())

# Separate the letters and their corresponding frequencies
letters = list(letter_counts.keys())
frequencies = list(letter_counts.values())

print(letters)
print(frequencies)

newFreq = []
newLetters = []
for i in alpha_small:
    newLetters.append(i)
    if i in letters:
        newFreq.append(frequencies[letters.index(i)]) 
    else:
        newFreq.append(0)


# Plotting the histogram
plt.figure(figsize=(10, 6))
plt.bar(newLetters, newFreq, color='skyblue')
plt.grid(True)
plt.xlabel('Letters')
plt.ylabel('Frequency')
plt.title('Letter Frequency Histogram')
plt.show()