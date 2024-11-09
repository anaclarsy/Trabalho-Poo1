
 package components;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 

 public class RadioButtonDemo extends JPanel
                              implements ActionListener {
     static String Max = "Max Verstappen";
     static String Leclerc = "Charles Leclerc";
     static String Alonso = "Fernando Alonso";
     static String Senna = "Ayrton Senna";
     static String Schumacher = "Michael Schumacher";
 
     JLabel picture;
 
     public RadioButtonDemo() {
         super(new BorderLayout());
 
         
         JRadioButton MaxButton = new JRadioButton(Max);
         MaxButton.setMnemonic(KeyEvent.VK_B);
         MaxButton.setActionCommand(Max);
         MaxButton.setSelected(true);
 
         JRadioButton LeclercButton = new JRadioButton(Leclerc);
         LeclercButton.setMnemonic(KeyEvent.VK_C);
         LeclercButton.setActionCommand(Leclerc);
 
         JRadioButton AlonsoButton = new JRadioButton(Alonso);
         AlonsoButton.setMnemonic(KeyEvent.VK_D);
         AlonsoButton.setActionCommand(Alonso);
 
         JRadioButton SennaButton = new JRadioButton(Senna);
         SennaButton.setMnemonic(KeyEvent.VK_R);
         SennaButton.setActionCommand(Senna);
 
         JRadioButton SchumacherButton = new JRadioButton(Schumacher);
         SchumacherButton.setMnemonic(KeyEvent.VK_P);
         SchumacherButton.setActionCommand(Schumacher);
 
         
         ButtonGroup group = new ButtonGroup();
         group.add(MaxButton);
         group.add(LeclercButton);
         group.add(AlonsoButton);
         group.add(SennaButton);
         group.add(SchumacherButton);
 
         
         MaxButton.addActionListener(this);
         LeclercButton.addActionListener(this);
         AlonsoButton.addActionListener(this);
         SennaButton.addActionListener(this);
         SchumacherButton.addActionListener(this);
 
        
         picture = new JLabel(createImageIcon("images/"
                                              + Max
                                              + ".gif"));
 
        
         picture.setPreferredSize(new Dimension(256, 256));
 
 
        
         JPanel radioPanel = new JPanel(new GridLayout(0, 1));
         radioPanel.add(MaxButton);
         radioPanel.add(LeclercButton);
         radioPanel.add(AlonsoButton);
         radioPanel.add(SennaButton);
         radioPanel.add(SchumacherButton);
 
         add(radioPanel, BorderLayout.LINE_START);
         add(picture, BorderLayout.CENTER);
         setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
     }
 
    
     public void actionPerformed(ActionEvent e) {
         picture.setIcon(createImageIcon("images/"
                                         + e.getActionCommand()
                                         + ".gif"));
     }
 
     
     protected static ImageIcon createImageIcon(String path) {
         java.net.URL imgURL = RadioButtonDemo.class.getResource(path);
         if (imgURL != null) {
             return new ImageIcon(imgURL);
         } else {
             System.err.println("Couldn't find file: " + path);
             return null;
         }
     }
 
   
     private static void createAndShowGUI() {
         
         JFrame frame = new JFrame("RadioButtonDemo");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
         
         JComponent newContentPane = new RadioButtonDemo();
         newContentPane.setOpaque(true); 
         frame.setContentPane(newContentPane);
 
        
         frame.pack();
         frame.setVisible(true);
     }
 
     public static void main(String[] args) {
      
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI();
             }
         });
     }
 }