import cv2
import numpy as np
import matplotlib.pyplot as plt

# Load and convert image to grayscale
filename = "./images/small.png"
img = cv2.imread(filename)
img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Get the dimensions of the image
rows, cols = img_gray.shape
n_pixels = rows * cols

# Compute the histogram of pixel values
hist = cv2.calcHist([img_gray], [0], None, [256], [0, 256])
print(hist)
print(type(hist))

# Normalize histogram to get probabilities
pr = hist / n_pixels

# Compute cumulative distribution function (CDF)
sk = np.cumsum(pr)

# Round CDF values
rounded_sk = np.round(sk, decimals=2)

# Calculate ps values based on rounded_sk
ps = np.zeros_like(rounded_sk)

# Mapping from rounded_sk to index
for i in range(len(rounded_sk)):
    current_round_value = rounded_sk[i]
    if i == 0:
        ps[i] = pr[i] / n_pixels
    else:
        # Sum probabilities for all previous rounded_sk values
        relevant_probabilities = pr[:i+1] / n_pixels
        ps[i] = np.sum(relevant_probabilities)

# Convert results to lists
pixel_values_list = np.arange(256).tolist()
frequencies_list = hist.flatten().tolist()
probabilities_list = pr.flatten().tolist()
cumulative_sum_list = sk.flatten().tolist()
rounded_cumulative_sum_list = rounded_sk.flatten().tolist()
ps_list = ps.flatten().tolist()

# Print the results
# print("Pixel values (rk):", pixel_values_list)
# print("Frequencies (nk):", frequencies_list)
# print("Probabilities (pr(rk)):", probabilities_list)
# print("Cumulative sum (sk):", cumulative_sum_list)
# print("Rounded cumulative sum (round(sk)):", rounded_cumulative_sum_list)
# print("PS values for rounded sk:", ps_list)

# # Optional: Plot the histogram and CDF
# plt.figure(figsize=(12, 6))

# # Histogram
# plt.subplot(1, 2, 1)
# plt.title('Histogram')
# plt.bar(pixel_values_list, frequencies_list, width=1.0, color='gray')
# plt.xlabel('Pixel value')
# plt.ylabel('Frequency')

# # Cumulative Distribution Function (CDF)
# plt.subplot(1, 2, 2)
# plt.title('Cumulative Distribution Function (CDF)')
# plt.plot(pixel_values_list, rounded_cumulative_sum_list, marker='o', linestyle='-', color='blue', label='Rounded CDF')
# plt.xlabel('Pixel value')
# plt.ylabel('Rounded CDF')
# plt.legend()

# plt.show()
