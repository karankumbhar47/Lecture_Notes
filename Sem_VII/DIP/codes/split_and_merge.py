import cv2
import numpy as np
import requests

def is_homogeneous(region, threshold):
    min_val,max_val = np.min(region),np.max(region)
    return (max_val-min_val) <= threshold

def split_and_merge(image,threshold):

    def recursive_split(region):
        rows,cols = region.shape
        if rows <=1 or cols <=1:
            return np.zeros_like(region, dtype=np.uint8)

        if is_homogeneous(region,threshold):
            return np.ones_like(region,dtype=np.uint8)

        mid_row, mid_col = rows//2, cols//2

        top_left = region[:mid_row,:mid_col]
        top_right = region[:mid_row,mid_col:]
        bottom_left = region[mid_row:,:mid_col]
        bottom_right = region[mid_row:,mid_col:]

        segmented_quatrants = np.zeros_like(region,dtype=np.uint8)

        segmented_quatrants[:mid_row, :mid_col] = recursive_split(top_left)
        segmented_quatrants[:mid_row, mid_col:] = recursive_split(top_right)
        segmented_quatrants[mid_row:, :mid_col] = recursive_split(bottom_left)
        segmented_quatrants[mid_row:, mid_col:] = recursive_split(bottom_right)

        return segmented_quatrants

    def merge_regions(segmented):
        return segmented
    
    if len(image.shape) == 3:
        image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    
    
    segmetned_image =  recursive_split(image)
    segmetned_image =  merge_regions(segmetned_image)
    
    return segmetned_image


def main():
    image = cv2.imread('codes/images/p6.jpg')
    threshold = 20
    result = split_and_merge(image,threshold)
    cv2.imshow('Segmented image',result*255)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


if __name__ == "__main__":
    main()