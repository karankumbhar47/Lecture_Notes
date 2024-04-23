from qiskit import ClassicalRegister, QuantumCircuit, QuantumRegister
from qiskit import  execute
import qiskit_aer
import warnings

warnings.filterwarnings("ignore")

S_simulator =  qiskit_aer.Aer.backends(name="statevector_simulator")[0]
M_simulator =  qiskit_aer.Aer.backends(name="qasm_simulator")[0]

# Simon's Algorithm


def getQubitNumber():
    n = 2
    while True:
        n = int(input("Enter the number of Qubits\n"))
        if (n > 1):
            break
        else:
            print("Not valid number for Qubits")
    return n


def getOracle(n, s):
    input = QuantumRegister(n, name="x")
    output = QuantumRegister(n, name="y")
    qc = QuantumCircuit(input, output, name="Oracle")

    for i in range(0, n):
        qc.cx(input[i], output[i])

    fixed = -1
    for i in range(n-1, -1, -1):
        index = n - i - 1
        if (s[i] == '1' and fixed == -1):
            fixed = index
        if (s[i] == '1' and fixed != -1):
            qc.cx(input[fixed], output[index])

    print(qc.draw())
    return qc


def main():
    shot = 1000
    n = getQubitNumber()
    s = input("Enter the key : ")
    qr = QuantumRegister(n*2)
    cr = ClassicalRegister(n)
    qc = QuantumCircuit(qr, cr)

    # initial configuration
    qc.h(qr[0:n])

    # Oracle
    qc.barrier()
    qc.append(getOracle(n, s).to_instruction(), qr)
    qc.barrier()

    # output configuration
    qc.h(qr[0:n])

    # Measure the output
    qc.measure(qr[0:n], cr)
    print(qc.draw())

    counts = execute(qc, S_simulator, shots=shot).result().get_counts()
    print("counts are as follows")
    print(counts)


if __name__ == "__main__":
    main()
