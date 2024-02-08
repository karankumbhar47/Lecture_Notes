# imports

from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister
from qiskit.tools.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

# Problem 5 

q = QuantumRegister(3)
c = ClassicalRegister(3)
qc = QuantumCircuit(q,c)

# input ( |101>, |111>)
qc.x(q[0]) 
qc.h(q[1])  # actual input  
qc.x(q[2])


print("------------------------------------------------\n")
print("State vector before Not :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)


# output ( |100>, |110>)
qc.ccx(q[0],q[1],q[2])


print("------------------------------------------------\n")
print("State vector after Not :\n")
S = execute(qc,S_simulator).result().get_statevector()
print(S)


qc.measure(q,c)
M = execute(qc,M_simulator,shots=2000).result().get_counts(qc)

print("--------------------------------------------------\n")
print("After Mesurement ",M)
print(circuit_drawer(qc))