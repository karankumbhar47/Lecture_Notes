import sys
import time
import numpy as np
import math
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute, ClassicalRegister

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator = "\n=====================================================\n"

qr = QuantumRegister(3)
cr = ClassicalRegister(3)
qc = QuantumCircuit(qr,cr)


def printStateVector(qc):
    simulator = Aer.get_backend('statevector_simulator')
    statevector = execute(qc, simulator).result().get_statevector()
    formatted_statevector = np.round(statevector, 3)
    abs_values = np.abs(formatted_statevector)

    print("\nState Vector is as follows :-\n")
    print("         q2 q1 q0\n")
    for i, amp in enumerate(abs_values):
        if amp != 0:
            binary_index = format(i, '03b')
            print(f"          {binary_index[0]}  {binary_index[1]}  {binary_index[2]} ==> {amp}" )

    print("\n")
    print(f"{formatted_statevector}\n")


def printCounts(qc):
    print("Counts are as follows:- \n")
    dict = execute(qc, M_simulator).result().get_counts(qc)
    print("         q2 q1 q0\n")
    for i in dict.keys():
        print(f"          {i[0]}  {i[1]}  {i[1]}  ==> {dict[i]}")


def getData(qc):
    print("Getting data for bob",end="")
    showLoadingAnimation()

    printStateVector(qc)
    qc.measure(qr,cr)


def takeData(alpha,beta):
    qc.ry(2 * np.arccos(alpha), 0)  
    qc.rz(2 * np.arccos(beta), 0)   
    qc.barrier()

    print("\nInput created ...")
    printStateVector(qc)


def createEntangledBits():
    print("Creating two Entangled qbits",end="")
    showLoadingAnimation()
    qc.id(qr[1])
    qc.id(qr[2])
    qc.h(qr[1])
    qc.cx(qr[1],qr[2])
    qc.barrier()


def AliceManupulation():
    print("Maniculating Alice ebit",end="")
    showLoadingAnimation()
    qc.cx(qr[0],qr[1])
    qc.h(qr[0]) 
    qc.measure([0,1],[0,1])
    qc.barrier()
   

def BobManupulation():
    print("Manupulation at Bob end",end="")
    showLoadingAnimation()
    qc.cx(qr[1],qr[2])
    qc.cz(qr[0],qr[2])
    qc.barrier()


def showLoadingAnimation():
    sys.stdout.flush()
    for _ in range(5):
        print(".", end="", flush=True)
        time.sleep(0.3)
    print("\n")


'''
Quantum Teleportation Protocol
let assume  
qr[1] and qr[2] are both entangled qubits
qr[1]  --> alice
qr[2]  --> bob

qr[0] qubit should shared from alice to bob 
qr[0]  --> α∣0⟩ + β∣1⟩
here α and β will be taken as input
'''
def main():
    print('''
        Here Shared qubit is `q[0]` and you have to enter the 
        alpha value which abs value is less than 1
        beta value will automatically decided by alpha value 

        To verify the protocol
        observe the output at `q[2]` from state vector at end
    ''')
    print(seperator)
    print("Enter the value for α (β = √(1 - α^2))")
    while True:
        a = float(input())
        if abs(a) <= 1:
            break
        else:
            print("Enter a valid value for α (less than or equal to 1)")

    b = math.sqrt(1 - (a * a))

    print("\nα:", a)
    print("β:", b)
    print("\nα^2 + β^2:", a * a + b * b)
    takeData(a,b)

    print(seperator)
    createEntangledBits()
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
    getData(qc)

    print(seperator)
    print("\nCircuit diagram \n")
    print(qc.draw())

if __name__=="__main__":
    main()