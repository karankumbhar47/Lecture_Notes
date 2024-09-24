import cv2
import numpy as np
from matplotlib import pyplot as plt

file_name = "./images/p5.jpg"
img = cv2.imread(file_name)

Gaussian = cv2.GaussianBlur(img, (5, 3), 3)
# plt.imshow(Gaussian)

im2 = cv2.addWeighted(img, 1, Gaussian, 1, 0)

K = 1
im3 = img + K*im2

K1 = 5
img4 = img + K1*im2

plt.figure(1)
plt.subplot(1, 2, 1)
plt.imshow(img)

plt.subplot(1, 2, 2)
plt.imshow(Gaussian)

plt.show()
