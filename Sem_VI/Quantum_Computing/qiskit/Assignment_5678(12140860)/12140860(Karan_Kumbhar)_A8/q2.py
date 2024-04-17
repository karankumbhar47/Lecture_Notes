import math
from qiskit import Aer, ClassicalRegister, QuantumCircuit, QuantumRegister, execute

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

# Deutsch-Jozsa Algorithm

def getQubitNumber():
    n = 2 
    while True:
        n = int(input("Enter the number of Qubits\n"))
        if(n>1):
            break
        else:
            print("Not valid number for Qubits")
    return n

def getChoice():
    while True:
        print("Select one of following functions ")
        print("\t1. Constant 0 function")
        print("\t2. Constant 1 function")
        print("\t3. Balanced function\n ")

        choice = int(input())
        if(choice>=1 and choice<=4):
            break
        else:
            print("Choose the correct choice")
    return choice-1

def getOracle(choice,n):
    qr = QuantumRegister(n+1,name="qr")
    match choice:
        case 0:
            print("constant zero function selected")
            qc = QuantumCircuit(qr,name="constant_0")
        case 1:
            print("constant one function selected")
            qc = QuantumCircuit(qr,name="constant_1")
            qc.x(qr[:n])
        case 2:
            print("balanced function selected")
            qc = QuantumCircuit(qr,name="Balanced")
            qc.x(n-1)
            qc.cx(n-1,n)
            qc.x(n-1)
        case _:
            print("Invalid choice")
    return qc


def bits_needed(decimal_number):
    if decimal_number == 0:
        return 1 
    return math.ceil(math.log2(abs(decimal_number)))


def guessFunction(qc,n,shot):
    state = "0"*n;
    counts = execute(qc, S_simulator, shots=shot).result().get_counts()
    print(qc.draw())
    print("counts : ",counts)
    if counts.get(state, 0) > shot/ 2:
        print("Given Function is constant")
    else:
        print("Given Function is balanced")

def main():
    n = getQubitNumber()
    shot = 1000
    qr = QuantumRegister(n + 1)
    cr = ClassicalRegister(n)
    qc = QuantumCircuit(qr, cr)

    # Initial Configuraiton
    qc.h(qr[0:n])
    qc.x(qr[n])
    qc.h(qr[n])
    
    # setting oracle 
    selected_qc = getOracle(getChoice(),n) 
    qc.barrier()
    qc.append(selected_qc.to_instruction(), qr)
    qc.barrier()

    # output configuration
    qc.h(qr[0:n])
    qc.measure(qr[:n],cr)

    guessFunction(qc,n,shot) 


if __name__ == "__main__":
    main()