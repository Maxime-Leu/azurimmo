# Azurimmo — API de gestion immobilière

Azurimmo est une application backend Spring Boot permettant de gérer un parc immobilier: bâtiments, appartements, locataires, contrats et paiements. Le projet expose une API REST documentée via OpenAPI/Swagger et persiste les données dans une base MariaDB.

Cette documentation couvre l’installation, la configuration, l’exécution et un aperçu des endpoints disponibles.

## Sommaire
- Présentation du projet
- Stack technique
- Prérequis
- Installation et configuration
- Lancer l’application
- Documentation API (Swagger/OpenAPI)
- Endpoints principaux
- Postman et Trello
- Structure du projet
- Commandes Maven utiles
- Dépannage

---

## Présentation du projet
Application de gestion immobilière permettant:
- de créer et lister des bâtiments et appartements
- de gérer les locataires
- de créer et consulter des contrats de location
- de suivre les paiements

## Stack technique
- Java 21
- Spring Boot 3.4.1 (Web, Data JPA)
- MariaDB (driver `org.mariadb.jdbc:mariadb-java-client`)
- Lombok (pour réduire le boilerplate)
- springdoc-openapi-starter-webmvc-ui (Swagger UI)
- Maven

## Prérequis
- Java 21 installé (`java -version`)
- Maven 3.9+ (optionnel si vous utilisez le wrapper `mvnw`/`mvnw.cmd`)
- MariaDB accessible (local ou distante)

## Installation et configuration
1) Cloner le dépôt puis se placer à la racine du projet.
2) Configurer la base de données dans `src/main/resources/application.properties`:

```
server.port=9008

# MariaDB
spring.datasource.url=jdbc:mariadb://localhost:3307/azurimmo
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

Notes:
- Ajustez l’URL, l’utilisateur et le mot de passe selon votre environnement.
- `ddl-auto=update` crée/alter les tables au démarrage (à adapter en production).

## Lancer l’application
- Avec Maven (wrapper Windows):
```
./mvnw.cmd spring-boot:run
```

- Avec Maven (installé):
```
mvn spring-boot:run
```

Une fois démarrée, l’API est disponible sur: `http://localhost:9008`.

## Documentation API (Swagger/OpenAPI)
Le projet inclut springdoc OpenAPI. Accès à la documentation interactive:
- Swagger UI: `http://localhost:9008/swagger-ui.html`
- Spécification OpenAPI (JSON): `http://localhost:9008/v3/api-docs`

## Endpoints principaux
Préfixe commun: `/api`

### Bâtiments (`/api/batiments`)
- `GET /` — Lister tous les bâtiments
- `POST /` — Créer un bâtiment (body: `BatimentDTO`)
- `GET /{batimentId}` — Consulter un bâtiment par ID

### Appartements (`/api/appartements`)
- `POST /` — Créer un appartement (body: `Appartement`)
- `GET /ville/{ville}` — Lister les appartements d’une ville
- `GET /batiment/{batimentId}` — Lister les appartements d’un bâtiment
- `GET /surfaceGreaterThan/{surface}` — Lister les appartements avec surface > valeur

### Contrats (`/api/contrats`)
- `GET /` — Lister tous les contrats
- `POST /` — Créer un contrat (body: `Contrat`)
- `GET /{contratId}` — Consulter un contrat par ID
- `GET /appartement/{appartementId}` — Lister les contrats d’un appartement

### Locataires (`/api/locataires`)
- `GET /` — Lister tous les locataires
- `POST /` — Créer un locataire (body: `Locataire`)
- `GET /{locataireId}` — Consulter un locataire par ID
- `GET /contrat/{contratId}` — Lister les locataires d’un contrat

### Paiements (`/api/paiements`)
- `GET /` — Lister tous les paiements
- `POST /` — Créer un paiement (body: `Paiement`)
- `GET /{paiementId}` — Consulter un paiement par ID
- `GET /contrat/{contratId}` — Lister les paiements d’un contrat

## Postman et Trello
- Les endpoints sont organisés dans une collection Postman pour faciliter les tests et la découverte de l’API. Importez la collection depuis votre espace de travail Postman (voir dossier/documentation de l’équipe). Si nécessaire, demandez l’accès au propriétaire du projet.
- La gestion de projet est suivie sur Trello (tableau Kanban: backlog, en cours, terminé). Les cartes Trello référencent les fonctionnalités, bugs et évolutions planifiées.

## Structure du projet
```
azurimmo/
├─ pom.xml
├─ src/main/java/bts/sio/azurimmo/
│  ├─ AzurimmoApplication.java
│  ├─ controller/ (REST controllers)
│  ├─ dto/ (objets de transfert)
│  ├─ mapper/ (mapping entités ↔ DTO)
│  ├─ model/ (entités JPA)
│  ├─ repository/ (Spring Data JPA)
│  └─ service/ (logique métier)
├─ src/main/resources/application.properties
└─ src/test/java/... (tests)
```

## Commandes Maven utiles
- Compiler: `mvn clean compile`
- Tests: `mvn test`
- Lancer l’app: `mvn spring-boot:run`
- Construire le JAR: `mvn clean package`

## Dépannage
- Erreur de connexion DB: vérifiez `spring.datasource.*` et la disponibilité de MariaDB.
- Port occupé: modifiez `server.port` dans `application.properties`.
- Lombok: assurez-vous que le plugin Lombok est activé dans votre IDE et que l’annotation processing est activée.

---

© Azurimmo — Projet de gestion immobilière.