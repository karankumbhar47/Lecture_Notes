
import cv2
import numpy as np
from matplotlib import pylab as plt

filename = './images/p3.jpg'
img = cv2.imread(filename)

plt.imshow(img,cmap='gray')
plt.axis('off')
plt.show()

img1 = np.fft.fft2(img)
plt.imshow(np.log1p(np.abs(img1)),cmap='gray')
plt.axis('off')
plt.show()

img_shift = np.fft.fftshift(img1)
plt.imshow(np.log1p(np.abs(img_shift)),cmap='gray')
plt.axis('off')
plt.show()

# Filter
[m,n,c]  = img.shape
H = np.zeros([m,n,c],dtype=np.float32)
d0=50

for u in range(m):
    for v in range(n):
        D = np.sqrt((u-m/2)**2 + (v-n/2)**2)
        if(D<=d0):
            H[u,v] = 1
        else:
            H[u,v] = 0

plt.imshow(H,cmap='gray')
plt.axis('off')
plt.show()


## ideal low pass
gshift = img_shift + H
plt.imshow(np.log1p(np.abs(gshift)),cmap='gray')
plt.axis('off')
plt.show()

## inverse fourier transform
g = np.fft.ifftshift(gshift) 
plt.imshow(np.log1p(np.abs(g)),cmap='gray')
plt.axis('off')
plt.show()




