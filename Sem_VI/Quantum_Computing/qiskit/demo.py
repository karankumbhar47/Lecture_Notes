from qiskit import QuantumRegister, ClassicalRegister, QuantumCircuit, assemble, Aer
import numpy as np
import math as m
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
