# imports

from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister
from qiskit.tools.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]


# Question 2

q = QuantumRegister(2)
c = ClassicalRegister(2)
qc = QuantumCircuit(q,c)

# inputs (<00|, <01|)
qc.h(q[0]) 
qc.id(q[1])


print("------------------------------------------------\n")
print("State vector before cNot :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)

# output (<00|, <11|)
qc.cx(q[0],q[1])

print("------------------------------------------------\n")
print("State vector after first cNot :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)

# output (<00|, <01|)
qc.cx(q[0],q[1])


print("------------------------------------------------\n")
print("State vector after second cNot :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)

qc.measure(q,c)
M = execute(qc,M_simulator).result().get_counts(qc)

print("------------------------------------------------\n")
print(" After Measurement :", M)
print(qc.draw())