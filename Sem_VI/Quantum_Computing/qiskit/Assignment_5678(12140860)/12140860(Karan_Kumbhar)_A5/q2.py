import sys
import time
import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

qr = QuantumRegister(4)
qc = QuantumCircuit(qr)

def getData(qc):
    print("Getting data for bob",end="")
    showLoadingAnimation()

    S_array = np.array(execute(qc,S_simulator).result().get_statevector())
    index = np.argmax(np.abs(S_array))
    position = np.unravel_index(index, shape=(2, 2, 2, 2))

    return position[1], position[0]

def takeData(a,b):
    qc.x(qr[0]) if a == 1 else None 
    qc.x(qr[1]) if b == 1 else None 

def createEntangledBits():
    print("Creating two Entangled qbits",end="")
    showLoadingAnimation()
    qc.h(qr[2])
    qc.cx(qr[2],qr[3])

def AliceManupulation():
    print("Manupulating Alice ebit",end="")
    showLoadingAnimation()
    qc.cz(qr[1],qr[2]) 
    qc.cx(qr[0],qr[2])
   
def BobManupulation():
    print("Manupulation at Bob end",end="")
    showLoadingAnimation()
    qc.cx(qr[2],qr[3])
    qc.h(qr[2])


def showLoadingAnimation():
    sys.stdout.flush()
    for _ in range(5):
        print(".", end="", flush=True)
        time.sleep(0.5)
    print("\n")

'''
Super Dense Protocol with reverse order of a and b
let assume  
qr[2] and qr[3] are both entangled qbits
qr[2]  --> alice
qr[3]  --> bob

qr[0] and qr[1] are both classical bits
qr[0]  --> a
qr[1]  --> b
'''
def main():

    print("=======================================\n")
    createEntangledBits()

    print("Entangled Bits are created Successfully\n")

    print("Enter the data (bit a then bit b)")
    a = int(input())
    b = int(input())
    print("\n")
    

    takeData(a,b)

    AliceManupulation()

    print("=======================================\n")
    print("Transmitting Alice ebit to Bob",end="")
    showLoadingAnimation()
    print("Bob receives Alice ebit Successfully\n")
    print("=======================================\n")

    BobManupulation()

    a,b = getData(qc)

    print("=======================================\n")
    print("Data received at Bob end is")
    print("a ==> ",a)
    print("b ==> ",b)

    print("\nCircuit diagram \n")
    print(qc.draw())

if __name__=="__main__":
    main()