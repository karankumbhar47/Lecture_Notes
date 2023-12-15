# Requirements:

- Python

# Instructions:

- In order to run the two python files, use the following command:

``` bash
python3 Path_Finding.py
```
``` bash
python3 Path_Finding_2.py
```
# Input Instructions:

After you run above command input should be given in following format:
1. First line contains the dimension of the terrain, No. Of rows(N) and No. Of
columns(M).
2. N lines follow, where each line has M characters, representing the cell
terrain.

## Example
### When the python file is run and is given following grids as the input.  

**Example 1**
  - **Input**
    ```
    G D R G F
    G R R D G
    D G G R G
    G R G G D
    S G D R G
    ```
     - **Output of Path_finding**
    ```
    The length of path is 8
    (4, 1) (4, 2) (3, 2) (3, 3) (3, 4) (2, 4) (1, 4) (0, 4)
    ```
      - **Output of Path_finding_2**
    ```
    The length of path is 10
    (3, 0) (2, 0) (2, 1) (2, 2) (3, 2) (3, 3) (3, 4) (2, 4) (1, 4) (0, 4)    
    
    ```
**Example 2**
  - **Input**
    ```
    R D R G F
    R R R D G
    G G G R G
    G R G G G
    S R D R G
    ```
     - **Output of Path_finding**
    ```
    The length of path is 10
    (3, 0) (2, 0) (2, 1) (2, 2) (3, 2) (3, 3) (3, 4) (2, 4) (1, 4) (0, 4)

    ```
      - **Output of Path_finding_2**
    ```
    The length of path is 10
    (3, 0) (2, 0) (2, 1) (2, 2) (3, 2) (3, 3) (3, 4) (2, 4) (1, 4) (0, 4) 
    
    ```