import cv2
import numpy as np
from matplotlib import pylab as plt

filename = './images/p3.jpg'
img = cv2.imread(filename)
img1 = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# hist_bins = np.histogram(img1.flatten(),256,[0,256])
# plt.hist(img1.flatten(),256,[0,256],color='r')

# plt.figure(2)
# plt.imshow(img)
# plt.show()

# equlization
equal = cv2.equalizeHist(img1)
hist1,bins1 = np.histogram(equal.flatten(),256,[0,256])

plt.figure(1)
plt.subplot(231)
plt.imshow(img)
plt.subplot(222)
plt.imshow(equal)
plt.subplot(224)
plt.hist(equal.flatten(),256,[0,256],color='r')
plt.subplot(223)
hist_bins = np.histogram(img1.flatten(),256,[0,256])
plt.hist(img1.flatten(),256,[0,256],color='r')
plt.show()

# create histogram equalization function 
#  deadline