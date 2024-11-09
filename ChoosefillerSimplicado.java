import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleFileChooser extends JPanel implements ActionListener {
    JButton openButton;
    JLabel fileLabel;
    JFileChooser fc;

    public SimpleFileChooser() {
        super(new BorderLayout());

        fc = new JFileChooser();

        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        fileLabel = new JLabel("No file selected");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(fileLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(SimpleFileChooser.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                fileLabel.setText("Selected file: " + file.getName());
            } else {
                fileLabel.setText("No file selected");
            }
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple FileChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SimpleFileChooser());
        frame.pack();
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(SimpleFileChooser::createAndShowGUI);
    }
}
