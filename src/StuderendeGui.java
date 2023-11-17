import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuderendeGui extends JFrame {
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

    public StuderendeGui() {
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

    public static void main(String[] args) {
        StuderendeGui panel = new StuderendeGui();
        panel.alleStuderende();
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
        db.alleStuderende();

    }
}
