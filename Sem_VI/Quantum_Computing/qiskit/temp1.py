import math
import numpy as np

numRoot2 = 1/math.sqrt(2)

h = [[numRoot2,numRoot2],[numRoot2,-numRoot2]]
z = [[1,0],[0,-1]]
cz = [[1,0,0,0],[0,1,0,0],[0,0,0,1],[0,0,1,0]]
twoZ = np.kron(z,z)
towH = np.kron(h,h)
print(twoZ)


state2 = np.dot(twoZ,towH)
print(state2)
state3 = np.dot(cz,state2)
print(state3)
state4 = np.dot(twoZ,state3)
print(state4)
state5 = np.dot(towH,state4)
print(state5)

# import numpy as np

# # Define matrices for gates
# H = 1/np.sqrt(2) * np.array([[1, 1], [1, -1]])
# Z = np.array([[1, 0], [0, -1]])
# CNOT = np.array([[1, 0, 0, 0],
#                  [0, 1, 0, 0],
#                  [0, 0, 0, 1],
#                  [0, 0, 1, 0]])

# U_1 = np.dot(H, Z)
# U_2 = np.dot(H, Z)

# # Compute tensor product of the results to get the combined unitary operation
# U_combined = np.kron(U_1, U_2)

# # Compute tensor product with CNOT gate matrix
# U_with_CNOT = np.dot(CNOT, U_combined)


# print("Unitary matrix representing the combined operation with CNOT:")
# print(U_with_CNOT)


# # Compute tensor product for the first qubit (Hadamard followed by Z)
# U_1_after = np.dot(H, Z)

# # Compute tensor product for the second qubit (Hadamard followed by Z)
# U_2_after = np.dot(H, Z)


# # Compute tensor product with the previous unitary matrix
# U_combined_after = np.dot(np.kron(U_1_after, U_2_after), U_with_CNOT)

# print("Unitary matrix representing the combined operation after Hadamard and Z gates on each qubit:")
# print(U_combined_after)
