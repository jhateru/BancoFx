---
name: javafx-maven-review
description: Revisar proyectos JavaFX con Maven y modulos de Java. Usar cuando Codex necesite hacer code review, diagnostico o validacion tecnica sobre pom.xml, module-info.java, clases Application, controladores, archivos FXML y pruebas basicas.
---

# JavaFX Maven Review

Inspecciona primero:

1. `pom.xml`
2. `src/main/java/module-info.java`
3. La clase que extiende `Application`
4. Controladores JavaFX
5. Archivos FXML
6. Pruebas existentes o su ausencia

Evalua compatibilidad entre Java, JavaFX y el plugin Maven.

Revisa wiring entre FXML y controladores, carga de recursos, `opens`/`exports` del modulo y robustez de manejo de errores al cargar vistas.

Usa `references/javafx-checklist.md` como criterio de revision tecnica.
