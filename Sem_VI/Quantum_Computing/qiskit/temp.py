# Karan Kumbhar (12140860)


from qiskit import ClassicalRegister, QuantumCircuit, QuantumRegister
from qiskit import  execute
import qiskit_aer
import warnings
import numpy as np
seperator = "\n"+"="*50+"\n"

warnings.filterwarnings("ignore")

S_simulator =  qiskit_aer.Aer.backends(name="statevector_simulator")[0]
M_simulator =  qiskit_aer.Aer.backends(name="qasm_simulator")[0]
U_simulator =  qiskit_aer.Aer.backends(name="unitary_simulator")[0]

qr = QuantumRegister(2)
cr = ClassicalRegister(2)

qc = QuantumCircuit(qr,cr,name="qc")

qc.barrier()

qc.h(qr[0])
qc.h(qr[1])


qc.z(qr[0])
qc.z(qr[1])

qc.cx(qr[0],qr[1])

qc.z(qr[0])
qc.z(qr[1])

qc.h(qr[0])
qc.h(qr[1])

qc.barrier()

job = execute(qc,U_simulator)
result = job.result()
UnitaryMatrix = result.get_unitary(qc,2)

print(seperator)
print("This is unitary matrix generated\n")
matrix = np.asarray(UnitaryMatrix)
print(matrix)


print(seperator)
print("Circuit Diagram \n")
print(qc.draw())