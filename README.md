# Secure-Instant-Messaging-Protocol_Gr13

Ky projekt implementon një **protokoll të sigurt për mesazhe instant** në Java, duke përdorur shkëmbimin e çelësave Diffie-Hellman (DH) për krijimin e një çelësi sekret të përbashkët dhe enkriptimin simetrik AES për mesazhet.

## Përshkrimi

* **Shkëmbimi i çelësave:** Serveri dhe klienti përdorin DH për të krijuar një sekret të përbashkët pa e transmetuar atë drejtpërdrejt në rrjet.  
* **Enkriptimi:** Mesazhet komunikohen të enkriptuara me AES bazuar në sekretin e përbashkët.  
* **Komunikimi:** Klienti dhe serveri dërgojnë dhe marrin mesazhe nëpërmjet socket-ve TCP në mënyrë të sigurt.

## Strukturë e projektit

* **CryptoUtils.java** — Mjetet për DH dhe AES  
* **Server.java** — Serveri i komunikimit të sigurt  
* **Client.java** — Klienti për komunikim të sigurt

## Udhezime per perdorim
* 1. Kompilojmë të gjitha klasat: 
javac SecureChat/*.java
* 2. Starto serverin
java SecureChat.Server
* 3. Në një terminal tjetër, starto klientin
java SecureChat.Client

## Teknologji të përdorura
* Java JDK 8+  
* Diffie-Hellman (DH) për shkëmbimin e çelësave  
* AES për enkriptim simetrik  
* Socket TCP për komunikim rrjetor  

## Punuan: 
Studentët e Grupit 13 në kuadër të lëndës së Sigurisë së të Dhënave.
Universiteti i Prishtinës – Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike
