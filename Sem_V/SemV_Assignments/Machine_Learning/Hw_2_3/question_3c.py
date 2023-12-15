import matplotlib.pyplot as plt
import numpy as np
from scipy.spatial import distance

# Data
X1 = [3, 2, 4, 1, 2, 4, 4]
X2 = [4, 2, 4, 4, 1, 3, 1]
labels = ['Red', 'Red', 'Red', 'Red', 'Blue', 'Blue', 'Blue']

# Create a scatter plot
plt.figure(figsize=(6, 6))
plt.scatter(X1, X2, c=labels, cmap='viridis', s=10, marker='o')

# Label points with their coordinates
num = 0
for i, txt in enumerate(labels):
    num+=1
    plt.annotate(f'({X1[i]}, {X2[i]})', (X1[i], X2[i]), textcoords="offset points", xytext=(0, 10), ha='center')
    plt.annotate(f'P{num}', (X1[i], X2[i]), textcoords="offset points", xytext=(0, -11), ha='center')

# Define the slope and intercept
slope = 1 
intercept = -0.5  

# Generate x values
x_values = np.linspace(1, 6, 500)
y_values = slope * x_values + intercept

# Plot the line
plt.plot(x_values, y_values, linestyle='--', color='green', label='Seperating Plane')

x_values_lines = np.linspace(1, 6, 500)
y_values_P2_P3 = x_values_lines 
y_values_P5_P6 = x_values_lines - 1 

#plotting margin
plt.plot((3,3.5),(3,2.5), linestyle='solid', color='black', label='margin')

print(x_values[:10])
print(y_values_P2_P3[:10])
print(y_values_P5_P6[:10])

# Plot lines from P6 to P4 and P2 to P4
plt.plot(x_values_lines, y_values_P2_P3, linestyle='-', color='red', label='Support Vector')
plt.plot(x_values_lines, y_values_P5_P6, linestyle='-', color='blue', label='Support Vector')

# Set axis labels and title
plt.xlabel('X1')
plt.ylabel('X2')
plt.title('Observations with Class Labels')
plt.legend() 

plt.grid(False)  
plt.show()