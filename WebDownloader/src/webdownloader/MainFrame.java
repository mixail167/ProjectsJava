package webdownloader;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    private static FileNameExtensionFilter filter;
    private static Thread t;
    private static MainFrame mainFrame;
    private static boolean exit;

    private void CheckPaths(String path1) {
        File file = new File(path1);
        if (!file.isFile() || !file.exists()) {
            JOptionPane.showMessageDialog(MainFrame.this, "Неверный путь к файлу загрузки", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean CheckPaths(File file, File directory) {
        if (!file.isFile() || !file.exists()) {
            JOptionPane.showMessageDialog(MainFrame.this, "Неверный путь к файлу загрузки", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regex = "^([a-zA-Z]:\\\\|[a-zA-Z]:(\\\\(\\b[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"][^\\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"]*[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"]\\b|[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"]))+|[a-zA-Z]:\\\\((\\b[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"][^\\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"]*[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"]\\b|[^ \\\\\\/\\*\\:\\?\\<\\>\\|\\\"\"])\\\\)+)$";
        if (directory.getPath().matches(regex)) {
            if (!directory.exists()) {
                directory.mkdirs();
                if (directory.exists()) {
                    return true;
                }
            } else {
                return true;
            }
        }
        JOptionPane.showMessageDialog(MainFrame.this, "Неверный путь к папке загрузки", "Ошибка", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public MainFrame() {
        initComponents();
    }

    public MainFrame(String path1) {
        initComponents();
        jTextField1.setText(path1);
        CheckPaths(path1);
    }

    public MainFrame(String path1, String path2) {
        initComponents();
        jTextField1.setText(path1);
        jTextField2.setText(path2);
        Download(path1, path2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jProgressBar2 = new javax.swing.JProgressBar();

        jFileChooser1.setCurrentDirectory(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebDownloader");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jLabel1.setText("Путь к файлу загрузки:");

        jLabel2.setText("Путь к папке загрузки:");

        jButton1.setText("Запуск");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Отмена");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Журнал:");

        jButton3.setText("Обзор...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Обзор...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Очистить");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 178, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String ShowDialog(String path, boolean isFile) {
        jFileChooser1.setSelectedFile(null);
        jFileChooser1.setCurrentDirectory(new File(path));
        String title;
        if (isFile) {
            title = "Выбрать файл";
            jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jFileChooser1.setFileFilter(filter);
        } else {
            title = "Выбрать папку";
            jFileChooser1.removeChoosableFileFilter(filter);
            jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setDialogTitle(title);
        if (jFileChooser1.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            return jFileChooser1.getSelectedFile().getPath();
        }
        return "";
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String path = ShowDialog(jTextField1.getText(), true);
        if (!"".equals(path)) {
            jTextField1.setText(path);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String path = ShowDialog(jTextField2.getText(), false);
        if (!"".equals(path)) {
            jTextField2.setText(path);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        exit = true;
        try {
            t.join();
        } catch (InterruptedException ex) {
        }
        UpdateLog("Отмена операции.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EnableComponents(boolean flag) {
        jButton1.setEnabled(flag);
        jButton2.setEnabled(!flag);
        jButton3.setEnabled(flag);
        jButton4.setEnabled(flag);
        jButton5.setEnabled(flag);
        jTextField1.setEnabled(flag);
        jTextField2.setEnabled(flag);
        jProgressBar1.setValue(0);
        jProgressBar2.setValue(0);
    }

    private void Download(String path1, String path2) {
        File file = new File(path1);
        File directory = new File(path2);
        if (CheckPaths(file, directory)) {
            if (!directory.exists()) {
                directory.mkdir();
            }
        } else {
            return;
        }
        exit = false;
        EnableComponents(false);
        t = new Thread(() -> {
            UpdateLog("Чтение файла...");
            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
                if (!exit) {
                    jProgressBar1.setMaximum(lines.size());
                    for (String line : lines) {
                        if (exit) {
                            return;
                        }
                        URL website;
                        try {
                            website = new URL(line);
                        } catch (MalformedURLException ex) {
                            UpdateLog("Ошибка: " + ex.getMessage());
                            continue;
                        }
                        int sizeInt;
                        try {
                            URLConnection conn = website.openConnection();
                            long size = conn.getContentLengthLong();
                            if (size > Integer.MAX_VALUE) {
                                sizeInt = Integer.MAX_VALUE;
                            } else if (size == -1) {
                                UpdateLog("Ошибка: Размер файла неизвестен.");
                                continue;
                            } else {
                                sizeInt = Integer.parseInt(String.valueOf(size));
                            }
                        } catch (IOException ex) {
                            UpdateLog("Ошибка: " + ex.getMessage());
                            continue;
                        }
                        ReadableByteChannel rbc;
                        try {
                            rbc = Channels.newChannel(website.openStream());
                        } catch (IOException ex) {
                            UpdateLog("Ошибка: " + ex.getMessage());
                            continue;
                        }
                        String path = directory.getPath();
                        if (!path.endsWith("\\")) {
                            path += "\\";
                        }
                        path += line.substring(line.lastIndexOf("/") + 1);
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(path);
                            try {
                                UpdateLog("Загрузка данных по URL " + line + "...");
                                ByteBuffer data = ByteBuffer.allocate(1024);
                                int countSum = 0;
                                jProgressBar2.setMaximum(sizeInt);
                                while (rbc.read(data) != -1) {
                                    if (exit) {
                                        return;
                                    }
                                    byte[] buf = data.array();
                                    fos.write(buf, 0, buf.length);
                                    countSum += buf.length;
                                    UpdateProgress(jProgressBar2, countSum);
                                    if (countSum >= sizeInt) {
                                        break;
                                    }
                                }
                            } catch (IOException ex) {
                                UpdateLog("Ошибка: " + ex.getMessage());
                            } finally {
                                try {
                                    fos.close();
                                } catch (IOException ex) {

                                }
                                rbc.close();
                            }
                        } catch (FileNotFoundException ex) {
                            UpdateLog("Файл не найден.");
                        } finally {
                            UpdateProgress(jProgressBar1, jProgressBar1.getValue() + 1);
                        }
                        UpdateProgress(jProgressBar2, 0);
                    }
                    UpdateLog("Операция завершена.");
                }
            } catch (IOException ex) {
                UpdateLog("Ошибка чтения файла.");
            } finally {
                EnableComponents(true);
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void UpdateProgress(JProgressBar jProgressBar, int value) {
        SwingUtilities.invokeLater(() -> {
            jProgressBar.setValue(exit ? 0 : value);
        });
    }

    private void UpdateLog(String text) {
        SwingUtilities.invokeLater(() -> {
            jTextArea1.append(text + "\n");
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Download(jTextField1.getText(), jTextField2.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

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
            case 1:
                mainFrame = new MainFrame(args[0]);
                break;
            default:
                mainFrame = new MainFrame(args[0], args[1]);
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
