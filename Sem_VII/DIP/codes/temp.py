import cv2
import numpy as np
from matplotlib import pyplot as plt

filename = "./images/p3.jpg"
image = cv2.imread(filename)
img1 = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)

bins = [0] * 256
for i in img1.flatten():
    bins[i] += 1

plt.subplot(3, 2, 1)
plt.hist(img1.flatten(), 256, (0, 256), color="r")

plt.subplot(3, 2, 2)
plt.imshow(img1, cmap="gray")

img2 = np.zeros(img1.shape)
m, n = img1.shape
sum = 0
cdf = [0.0] * 256

for i, val in enumerate(bins):
    sum += val
    cdf[i] = (sum / (m * n)) * 256

for i in range(m):
    for j in range(n):
        img2[i][j] = cdf[img1[i][j]]
img2 = np.uint8(img2)

plt.subplot(3, 2, 3)
plt.hist(img2.flatten(), 256, (0, 256), color="r")

plt.subplot(3, 2, 4)
plt.imshow(img2, cmap="gray")
plt.show()