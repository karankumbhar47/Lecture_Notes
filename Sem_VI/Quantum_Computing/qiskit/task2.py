from qiskit import QuantumRegister, ClassicalRegister, QuantumCircuit, assemble, Aer
S_simulator = Aer.backends(name="statevector_simulator")[0]

q = QuantumRegister(1)
hello_qubit = QuantumCircuit(1)
hello_qubit.id(q[0])
job = execute(hello_qubit, S_simulator)
result = job.result()
result.get_statevector()
print("Simulator: ",S_simulator,"\n")
print("Simulator Type : ",type(S_simulator),"\n")
