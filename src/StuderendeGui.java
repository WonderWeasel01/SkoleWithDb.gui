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

    private DefaultListModel<String> FagListModel = new DefaultListModel<>();


    private Connection connection;

    private PreparedStatement Pstmt;
    private Statement stmt;
    private Statement stmt1;

    private JButton FagButton;
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
    private JTextField AdresseTextField;
    private JTextField PostNrTextField;
    private JTextField KlasseTextField;
    private JPanel FjernStuderende;
    private JTextField FjernStuderendetextField1;
    private JLabel IDLabel;
    private JButton fjernStuderendeButton1;
    private JButton BackToStudPanel2;
    private JButton BackToStudPanel;
    private JTextField MobilTextField;
    private JPanel Fag;
    private JButton BackToStart;
    private JButton opretFagButton;
    private JButton udskrivFagButton;
    private JButton tilmeldFagButton;
    private JButton BackToFag;
    private JPanel OpretFag;
    private JTextField FagNrTextField;
    private JTextField FagNavnTextField;
    private JButton opretFagButton1;
    private JPanel UdskrivFag;
    private JPanel TilmeldFag;
    private JList FagList;
    private JButton BackToFag2;
    private JButton BackToFag3;
    private JTextField textField1;
    private JCheckBox danskCheckBox;
    private JCheckBox engelskCheckBox;
    private JCheckBox matematikCheckBox;
    private JCheckBox tyskCheckBox;
    private JCheckBox franskCheckBox;
    private JButton tilmeldFagButton1;


    public StuderendeGui() {

        connection = null;
        stmt = null;
        try {
            //Windows
            String url = "jdbc:sqlite:C:/Users/alexw/IdeaProjects/SkoleWithDb.gui/identifier.sqlite";
            //Mac
            //String url = "jdbc:sqlite:/Users/alexwentzel/Documents/1Semester/SkoleWithDb.gui/identifier.sqlite";
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

        BackToStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startpanel.setVisible(true);
                Fag.setVisible(false);

            }
        });

        FagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startpanel.setVisible(false);
                Fag.setVisible(true);

            }
        });
        BackToFag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpretFag.setVisible(false);
                Fag.setVisible(true);

            }
        });

        opretFagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fag.setVisible(false);
                OpretFag.setVisible(true);

            }
        });

        opretStuderendeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpretStudBtn();

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
            }
        });


        BackToStudPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FjernStuderende.setVisible(false);
                Studpanel.setVisible(true);
            }
        });

        BackToStudPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStudent.setVisible(false);
                Studpanel.setVisible(true);
            }
        });

        BackToFag2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UdskrivFag.setVisible(false);
                Fag.setVisible(true);
            }
        });

        BackToFag3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TilmeldFag.setVisible(false);
                Fag.setVisible(true);
            }
        });

        udskrivFagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fag.setVisible(false);
                UdskrivFag.setVisible(true);
            }
        });

        tilmeldFagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fag.setVisible(false);
                TilmeldFag.setVisible(true);
            }
        });

        udskrivFagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFagList();
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
                String adr = rs.getString("adr");
                int mobil = rs.getInt("mobil");
                int klasse = rs.getInt("klasse");

                studerendeListModel.addElement(stdnr + ": " + fnavn + " " + enavn + " " + adr + " " + mobil  + " " + klasse);
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
            String sql = "insert into main.Studerende(stdnr,fnavn, enavn,adr,postnr,mobil,klasse ) values (?,?,?,?,?,?,?)";


            PreparedStatement Pstmt = connection.prepareStatement(sql);
            Pstmt.setInt(1, Integer.parseInt(IDTextField.getText()));
            Pstmt.setString(2, navnTextField.getText());
            Pstmt.setString(3, efterNavnTextField.getText());
            Pstmt.setString(4, AdresseTextField.getText());
            Pstmt.setInt(5, Integer.parseInt(MobilTextField.getText()));
            Pstmt.setInt(6, Integer.parseInt(PostNrTextField.getText()));
            Pstmt.setInt(7, Integer.parseInt(KlasseTextField.getText()));

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


    public void updateFagList() {
        FagListModel.clear();
        try {
            Statement stmt = connection.createStatement();
            String sql = "select stdnr,fnavn,fagNavn from Studerende inner join Fag;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int stdnr = rs.getInt("stdnr");
                String fnavn = rs.getString("fnavn");
                String FagNavn = rs.getString("FagNavn");


                FagListModel.addElement(stdnr + ": " + fnavn + " " + FagNavn);
            }
            FagList.setModel(FagListModel);
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

