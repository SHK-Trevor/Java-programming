import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PlayerGameApp extends JFrame {
    private JTextField playerIdField, playerNameField, playerEmailField, playerAgeField, gameIdField, gameTitleField;
    private JTable reportTable;

    public PlayerGameApp() {
        setTitle("Player-Game Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Player ID:"));
        playerIdField = new JTextField();
        inputPanel.add(playerIdField);

        inputPanel.add(new JLabel("Name:"));
        playerNameField = new JTextField();
        inputPanel.add(playerNameField);

        inputPanel.add(new JLabel("Email:"));
        playerEmailField = new JTextField();
        inputPanel.add(playerEmailField);

        inputPanel.add(new JLabel("Age:"));
        playerAgeField = new JTextField();
        inputPanel.add(playerAgeField);

        inputPanel.add(new JLabel("Game ID:"));
        gameIdField = new JTextField();
        inputPanel.add(gameIdField);

        inputPanel.add(new JLabel("Game Title:"));
        gameTitleField = new JTextField();
        inputPanel.add(gameTitleField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update Player");
        JButton reportButton = new JButton("Show Reports");

        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(reportButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Table for Reports
        reportTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(reportTable);
        add(scrollPane, BorderLayout.SOUTH);

        // Button Actions
        insertButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updatePlayer());
        reportButton.addActionListener(e -> showReports());
    }

    private void insertData() {
        String playerId = playerIdField.getText();
        String name = playerNameField.getText();
        String email = playerEmailField.getText();
        String age = playerAgeField.getText();
        String gameId = gameIdField.getText();
        String gameTitle = gameTitleField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Insert Player
            String insertPlayerSQL = "INSERT INTO Player (player_id, name, email, age) VALUES (?, ?, ?, ?)";
            PreparedStatement playerStmt = conn.prepareStatement(insertPlayerSQL);
            playerStmt.setInt(1, Integer.parseInt(playerId));
            playerStmt.setString(2, name);
            playerStmt.setString(3, email);
            playerStmt.setInt(4, Integer.parseInt(age));
            playerStmt.executeUpdate();

            // Insert Game
            String insertGameSQL = "INSERT INTO Game (game_id, title) VALUES (?, ?)";
            PreparedStatement gameStmt = conn.prepareStatement(insertGameSQL);
            gameStmt.setInt(1, Integer.parseInt(gameId));
            gameStmt.setString(2, gameTitle);
            gameStmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Inserted Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updatePlayer() {
        String playerId = playerIdField.getText();
        String name = playerNameField.getText();
        String email = playerEmailField.getText();
        String age = playerAgeField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String updateSQL = "UPDATE Player SET name = ?, email = ?, age = ? WHERE player_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, Integer.parseInt(age));
            stmt.setInt(4, Integer.parseInt(playerId));
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Player Updated Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void showReports() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT p.player_id, p.name, g.title FROM Player p JOIN Player_Game pg ON p.player_id = pg.player_id JOIN Game g ON g.game_id = pg.game_id";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            reportTable.setModel(new ResultSetTableModel(rs));
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlayerGameApp app = new PlayerGameApp();
            app.setVisible(true);
        });
    }
}
