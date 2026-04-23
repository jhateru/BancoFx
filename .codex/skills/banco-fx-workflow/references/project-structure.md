# BancoFx

## Estructura

- `AGENTS.md`: reglas locales del agente.
- `bancoproyect/`: modulo Maven principal del proyecto.
- `bancoproyect/pom.xml`: dependencias JavaFX y plugins Maven.
- `bancoproyect/src/main/java/module-info.java`: declaracion del modulo.
- `bancoproyect/src/main/java/society/`: `App.java` y controladores.
- `bancoproyect/src/main/resources/society/`: archivos FXML.

## Comandos validos

- `mvn clean javafx:run`
- `mvn test`
- `mvn clean compile`

Ejecuta esos comandos desde `bancoproyect/`.

## Convenciones locales

- Java 11
- JavaFX 13
- Clase principal: `society.App`
- El proyecto es modular
- Las vistas FXML viven en `src/main/resources/society/`
- El modulo actual exporta y abre `society`

## Observaciones del estado actual

- `App.java` carga vistas con `FXMLLoader` usando nombres como `primary.fxml` y `secondary.fxml`.
- Los controladores actuales son `PrimaryController` y `SecondaryController`.
- El flujo actual cambia la raiz de la escena con `App.setRoot(...)`.
