import cv2
import math
import numpy as np
from matplotlib import pyplot as plt

file_name = "./images/p3.jpg"
img = cv2.imread(file_name)
[m, n, c] = img.shape

img1 = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
edge = np.uint8(np.zeros([m, n]))

sobel_x = [[-1, 0, 1],
           [-2, 0, 2],
           [-1, 0, 1]]

sobel_y = [[-1, -2, -1],
           [0, 0, 0],
           [1, 2, 1]]

for x in range(1, m):
    for y in range(1, n):
        pixel_x = (sobel_x[0][0] * img.at(x-1, y-1)) + (sobel_x[0][1] * img.at(x, y-1)) + (sobel_x[0][2] * img.at(x+1, y-1)) + (sobel_x[1][0] * img.at(x-1, y)) + (sobel_x[1][1] * img.at(x, y)) + (sobel_x[1][2] * img.at(x+1, y)) + (sobel_x[2][0] * img.at(x-1, y+1)) + (sobel_x[2][1] * img.at(x, y+1)) + (sobel_x[2][2] * img.at(x+1, y+1))
        pixel_y = (sobel_y[0][0] * img.at(x-1, y-1)) + (sobel_y[0][1] * img.at(x, y-1)) + (sobel_y[0][2] * img.at(x+1, y-1)) + (sobel_y[1][0] * img.at(x-1, y)) + (sobel_y[1][1] * img.at(x, y)) + (sobel_y[1][2] * img.at(x+1, y)) + (sobel_y[2][0] * img.at(x-1, y+1)) + (sobel_y[2][1] * img.at(x, y+1)) + (sobel_y[2][2] * img.at(x+1, y+1))

        val = math.ceil(math.sqrt((pixel_x * pixel_x) + (pixel_y * pixel_y)))
        edge[x, y] = val

plt.imshow(edge)
plt.show()