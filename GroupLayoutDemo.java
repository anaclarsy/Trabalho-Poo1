
 import javax.swing.*;
 import static javax.swing.GroupLayout.Alignment.*;
  
 public class GroupLayoutDemo extends JFrame {
    public GroupLayoutDemo() {
        JLabel label = new JLabel("Nome:");
        JTextField textField = new JTextField();
        JCheckBox caseCheckBox = new JCheckBox("Retirar vogais ");
        JButton findButton = new JButton("Proxima palavra");
        JButton cancelButton = new JButton("Retroceder");

        // Remove o border padrão para alinhar melhor
        caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(label)
            .addGap(20)
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(textField)
                .addComponent(caseCheckBox))
            .addGap(20)
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(findButton)
                .addComponent(cancelButton))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(label)
                .addComponent(textField)
                .addComponent(findButton))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(caseCheckBox)
                .addComponent(cancelButton))
        );

        setTitle("retirar vogais ");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


      
     public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 try {
                     UIManager.setLookAndFeel(
                                   "javax.swing.plaf.metal.MetalLookAndFeel");
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 new GroupLayoutDemo().setVisible(true);
             }
         });
     }
 }
 