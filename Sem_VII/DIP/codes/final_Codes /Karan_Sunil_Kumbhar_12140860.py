import cv2
import numpy as np
import matplotlib.pyplot as plt

# Function to apply Otsu's thresholding to an image
def OTSU_thresholding(img):
    hist = np.zeros(256)
    for pi in img.flatten():
        hist[pi] += 1

    totalPixels = img.size
    totalSum = np.dot(range(256), hist)

    background_weight = 0
    background_sum = 0
    max_between_class_variance = 0
    best_threshold = 0

    for th in range(256):
        background_weight += hist[th]
        if background_weight == 0:
            continue

        foreground_weight = totalPixels - background_weight
        if foreground_weight == 0:
            break

        background_sum += th * hist[th]
        
        mean_background = background_sum / background_weight
        mean_foreground = (totalSum - background_sum) / foreground_weight
        
        between_class_variance = background_weight * foreground_weight * (mean_background - mean_foreground) ** 2
        if between_class_variance > max_between_class_variance:
            max_between_class_variance = between_class_variance
            best_th = th

    bin_image = np.zeros_like(img)
    bin_image[img > best_th] = 255
    return bin_image


def main():
    filename = 'images/p4.jpg'
    img = cv2.imread(filename)
    img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    otsu_img = OTSU_thresholding(img)
    images = [img, otsu_img]
    titles = ['Original Image', 'Otsu Thresholding']

    fig = plt.figure(figsize=(8, 6))
    for i in range(len(images)):
        fig.add_subplot(1, 2, i + 1)
        plt.imshow(images[i], cmap='gray')
        plt.title(titles[i])

    plt.show()


if __name__=="__main__":
    main()