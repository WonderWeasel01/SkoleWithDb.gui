import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.DefaultListModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private JButton backButton;
    private JButton backButton_panel1;


    public StuderendeGui() {

        connection = null;
        stmt = null;
        try {
            //Windows
            //String url = "jdbc:sqlite:C:/Users/alexw/IdeaProjects/SkoleWithDb.gui/identifier.sqlite";
            //Mac
            String url = "jdbc:sqlite:/Users/alexwentzel/Documents/1Semester/SkoleWithDb.gui/identifier.sqlite";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Studerende.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startpanel.setVisible(false);
                Studpanel.setVisible(true);
            }
        });

        backButton_panel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(false);
                startpanel.setVisible(true);
            }
        });



        udskrivAlleStuderendeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(false);
                VisStuderendePanel.setVisible(true);
                studerendeListModel.clear();
                updateStudList();
                Print();

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(true);
                VisStuderendePanel.setVisible(false);

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





    public void updateStudList() {
        studerendeListModel.clear();
        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from main.Studerende";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int stdnr = rs.getInt("stdnr");
                String fnavn = rs.getString("fnavn");
                String enavn = rs.getString("enavn");

                studerendeListModel.addElement(stdnr + ": " + fnavn + " " + enavn);
            }
            StuderendeList.setModel(studerendeListModel);
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Print(){
        System.out.println(studerendeListModel);
    }


}

