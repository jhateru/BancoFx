package society.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDao {
    private static final Path LOCAL_DATA_FILE = Path.of("data", "cliente.csv");
    private static final Path ROOT_DATA_FILE = Path.of("bancoproyect", "data", "cliente.csv");
    private final Path filePath;

    public ClienteDao() {
        this.filePath = resolveDataFile();
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 5) {
                    continue;
                }
                clientes.add(new Cliente(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[4])));
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo CSV: " + e.getMessage());
        }
        return clientes;
    }

    public void guardar(Cliente cliente) {
        List<Cliente> clientes = listarTodos();
        boolean found = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNumeroCuenta().equals(cliente.getNumeroCuenta())) {
                clientes.set(i, cliente);
                found = true;
                break;
            }
        }
        if (!found) {
            clientes.add(cliente);
        }
        escribirTodo(clientes);
    }

    public void eliminar(String numeroCuenta) {
        List<Cliente> clientes = listarTodos().stream()
            .filter(c -> !c.getNumeroCuenta().equals(numeroCuenta))
            .collect(Collectors.toList());
        escribirTodo(clientes);
    }

    private void escribirTodo(List<Cliente> clientes) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(filePath))) {
            for (Cliente c : clientes) {
                pw.println(c.toString());
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo archivo CSV: " + e.getMessage());
        }
    }

    private Path resolveDataFile() {
        try {
            if (Files.exists(LOCAL_DATA_FILE.getParent())) {
                createFileIfMissing(LOCAL_DATA_FILE);
                return LOCAL_DATA_FILE;
            }

            if (Files.exists(ROOT_DATA_FILE.getParent())) {
                createFileIfMissing(ROOT_DATA_FILE);
                return ROOT_DATA_FILE;
            }

            Files.createDirectories(LOCAL_DATA_FILE.getParent());
            createFileIfMissing(LOCAL_DATA_FILE);
            return LOCAL_DATA_FILE;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo inicializar el archivo de datos", e);
        }
    }

    private void createFileIfMissing(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}
