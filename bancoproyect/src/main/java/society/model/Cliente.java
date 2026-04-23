package society.model;

public class Cliente {
    private String numeroCuenta;
    private String nombreCliente;
    private double limiteCredito;
    private int tipoTarjeta;
    private double deudaPendiente;

    public Cliente(String numeroCuenta, String nombreCliente, double limiteCredito, int tipoTarjeta, double deudaPendiente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.limiteCredito = limiteCredito;
        this.tipoTarjeta = tipoTarjeta;
        this.deudaPendiente = deudaPendiente;
    }

    public boolean tieneDeuda() {
        return this.deudaPendiente > 0;
    }

    public void aumentarLimite() {
        double porcentaje;
        switch (this.tipoTarjeta) {
            case 1: porcentaje = 0.25; break;
            case 2: porcentaje = 0.35; break;
            case 3: porcentaje = 0.40; break;
            default: porcentaje = 0.50; break;
        }

        if (tieneDeuda()) {
            if (this.tipoTarjeta == 1 || this.tipoTarjeta == 2) {
                porcentaje = porcentaje / 2;
            } else {
                porcentaje = 0; // El resto no tiene incremento si tiene deuda
            }
        }

        this.limiteCredito += this.limiteCredito * porcentaje;
    }

    // Getters and Setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }
    public int getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(int tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
    public double getDeudaPendiente() { return deudaPendiente; }
    public void setDeudaPendiente(double deudaPendiente) { this.deudaPendiente = deudaPendiente; }

    @Override
    public String toString() {
        return numeroCuenta + "," + nombreCliente + "," + limiteCredito + "," + tipoTarjeta + "," + deudaPendiente;
    }
}
