import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnection.getConnection();
             Scanner t = new Scanner(System.in)) {

            System.out.println("La conexión ha sido establecida con éxito.");

            System.out.print("Introduce la nota mínima: ");
            double notaMinima = t.nextDouble();

            System.out.print("Introduce la nota máxima: ");
            double notaMaxima = t.nextDouble();

            String query = "select nombre, apellido, nota_media from alumnado_examen where nota_media between ? and ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, notaMinima);
                preparedStatement.setDouble(2, notaMaxima);

                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("Resultados:");
                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    double notaMedia = resultSet.getDouble("nota_media");

                    System.out.print("Nombre: " + nombre + ", Apellido: " + apellido + ", Nota media: " + notaMedia);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





















