import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = obtenerProductos();

        System.out.println("Nombre\t\tCategoría\t\tPrecio");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + "\t\t" + producto.getCategoria() + "\t\t" + producto.getPrecio());
        }

        double sumaPrecios = 0;
        Producto productoMasCaro = null;
        for (Producto producto : productos) {
            sumaPrecios += producto.getPrecio();
            if (productoMasCaro == null || producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        double precioPromedio = sumaPrecios / productos.size();
        System.out.println("\nPrecio promedio de los productos: " + precioPromedio);

        if (productoMasCaro != null) {
            System.out.println("\nProducto más caro:");
            System.out.println("Nombre: " + productoMasCaro.getNombre());
            System.out.println("Categoría: " + productoMasCaro.getCategoria());
            System.out.println("Precio: " + productoMasCaro.getPrecio());
        }
    }

    public static List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();

        try (Connection conexion = DatabaseConnection.getConnection()) {
            String consultaSQL = "SELECT * FROM producto_examen";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String categoria = resultSet.getString("categoria");
                double precio = resultSet.getDouble("precio");
                productos.add(new Producto(id, nombre, categoria, precio));
            }
        } catch (SQLException e) {
            System.out.println("Ha habido un error al obtener los productos: " + e.getMessage());
        }

        return productos;
    }
}
