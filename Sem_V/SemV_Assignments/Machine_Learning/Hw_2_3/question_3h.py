import matplotlib.pyplot as plt
import numpy as np
from scipy.spatial import distance

# Data
X1 = [3, 2, 4, 1, 2, 4, 4, 2]
X2 = [4, 2, 4, 4, 1, 3, 1, 3]
labels = ['Red', 'Red', 'Red', 'Red', 'Blue', 'Blue', 'Blue','Blue']

# Create a scatter plot
plt.figure(figsize=(6, 6))
plt.scatter(X1, X2, c=labels, cmap='viridis', s=10, marker='o')

# Label points with their coordinates
num = 0
for i, txt in enumerate(labels):
    num+=1
    plt.annotate(f'({X1[i]}, {X2[i]})', (X1[i], X2[i]), textcoords="offset points", xytext=(0, 10), ha='center')
    plt.annotate(f'P{num}', (X1[i], X2[i]), textcoords="offset points", xytext=(0, -11), ha='center')

# Define the coefficients of the hyperplane 
hyperplane_slope =  1
hyperplane_intercept = -0.5

# Generate x values
x_values = np.linspace(0, 5, 500)
y_values = hyperplane_slope * x_values + hyperplane_intercept

# Plot the hyperplane
plt.plot(x_values, y_values, linestyle='--', color='red', label='Hyperplane')


# Set axis labels and title
plt.xlabel('X1')
plt.ylabel('X2')
plt.title('Observations with Class Labels')
plt.legend() 

plt.ylim(0,5)
plt.grid(False)  
plt.show()