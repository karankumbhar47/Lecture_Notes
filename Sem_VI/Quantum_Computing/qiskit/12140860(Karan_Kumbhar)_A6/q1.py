from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator = "\n=============================================\n"


# Implementing And Gate using Fredkin Gate
def FredkinAND(state):
    qr = QuantumRegister(3,name="qr")
    cr = ClassicalRegister(3,name="cr")
    qc = QuantumCircuit(qr,cr)

    qc.x(qr[0]) if state[0] == "1" else qc.id(qr[0])
    qc.x(qr[2]) if state[1] == "1" else qc.id(qr[2])
    qc.id(qr[1]) 

    qc.cswap(qr[0],qr[1],qr[2])

    qc.measure(qr, cr)
    result = execute(qc, M_simulator).result().get_counts(qc)

    return (list(result.keys())[0][1]), qc



# Implementing Not Gate using Fredkin Gate
def FredkinNOT(state):
    qr = QuantumRegister(3,name="qr")
    cr = ClassicalRegister(3,name="cr")
    qc = QuantumCircuit(qr,cr)

    qc.x(qr[0]) if state[0] == "1" else qc.id(qr[0])
    qc.x(qr[1]) 
    qc.id(qr[2])

    qc.cswap(qr[0],qr[1],qr[2])

    qc.measure(qr, cr)
    result = execute(qc, M_simulator).result().get_counts(qc)

    return (list(result.keys())[0][2]),qc


# Implementing OR Gate using Fredkin Gate
def FredkinOR(state):
    qr = QuantumRegister(3,name="qr")
    cr = ClassicalRegister(3,name="cr")
    qc = QuantumCircuit(qr,cr)

    qc.x(qr[0]) if state[0] == "1" else qc.id(qr[0])
    qc.x(qr[2]) if state[0] == "1" else qc.id(qr[2])
    qc.x(qr[1]) if state[1] == "1" else qc.id(qr[1])

    qc.cswap(qr[0],qr[1],qr[2])

    qc.measure(qr, cr)
    result = execute(qc, M_simulator).result().get_counts(qc)

    return (list(result.keys())[0][1]),qc


def testAndGate():
    print("Fredkin AND Gate\n") 
    print("Input ==> Output") 

    states = ["00","01","10","11"]
    for i in range(4):
        output, circuit = FredkinAND(states[i])
        print(states[i],"   ==> ", output)

    print(circuit.draw())
    

def testORGate():
    print("Fredkin OR Gate\n") 
    print("Input ==> Output") 

    states = ["00","01","10","11"]
    for i in range(4):
        output, circuit = FredkinOR(states[i])
        print(states[i],"   ==> ", output)

    print(circuit.draw())


def testNotGate():
    print("Fredkin Not Gate\n") 
    print("Input ==> Output") 

    states = ["0","1"]
    for i in range(2):
        output, circuit = FredkinNOT(states[i])
        print(states[i],"    ==> ", output)

    print(circuit.draw())


def main():
    print(seperator)
    testAndGate()        
    print(seperator)
    testORGate()
    print(seperator)
    testNotGate()
    print(seperator)


if __name__=="__main__":
    main()
