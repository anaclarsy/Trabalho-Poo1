import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CardLayoutDemo implements ItemListener {
    JPanel cards; // a panel that uses CardLayout
    final static String BUTTONPANEL = "ultimo passo";
    final static String TEXTPANEL = "questao";


    public void addComponentToPane(Container pane) {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { TEXTPANEL, BUTTONPANEL }; // Inverte a ordem das questões
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);


        // Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("refazer quiz"));
        card1.add(new JButton("concluir quiz"));


        JPanel card2 = new JPanel();
        card2.add(new JTextField("Capital da Russia:", 20));


        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card2, TEXTPANEL); // Adiciona a "questao dois" primeiro
        cards.add(card1, BUTTONPANEL);


        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }


    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("quiz geografia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());


        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


