# Requirements

- Python

# Instructions

- In order to run the two python files, use the following command:

```
bash
python word_Conversion_BFS.py
```

```
 bash
python word_Conversion_ID-DFS.py
```

- When the python file is run, given the grid as the input.

## Example

### For first Part(DFS)

**Example 1**

- **Input**

    ```
    5
    cat dog
    cot
    dot
    dog
    bat
    hat
    ```

- **Output**

    ```
    cat cot dot dog
    ```

**Example 2**

- **Input**

    ```
    4
    book read
    cook
    road
    reed
    read
    ```

- **Output**

    ```
    No transformation sequence found.
    ```

### For second Part(ID-DFS)

**Example 1**

- **Input**

    ```
    6
    lead gold
    gold
    cold
    cord
    lord
    load
    lead
    ```

- **Output**

    ```
    lead load lord cord cold gold
    ```

**Example 2**

- **Input**

    ```
    3
    code bear
    care
    dare
    case
    ```

- **Output**

    ```
    No transformation sequence found.
    ```
