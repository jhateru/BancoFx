# Project Structure Mapping: BancoFx

## 🗺️ High-Level Architecture
This is a modular JavaFX application using Maven for build management.

### 1. Project DNA
- **Language**: Java 11
- **UI Framework**: JavaFX 13
- **Build Tool**: Maven (Working directory: `bancoproyect/`)
- **Module Name**: `society`

### 2. Component Map
| Component | Path | Role |
| :--- | :--- | :--- |
| **Main Entry** | `src/main/java/society/App.java` | App initialization and scene management via `setRoot()`. |
| **Module Config** | `src/main/java/module-info.java` | Defines module boundaries and JavaFX access. |
| **FXML Views** | `src/main/resources/society/*.fxml` | Declarative UI layout definitions. |
| **Controllers** | `src/main/java/society/*.java` | Logic for handling UI events. |

### 3. Navigation Flow
`App.java` $\xrightarrow{loadFXML}$ `primary.fxml` $\xrightarrow{linked to}$ `PrimaryController` $\xrightarrow{App.setRoot}$ `secondary.fxml` $\xrightarrow{linked to}$ `SecondaryController`.

### 4. Resource-Controller Matrix
- `primary.fxml` $\rightarrow$ `society.PrimaryController`
- `secondary.fxml` $\rightarrow$ `society.SecondaryController`
- `diseño1.fxml` $\rightarrow$ `society.BancoController` (Pending implementation)

### 5. Current Implementation Status
- [x] Basic project structure and modularity.
- [x] Basic scene navigation between primary and secondary views.
- [x] UI Design for Banco problem (`diseño1.fxml`).
- [ ] Business Logic Class `Banco` (Pending).
- [ ] UI Controller `BancoController` (Pending).
