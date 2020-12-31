# Progetto-Chalet

> "Progetto-Chalet" è un programma si occupa della gestione di uno stabilimento balneare dal punto di vista del Cliente e del Proprietario.
> Effettuando l'accesso come cliente con il proprio account si ha la possibilità di prenotare: eventi, posti ombrelloni, tavoli per il ristorante oppure
> consultare semplicemente le condizioni metereologiche o la situazione della spiaggia.
> L'account "Proprietario" oltre a poter utilizzare le stesse operazioni del "Cliente" ha accesso a funzioni specifiche per la gestione del proprio chalet.

***

## Chiamate Postman

TIPO |ROTTA|DESCRIZIONE
------ | ------|----------
POST|/creaAccount|Crea un account personale inserendo username e password
POST|/login|Accedi al tuo account inserendo username e password
GET|/previsioni|Visualizza le condizioni metereologiche
POST|/prenota|Ti permette di prenotare eventi, tavoli o attrezzature per la balneazione inserendo la richiesta e il nome a cui intestare la prenotazione
POST|/prenotaOmbrellone|Per prenotare un posto ombrellone inserendo il posto e il nome a cui intestare la prenotazione

- ## Use Case Diagram
  - ### Cliente 
     <img src="https://raw.githubusercontent.com/Diego-Mignani/imgdatabase/main/Client.jpg?token=AR2C3IEFKKO36EFZO3GZKA275X2MQ" width="500" height="500">
  
  - ### Proprietario
     <img src="https://raw.githubusercontent.com/Diego-Mignani/imgdatabase/main/Owner.jpg?token=AR2C3IAAZA3LMDB4WVGPSGK75X2OG" width="500" height="500">
     
- ## Use Class Diagram
     <img src="https://raw.githubusercontent.com/Diego-Mignani/imgdatabase/main/Uso%20delle%20classi%20Class%20Diagram2.jpg?token=AR2C3IDIANAYEPFMXRSOCC275X2YI" width="500" height="500">
     
- ## Sequence Diagram
  - ### Cliente
     <img src="https://raw.githubusercontent.com/Diego-Mignani/imgdatabase/main/Diagramma%20delle%20sequenze%20Cliente.jpg?token=AR2C3IBZAGBCZE7BPSPK6XK75X25U" width="500" height="500">

  - ### Proprietario
      <img src="https://raw.githubusercontent.com/Diego-Mignani/imgdatabase/main/Uso%20delle%20classi%20Sequence%20Diagram%20Proprietario.jpg?token=AR2C3IFBVDSYTH5CGCVXI7C75X27Y" width="500" height="500">

*** 
