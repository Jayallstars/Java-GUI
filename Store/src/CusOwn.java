import javax.swing.*;
import java.awt.*;

public class CusOwn extends JFrame {
    private JButton CUSTOMERButton;
    private JButton OWNERButton;
    private JPanel panelMain;
    private JLabel author;
    private Container container;

    public CusOwn(){
        super("STORE SHOP SYSTEM");
        container = getContentPane();
        container.add(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        CusOwn obj = new CusOwn();
    }
}
