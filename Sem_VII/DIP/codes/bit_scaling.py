import numpy
import matplotlib.pyplot as plt

# utility function
# Function for extrating single
# bit plane from image
def utility_bit_plane(img, bit):
    bitPlane = numpy.uint8((img >> bit) & 1)
    bitPlane *= 255
    return bitPlane

# relative path of image
# put p1.jpg in images folder in 
# current directory
# TODO: Replace file path with 
#       the actual image path
filepath = './images/p1.jpg'

# laoding image in originalImg 
# variable
originalImg = plt.imread(filepath)

# taking first three channels of image
if len(originalImg.shape) == 3:
    originalImg = originalImg[:, :, 0]

# observing shape of image
[l, w] = originalImg.shape
print("Shape of Image : ", originalImg.shape)


# Getting bit planes list 
# using utility function
# to extract bit planes
bitPlanes = []
for i in range(8):
    plane = utility_bit_plane(originalImg, i)
    bitPlanes.append(plane)

# plotting all bit planes
# alogn with the original 
# image
plt.figure(figsize=(16, 12))

# plotting original image 
# using subplot
plt.subplot(3, 3, 1)
plt.imshow(originalImg, cmap='gray')
plt.title('Original Image')

# plotting all bit planes using 
# for loop on bit planes list
for k in range(8):
    plt.subplot(3, 3, k + 2)
    plt.imshow(bitPlanes[k], cmap='gray')
    plt.title(f'Bit Plane {k}')

# displaying all plots
plt.show()