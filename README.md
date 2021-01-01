# Progetto-Chalet

> "Progetto-Chalet" è un programma si occupa della gestione di uno stabilimento balneare dal punto di vista del Cliente e del Proprietario.
> Effettuando l'accesso come cliente con il proprio account si ha la possibilità di prenotare: eventi, posti ombrelloni, tavoli per il ristorante oppure
> consultare semplicemente le condizioni metereologiche o la situazione della spiaggia.
> L'account "Proprietario" oltre a poter utilizzare le stesse operazioni del "Cliente" ha accesso a funzioni specifiche per la gestione del proprio chalet.

***

## Chiamate Postman Cliente

TIPO |ROTTA|DESCRIZIONE
------ | ------|----------
POST|/creaAccount|Crea un account personale inserendo username e password
POST|/login|Accedi al tuo account inserendo username e password
GET|/previsioni|Visualizza le condizioni metereologiche
POST|/prenota|Ti permette di prenotare eventi, tavoli o attrezzature per la balneazione inserendo la richiesta e il nome a cui intestare la prenotazione
POST|/prenotaOmbrellone|Per prenotare un posto ombrellone inserendo il posto e il nome a cui intestare la prenotazione
GET|/vini|Restituisce la lista dei vini

## Chiamate Postman Proprietario

TIPO |ROTTA|DESCRIZIONE
------ | ------|----------
POST|/listaAccount|Visualizza a schermo tutti gli account presenti nel server
POST|/creaEvento|Creare gli eventi inserendo la descrizione e l'orario
POST|/creaSpiaggia|Creazione di una spiaggia inserendo le righe e le colonne degli ombrelloni
GET|/chalet|Visualizza a schermo tutte le informazioni utili dello chalet
POST|/cambiaVino|Permette di modificare i prezzi dei vini

- ## Use Case Diagram
  
  - ### Cliente
  
  <div align="center"><img src="https://raw.githubusercontent.com/Luca-Marcianesi/Progetto-chalet/master/img/Cliente.jpg" width="500" height="500" ></div>
     
     
  - ### Proprietario
  <div align="center"><img src="https://raw.githubusercontent.com/Luca-Marcianesi/Progetto-chalet/master/img/Proprietario.jpg" width="500" height="500" ></div>

     
- ## Use Class Diagram
  <div align="center"><img src="https://raw.githubusercontent.com/Luca-Marcianesi/Progetto-chalet/master/img/Uso%20delle%20classi%20Class%20Diagram.jpg" width="600" height="400" ></div>
  
     
- ## Sequence Diagram

  - ### Cliente
  <div align="center"><img src="https://raw.githubusercontent.com/Luca-Marcianesi/Progetto-chalet/master/img/Diagramma%20delle%20sequenze%20Cliente.jpg" width="600" height="400" ></div>
  

  - ### Proprietario
  <div align="center"><img src="https://raw.githubusercontent.com/Luca-Marcianesi/Progetto-chalet/master/img/diagramma%20delle%20sequenze%20Proprietario.jpg" width="600" height="400" ></div>


*** 
