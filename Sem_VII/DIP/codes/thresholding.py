import matplotlib
import numpy as np
import matplotlib.pyplot as plt

matplotlib.rcParams['font.size'] = 9

image = data.camera()

thresholds = thresholds_multiostsu(image)

regions = np.digitize(image,bins=thresholds)

fig,ax = plt.subplots(nrows=1,ncols=3,figsize=(10,3.5))

ax[0].imshow(image,cmap='gray')
ax[0].set_title('Original')
ax[0].axis('off')

ax[1].hist(image.ravel(),bins=255)
ax[1].set_title('Histogram')
for thresh in thresholds:
    ax[1].axvline(thresh,color='r')


ax[1].imshow(regions,cmap='jet')
ax[1].set_title('Multi-Otsu result')
ax[1].axis('off')
plt.subplots_adjust()
plt.show()