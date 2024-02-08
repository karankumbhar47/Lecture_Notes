from qiskit import QuantumCircuit, QuantumRegister, ClassicalRegister, execute, Aer

S_simulator = Aer.backends(name='statevector_simulator')[0]
M_simulator = Aer.backends(name='qasm_simulator')[0]

'''
using hadamard gate to for getting super position 
of both state |0> and |1> 

using classical register to get classical state 
correspoding to this 

using codition of getting zero in output of calssical  
state(using measure function) as getting head for 
quantum coin and vice versa  

'''
def tossQuantumCoin():
    q = QuantumRegister(1)
    c = ClassicalRegister(1)

    qc = QuantumCircuit(q,c)
    qc.h(q[0])

    qc.measure(q,c)
    dict = execute(qc, M_simulator,shots=1).result().get_counts(qc)

    return list(dict.keys())[0] == '0'


# Tossing coin for 10 times to get random output
print("\nTossing Quantum Coin 10 times\n ")

for i in range(10):
    if tossQuantumCoin():
        print(f"Output for {i+1} event ==> head")
    else:
        print(f"Output for {i+1} event ==> tail")