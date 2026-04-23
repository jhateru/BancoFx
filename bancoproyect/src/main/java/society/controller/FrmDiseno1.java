package society.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import society.App;
import society.model.Cliente;
import society.model.ClienteDao;

import java.io.IOException;

public class FrmDiseno1 {
    @FXML private TextField txtCuenta;
    @FXML private Label lblMensaje;

    private ClienteDao dao = new ClienteDao();

    @FXML
    private void irAAdministrar() throws IOException {
        App.setRoot("FrmDiseno2");
    }

    @FXML
    private void calcularNuevoLimite() {
        try {
            String cuenta = txtCuenta.getText();
            if (cuenta.isEmpty()) {
                lblMensaje.setText("Error: Por favor ingrese el número de cuenta.");
                return;
            }

            Cliente cliente = dao.listarTodos().stream()
                .filter(c -> c.getNumeroCuenta().equals(cuenta))
                .findFirst()
                .orElse(null);

            if (cliente == null) {
                lblMensaje.setText("Error: Cliente no encontrado.");
                return;
            }

            double limiteAnterior = cliente.getLimiteCredito();
            cliente.aumentarLimite();
            double nuevoLimite = cliente.getLimiteCredito();

            lblMensaje.setText("Cliente: " + cliente.getNombreCliente() + 
                               "\nTipo Tarjeta: " + cliente.getTipoTarjeta() + 
                               "\nDeuda: " + (cliente.tieneDeuda() ? "SÍ" : "NO") +
                               "\nLímite Anterior: $" + limiteAnterior + 
                               "\nNuevo Límite: $" + nuevoLimite);
        } catch (Exception e) {
            lblMensaje.setText("Error al calcular: " + e.getMessage());
        }
    }
}
