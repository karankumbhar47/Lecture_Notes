# Basic imports

from qiskit import execute, QuantumCircuit, QuantumCircuit, QuantumRegister, Aer
S_simulator = Aer.backends(name="statevector_simulator")[0]


##############################################################

# problem 2 (write Wavefunction) 

import numpy as np  
import math

def bits_needed(decimal_number):
    if decimal_number == 0:
        return 1  # Special case: 0 requires 1 bit

    return math.ceil(math.log2(abs(decimal_number)))


def Wavefunction(circuit):
    job = execute(circuit, S_simulator)
    result = job.result()

    vector = np.asarray(result.get_statevector())
    print("state vector ==>\n ")
    print(result.get_statevector())
    print("\n ")

    for i in range(len(vector)):
        modulus = np.abs(vector[i])
        if(modulus!=0):
            binary_string = bin(i)[2:]
            binary_string = binary_string.zfill(bits_needed(len(vector)))
            binary_string = ''.join(reversed(binary_string))
            print(f"vector value ==> {vector[i]}\nstate value  ==> |{binary_string}>\nprobability  ==> {modulus*modulus}\n")
