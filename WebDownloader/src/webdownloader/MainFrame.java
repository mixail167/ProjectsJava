package webdownloader;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    private static FileNameExtensionFilter filter;
    private static MainFrame mainFrame;

    private boolean CheckPaths(File file) {
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return true;
    }

    private void UpdateLog(String text) {
        SwingUtilities.invokeLater(() -> {
            jTextArea1.append(text + "\n");
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        });
    }

    public MainFrame() {
        initComponents();
    }

    public MainFrame(String path1) {
        initComponents();
        jTextField1.setText(path1);
        Download(path1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        jFileChooser1.setCurrentDirectory(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebDownloader");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jLabel1.setText("Путь к файлу загрузки:");

        jTextField1.addMouseListener(new ContextMenuMouseListener());

        jButton1.setText("Запуск");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Обзор...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Журнал:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Очистить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 178, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String ShowDialog(String path) {
        jFileChooser1.setSelectedFile(null);
        jFileChooser1.setCurrentDirectory(new File(path));
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser1.setFileFilter(filter);
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setDialogTitle("Выбрать файл");
        if (jFileChooser1.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            return jFileChooser1.getSelectedFile().getPath();
        }
        return "";
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String path = ShowDialog(jTextField1.getText());
        if (!"".equals(path)) {
            jTextField1.setText(path);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Download(String path1) {
        File file = new File(path1);
        if (!CheckPaths(file)) {
            UpdateLog("Неверный путь к файлу загрузки.");
        }
        else
        {
            try {
                UpdateLog("Чтение файла.");
                Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8).forEach((line) -> {
                    try {
                        Desktop.getDesktop().browse(new URI(line));
                    } catch (URISyntaxException | IOException ex) {
                        UpdateLog("Ошибка: " + ex.getMessage());
                    }
                });
            } catch (IOException ex) {
                UpdateLog("Ошибка: " + ex.getMessage());
            }
            finally{
                UpdateLog("Операция завершена.");
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Download(jTextField1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        ResourceBundle resource = ResourceBundle.getBundle("webdownloader.data");
        resource.keySet().forEach((s) -> {
            UIManager.put(s, resource.getString(s));
        });
        filter = new FileNameExtensionFilter("Download Files", "dwl");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        switch (args.length) {
            case 0:
                mainFrame = new MainFrame();
                break;
            default:
                mainFrame = new MainFrame(args[0]);
                break;
        }
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
