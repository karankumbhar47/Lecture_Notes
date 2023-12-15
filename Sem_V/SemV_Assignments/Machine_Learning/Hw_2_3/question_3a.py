import matplotlib.pyplot as plt

# Data
X1 = [3, 2, 4, 1, 2, 4, 4]
X2 = [4, 2, 4, 4, 1, 3, 1]
labels = ['Red', 'Red', 'Red', 'Red', 'Blue', 'Blue', 'Blue']

# Creating a scatter plot
plt.scatter(X1, X2, c=labels, cmap='viridis', s=10, marker='o')

# Label points with their coordinates
num = 0
for i, txt in enumerate(labels):
    num+=1
    if(X2[i]<3.5):
        plt.annotate(f'({X1[i]}, {X2[i]})', (X1[i], X2[i]), textcoords="offset points", xytext=(0, 10), ha='center')
        plt.annotate(f'P{num}', (X1[i], X2[i]), textcoords="offset points", xytext=(0, -11), ha='center')
    else:
        plt.annotate(f'({X1[i]}, {X2[i]})', (X1[i], X2[i]), textcoords="offset points", xytext=(0, -15), ha='center')
        plt.annotate(f'P{num}', (X1[i], X2[i]), textcoords="offset points", xytext=(5, 4), ha='center')

# Set axis labels and title
plt.xlabel('X1')
plt.ylabel('X2')
plt.title('Observations with Class Labels')

# Display the plot
plt.grid(False) 
plt.show()