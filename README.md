

# Football Equipe  API

## Description

API Rest pour gérer l'équipe de football de Nice en Ligue 1. Cette API permet de lister les équipes avec des options de tri et de pagination, ainsi que d'ajouter des équipes avec ou sans joueurs associés.

## Prérequis

- Java 17

## Documentation et Guide d'Installation

### 7.1. Guide d'Installation

#### Cloner le dépôt :

```bash
git clone https://github.com//houssemhadhiri/football_app_test.git

cd football_app_test
```

#### Configurer la base de données MySQL :

Créez une base de données nommée `equipe_db` et mettez à jour le fichier `application.properties` avec vos informations d'identification MySQL.

#### Construire et exécuter l'application :

```bash
./mvnw spring-boot:run
```

### Tester les API :

- **Liste paginée et triée des équipes :**

```http
GET http://localhost:8080/api/equipe
```

- **Ajouter une équipe :**

```http
POST http://localhost:8080/api/equipe
Content-Type: application/json
{
  "name": "OGC Nice",
  "acronym": "OGCN",
  "budget": 1000000.00,
  "joueurs": [
    {"name": "Jean-Claude", "position": "Attacker"},
    {"name": "Michel", "position": "Defender"}
  ]
}
```

## Temps Passé

- **Analyse du projet** : 1h
- **Développement** : 4h
- **Tests unitaires et d'intégration** : 2h
- **Documentation et guide d'installation** : 1h
- **Total** : 8h

## Choix Techniques

- **Spring Boot** pour la structure de l'application.
- **Hibernate** pour la gestion de la persistance des données.
- **MySQL** comme base de données relationnelle.

## Architecture

L'application est structurée en couches :
- **Controller** : Gère les requêtes HTTP entrantes et renvoie les réponses.
- **Service** : Contient la logique métier de l'application.
- **Repository** : Interagit avec la base de données pour effectuer des opérations CRUD.

## Tests

Des tests unitaires et d'intégration ont été écrits pour assurer la fiabilité de l'application. Ils couvrent les différentes couches de l'application.


## Licence

Distribué sous la licence MIT. Voir `LICENSE` pour plus d'informations.

