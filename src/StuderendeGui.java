import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.DefaultListModel;

public class StuderendeGui extends JFrame {
    private DefaultListModel<String> studerendeListModel = new DefaultListModel<>();


    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    private JButton holdButton;
    private JPanel panel1;
    private JButton Studerende;
    private JButton opretStuderendeButton;
    private JButton fjernStuderendeButton;
    private JButton udskrivAlleStuderendeButton;
    private JButton opretHoldButton;
    private JButton fjernHoldButton;
    private JButton visHoldButton;
    private JPanel Studpanel;
    private JPanel FagPanel;
    private JPanel startpanel;
    private JList StuderendeList;
    private JPanel VisStuderendePanel;


    public StuderendeGui() {

        connection = null;
        stmt = null;
        try {
            //Windows
            //String url = "jdbc:sqlite:C:/Users/alexw/IdeaProjects/SkoleWithDb.gui/identifier.sqlite";
            //Mac
            String url = "jdbc:sqlite:/Users/alexwentzel/Documents/1Semester/SkoleDb/identifier.sqlite";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Studerende.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStudpanel();
            }
        });

        udskrivAlleStuderendeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleVisStuderende();
            }
        });


    }



    public void alleStuderende() {
        setContentPane(panel1);
        setTitle("Wonder's Skole");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setVisible(true);
    }

    public void handleStudpanel() {
        startpanel.setVisible(false);
        Studpanel.setVisible(true);

    }

    public void handleVisStuderende() {
        DbSql db=new DbSql();
        Studpanel.setVisible(false);
        VisStuderendePanel.setVisible(true);
        printStud();
    }

    public void printStud() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from main.Studerende ";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Connection to SQLite has been established.");

            while (rs.next()) {
                int stdnr = rs.getInt("stdnr");
                String fnavn = rs.getString("fnavn");
                String enavn = rs.getString("enavn");


                studerendeListModel.addElement(stdnr + ": " + fnavn + " " + enavn);
            }

            StuderendeList.setModel(studerendeListModel);

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


//Main
    public static void main(String[] args) {
        StuderendeGui panel = new StuderendeGui();
        panel.alleStuderende();
    }
}

