# AzurImmo

AzurImmo est une application Spring Boot pour gérer des bâtiments et leurs appartements.  
Elle permet de récupérer des informations sur les bâtiments et les appartements via une API REST.

---

## Fonctionnalités

- Gestion des bâtiments (`Batiment`) : adresse, ville, liste des appartements.  
- Gestion des appartements (`Appartement`) : numéro, description, surface.  
- Mappers pour convertir entre les entités JPA et les DTO.  
- API REST pour récupérer les bâtiments et leurs appartements.

---

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Lombok
- Base de données H2 (ou autre base compatible JPA)
- Git & GitHub

---

## Structure du projet

src/main/java
├── bts.sio.azurimmo
│ ├── controller
│ │ └── BatimentController.java
│ ├── model
│ │ ├── Appartement.java
│ │ └── Batiment.java
│ ├── model/dto
│ │ ├── AppartementDTO.java
│ │ └── BatimentDTO.java
│ ├── model/mapper
│ │ ├── AppartementMapper.java
│ │ └── BatimentMapper.java
│ ├── repository
│ │ ├── AppartementRepository.java
│ │ └── BatimentRepository.java
│ └── service
│ └── BatimentService.java
└── resources
└── application.properties


---

## Installation & exécution

1. Cloner le repository :  
```bash
git clone https://github.com/tonNomUtilisateur/AzurImmo.git

