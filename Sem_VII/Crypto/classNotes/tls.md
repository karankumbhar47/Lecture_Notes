### TLS 1.2

-   handshake working

    ```md
    Client Server
    | hello -------------------------------> |
    | |
    | <--------------------------- hello , |
    | certificate, |  
     | key Exchange |  
     | (public key) |  
     | done |  
     | session key (encryption key) --------> |  
     | encrypted with public key, |  
     | cipher spec, |  
     | finish |  
     | |  
     | <---------------------------- spec change,|  
     | finish |  
     | |  
     | <---- symmetric encryption start ----> |
    ```

-   2RTT (for handshake)
-   slower and insecure
    (if get private key of server then able to decrypt all server messages) than tls1.3
-   use RSA(for key exchange)

### TLS 1.3

-   one pass to change the key
-   not use RSA
-   use diffie-hellman(for key exchange)
-   here main symmetric key is made by three element
    -   private key of client
    -   public key of client
    -   private key of server
-   here public things are(which is okay to publish)
    -   public key of client
    -   private key of client + public key of client (unbreakable)
    -   private key of server + public key of client (unbreakable)
-   here private things are

    -   private key of server
    -   private key of client

-   1 RTT ~ 0 RTT
-   it works as follows
    ```md
    Client Server
    | key Exchange ----------------------> |  
     | (public key) |  
     | (public +private key) |  
     | change cipher spec |  
     | clinet done |  
     | |
    | <-------------------------- hello , |  
     | certificate, |  
     | (private key + |  
     | public key[client]) |  
     | Server done |  
     | |
    | <---- symmetric encryption start ----> |
    ```

### Symmetric Algorithms

-   AES

### Asymmetric Algorithms

-   RSA

### Auth

-   certificate(can be issued by organisation using our public key)
-   certificate fingerprint (authority check)
-   different format
    -   PEM(web,email)[base64] --> .pem .crt .cer
    -   DER(java)[binary] --> .der .cer
    -   PKCS#7(certificate chain)[binary+base64] --> .p7b, .p77c
    -   PKCS#12(export,import)[binary] --> .p12, .pfx
-   expiray

### Hashing

-   hash of (message + secret key)
-   send both hash and message
-   even hanker change hash and message
-   will be identified easily with secret key
-   MD5, SHA (1,2,3,224,256,384,512)

### TLS

-   SSL is successor of TLS
-   deprecated from 2015
-   also share wihch protocol to use beweeen server
    and client in certificate
-   TLS and SSL are not interoperable

### Questions

-   what is certificate chain
