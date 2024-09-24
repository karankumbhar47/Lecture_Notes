import cv2
from matplotlib import pyplot as plt

filename = "./images/p5.jpg"
img = cv2.imread(filename)

averaing = cv2.blur(img,(3,3))
median = cv2.medianBlur(img,3)

plt.subplot(1,3,1),plt.imshow(img)
plt.subplot(1,3,2),plt.imshow(averaing)
plt.subplot(1,3,3),plt.imshow(median)
plt.show()