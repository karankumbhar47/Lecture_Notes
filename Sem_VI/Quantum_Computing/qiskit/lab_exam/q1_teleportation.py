import sys
import time
import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute, ClassicalRegister
import warnings 

warnings.filterwarnings("ignore")

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator = "\n=====================================================\n"

qr = QuantumRegister(4)
cr = ClassicalRegister(3)
qc = QuantumCircuit(qr,cr)


def printStateVector(qc):
    simulator = Aer.get_backend('statevector_simulator')
    statevector = execute(qc, simulator).result().get_statevector()
    formatted_statevector = np.round(statevector, 3)
    abs_values = np.abs(formatted_statevector)
    print(formatted_statevector)

    print("\nState Vector is as follows :-\n")
    print("         q3 q2 q1\n")
    for i, amp in enumerate(abs_values):
        if amp != 0:
            binary_index = format(i, '03b')
            print(f"          {binary_index[0]}  {binary_index[1]}  {binary_index[2]} ==> {amp}" )

    print("\n")
    print(f"{formatted_statevector}\n")


def getData(qc):
    print("Getting data for bob",end="")
    showLoadingAnimation()

    printStateVector(qc)
    qc.measure(qr,cr)


def createEntangledBits(shared):
    print("Creating two Entangled qbits",end="")
    showLoadingAnimation()
    if(shared):
        qc.id(qr[2])
        qc.id(qr[3])
        qc.h(qr[2])
        qc.cx(qr[2],qr[3])
        qc.barrier()
    else:
        qc.id(qr[0])
        qc.id(qr[1])
        qc.h(qr[1])
        qc.cx(qr[0],qr[1])
        qc.barrier()


def AliceManupulation():
    print("Maniculating Alice ebit",end="")
    showLoadingAnimation()
    qc.cx(qr[1],qr[2])
    qc.h(qr[1]) 
    qc.measure([1,2],[0,1])
    qc.barrier()
   

def BobManupulation():
    print("Manupulation at Bob end",end="")
    showLoadingAnimation()
    qc.cx(qr[2],qr[3])
    qc.cz(qr[1],qr[3])
    qc.barrier()


def showLoadingAnimation():
    sys.stdout.flush()
    for _ in range(5):
        print(".", end="", flush=True)
        time.sleep(0.1)
    print("\n")


'''
Quantum Teleportation Protocol
let assume  
qr[2] and qr[3] are both entangled qubits
qr[2]  --> alice
qr[3]  --> bob

qr[1] qubit should shared from alice to bob 
qr[0] and qr[1] are both entangled qubits
sharing qubit (qr[1])
'''
def main():
    print(seperator)
    createEntangledBits(shared=False)
    createEntangledBits(shared=True)
    print("Entangled Bits are created Successfully\n")

    print(seperator)
    AliceManupulation()

    print(seperator)
    print("Transmitting Alice ebit to Bob",end="")
    showLoadingAnimation()
    print("Bob receives Alice ebit Successfully\n")

    print(seperator)
    BobManupulation()

    print(seperator)
    printStateVector(qc)

    print(seperator)
    print("\nCircuit diagram \n")
    print(qc.draw())

if __name__=="__main__":
    main()