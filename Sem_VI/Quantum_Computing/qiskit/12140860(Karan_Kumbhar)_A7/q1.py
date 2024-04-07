import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute,ClassicalRegister
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator   = "\n=============================================================================\n"
sep         = "\n-----------------------------------------------------------------------------\n"


def printStateVector(qc):
    simulator = Aer.get_backend('statevector_simulator')
    statevector = execute(qc, simulator).result().get_statevector()
    statevector_np = np.asarray(statevector)
    formatted_statevector = np.round(statevector_np, 3)
    abs_values = np.abs(formatted_statevector)
    num_qubits = int(np.log2(len(statevector_np)))

    print("\nState is as follows :-\n")
    print(" ".join([f"q{i}" for i in reversed(range(num_qubits))]))
    for i, amp in enumerate(abs_values):
        if amp != 0:
            binary_index = format(i, f'0{num_qubits}b')
            print(" " * (num_qubits-len(binary_index)) + "  ".join(binary_index) + f" ==> {formatted_statevector[i]}")


def takeData(qr,qc,a,b):
    qc.x(qr[0]) if a == 1 else qc.id(qr[0]) 
    qc.x(qr[1]) if b == 1 else qc.id(qr[1]) 
    qc.barrier()
    return qr,qc


def createEntangledBits(qr,qc):
    qc.h(qr[2])
    qc.cx(qr[2],qr[3])
    qc.barrier()
    return qr,qc


def createInputFromEntanglement(qr,qc,flag):
    qc.cz(qr[0],qr[2]) 
    qc.cx(qr[1],qr[2])

    qc.cx(qr[2],qr[3])
    qc.h(qr[2])

    if(flag):
        qc.cz(qr[2],qr[3])
    qc.barrier()
    return qr,qc


'''
Creating input with state string as input.
Here if state is "00", then we are creating 
state as per statevector representation
'''
def createResultantState(qr,qc):
    cr = ClassicalRegister(2,name="cr")

    qc.barrier()

    qc.h(qr[2])
    qc.h(qr[3])

    qc.z(qr[2])
    qc.z(qr[3])

    qc.cz(qr[2],qr[3])

    qc.h(qr[2])
    qc.h(qr[3])

    qc.barrier()

    statevector = execute(qc,S_simulator).result().get_statevector()
    formatted_statevector = [np.round(x, 2) for x in statevector.data]
    print("Result state is as follows :-\n")
    print(f"{formatted_statevector}\n")

    
    return qc,qr,cr



'''
here we are going to use the circuit 
used in Assignment 6 which takes input 
from [00,01,10,11] and gives corresponding 
output requried for this question too

our goal is to get input from [00,01,10,11]
from entangled bits pair 

This can be done by super dense coding 
approach (just need to flip ouput when 
input is 11 to change it to `∣11⟩` from `-∣11⟩`)

Here we are using 4 qubit circuit 
q[0], q[1] are control bits
q[2], q[3] are actual qubits(entanglement)
'''
def main():
    states = ["00","01","10","11"]
    for i in states:
        print(seperator)

        print(f"Input to first Circuit   : {i}\n")

        # creating 4 qubit created
        qr = QuantumRegister(4,name="qr")
        qc = QuantumCircuit(qr,name="qc")

        # creating entanglement in q[2] and q[3]
        qr,qc = createEntangledBits(qr,qc)

        # creating inputs for next circuit 
        # from entagnled qubit state
        qr,qc = takeData(qr,qc,int(i[1]),int(i[0])) 
        qr,qc = createInputFromEntanglement(qr,qc,i=="11")

        print(sep)
        print(f"Inputs for second circuit : ")
        printStateVector(qc)

        # creating actual result from states from states list
        print(sep)
        createResultantState(qr,qc)
        printStateVector(qc)

        print(sep)
        print("Circuit Diagram : \n")
        print(qc.draw())

        print(seperator)


if __name__=="__main__":
    main()
