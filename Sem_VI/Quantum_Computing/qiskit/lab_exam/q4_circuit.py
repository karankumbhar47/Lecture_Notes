from qiskit import QuantumRegister, QuantumCircuit, Aer, execute, ClassicalRegister
import qiskit_aer
import warnings

S_simulator = qiskit_aer.Aer.backends(name="statevector_simulator")[0]
M_simulator = qiskit_aer.Aer.backends(name="qasm_simulator")[0]

seperator = "\n=====================================================\n"
warnings.filterwarnings("ignore")

def measureValue(qc,qr,cr,num):
    qc.measure(qr,cr)
    dict = execute(qc, M_simulator).result().get_counts(qc)

    print(seperator)
    print(f"Q{num} : \n")
    print(qc.draw())
    print(seperator)
    print("\nCounts are : ")
    print(dict)
    print(seperator)

# let say 
#  α = 1/sqrt(2)
#  β = 1/sqrt(2)

## %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

# problem 1
# α∣00⟩ + β∣11⟩

qr1 = QuantumRegister(2)
cr1 = ClassicalRegister(2)
qc1 = QuantumCircuit(qr1,cr1);

qc1.id(qr1[0])
qc1.id(qr1[1])
qc1.barrier()

qc1.h(qr1[0])
qc1.cx(qr1[0],qr1[1])
qc1.barrier()

measureValue(qc1,qr1,cr1,1)


## %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

# problem 2
# α∣01⟩ + β∣10⟩

qr2 = QuantumRegister(2)
cr2 = ClassicalRegister(2)
qc2 = QuantumCircuit(qr2,cr2);

qc2.id(qr2[0])
qc2.id(qr2[1])
qc2.barrier()

qc2.h(qr2[0])
qc2.cx(qr2[0],qr2[1])
qc1.barrier()

qc2.x(1)
qc2.barrier()

measureValue(qc2,qr2,cr2,3)


## %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

# problem 3
# α∣00⟩ - β∣11⟩

qr3 = QuantumRegister(2)
cr3 = ClassicalRegister(2)
qc3 = QuantumCircuit(qr3,cr3);

qc3.id(qr3[0])
qc3.id(qr3[1])
qc3.barrier()

qc3.h(qr3[0])
qc3.cx(qr3[0],qr3[1])
qc3.barrier()

qc3.cz(qr3[0],qr3[1])
qc3.barrier()

measureValue(qc3,qr3,cr3,3)
## %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

# problem 4
# α∣01⟩ - β∣10⟩

qr4 = QuantumRegister(2)
cr4 = ClassicalRegister(2)
qc4 = QuantumCircuit(qr4,cr4);

qc4.id(qr4[0])
qc4.id(qr4[1])
qc4.barrier()

qc4.h(qr4[0])
qc4.cx(qr4[0],qr4[1])
qc4.barrier()

qc4.x(1)
qc4.barrier()

qc4.z(0)
qc4.barrier()

measureValue(qc4,qr4,cr4,4)


## %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

# problem 5
# α∣0⟩∣+> - β∣1⟩∣-⟩

cr5 = ClassicalRegister(2)
qr5 = QuantumRegister(2)
qc5 = QuantumCircuit(qr5,cr5)

qc5.h(0)
qc5.x(1)
qc5.barrier()

qc5.h(1)
qc5.cx(0, 1)
qc5.barrier()

measureValue(qc5,qr5,cr5,4)