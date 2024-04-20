from qiskit import QuantumRegister, ClassicalRegister, QuantumCircuit, assemble, Aer, execute
import numpy as np
import math as m
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]


qr = QuantumRegister(3)
cr = ClassicalRegister(3)

qc = QuantumCircuit(qr,cr,name="sushmit")

qc.x(qr[0])
qc.x(qr[1])
qc.id(qr[2])

stateVector = execute(qc,S_simulator).result().get_statevector();
print(stateVector)
print(qc.draw())
