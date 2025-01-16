import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;

public class TelaLogin extends JFrame {

    private JTextField txtMatricula;
    private JPasswordField txtSenha;
    private JComboBox<String> cbTipo;


    public TelaLogin() {
        setTitle("Login - Gerenciador de Academias");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        add(txtMatricula);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"ALUNO", "INSTRUTOR"});
        add(cbTipo);

        JButton btnLogin  = new JButton("Login");
        add(btnLogin);

        add(new JLabel());

        btnLogin.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String matricula = txtMatricula.getText();
        String senha = new String(txtSenha.getPassword());
        String tipo = (String) cbTipo.getSelectedItem();

        if (autenticarUsuario(matricula, senha, tipo)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // tela principal do sistema

        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean autenticarUsuario(String matricula, String senha, String tipo) {
        String url = "jdbc:mysql://localhost:3306/cadastro";
        String usuarioBD = "root"; //seu usuario
        String senhaBD = "password"; //sua senha

        // as '?' vao ser substituidas pelos referentes valores no comando .prepareStatement
        String sql = "SELECT * FROM usuarios WHERE matricula = ? AND senha = ? AND tipo = ?";

        try (Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            stmt.setString(2, senha);
            stmt.setString(3, tipo);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // retorna true se encontrar o usuario
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}
