# Agent Instructions

## 🛠️ Build & Run
- **Project Root**: Maven project located in `bancoproyect/`.
- **Crucial**: All Maven commands MUST be executed from the `bancoproyect/` directory.
- **Run Application**: `mvn clean javafx:run`
- **Main Class**: `society.App`

## 🏗️ Architecture & Environment
- **Stack**: Java 11, JavaFX 13.
- **Modularity**: Project uses Java Modules. Update `src/main/java/module-info.java` when adding new packages that require JavaFX access (use `opens` or `exports`).
- **Resources**: FXML files are located in `src/main/resources/society/`.

## 🔄 Navigation Workflow
- **Scene Switching**: Use `App.setRoot("fxml_name")` to change views.
- **View-Controller Link**: Ensure `fx:controller` in FXML matches the class path in `src/main/java/society/`.

## 📂 Key Files to Check First
1. `bancoproyect/pom.xml` (Dependencies)
2. `bancoproyect/src/main/java/module-info.java` (Module permissions)
3. `bancoproyect/src/main/java/society/App.java` (App Entry & Navigation)
4. `bancoproyect/src/main/resources/society/*.fxml` (UI layouts)
