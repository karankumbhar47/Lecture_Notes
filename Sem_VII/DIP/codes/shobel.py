import cv2
import numpy as np
from matplotlib import pyplot as plt

file_name = "./images/p3.jpg"
img = cv2.imread(file_name)

sobelx =cv2.Sobel(img,cv2.CV_64F,1,0,ksize=5)
sobely =cv2.Sobel(img,cv2.CV_64F,0,1,ksize=5)
combined = cv2.addWeighted(sobelx,0.5,sobely,0.5,0)


plt.subplot(2,2,1)
plt.imshow(img)
plt.title('Original')

plt.subplot(2,2,2)
plt.imshow(combined)
plt.title("Sobel gradient image")

plt.show()
