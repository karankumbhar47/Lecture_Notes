from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
from qiskit import ClassicalRegister
from qiskit.tools.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]



# circuit to draw
def reverseCNot(state):
    qr = QuantumRegister(2)
    cr = ClassicalRegister(2)
    qc = QuantumCircuit(qr, cr)

    # Apply initial state
    if state[0] == '1':
        qc.x(qr[0])
    else:
        qc.id(qr[0])
    if state[1] == '1':
        qc.x(qr[1])
    else:
        qc.id(qr[1])
        
    # Apply Hadamard gates
    qc.h(qr[0])
    qc.h(qr[1])

    # Apply CNOT gate
    qc.cx(qr[0], qr[1])

    # Apply final Hadamard gates
    qc.h(qr[0])
    qc.h(qr[1])

    # Measure
    qc.measure(qr, cr)

    # Execute and print results
    result = execute(qc, M_simulator).result().get_counts(qc)
    print(f"Input State :  {state}")
    print(f"Output State:  {list(result.keys())[0][::-1]}")
    print(qc.draw())


if __name__=="__main__":
    states = {'00','01','10','11'}
    for state in states:
        print('\n=================================================\n')
        reverseCNot(state)
        print('\n=================================================\n')
    print('''
Observing input and output we can say that,
whole circuit is acting like cNot gate where 
fist bit is target bit and second bit is control bit''')