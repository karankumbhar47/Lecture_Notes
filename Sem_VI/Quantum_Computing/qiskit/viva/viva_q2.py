# Find the unitary matrix 

import math
import numpy as np

numRoot2 = 1/math.sqrt(2)

h = [[numRoot2,numRoot2],[numRoot2,-numRoot2]]
z = [[1,0],[0,-1]]
cz = [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,-1]]
twoZ = np.kron(z,z)
twoH = np.kron(h,h)

print("\n\nstate 1 is : \n",twoH)
state2 = np.dot(twoZ,twoH)
print("\n\nstate 2 is : \n",state2)
state3 = np.dot(cz,state2)
print("\n\nstate 3 is : \n",state3)
state4 = np.dot(twoH,state3)
print("\n\nstate 4 is : \n",state4)
