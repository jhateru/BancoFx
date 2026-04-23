# Checklist JavaFX Maven

- Verificar compatibilidad entre version de Java, dependencias JavaFX y version del `javafx-maven-plugin`.
- Revisar que los namespaces de los FXML no declaren versiones incoherentes con la libreria objetivo.
- Verificar que la clase `Application` cargue recursos con rutas correctas y trate fallos de carga de forma diagnostica.
- Revisar que `module-info.java` tenga `requires`, `opens` y `exports` adecuados para FXML y acceso reflejado.
- Confirmar que cada `fx:controller` exista y que los manejadores de eventos declarados en FXML coincidan con metodos reales.
- Verificar que los recursos FXML, CSS e imagenes existan en `src/main/resources`.
- Revisar si hay smoke tests recomendados para compilacion, carga de FXML y arranque minimo de la aplicacion.
