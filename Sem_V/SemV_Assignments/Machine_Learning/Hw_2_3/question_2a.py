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
plt.grid(True)
plt.show()

