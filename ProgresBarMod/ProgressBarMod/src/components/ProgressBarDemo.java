
package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;


public class ProgressBarDemo extends JPanel
                             implements ActionListener, 
                                        PropertyChangeListener {

    private JProgressBar progressBar;
    private JButton startButton;
    private JTextArea taskOutput;
    private Task task;

    class Task extends SwingWorker<Void, Void> {
        
        @Override
        public Void doInBackground() {
            
            setProgress(0);
            int progress = 0;
        
            while (progress < 100) {
                
                try {
                    Thread.sleep(2000); 
                } catch (InterruptedException ignore) {}
        
                
                progress += 10;
                setProgress(Math.min(progress, 100)); 
            }
            return null;
        }
        
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            setCursor(null); 
            taskOutput.append("Programa instalado com Sucesso!\n");
        }
    }

    public ProgressBarDemo() {
        super(new BorderLayout());
    
        // Cria a interface do usuário.
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
    
        startButton = new JButton("Instalar");
        startButton.setActionCommand("Instalar");
        startButton.addActionListener(this);
    
        taskOutput = new JTextArea(5, 20);
        taskOutput.setMargin(new Insets(5, 5, 5, 5));
        taskOutput.setEditable(false);
    
        // Adiciona a barra de progresso na parte superior
        add(progressBar, BorderLayout.NORTH);
    
        // Adiciona a área de saída na parte central
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
    
        // Painel para o botão, alinhado à direita na parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(startButton);
    
        // Adiciona o painel do botão na parte inferior
        add(buttonPanel, BorderLayout.SOUTH);
    
        // Define uma borda para a janela
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    /**
     * Invoked when the user presses the start button.
     */
    public void actionPerformed(ActionEvent evt) {
        startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            taskOutput.append(String.format(
                    "Instalacao em: %d%% .\n", task.getProgress()));
        } 
        if ("progress" == evt.getPropertyName()) {
            if(task.getProgress()==100){
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            taskOutput.append(String.format(
                    "0 falhas durante a instalação.\n"));
        } 
    }
    }


    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ProgressBarDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
