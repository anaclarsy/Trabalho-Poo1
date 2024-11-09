package components;


import javax.swing.*;
import java.awt.*;


public class TextAreaDemo extends JPanel {
    private JLabel jLabel1;
    private JTextArea textArea;
    private JScrollPane jScrollPane1;


    public TextAreaDemo() {
        // conf principal
        setLayout(new BorderLayout());


        // cria JLabel
        jLabel1 = new JLabel("Digite algo abaixo:");
        add(jLabel1, BorderLayout.NORTH);


        // cria TEXT AREA
        textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        // add text area em um scrollpane p rolagem
        jScrollPane1 = new JScrollPane(textArea);
        add(jScrollPane1, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        // cria frame p mostrar na main
        JFrame frame = new JFrame("Demo de JLabel e JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // add instância de TextAreaDemo ao frame
        frame.add(new TextAreaDemo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
