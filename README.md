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

## Teknologji të përdorura

* Java JDK 8+  
* Diffie-Hellman (DH) për shkëmbimin e çelësave  
* AES për enkriptim simetrik  
* Socket TCP për komunikim rrjetor  

## Kujdes dhe vërejtje

* AES përdor modin default (ECB) që nuk është i rekomanduar për përdorim prodhues.  
* Protokolli nuk përfshin autentifikim ose integritet të mesazheve, prandaj duhet përmirësuar për përdorim real.  
* Ky është një projekt mësimor për konceptin e komunikimit të koduar.
