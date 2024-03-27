import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDados {

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public static void inserirCandidato(String nome, double salarioPretendido) {
        String sql = "INSERT INTO candidatos (nome, salario_pretendido) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, salarioPretendido);

            stmt.executeUpdate();
            System.out.println("Candidato inserido com sucesso no banco de dados.");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir candidato no banco de dados: " + e.getMessage());
        }
    }
}