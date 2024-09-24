import cv2
import numpy as np
from matplotlib import pyplot as plt

file_name = "./images/p5.jpg"
img = cv2.imread(file_name)

kernel_sharpening = np.array([
[-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1],
[-1,-1,25,-1,-1],
[-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1],
])

sharpened_image = cv2.filter2D(img,-1,kernel_sharpening)
plt.subplot(1,2,1)
plt.imshow(img)
plt.subplot(1,2,2)
plt.imshow(sharpened_image)
plt.show()