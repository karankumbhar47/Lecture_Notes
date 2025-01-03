from qiskit import QuantumCircuit, QuantumRegister, ClassicalRegister, execute, Aer

S_simulator = Aer.backends(name='statevector_simulator')[0]
M_simulator = Aer.backends(name='qasm_simulator')[0]

# measuring only say middle bit
q = QuantumRegister(3)
c = ClassicalRegister(3)
qc = QuantumCircuit(q,c)

qc.x(q[0])  # 0
qc.h(q[1])  # 0,1
qc.id(q[2]) # 1

print("\nProblem 1 : -\n")
print("b) Measuring only middle bit : -\n")
print("==============================================\n")
print("State vector before mesurement :- \n")
result = execute(qc, S_simulator).result()
print(result.get_statevector())

qc.measure(q[1],c[1])

result = execute(qc, S_simulator).result()
state_counts = execute(qc, M_simulator).result().get_counts(qc)
print("\n==============================================\n")
print("State vector before mesurement :- \n")
print(result.get_statevector())

print("\n==============================================\n")
print('''
Explaination :- 

Before mesurement state vector shows superposition of two state with equal
probability of 0.5(square of amplitude), and after measurement we get one fix classical state
''')

print("\n==============================================\n")
print("Circuit diagram")
print(qc.draw())

