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

    private PreparedStatement Pstmt;
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
    private JPanel CreateStudent;
    private JTextField IDTextField;
    private JTextField navnTextField;
    private JTextField efterNavnTextField;
    private JButton opretStuderendeButton1;
    private JButton BackToStudPanel;
    private JPanel FjernStuderende;
    private JTextField FjernStuderendetextField1;
    private JLabel IDLabel;
    private JButton fjernStuderendeButton1;
    private JButton BackToStudPanel2;
    private JLabel FjernetLabel;


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

        fjernStuderendeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(false);
                FjernStuderende.setVisible(true);
            }
        });

        fjernStuderendeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FjernStuderende();
                Studpanel.setVisible(false);
                FjernStuderende.setVisible(true);
                FjernetLabel.setVisible(true);
            }
        });

        BackToStudPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStudent.setVisible(false);
                Studpanel.setVisible(true);
            }
        });

        BackToStudPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FjernStuderende.setVisible(false);
                Studpanel.setVisible(true);
                FjernetLabel.setVisible(false);
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


            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(true);
                VisStuderendePanel.setVisible(false);

            }
        });


        opretStuderendeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Studpanel.setVisible(false);
                CreateStudent.setVisible(true);

            }
        });

        opretStuderendeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpretStudBtn();

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

    public void OpretStudBtn() {
        studerendeListModel.clear();
        try {
            String sql = "insert into main.Studerende(stdnr,fnavn, enavn) values (?,?,?)";


            PreparedStatement Pstmt = connection.prepareStatement(sql);
            Pstmt.setInt(1, Integer.parseInt(IDTextField.getText()));
            Pstmt.setString(2, navnTextField.getText());
            Pstmt.setString(3, efterNavnTextField.getText());
            boolean rs = Pstmt.execute();

            Pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void FjernStuderende() {
        studerendeListModel.clear();
        try {
            String sql = "DELETE FROM Studerende WHERE fnavn=?";


            PreparedStatement Pstmt = connection.prepareStatement(sql);
            Pstmt.setString(1, (FjernStuderendetextField1.getText()));

            boolean rs = Pstmt.execute();

            Pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}

