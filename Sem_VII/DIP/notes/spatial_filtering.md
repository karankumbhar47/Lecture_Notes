### img neagtive
- done pixel wise
- individual pixel

### Spatial Filtering
- remove noise  
- remove blur
- $ g(x,y) = \sum_{s=-a}^{a} \sum_{t=-b}^{b} w(s,t) f(x+s ,y+t) $
- working with neighbour
- 0 padding
- feature extraction

### Spatial Convolution
- $ w(x,y) \times f(x,y) = \sum_{s=-a}^{a} \sum_{t=-b}^{b} w(s,t) f(x+s ,y+t)  $
- filter 
- $\frac{m - k + 2*p}{s} + 1 $ 
- p = padding[0], s = stride[1], k=filter size[3],M = matrix size[6]
$$
\begin{pmatrix}
  1 & 2 & 3 \\
  4 & 5 & 6 \\
  7 & 8 & 9
\end{pmatrix}
$$

| 1 | 0 | -1 |
| 1 | 0 | -1 |
| 1 | 0 | -1 |

### Smoothing Spatial Filter
- weighted average
- matrix of 3x3 with 1/9 