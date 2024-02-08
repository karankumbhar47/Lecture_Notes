from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]


# problem 1 

qr = QuantumRegister(2)
qc = QuantumCircuit(qr);

qc.id(qr[0])
qc.id(qr[1])

qc.h(qr[0])

qc.cx(qr[0],qr[1])

S = execute(qc,S_simulator).result().get_statevector()
print(S)

print(qc.draw())