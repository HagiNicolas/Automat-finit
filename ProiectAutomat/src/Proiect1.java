
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proiect1 {
private static Automat automat;
    public static void main(String[] args) {
    try {
        automat = new Automat("automat.txt");
    } catch (Exception ex) {
        Logger.getLogger(Proiect1.class.getName()).log(Level.SEVERE, null, ex);
    }
        JFrame frame = new JFrame("Analiza Cuvintelor cu AFD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introduceți un cuvânt:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Verifică");
        button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cuvant = textField.getText();
        boolean esteAcceptat = automat.analizaCuvant(cuvant);
        String rezultat = esteAcceptat ? "acceptat" : "respins";
        
        String mesaj = "Cuvântul '" + cuvant + "' este " + rezultat + "\n" + automat.getSir();

        JOptionPane.showMessageDialog(null, mesaj);
    }
});
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
}
