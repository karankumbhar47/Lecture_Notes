from qiskit import ClassicalRegister, QuantumCircuit, QuantumRegister
from qiskit import execute, Aer

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

# Bernstein-Vazirani Algorithm
def getQubitNumber():
    n = 2 
    while True:
        n = int(input("Enter the number of Qubits\n"))
        if(n>1):
            break
        else:
            print("Not valid number for Qubits")
    return n

def takeSInput(n):
    s = [2 for _ in range(n)]
    for i in range(n):
        s[i] = 2 
        arr = [0,1]
        while s[i] not in arr:
            try:
                s[i] = int(input(f"value for s[{i}] --> "))
            except Exception:
                s[i] = 2
    return s

def getOracle(s,n):
    input = QuantumRegister(n, name="x")
    output = QuantumRegister(1, name="y")
    qc = QuantumCircuit(input,output, name="Oracle")
    for i in range(n):
        if s[i] == 1:
            qc.cx(input[i], output)
    return qc 

def getSstring(qc,shot):
    counts = execute(qc, S_simulator, shots=shot).result().get_counts()
    print(counts)

    S_value = 0
    MaxCount = 0
    for value, count in counts.items():
        if count > MaxCount:
            MaxCount = count 
            S_value = value 

    print("Value for string S is ",S_value)


def main():
    shot = 1000
    n = getQubitNumber()
    qr = QuantumRegister(n+1)
    cr = ClassicalRegister(n)
    qc = QuantumCircuit(qr, cr)

    # initial configuration 
    qc.h(qr[0:n])
    qc.x(qr[n])
    qc.h(qr[n])

    # Oracle
    qc.barrier()
    oracleCircuit = getOracle(takeSInput(n),n)
    qc.append(oracleCircuit.to_instruction(), qr)

    # outpuput configuration
    qc.barrier()
    qc.h(qr[0:n])

    # Measure the output
    qc.barrier()
    qc.measure(qr[0:n], cr)
    print(qc.draw())

    getSstring(qc,shot)

if __name__ == "__main__":
    main()
