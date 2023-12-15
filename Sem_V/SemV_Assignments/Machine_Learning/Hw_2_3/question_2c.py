import matplotlib.pyplot as plt
import numpy as np

# Define a range for X1 and X2
X1 = np.linspace(-3, 4, 400)
X2 = np.linspace(-1, 10, 400)  # Adjusted the upper limit for better visibility

# Create a grid of X1 and X2 values
X1, X2 = np.meshgrid(X1, X2)

# Define the equation for the curve
curve = (1 + X1)**2 + (2 - X2)**2 - 4

# Create a contour plot for the curve
plt.figure(figsize=(7, 13))
contour = plt.contour(X1, X2, curve, levels=[0], colors='blue')
plt.xlabel('X1')
plt.ylabel('X2')
plt.title('Curve: (1 + X1)^2 + (2 - X2)^2 = 4')
plt.grid(False)

# Define the regions based on the inequalities
region1 = (1 + X1)**2 + (2 - X2)**2 > 4

# Create circular boundaries with a margin around the curve
circle = plt.Circle((-1, 2), 2, fill=False, color='red', linestyle='dashed', linewidth=2)
plt.gca().add_patch(circle)

# Shade the regions and add labels
plt.imshow(region1, extent=(-3, 4, -1, 10), origin='lower', cmap='Reds', alpha=0.5, aspect='auto', vmin=0, vmax=1)
plt.text(0.5, 6, 'Region 1', fontsize=12, color='black', ha='center', va='center')
plt.imshow(~region1, extent=(-3, 4, -1, 10), origin='lower', cmap='Greens', alpha=0.5, aspect='auto', vmin=0, vmax=1)
plt.text(-1, 2.2, 'Region 2', fontsize=12, color='black', ha='center', va='center')

# Define the points for classification
points = [(0, 0), (-1, 1), (2, 2), (3, 8)]

# Classify and plot the points
for point in points:
    x1, x2 = point
    if (1 + x1)**2 + (2 - x2)**2 > 4:
        label = f'Blue Class[{x1},{x2}]'
        plt.scatter(x1, x2, color='blue', label=label)
    else:
        label = f'Red Class[{x1},{x2}]'
        plt.scatter(x1, x2, color='red', label=label)
    plt.annotate(f'({x1}, {x2})', (x1, x2), textcoords="offset points", xytext=(0, 10), ha='center')

# Show the plot
plt.xlim(-3, 4)  
plt.ylim(-1, 10)
plt.legend()
plt.show()