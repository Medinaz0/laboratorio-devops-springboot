# Laboratorio DevOps Azure CI/CD

Aplicacion Spring Boot + Maven para demostrar un flujo CI/CD en Azure DevOps:

```text
Git -> Build -> Test -> Artifact -> DEV -> QA -> PDN
```

## Ejecutar localmente

```bash
mvn test
mvn spring-boot:run
```

Probar:

```bash
curl http://localhost:8080/api/hello
```

Respuesta esperada local:

```json
{
  "message": "Hola desde DevOps",
  "environment": "LOCAL"
}
```

Para simular un ambiente:

```bash
APP_ENVIRONMENT=DEV mvn spring-boot:run
```

## Build

```bash
mvn clean package
java -jar target/devops-azure-cicd-0.0.1-SNAPSHOT.jar
```

## Azure DevOps

El archivo `azure-pipelines.yml` construye el proyecto, ejecuta pruebas, publica el `.jar` como artifact y despliega el mismo artifact a DEV, QA y PDN.

Antes de ejecutar el pipeline, cambiar estas variables en `azure-pipelines.yml` o definirlas como variables del pipeline:

```yaml
azureServiceConnection: 'CHANGE_ME_AZURE_SERVICE_CONNECTION'
devAppServiceName: 'CHANGE_ME_DEV_APP_SERVICE'
qaAppServiceName: 'CHANGE_ME_QA_APP_SERVICE'
pdnAppServiceName: 'CHANGE_ME_PDN_APP_SERVICE'
```

Crear en Azure DevOps los ambientes:

```text
DEV
QA
PDN
```

En `PDN`, agregar una aprobacion manual desde:

```text
Environment -> Approvals and checks -> Approvals
```

## Variables de App Service

Configurar en cada Azure App Service:

```text
APP_ENVIRONMENT=DEV
APP_ENVIRONMENT=QA
APP_ENVIRONMENT=PDN
```

Cada ambiente debe responder `/api/hello` mostrando su propio valor.
