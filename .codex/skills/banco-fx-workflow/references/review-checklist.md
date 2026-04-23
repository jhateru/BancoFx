# Checklist de revision

- Confirmar que `pom.xml` declare `javafx-controls`, `javafx-fxml` y el plugin `javafx-maven-plugin`.
- Confirmar que `module-info.java` incluya `requires javafx.controls` y `requires javafx.fxml`.
- Verificar que los paquetes usados por controladores FXML esten abiertos con `opens ... to javafx.fxml`.
- Revisar que cada `fx:controller` apunte a una clase existente.
- Revisar que los metodos `onAction` existan y esten anotados con `@FXML` cuando corresponda.
- Revisar que `App.loadFXML(...)` maneje adecuadamente recursos faltantes o errores de carga.
- Confirmar que las rutas de FXML coincidan con `src/main/resources/society/`.
- Verificar pruebas minimas o al menos smoke tests de compilacion y carga basica.
