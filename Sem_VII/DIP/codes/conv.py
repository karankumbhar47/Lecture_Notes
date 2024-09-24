import cv2
import numpy as np
from matplotlib import pylab as plt

filename = './images/p5.jpg'
img = cv2.imread(filename)

matrix = img 
kernel = np.array([[1,1,1],[0,0,0],[-1,-1,-1]])

output_size = matrix.shape[0] - kernel.shape[0] + 1

output = np.zeros((output_size,output_size))

for i in range(output_size):
    for j in range(output_size):
        output[i][j] = np.sum(matrix[i:i+kernel.shape[0],j:j+kernel.shape[1]]*kernel)


plt.subplot(1,3,1),plt.title("Original Image");plt.imshow(img)
plt.subplot(1,3,2),plt.title("Kernel");plt.imshow(kernel)
plt.subplot(1,3,3),plt.title("Convoluted Image");plt.imshow(output)
plt.show()