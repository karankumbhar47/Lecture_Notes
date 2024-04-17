import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator = "\n=====================================================\n"


'''
Creating input with state string as input.
Here if state is "00", then we are creating 
state as per statevector representation
'''
def createInput(state):
    qr = QuantumRegister(2,name="qr")
    cr = ClassicalRegister(2,name="cr")
    qc = QuantumCircuit(qr,cr)

    qc.x(qr[0]) if state[1]=="1" else qc.id(qr[0])
    qc.x(qr[1]) if state[0]=="1" else qc.id(qr[1])

    qc.barrier()

    qc.h(qr[0])
    qc.h(qr[1])

    qc.z(qr[0])
    qc.z(qr[1])

    qc.cz(qr[0],qr[1])

    qc.h(qr[0])
    qc.h(qr[1])

    qc.barrier()

    statevector = execute(qc,S_simulator).result().get_statevector()
    formatted_statevector = [np.round(x, 2) for x in statevector.data]
    print("\nInput created is as follows :-\n")
    print(f"{formatted_statevector}\n")

    return qc,qr,cr


def getOutput(qc,qr,cr):
    qc.measure(qr,cr)
    M = execute(qc,M_simulator).result().get_counts(qc)

    print(qc.draw())

    if(len(M)==1):
        return list(M.keys())[0]
    else:
        return -1


def circuitOutput(qc,qr,cr):
    qc.h(qr[0])
    qc.h(qr[1])

    qc.z(qr[0])
    qc.z(qr[1])

    qc.cz(qr[0],qr[1])

    qc.h(qr[0])
    qc.h(qr[1])

    qc.barrier()

    return getOutput(qc,qr,cr)


def testCircuit():
    states = ["00","01","10","11"]
    inputs = [
        "φ₀₀ = 1/2(- |00> + |01> + |10> + |11>)  ",
        "φ₀₁ = 1/2(  |00> - |01> + |10> + |11>)  ",
        "φ₁₀ = 1/2(  |00> + |01> - |10> + |11>)  ",
        "φ₁₁ = 1/2(  |00> + |01> + |10> - |11>)  "
    ]

    for i in range(len(states)):
        print(seperator)

        qc,qr,cr = createInput(states[i])
        output   = circuitOutput(qc,qr,cr)

        print("\nInput state  :- "+inputs[i])
        if(output==-1):
            print("Some error in Circuit")
        else:
            print("Output state :-",output)

        print(seperator)


def main():
    testCircuit() 


if __name__=="__main__":
    main()


     