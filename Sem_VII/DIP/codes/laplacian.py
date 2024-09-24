import cv2
import math
import numpy as np
from matplotlib import pyplot as plt

file_name = "./images/p3.jpg"
img = cv2.imread(file_name,0)

laplacian = cv2.Laplacian(img,cv2.CV_64F)

sharp_img = img+laplacian

sobelx =cv2.Sobel(img,cv2.CV_64F,1,0,ksize=5)
sobely =cv2.Sobel(img,cv2.CV_64F,0,1,ksize=5)
combined = cv2.addWeighted(sobelx,0.5,sobely,0.5,0)

average = cv2.blur(combined,(5,5))
result_img = cv2.multiply(sharp_img,average)

g_img = img+result_img

plt.subplot(3,2,1)
plt.imshow(img)
plt.title('Original')

plt.subplot(3,2,2)
plt.imshow(combined)
plt.title("Sobel gradient image")

plt.subplot(3,2,3)
plt.imshow(g_img)
plt.title("sharp img")

plt.subplot(3,2,4)
plt.imshow(average)
plt.title("average")
plt.show()