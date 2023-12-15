import numpy as np
import matplotlib.pyplot as plt

# Define a range for X1 and X2
X1 = np.linspace(-3, 3, 400)
X2 = np.linspace(-1, 5, 400)
X1, X2 = np.meshgrid(X1, X2)

# Define the equation for the curve
curve = (1 + X1)**2 + (2 - X2)**2 - 4

# Create a contour plot for the curve
plt.figure(figsize=(6, 6))
contour = plt.contour(X1, X2, curve, levels=[0], colors='blue')
plt.xlabel('X1')
plt.ylabel('X2')
plt.title('Curve: (1 + X1)^2 + (2 - X2)^2 = 4')
plt.grid(False)

# Define the regions based on the inequalities
region1 = (1 + X1)**2 + (2 - X2)**2 > 4

circle = plt.Circle((-1, 2), 2, fill=False, color='red', linestyle='dashed', linewidth=2)
plt.gca().add_patch(circle)

# Shade the regions
plt.imshow(region1, extent=(-3, 3, -1, 5), origin='lower', cmap='Reds', alpha=0.5, aspect='auto', vmin=0, vmax=1)
plt.text(1, 4.3, '(1 + X1)^2 + (2 - X2)^2 > 4', fontsize=12, color='black', ha='center', va='center')
plt.imshow(~region1, extent=(-3, 3, -1, 5), origin='lower', cmap='Greens', alpha=0.5, aspect='auto', vmin=0, vmax=1)
plt.text(-1, 2.2, '(1 + X1)^2 + (2 - X2)^2 <= 4', fontsize=12, color='black', ha='center', va='center')
plt.show()


