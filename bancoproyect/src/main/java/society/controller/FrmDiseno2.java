package society.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import society.App;
import society.model.Cliente;
import society.model.ClienteDao;

import java.io.IOException;

public class FrmDiseno2 {
    @FXML private TextField txtCuenta;
    @FXML private TextField txtNombre;
    @FXML private TextField txtLimite;
    @FXML private TextField txtTipo;
    @FXML private TextField txtDeuda;
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colCuenta;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, Double> colLimite;
    @FXML private TableColumn<Cliente, Integer> colTipo;
    @FXML private TableColumn<Cliente, Double> colDeuda;

    private ClienteDao dao = new ClienteDao();

    @FXML
    public void initialize() {
        // Vincular columnas con atributos de la clase Cliente
        colCuenta.setCellValueFactory(new PropertyValueFactory<>("numeroCuenta"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colLimite.setCellValueFactory(new PropertyValueFactory<>("limiteCredito"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoTarjeta"));
        colDeuda.setCellValueFactory(new PropertyValueFactory<>("deudaPendiente"));
        
        cargarTabla();

        // Cargar datos en el formulario al hacer clic en la tabla
        tblClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtCuenta.setText(newVal.getNumeroCuenta());
                txtNombre.setText(newVal.getNombreCliente());
                txtLimite.setText(String.valueOf(newVal.getLimiteCredito()));
                txtTipo.setText(String.valueOf(newVal.getTipoTarjeta()));
                txtDeuda.setText(String.valueOf(newVal.getDeudaPendiente()));
            }
        });
    }

    private void cargarTabla() {
        tblClientes.setItems(FXCollections.observableArrayList(dao.listarTodos()));
    }

    @FXML
    private void crearCliente() {
        try {
            Cliente c = new Cliente(
                txtCuenta.getText(),
                txtNombre.getText(),
                Double.parseDouble(txtLimite.getText()),
                Integer.parseInt(txtTipo.getText()),
                Double.parseDouble(txtDeuda.getText())
            );
            dao.guardar(c);
            cargarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor ingrese valores numéricos válidos.");
        }
    }

    @FXML
    private void actualizarCliente() {
        try {
            String cuenta = txtCuenta.getText();
            if (cuenta.isEmpty()) {
                mostrarAlerta("Error", "Ingrese la cuenta del cliente a actualizar.");
                return;
            }
            Cliente c = new Cliente(
                cuenta,
                txtNombre.getText(),
                Double.parseDouble(txtLimite.getText()),
                Integer.parseInt(txtTipo.getText()),
                Double.parseDouble(txtDeuda.getText())
            );
            dao.guardar(c);
            cargarTabla();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Valores numéricos inválidos.");
        }
    }

    @FXML
    private void eliminarCliente() {
        String cuenta = txtCuenta.getText();
        if (cuenta.isEmpty()) {
            mostrarAlerta("Error", "Ingrese la cuenta del cliente a eliminar.");
            return;
        }
        dao.eliminar(cuenta);
        cargarTabla();
        limpiarCampos();
    }

    @FXML
    private void limpiarCampos() {
        txtCuenta.clear();
        txtNombre.clear();
        txtLimite.clear();
        txtTipo.clear();
        txtDeuda.clear();
    }

    @FXML
    private void volverAInicio() throws IOException {
        App.setRoot("FrmDiseno1");
    }

    private void mostrarAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
