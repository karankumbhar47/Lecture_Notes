import warnings
from qiskit import ClassicalRegister, QuantumCircuit, QuantumRegister, execute
from qiskit_aer import Aer
S_simulator = Aer.backends(name="statevector_simulator")[0]
M_simulator = Aer.backends(name="qasm_simulator")[0]
warnings.filterwarnings("ignore")

def integer_to_binary(n):
    binary_string = bin(n)[2:]
    return binary_string

def set_input(numStr,qc,qr):
    for i in range(len(numStr)):
        if numStr[i]=="0":
           qc.id(qr[i]) 
        else:
            qc.x(qr[i])
    return qc,qr

def set_trash(y,qc,qr,n):
    if(y==1):
        qc.x(qr[n])
    else:
        qc.id(qr[n])
    return qc

def getInput():
    x = -1
    while(x<0):
        x = int(input("Enter the positive integer number for input(x) : ")) 
    y = -1
    while(y not in [0,1]):
        y = int(input("Enter the one bit number for trash bit(0,1) : ")) 
    return x,y 


def getChoice():
    while True:
        print("Select one of following functions ")
        print("\t1. Constant 0 function")
        print("\t2. Constant 1 function")
        print("\t3. Balanced function\n ")

        choice = int(input())
        if(choice>=1 and choice<=3):
            break
        else:
            print("Choose the correct choice")
    return choice

def constant_0(x,y):
    '''
    Parameters:
    x: Input n bit number.
    y: trash 1 bit number.

    Returns:
    output will be x and y^f(x),
    for constant 0 function
    '''
    numStr = integer_to_binary(x)
    n = len(numStr)
    qr = QuantumRegister(n+1)
    cr = ClassicalRegister(n+1)
    qc = QuantumCircuit(qr,cr,name="qc")

    qc,qr = set_input(numStr,qc,qr)
    qc = set_trash(y,qc,qr,n)
    qc.barrier()
    
    # oracacle will return as it
    qrOracle = QuantumRegister(n+1,name="qr")
    qcOracle = QuantumCircuit(qrOracle,name="Constant_0") 
    qc.append(qcOracle.to_instruction(), qr)
    qc.barrier()

    # measurement
    qc.measure(qr,cr)
    counts = execute(qc, S_simulator).result().get_counts()
    
    print("x at output is as follows\n",counts)
    print("Circuit diagram for constant 0\n")
    print(qc.draw())
    print("\n")


def constant_1(x,y):
    '''
    Parameters:
    x: Input n bit number.
    y: trash 1 bit number.

    Returns:
    output will be x and y^f(x),
    for constant 1 function
    '''
    numStr = integer_to_binary(x)
    n = len(numStr)
    qr = QuantumRegister(n+1)
    cr = ClassicalRegister(n+1)
    qc = QuantumCircuit(qr,cr,name="qc")

    qc,qr = set_input(numStr,qc,qr)
    qc = set_trash(y,qc,qr,n)
    qc.barrier()
    
    # oracacle will return as it
    qrOracle = qr 
    qcOracle = QuantumCircuit(qrOracle,name="Constant_1") 
    qcOracle.x(qrOracle[n])
    qc.append(qcOracle.to_instruction(), qr)
    qc.barrier()

    # measurement
    qc.measure(qr,cr)
    counts = execute(qc, S_simulator).result().get_counts()
    print("Counts are as follows\n",counts)
    print("Circuit diagram for constant 1\n")
    print(qc.draw())
    print("\n")

    
def balanced(x,y):
    '''
    Parameters:
    x: Input n bit number.
    y: trash 1 bit number.

    Returns:
    output will be x and y^f(x),
    for balanced function
    here balance function is as follows
    for 2 bit number ==> 
    x   f(x)
    0   0
    1   1
    2   0
    3   1
    '''
    numStr = integer_to_binary(x)
    n = len(numStr)
    qr = QuantumRegister(n+1)
    cr = ClassicalRegister(n+1)
    qc = QuantumCircuit(qr,cr,name="qc")

    qc,qr = set_input(numStr,qc,qr)
    qc = set_trash(y,qc,qr,n)
    qc.barrier()
    
    # oracacle will return as it
    qrOracle = qr 
    qcOracle = QuantumCircuit(qrOracle,name="Balanced") 
    qcOracle.cx(qrOracle[n-1],qrOracle[n])
    qc.append(qcOracle.to_instruction(), qr)
    qc.barrier()

    # measurement
    qc.measure(qr,cr)
    counts = execute(qc, S_simulator).result().get_counts()
    print("Counts are as follows\n",counts)
    print("Circuit diagram for balanced\n")
    print(qc.draw())
    print("\n")

def main():
    while(True):
        c = getChoice()
        x,y = getInput()
        if(c==1):
            constant_0(x,y)
        elif c==2:
            constant_1(x,y)
        elif c==3:
            balanced(x,y)

if __name__=="__main__":
    main()



     

    
