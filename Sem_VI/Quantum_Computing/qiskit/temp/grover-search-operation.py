import numpy as np

def create_identity_matrix(n):
    return np.identity(n)

def create_matrix(n, entries):
    size = 2 ** n
    matrix = np.array(entries).reshape((size, 1))
    return matrix

def multiply_matrices(matrix1, matrix2):
    return np.dot(matrix1, matrix2)

def main():
    n = int(input("Enter the value of n: "))
    
    # Create V matrix from user input
    size = 2 ** n
    entries = [float(input(f"Enter value for V[{i}]: ")) for i in range(size)]
    V = create_matrix(n, entries)
    
    # Create A matrix
    entry = 1 / size
    A = np.full((size, size), entry)
    
    # Create identity matrix I
    I = create_identity_matrix(size)
    
    # Calculate (-I + 2A)
    result_matrix = -I + 2 * A
    
    # Multiply (-I + 2A) with V
    final_result = multiply_matrices(result_matrix, V)

    # Display the resulting matrix
    print(f"The result of (-I + 2A) * V for dimension 2^{n} x 1:")
    print(final_result)

if __name__ == "__main__":
    main()
