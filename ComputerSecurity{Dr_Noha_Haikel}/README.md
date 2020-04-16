# In The Name Of ALLAH 
## Computer Security

|Week| Download|
|:---|:---|
|Week 6|[![](https://img.shields.io/badge/Computer%20Security%20-Lec%206%20Pdf-green)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_ITIS_Computer%20Security_Week06_%20Noha%20Hikal_Lec.pptx.pdf)|
|Week 7|[![](https://img.shields.io/badge/Computer%20Security%20-Lec%207%20Pdf-green)]()</br>[![](https://img.shields.io/badge/Computer%20Security%20-Lec%207%20ppsx-red)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_ITIS_Computer%20Security_Week07_%20Noha%20Hikal_Lec.ppsx)|
|Week 8|[![](https://img.shields.io/badge/Computer%20Security%20-Lec%208%20Pdf-green)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_IT-IS_week08_NOHA-HIKAL_lect.pdf)</br>[![](https://img.shields.io/badge/Computer%20Security%20-Lec%208%20ppsx-red)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_IT-IS_week08_NOHA-HIKAL_lect.ppsx)|
|Week 9|[![](https://img.shields.io/badge/Computer%20Security%20-Lec%209%20Pdf-green)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_IT-IS_week09_NOHA-HIKAL_lect.pdf)</br>[![](https://img.shields.io/badge/Computer%20Security%20-Lec%209%20ppsx-red)](https://github.com/mansoura-cis/4th_Grade_IS-Master-/raw/master/ComputerSecurity%7BDr_Noha_Haikel%7D/Lectures/FCI_IT-IS_week09_NOHA-HIKAL_lect.ppsx)|

## Week 6

### Content
- Asymetric Cryptography 
- Key management


### pLaintext processed

- Stream
    - encrypts and decrypts the text by taking the one byte of the text at a time.

- Block 
    - encrypts and decrypts a block of the text at a time


### Symmetric vs Asymmetric cryptography
|Symmetric (Private Key Crypto)| Asymmetric (Public Key Crypto)|
|:-|:-|
|Using one key (Private Key, Secret Key)| Using 2 Keys {Public and the private key}|
|Key must be secret to save authunticity, It's good when you need to keep your data secret from other people but when __Distribution__ is a big problem |Imagine that Bob and alice need to share data Bob uses the  Alice {Public Key } to encrypt thr data that can't be decrypted without Alice private key, Private key not shared so it's more secure|
|problem : Exchanging or Distribution of Key, The Equation where you must share the key to # of people __$\frac{n(n-1)}{2}$__ people | Problem : The Key management|

