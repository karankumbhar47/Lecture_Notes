import numpy as np
import matplotlib.pyplot as plt

# Utility function to apply
# intensity
def applyIntesity1(minRange: int, maxRange: int):
    # Image to store output after applying intensity
    newImage = np.zeros((l, w), dtype='uint8')

    # applying intensity
    for i in range(l):
        for j in range(w):
            if minRange < originalImg[i, j] and originalImg[i, j] < maxRange:
                newImage[i, j] = 255
            else:
                newImage[i, j] = 0

    return newImage

def applyIntesity2(minRange1: int, maxRange1: int, 
                  minRange2: int, maxRange2: int):
    # Image to store output after applying intensity
    newImage = np.zeros((l, w), dtype='uint8')

    # applying intensity
    for i in range(l):
        for j in range(w):
            if minRange1 < originalImg[i, j] and originalImg[i, j] < maxRange1:
                newImage[i, j] = 255
            elif minRange2 < originalImg[i, j] and originalImg[i, j] < maxRange2:
                newImage[i,j] = 255
            else:
                newImage[i, j] = 0

    return newImage


# relative path of image
# put p1.jpg in images folder in
# current directory
# TODO: Replace file path with
#       the actual image path
filepath = './images/p6.jpg'

# laoding image in originalImg
# variable
originalImg = plt.imread(filepath)

# taking first three channels of image
if len(originalImg.shape) == 3:
    originalImg = originalImg[:, :, 0]


# observing shape of image
[l, w] = originalImg.shape
print("Shape of Image : ", originalImg.shape)



# Intensity level slicing
# for single interval range
# with following parameters
minRange = 150
maxRange = 200

# slicing image whith above params
sliceImage = applyIntesity1(minRange, maxRange)

# Applying Intensity level slicing
# for mulitple range as follows
minRange1 = 150
maxRange1 = 200

minRange2 = 80 
maxRange2 = 100
# mulitple slicing image whith above params
mulitiSlicingImage = applyIntesity2(minRange1,maxRange2,minRange2,maxRange2)


plt.figure(figsize=(20, 10))

# Original image
plt.subplot(1, 3, 1)
plt.imshow(originalImg, cmap='gray')
plt.title('Original Image')

# plotting first image
plt.subplot(1, 3, 2)
plt.imshow(sliceImage, cmap='gray')
plt.title(f'Intensity Level Slicing ({minRange},{maxRange})')

# plotting second image 
plt.subplot(1, 3, 3)
plt.imshow(mulitiSlicingImage, cmap='gray')
plt.title(f'Intensity Level Slicing ({minRange1},{maxRange1}), ({minRange2},{maxRange2})')

# display the plot
plt.show()
