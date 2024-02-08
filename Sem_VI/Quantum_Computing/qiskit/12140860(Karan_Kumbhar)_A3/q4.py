# imports

from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister
from qiskit.tools.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

# Problem 4 

q = QuantumRegister(3)
c = ClassicalRegister(3)
qc = QuantumCircuit(q,c)

# input ( |000>, |001>, |010>, |011>)
qc.h(q[0])  # actual input (x)  
qc.h(q[1])  # actual input (y) 
qc.id(q[2])


print("------------------------------------------------\n")
print("State vector before And :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)


# output ( |000>, |001>, |010>, |111>)
qc.ccx(q[0],q[1],q[2])


print("------------------------------------------------\n")
print("State vector after And:\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)


qc.measure(q,c)
M = execute(qc,M_simulator,shots=2000).result().get_counts(qc)

print("--------------------------------------------------\n")
print("After Mesurement ",M)
print(circuit_drawer(qc))