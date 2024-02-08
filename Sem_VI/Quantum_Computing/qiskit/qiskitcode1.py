from qiskit import *
from qiskit.tools.visualization import plot_histogram, plot_bloch_multivector
from qiskit.tools.visualization import plot_state_qsphere
from qiskit.quantum_info import Statevector
from qiskit.tools.monitor import job_monitor
from math import pi, sqrt
from qiskit import QuantumRegister, ClassicalRegister, QuantumCircuit, assemble, Aer

import numpy as np
import math as ma

def qasm_Simulator(circuit):
    simulator = Aer.get_backend('qasm_simulator')
    job = execute(circuit,backend=simulator,shots=1024)
    result = job.result()
    counts = result.get_counts()
    #print (counts)
    return counts
def Draw(circuit, qasm = 0):
    if(qasm == 0):
        print(circuit.draw(initial_state=True,  cregbundle=True))
    else:
        print(circuit.qasm())

q = QuantumRegister(2)
c = ClassicalRegister(2)
qc = QuantumCircuit(q,c)

qc.x(q[0])

qc.measure(q[0],c[0])
qc.measure(q[1],c[1])

Draw(qc)
QS = qasm_Simulator(qc)
print(QS)
