# imports

from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister
from qiskit.tools.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]


# Question 3

q = QuantumRegister(3)
c = ClassicalRegister(3)
qc = QuantumCircuit(q,c)

# input |011>, |001>
qc.x(q[0])
qc.h(q[1]) # actual input
qc.id(q[2])

print("------------------------------------------------\n")
print("State vector before ccNot :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)

# output (|111>, |001>)
qc.ccx(q[0],q[1],q[2])

print("------------------------------------------------\n")
print("State vector after ccNot :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)


qc.measure(q,c)
M = execute(qc,M_simulator).result().get_counts(qc)

print("------------------------------------------------\n")
print("After ccNot : ",M)
print(qc.draw())