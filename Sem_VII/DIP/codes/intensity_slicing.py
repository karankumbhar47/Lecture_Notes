import cv2
import matplotlib.pyplot as plt
import numpy as np

filename = "/home/karan/Documents/Lecture_Notes/Sem_VII/DIP/codes/images/p1.png"
img = cv2.imread(filename)
# plt.imshow(img)

img1 = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
# plt.imshow(img1)

[row,coloum] = img1.shape
img2 = np.zeros((row,coloum),dtype='')
img3 = np.zeros((row,coloum),dtype='uint8')

min_range = 150
max_rane = 255

for i in range(row):
    for j in range(coloum):
        if(img1[i,j]<thld):
            img1[i,j] = 0
        else:
            img1[i,j] = 255