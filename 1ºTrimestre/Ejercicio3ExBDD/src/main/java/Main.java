import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("***************************************************************");
            System.out.println("*                     Gestión de productos                    *");
            System.out.println("***************************************************************");
            System.out.println("Seleccione la operación a realizar (1-4):");
            System.out.println("1. Insertar nuevo producto");
            System.out.println("2. Actualizar precio de producto");
            System.out.println("3. Intercambiar precios de productos");
            System.out.println("4. Salir");

            opcion = t.nextInt();
            t.nextLine();

            switch (opcion) {
                case 1:
                    insertarProducto(t);
                    break;
                case 2:
                    actualizarPrecioProducto(t);
                    break;
                case 3:
                    intercambiarPrecios(t);
                    break;
                case 4:
                    System.out.println("Ha salido del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);

        t.close();
    }

    private static void insertarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        try (Connection conexion = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO producto_examen (nombre, categoria, precio) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, categoria);
                pstmt.setDouble(3, precio);
                pstmt.executeUpdate();
                System.out.println("Producto insertado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    private static void actualizarPrecioProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();

        try (Connection conexion = DatabaseConnection.getConnection()) {
            String sql = "UPDATE producto_examen SET precio = ? WHERE id = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setDouble(1, nuevoPrecio);
                pstmt.setInt(2, id);
                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("El precio del producto actualizado exitosamente.");
                } else {
                    System.out.println("No se ha encontrado ningún producto con ese ID");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha habido un error al actualizar el precio del producto: " + e.getMessage());
        }
    }

    private static void intercambiarPrecios(Scanner scanner) {
        System.out.print("Ingrese el ID del primer producto: ");
        int id1 = scanner.nextInt();
        System.out.print("Ingrese el ID del segundo producto: ");
        int id2 = scanner.nextInt();

        try (Connection conexion = DatabaseConnection.getConnection()) {
            conexion.setAutoCommit(false);

            double precio1 = obtenerPrecio(conexion, id1);
            double precio2 = obtenerPrecio(conexion, id2);

            if (precio1 == -1 || precio2 == -1) {
                conexion.rollback();
                System.out.println("No se han encontrado ninguno de los productos con esos IDs");
                return;
            }

            actualizarPrecio(conexion, id1, precio2);
            actualizarPrecio(conexion, id2, precio1);

            conexion.commit();
            System.out.println("Los precios se han cambiado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al intercambiar los precios: " + e.getMessage());
            try (Connection conexion = DatabaseConnection.getConnection()) {
                conexion.rollback();
            } catch (SQLException rollbackException) {
                System.out.println("Ha habido un error al hacer rollback: " + rollbackException.getMessage());
            }
        }
    }

    private static double obtenerPrecio(Connection conexion, int id) throws SQLException {
        String sql = "SELECT precio FROM producto_examen WHERE id = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("precio");
            } else {
                return -1;
            }
        }
    }

    private static void actualizarPrecio(Connection conexion, int id, double nuevoPrecio) throws SQLException {
        String sql = "UPDATE producto_examen SET precio = ? WHERE id = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoPrecio);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
}
