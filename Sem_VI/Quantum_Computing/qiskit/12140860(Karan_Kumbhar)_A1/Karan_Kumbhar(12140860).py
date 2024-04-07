# Basic imports
from qiskit import execute, QuantumCircuit, QuantumCircuit, QuantumRegister, Aer
import Our_Qiskit_Function as oq

S_simulator = Aer.backends(name="statevector_simulator")[0]

##############################################################

# Problem 1 (Roll number problem)

# creating quantum register to store 4 qbits
q = QuantumRegister(4)

# initializing quntum circuit
circuit = QuantumCircuit(q)

# my roll number --> 12140860
# n = 6(0110) 

circuit.id(q[0])
circuit.x(q[1])
circuit.x(q[2])
circuit.id(q[3])

job = execute(circuit, S_simulator)
result = job.result()

print("==============================================================")
print("Result for first problem :- \n")
print(result.get_statevector())
print("\n")

##############################################################

# problem 2 
# write Our_Qiskit_Function  

q = QuantumRegister(3)
circuit = QuantumCircuit(q)

# some assumption we are treating zero'th  bit as MSB(some confusion
# which one is MSB and which one LSB)
circuit.x(q[0])
circuit.id(q[1])
circuit.id(q[2])

print("==============================================================")
print("Result for second problem :-\n")
oq.Wavefunction(circuit)
print("\n")

##############################################################
