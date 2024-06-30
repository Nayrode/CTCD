# CI-CD-DLP

Projet de ci/cd

## À propos

Cette API gère les informations sur les villes, telles que la création et la récupération des détails des villes. Le projet utilise une configuration CI/CD avec les Github Actions pour assurer la qualité du code et l'intégration continue.

## Prérequis

- Docker
- Java 17
- Gradle

## Lancer l'appplication

- Renseigner les variables d'environnement suivantes dans le fichier `.env` comme sur le fichier d'exemple .env.template:
```bash
CITY_API_ADDR
CITY_API_PORT
CITY_API_DB_URL
CITY_API_DB_USER
CITY_API_DB_PWD
```

- Sourcez votre .env puis démarrez les services Docker:
```bash
source .env && docker-compose up -d
```

## Exécution des Tests

Pour exécuter les tests en local avec les configurations spécifiées dans `.env` :
```sh
./gradlew test -Dspring.profiles.active=test
```

## Workflow GitHub Actions

Le workflow GitHub Actions `ci` est déclenché à chaque push ou pull request et exécute plusieurs actions :
- Linter
- Tests
- Build de l'image Docker
- Push de l'image Docker sur le DockerHub
- Scan des CVEs
- Déploiement de l'application dans k3s