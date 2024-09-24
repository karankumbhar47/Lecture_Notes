### image enhancing in frequency domain
- spatial --> descrite img transform , conv, courier transofrm   
- frequency --> input image to freq domain, conv--> mult 
- img -> couier transform -> mulitply with feature --> muliply with co-efficient 
- inverse courier transform

- process
    - fourier then muliply with filter 
    - low pass (allow low freq)
    - high pass

### Ideal low pass filter
- allow freq below D_0 if more not allowed
- D_0 is cutoff frequency
- distance in frequency domain 
    - $D(u,v) = [(u-P/2)^2 + (u-Q/2)^2]$
- low cut off freq --> blur

### butterworth lowpass filters
- n = order of pixel 
- order high = ideal low pass filter
- $H(u,v) = \frac{1}{1+[D(u,v)/D_0]^{2*n}}$ 

### Gaussian low pass filter
- $H(u,v) = e^{\frac{-D^{2}(u,v)}{2*D_0^{2}}}$

### homomorphic filtering
- $f(x,y) = i(x,y)r(x,y)$
- illumination coeff --> i(x,y)
- reflection coeff. --> r(x,y)
- path 
- $f(x,y) -> log -> DFT(fourier) -> H(u,v) -> DFT^{-1} -> exp -> g(x,y)$
- $H(u,v) = (gamma_H-gamma_L)[1 - e^{\frac{-D^{2}(u,v)}{2*D_0^{2}}}] + gamma_L  $
