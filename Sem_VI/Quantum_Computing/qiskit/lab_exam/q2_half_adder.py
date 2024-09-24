from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
import qiskit_aer
S_simulator = qiskit_aer.Aer.backends(name="statevector_simulator")[0]
M_simulator = qiskit_aer.Aer.backends(name="qasm_simulator")[0]
import warnings 

seperator = "\n=====================================================\n"
warnings.filterwarnings("ignore")

# qc[3] --> x.y
# qc[2] --> x^y

#  Half Adder
qr = QuantumRegister(4)
qc = QuantumCircuit(qr);

qc.h(qr[0])     # value x
qc.x(qr[1])     # value 1
qc.h(qr[2])     # value y
qc.id(qr[3])    # value 0
qc.barrier()

# using toffoli gate
qc.ccx(qr[0],qr[2],qr[3])
qc.ccx(qr[0],qr[1],qr[2])
qc.barrier()

S = execute(qc,S_simulator).result().get_statevector()

print(seperator)
print(S)
print(seperator)
print(qc.draw())
print(seperator)