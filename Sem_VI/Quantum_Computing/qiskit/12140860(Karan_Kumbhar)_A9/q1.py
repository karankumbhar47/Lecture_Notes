import math
import warnings
import qiskit
from qiskit import QuantumCircuit,Aer
from qiskit.circuit.library import GroverOperator, MCMT, ZGate
warnings.filterwarnings("ignore")

S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

def getOracle(solutionState):
    if not isinstance(solutionState, list):
        solutionState = [solutionState]
    num_qubits = len(solutionState[0])

    qc = QuantumCircuit(num_qubits)
    try:
        for target in solutionState:
            getTarget = target[::-1]
            zeroIndexNum = [i for i in range(num_qubits) if getTarget.startswith("0", i)]
            qc.x(zeroIndexNum)
            qc.compose(MCMT(ZGate(), num_qubits - 1, 1), inplace=True)
            qc.x(zeroIndexNum)
    except Exception as e:
        print(e)
    return qc

def getCircuit(solutionState):
    oracle = getOracle(solutionState)
    operator = GroverOperator(oracle)
    iteration = math.floor(
        math.pi / (4 * math.asin(math.sqrt(1 / 2**operator.num_qubits)))
    )
    qc = QuantumCircuit(operator.num_qubits)
    qc.h(range(operator.num_qubits))
    qc.compose(operator.power(iteration), inplace=True)
    qc.measure_all()
    return qc

def main():
    state = input("Enter the binary state: ")
    state = "0"+state
    solutionStates = [state]
    print("Solution State is : ", state)

    gc = getCircuit(solutionStates)
    print("Circuit Diagram :")
    print(gc.draw())
    
    counts = qiskit.execute(gc, S_simulator, shots=1024).result().get_counts()
    print("Measurement outcomes:", counts)

if __name__ == "__main__":
    main()
