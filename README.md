# CI-CD-DLP

This repository contains the code for the CI/CD project of the "Industrialisation / CI/CD" course.

## Overview

This API manages information about cities, such as creating and retrieving city details.
The project uses a CI/CD configuration with Github Actions to ensure code quality and continuous integration.

The focus of this project is to create a CI/CD pipeline for a Spring Boot application. The application is a simple API that manages information about cities. The API is built using Spring Boot and uses a PostgreSQL database to store city information.

Currently, the CI/CD pipeline is configured to run the following steps:
  - On every push or pull request:
    - Check secrets leaks
    - Linter
    - Tests
    - Build Docker image
    - Scan for CVEs
  - On every release:
    - Push Docker image to private Harbor registry
    - Push helm chart to private Harbor registry

After the releasing of new version, the application is deployed in a k3s cluster with argocd.

You can find the API documentation [here](https://docs.ct-cd.fr/).
The API is deployed on [https://api.ct-cd.fr](https://api.ct-cd.fr).

If you want to deploy the application for yourself, you can follow the instructions below.

## Installation

You can install the application in different environments:
  - Test
  - Development
  - Production

### Test Environment

For the test environment, you can use the provided docker-compose file to start the application. The docker-compose file will start the application and a PostgreSQL database.

```bash
cp .env.template .env # modify the .env file with your configuration 
docker-compose up -d
```

After starting the application, you can access to different endpoints:
  - api: [http://localhost:2022](http://localhost:2022)
  - grafana: [http://localhost:3000](http://localhost:3000)
  - postgres: [http://localhost:5432](http://localhost:5432)
  - prometheus: [http://localhost:9090](http://localhost:9090)

The default credentials for Grafana are:
  - username: admin
  - password: admin

### Development Environment

For the development environment, you can use the provided docker-compose file to start a PostgreSQL database. 
And start the application with gradle.

```bash
cp .env.template .env # modify the .env file with your configuration
docker-compose up -d db

./gradlew bootRun
```

if you want run some tests, you can use the following command:

```bash
./gradlew test -Dspring.profiles.active=test
```

### Production Environment

For the production environment, you can use the provided helm chart to deploy the application in a k3s cluster.

```bash
helm show values oci://registry.razano.dev/ctcd/ctcd > values.yaml

# Modify the values.yaml file with your configuration

helm install oci://registry.razano.dev/ctcd/ctcd ctcd --values values.yaml
```
