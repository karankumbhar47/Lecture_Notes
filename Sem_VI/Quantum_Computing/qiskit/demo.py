import warnings
from qiskit import QuantumRegister, ClassicalRegister, QuantumCircuit, assemble, execute
import numpy as np
import math as m
import qiskit_aer

S_simulator = qiskit_aer.Aer.backends(name="statevector_simulator")[0]
M_simulator = qiskit_aer.Aer.backends(name="qasm_simulator")[0]

warnings.filterwarnings("ignore")

qr = QuantumRegister(3)
cr = ClassicalRegister(3)

qc = QuantumCircuit(qr, cr, name="sushmit")

qc.x(qr[0])
qc.x(qr[1])
qc.id(qr[2])

stateVector = execute(qc, S_simulator).result().get_statevector()
print(stateVector)
print(qc.draw())
