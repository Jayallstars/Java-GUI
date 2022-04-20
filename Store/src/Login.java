import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton clearButton;
    private Container container;

    public Login(){
        super("STORE SHOP SYSTEM");
        container = getContentPane();
        container.add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
       Login obj = new Login();
    }

}
