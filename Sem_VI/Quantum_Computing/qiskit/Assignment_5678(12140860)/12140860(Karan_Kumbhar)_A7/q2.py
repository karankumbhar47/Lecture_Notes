import numpy as np
from qiskit import QuantumRegister, QuantumCircuit, Aer, execute,ClassicalRegister
from qiskit.circuit.library import UGate
from qiskit.visualization import circuit_drawer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
seperator   = "\n=============================================================================\n"
sep         = "\n-----------------------------------------------------------------------------\n"


def constFun_0(qc,qr,input=None):
    qc.barrier()
    return qc,qr,0


def constFun_1(qc,qr,input=None):
    qc.x(qr[1])
    qc.barrier()

    return qc,qr,1

def balanceFun_ID(qc,qr,input=None):
    qc.x(qr[1])
    qc.cx(qr[0],qr[1])
    qc.barrier()
    
    return qc,qr,input 

def balanceFun_NOT(qc,qr,input=None):
    qc.cx(qr[0],qr[1])
    qc.barrier()
    
    if(input!=None):
        input = 1 - input
    return qc,qr,input

def runClasicalAlgo(f):
    qr = QuantumRegister(2)
    qc = QuantumCircuit(qr)

    print(seperator)
    _,_,value1 = f(qc,qr,0)
    _,_,value2 = f(qc,qr,1)

    print(f"Calculating Value for {f.__name__}(0) ==> {value1}\n")
    print(f"Calculating Value for {f.__name__}(1) ==> {value2}\n")

    if(value1==0):
        if(value2==0):
            print("So this is Constant Zero Function")
        else:
            print("So this is Balance Identity Function")
    else:
        if(value2==0):
            print("So this is Balance Not Function")
        else:
            print("So this is Constant One Function")

    
    print(seperator)


def runQuantumAlgo(f):
    print(seperator)
    print(f"Running algorithm for function : {f.__name__}\n")
    qr = QuantumRegister(2,name="qr")
    cr = ClassicalRegister(1,name="cr") 
    qc = QuantumCircuit(qr, cr)
    
    qc.x(qr[1])
    
    qc.h(qr[0])
    qc.h(qr[1])
    qc.barrier()
    
    qc,qr,_ = f(qc,qr)

    qc.h(qr[0])
    qc.barrier()
    
    qc.measure(qr[0],cr)
    M = execute(qc,M_simulator).result().get_counts(qc)
    print(f"counts are :- {M}\n")
    print(qc.draw())
    if(list(M.keys())[0]=="0"):
        print("This is Constant function\n")
    else:
        print("This is Balance function\n")

    print(seperator)

def quantumMethod():
    print(seperator)
    print(f"============================= Quantum Method ================================")
    print(seperator)
    while(True):
        print('''
Select one of the following function 
    1) Constant_0
    2) Constant_1
    3) Balance(Not)
    4) Balance(Identity)
    5) Display All
    6) Exit
        ''')

        inputChoice = int(input())
        if(inputChoice==1):
            runQuantumAlgo(constFun_0)
        if(inputChoice==2):
            runQuantumAlgo(constFun_1)
        if(inputChoice==3):
            runQuantumAlgo(balanceFun_NOT)
        if(inputChoice==4):
            runQuantumAlgo(balanceFun_ID)
        if(inputChoice==5):
            runQuantumAlgo(constFun_0)
            runQuantumAlgo(constFun_1)
            runQuantumAlgo(balanceFun_NOT)
            runQuantumAlgo(balanceFun_ID)
        if(inputChoice==6):
            break

def classicalMethod():
    print(seperator)
    print(f"=========================== Classical Method ================================")
    print(seperator)
    while(True):
        print('''
Select one of the following function 
    1) Constant_0
    2) Constant_1
    3) Balance(Not)
    4) Balance(Identity)
    5) Display All
    6) Exit
        ''')

        inputChoice = int(input())
        if(inputChoice==1):
            runClasicalAlgo(constFun_0)
        if(inputChoice==2):
            runClasicalAlgo(constFun_1)
        if(inputChoice==3):
            runClasicalAlgo(balanceFun_NOT)
        if(inputChoice==4):
            runClasicalAlgo(balanceFun_ID)
        if(inputChoice==5):
            runClasicalAlgo(constFun_0)
            runClasicalAlgo(constFun_1)
            runClasicalAlgo(balanceFun_NOT)
            runClasicalAlgo(balanceFun_ID)
        if(inputChoice==6):
            break

if __name__=="__main__":
    while(True):
        print(seperator)
        print('''
Select one of the following Way 
    1) Quantum
    2) Classical
    3) Exit
        ''')
        inputChoice = int(input())
        if(inputChoice==1):
            quantumMethod()
        if(inputChoice==2):
            classicalMethod()
        if(inputChoice==3):
            break
 
        print(seperator)