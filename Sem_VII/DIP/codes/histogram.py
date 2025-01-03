import cv2
import numpy as np
from matplotlib import pyplot as plt

# Load the image
filename = "./images/p3.jpg"
original_image = cv2.imread(filename)

# Convert the image to grayscale
gray_image = cv2.cvtColor(original_image, cv2.COLOR_BGR2GRAY)

# Calculate the histogram of the grayscale image
histogram_bins = [0] * 256
for pixel_value in gray_image.flatten():
    histogram_bins[pixel_value] += 1

# Plot the original image histogram
plt.subplot(2, 2, 1)
plt.hist(gray_image.flatten(), 256, (0, 256), color="r")
plt.title("Original Histogram")

# Plot the grayscale image
plt.subplot(2, 2, 2)
plt.imshow(gray_image, cmap="gray")
plt.title("Grayscale Image")

# Perform histogram equalization
equalized_image = np.zeros(gray_image.shape)
rows, cols = gray_image.shape
cumulative_distribution_function = [0.0] * 256

# Compute the cumulative distribution function (CDF)
cumulative_sum = 0
for i, bin_count in enumerate(histogram_bins):
    cumulative_sum += bin_count
    cumulative_distribution_function[i] = (cumulative_sum / (rows * cols)) * 255

# Map the old pixel values to new equalized values
for i in range(rows):
    for j in range(cols):
        equalized_image[i, j] = cumulative_distribution_function[gray_image[i, j]]

# Convert the image to uint8 type
equalized_image = np.uint8(equalized_image)

# Plot the histogram of the equalized image
plt.subplot(2, 2, 3)
plt.hist(equalized_image.flatten(), 256, (0, 256), color="r")
plt.title("Equalized Histogram")

# Plot the equalized image
plt.subplot(2, 2, 4)
plt.imshow(equalized_image, cmap="gray")
plt.title("Equalized Image")

# Display the plots
plt.show()
