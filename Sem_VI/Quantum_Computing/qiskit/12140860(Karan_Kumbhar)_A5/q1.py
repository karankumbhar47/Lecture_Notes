# imports

import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]

# Utility functions
def setInput(x,y,z,w):
    qc.x(qr[0]) if x==1 else qc.id(qr[0])
    qc.x(qr[1]) if y==2 else qc.id(qr[1])
    qc.x(qr[3]) if z==3 else qc.id(qr[3])
    qc.x(qr[4]) if w==4 else qc.id(qr[4])
    qc.id(qr[2])

def getData(qc):
    S_array = np.array(execute(qc,S_simulator).result().get_statevector())
    index = np.argmax(np.abs(S_array))
    output = str(format(index, '05b'))
    return output[4], output[3], output[2], output[1], output[0]


# testing 3-toffoli gate for input (x=1,y=1,z=1,w=1) 
qr = QuantumRegister(5,name="qr")
qc = QuantumCircuit(qr,name="qc")

print('''
qr[0] = "x"
qr[1] = "y"
qr[2] = "0"
qr[3] = "z"
qr[1] = "w"
''')

setInput(x=1,y=1,z=1,w=1)

qc.ccx(qr[0],qr[1],qr[2])
qc.ccx(qr[2],qr[3],qr[4])
qc.ccx(qr[0],qr[1],qr[2])

print(qc.draw())
x_output,y_output,zero_output,z_output,w_output = getData(qc)


# checking output for all inputs
qc.clear()
print("input   => output")
print("x y z w => x y z w")
for x in 0,1:
    for y in 0,1:
        for z in 0,1:
            for w in 0,1:
                qr = QuantumRegister(5)
                qc = QuantumCircuit(qr)

                qc.x(qr[0]) if x==1 else qc.id(qr[0])
                qc.x(qr[1]) if y==1 else qc.id(qr[1])
                qc.x(qr[3]) if z==1 else qc.id(qr[3])
                qc.x(qr[4]) if w==1 else qc.id(qr[4])
                qc.id(qr[2])

                qc.ccx(qr[0],qr[1],qr[2])
                qc.ccx(qr[2],qr[3],qr[4])
                qc.ccx(qr[0],qr[1],qr[2])

                _x,_y,_zero,_z,_w = getData(qc)
                print(x,y,z,w, "=>", _x,_y,_z,_w)
                # print(qc.draw())
                qc.clear()
