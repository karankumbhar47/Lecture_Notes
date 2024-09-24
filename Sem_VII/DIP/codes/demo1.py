import cv2
import matplotlib.pyplot as plt
import numpy

filename = "/home/karan/Pictures/S1.png"

img = cv2.imread(filename)

[m,n,c] = img.shape

img1 = cv2.cvtColor(img,cv2.COLOR_BGR2RGB);
b = img[:,:,0]
g = img[:,:,1]
r = img[:,:,2]
gray_img = numpy.uint8(numpy.zeros([m,n]))

for i in range(0,m):
    for j in range(0,n):
        gray_value = 0.114*b[i,j] + 0.587*g[i,j] + 0.299*r[i,j]
        gray_img[i,j] = gray_value

Neg_img = numpy.uint8(numpy.zeros([m,n]))

for i in range(m):
    for j in range(n):
        neg = 255 - gray_img[i,j]
        Neg_img[i,j] = neg

plt.figure(1)
plt.subplot(131)
plt.imshow(img)

plt.subplot(132)
img12= cv2.cvtColor(gray_img,cv2.COLOR_RGB2BGR)
plt.imshow(img12)

plt.subplot(133)
img123= cv2.cvtColor(Neg_img,cv2.COLOR_RGB2BGR)
plt.imshow(img123)

plt.show()
