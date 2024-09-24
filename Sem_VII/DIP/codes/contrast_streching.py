import cv2
import matplotlib.pyplot as plt
import numpy as np

filename = "/home/karan/Documents/Lecture_Notes/Sem_VII/DIP/codes/images/p1.png"
# filename = "./images/p1.png"
img = cv2.imread(filename)
# plt.imshow(img)
img1 = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

plt.imshow(img1)
[l,w] = img1.shape

x1 = 50
x2 = 200
y1 = 50
y2 = 120

slope1 = y1/x1
slope2 = (y2-y1)/(x2-x1)
slope3 = (255-y2)/(255-x2)

inter1 = y1 - slope1*x1
inter2 = y2 - slope2*x2

cnt_img = np.uint8(np.zeros([l,w]))

for i in range(0,l):
    for j in range(0,w):
        if(0<img1[i,j] & img1[i,j]<x1):
            cnt_img[i,j] = slope1*img1[i,j]
        elif x1<img1[i,j] & img1[i,j]<x2:
            cnt_img[i,j] = slope2*img1[i,j] + inter1
        elif x2<img1[i,j] & img1[i,j]<255:
            cnt_img[i,j] = slope3*img1[i,j]+inter2


## thresholding opration
thrld_img = (np.zeros([l,w]))
total = 0
thld = 0

for i in range(0,l):
    for j in range(0,w):
        total = total + img1[i,j]

thld = total/(l*w)
print(thld)

for i in range(l):
    for j in range(w):
        if(img1[i,j]<thld):
            thrld_img[i,j] = 0
        else:
            thrld_img[i,j] = 255


plt.figure(1)
plt.imshow(img)
plt.figure(2)
plt.imshow(cnt_img)
plt.figure(3)
plt.imshow(thrld_img)
plt.show()
