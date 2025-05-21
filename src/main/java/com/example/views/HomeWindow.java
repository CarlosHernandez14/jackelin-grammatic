/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.views;

import com.example.utils.Language;
import com.github.weisj.darklaf.extensions.rsyntaxarea.DarklafRSyntaxTheme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import jnafilechooser.api.JnaFileChooser;

import org.fife.ui.rsyntaxtextarea.ErrorStrip;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

public class HomeWindow extends javax.swing.JFrame {

    private RSyntaxTextArea textArea;
    
    private List<File> openedFiles;
    private File selectedFile;
    
    private Language selectedLanguage;
    
    /**
     * Creates new form HomeWindow
     */
    public HomeWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.openedFiles = new ArrayList<>();
        this.containerTabbar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 8));
        
        // Default language
        this.radioJava.setSelected(true);
        this.radioCpp.setSelected(false);
        this.selectedLanguage = Language.JAVA;
        this.fileTree.setModel(null);
        
        initCodeEditor();
        
        initTabs();
        
        
        
    } 
    
    private void initCodeEditor() {
        this.containerCodeEditor.removeAll();
        
        RSyntaxTextArea textArea = new RSyntaxTextArea();
        textArea.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        
        Theme theme = new DarklafRSyntaxTheme();
        theme.apply(textArea);

        CustomParser parser = new CustomParser();
        parser.setSelectedLanguage(this.selectedLanguage);
        parser.setTextAreaConverted(this.textAreaConverted);
        parser.setTextAreaOutput(this.textAreaOutput);
        textArea.addParser(parser);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);

        ErrorStrip errorStrip = new ErrorStrip(textArea);
        this.containerCodeEditor.setLayout(new BorderLayout());
        
        this.textArea = textArea;
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.setBorder(null);
        // Add the code editor to the container panel
        this.containerCodeEditor.add(sp, BorderLayout.CENTER);
        this.containerCodeEditor.add(errorStrip, BorderLayout.LINE_END);
        
    }
    
    private void initTabs() {
        
        this.containerTabbar.removeAll();
        
        for (File openedFile : openedFiles) {
            PanelTab pt = new PanelTab(openedFile, this, this.selectedFile.equals(openedFile));
            
            if (this.selectedFile.equals(openedFile)) {
                try {
                    String code = new String(Files.readAllBytes(this.selectedFile.toPath()));
                    
                    this.textArea.setText(code);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar el codigo del archivo");
                    System.out.println("No se pudo cargar el codigo del archivo : " + ex.getMessage());
                }
            }
            
            this.containerTabbar.add(pt);
        }
        
        this.containerTabbar.revalidate();
        this.containerTabbar.repaint();
    }
    
    public void closeFile(File file) {
        
        int result = JOptionPane.showConfirmDialog(null, "Deseas guardar los cambios antes de cerrar?", "Guardar cambios", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            // Save the file updates
            itemSaveActionPerformed(null);
        }
        
        this.openedFiles.remove(file);
        
        try {
            this.setSelectedFile(this.openedFiles.getLast());
        } catch (Exception e) {
            System.out.println("No existen mas arhivos por cargar");
            this.textArea.setText("");
            this.setSelectedFile(null);
        }
        
        this.initTabs();
        
    }
    
    public void setSelectedFile(File file) {
        this.selectedFile = file;
        this.initTabs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupOptions = new javax.swing.JPopupMenu();
        menuLanguage = new javax.swing.JMenu();
        radioCpp = new javax.swing.JRadioButtonMenuItem();
        radioJava = new javax.swing.JRadioButtonMenuItem();
        containerWindow = new javax.swing.JPanel();
        containerNavbar = new javax.swing.JPanel();
        containerElements = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnPLAY = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        containerTabbar = new javax.swing.JPanel();
        containerBody = new javax.swing.JPanel();
        containerSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileTree = new javax.swing.JTree();
        jSeparator2 = new javax.swing.JSeparator();
        containerCodeEditor = new javax.swing.JPanel();
        containerTerminal = new javax.swing.JPanel();
        tabbedPaneTerminal = new javax.swing.JTabbedPane();
        panelOutput = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaConverted = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemOpenFile = new javax.swing.JMenuItem();
        itemOpenFolder = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();

        menuLanguage.setText("Convertion Language");

        radioCpp.setText("Cpp");
        radioCpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCppActionPerformed(evt);
            }
        });
        menuLanguage.add(radioCpp);

        radioJava.setSelected(true);
        radioJava.setText("Java");
        radioJava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioJavaActionPerformed(evt);
            }
        });
        menuLanguage.add(radioJava);

        popupOptions.add(menuLanguage);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerWindow.setBackground(new java.awt.Color(255, 255, 255));
        containerWindow.setLayout(new javax.swing.BoxLayout(containerWindow, javax.swing.BoxLayout.Y_AXIS));

        containerNavbar.setBackground(new java.awt.Color(79, 78, 78));
        containerNavbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        containerNavbar.setPreferredSize(new java.awt.Dimension(814, 50));
        containerNavbar.setLayout(new java.awt.CardLayout());

        containerElements.setBackground(new java.awt.Color(79, 78, 78));

        btnOptions.setBackground(new java.awt.Color(79, 78, 78));
        btnOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/options-icon.png"))); // NOI18N
        btnOptions.setBorderPainted(false);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });

        btnPLAY.setBackground(new java.awt.Color(79, 78, 78));
        btnPLAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/run-icon.png"))); // NOI18N
        btnPLAY.setBorderPainted(false);
        btnPLAY.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        containerTabbar.setBackground(new java.awt.Color(79, 78, 78));
        containerTabbar.setMaximumSize(new java.awt.Dimension(32767, 50));
        containerTabbar.setMinimumSize(new java.awt.Dimension(712, 50));
        containerTabbar.setPreferredSize(new java.awt.Dimension(712, 50));

        javax.swing.GroupLayout containerTabbarLayout = new javax.swing.GroupLayout(containerTabbar);
        containerTabbar.setLayout(containerTabbarLayout);
        containerTabbarLayout.setHorizontalGroup(
            containerTabbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        containerTabbarLayout.setVerticalGroup(
            containerTabbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(containerTabbar);

        javax.swing.GroupLayout containerElementsLayout = new javax.swing.GroupLayout(containerElements);
        containerElements.setLayout(containerElementsLayout);
        containerElementsLayout.setHorizontalGroup(
            containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerElementsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptions)
                .addContainerGap())
        );
        containerElementsLayout.setVerticalGroup(
            containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(containerElementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerNavbar.add(containerElements, "card2");

        containerWindow.add(containerNavbar);

        containerBody.setBackground(new java.awt.Color(79, 78, 78));
        containerBody.setLayout(new javax.swing.BoxLayout(containerBody, javax.swing.BoxLayout.X_AXIS));

        containerSidebar.setBackground(new java.awt.Color(79, 78, 78));

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("EXPLORER");

        jScrollPane1.setBorder(null);

        fileTree.setBackground(new java.awt.Color(79, 78, 78));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Folder");
        fileTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        fileTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                fileTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(fileTree);

        javax.swing.GroupLayout containerSidebarLayout = new javax.swing.GroupLayout(containerSidebar);
        containerSidebar.setLayout(containerSidebarLayout);
        containerSidebarLayout.setHorizontalGroup(
            containerSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        containerSidebarLayout.setVerticalGroup(
            containerSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerBody.add(containerSidebar);

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        containerBody.add(jSeparator2);

        containerCodeEditor.setBackground(new java.awt.Color(242, 242, 242));
        containerCodeEditor.setMinimumSize(new java.awt.Dimension(600, 425));
        containerCodeEditor.setPreferredSize(new java.awt.Dimension(600, 425));
        containerCodeEditor.setLayout(new java.awt.CardLayout());
        containerBody.add(containerCodeEditor);

        containerWindow.add(containerBody);

        containerTerminal.setBackground(new java.awt.Color(79, 78, 78));
        containerTerminal.setMinimumSize(new java.awt.Dimension(0, 0));
        containerTerminal.setLayout(new java.awt.CardLayout(5, 5));

        tabbedPaneTerminal.setBackground(new java.awt.Color(79, 78, 78));
        tabbedPaneTerminal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        panelOutput.setBackground(new java.awt.Color(79, 78, 78));
        panelOutput.setLayout(new java.awt.CardLayout());

        textAreaOutput.setBackground(new java.awt.Color(64, 63, 63));
        textAreaOutput.setColumns(20);
        textAreaOutput.setLineWrap(true);
        textAreaOutput.setRows(5);
        jScrollPane3.setViewportView(textAreaOutput);

        panelOutput.add(jScrollPane3, "card2");

        tabbedPaneTerminal.addTab("OUTPUT", panelOutput);

        jPanel1.setBackground(new java.awt.Color(79, 78, 78));
        jPanel1.setLayout(new java.awt.CardLayout());

        textAreaConverted.setBackground(new java.awt.Color(66, 65, 65));
        textAreaConverted.setColumns(20);
        textAreaConverted.setLineWrap(true);
        textAreaConverted.setRows(5);
        jScrollPane4.setViewportView(textAreaConverted);

        jPanel1.add(jScrollPane4, "card2");

        tabbedPaneTerminal.addTab("CONVERTED", jPanel1);

        containerTerminal.add(tabbedPaneTerminal, "card2");

        containerWindow.add(containerTerminal);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setForeground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("File");

        itemOpenFile.setText("Open File");
        itemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOpenFileActionPerformed(evt);
            }
        });
        fileMenu.add(itemOpenFile);

        itemOpenFolder.setText("Open Folder");
        itemOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOpenFolderActionPerformed(evt);
            }
        });
        fileMenu.add(itemOpenFolder);

        itemSave.setText("Save");
        itemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaveActionPerformed(evt);
            }
        });
        fileMenu.add(itemSave);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOpenFileActionPerformed
        // TODO add your handling code here:
        
        JnaFileChooser fc = new JnaFileChooser();
        fc.addFilter("All Files", "*");
        if (fc.showOpenDialog(this)) {
            File selectedFile = fc.getSelectedFile();
            this.openedFiles.add(selectedFile);
            this.selectedFile = selectedFile;
            // Refresh tabs
            this.initTabs();
        }
        
    }//GEN-LAST:event_itemOpenFileActionPerformed

    private void itemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveActionPerformed
        // TODO add your handling code here:
        
        // Save the selected file
        if (selectedFile == null) {
            JnaFileChooser fc = new JnaFileChooser();
            // Mostrar únicamente ficheros (y la caja de texto para teclear un nuevo nombre)
            fc.setMode(JnaFileChooser.Mode.Files);
            fc.addFilter("All files", "*");
            fc.setTitle("Guardar como…");
            if (fc.showSaveDialog(this)) {
                File picked = fc.getSelectedFile();
                // Forzar extensión .java si no la incluye
                selectedFile = picked;
                openedFiles.add(selectedFile);
                
            } else {
                // El usuario canceló el diálogo
                return;
            }
        }
        

        try {
            // Obtiene el texto del editor
            String codigo = textArea.getText();
            // Escribe (sobrescribe) el fichero en UTF-8
            Files.write(selectedFile.toPath(), codigo.getBytes(StandardCharsets.UTF_8));
            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente.", 
                                          "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al guardar el archivo:\n" + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initTabs();
        
    }//GEN-LAST:event_itemSaveActionPerformed

    private void btnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsActionPerformed
        // TODO add your handling code here:
        
        this.popupOptions.show(this.btnOptions, 0, this.btnOptions.getHeight());
        
        
    }//GEN-LAST:event_btnOptionsActionPerformed

    private void radioCppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCppActionPerformed
        // TODO add your handling code here:
        this.radioJava.setSelected(false);
        this.selectedLanguage = Language.CPP;
        
        this.initCodeEditor();
    }//GEN-LAST:event_radioCppActionPerformed

    private void radioJavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioJavaActionPerformed
        // TODO add your handling code here:
        this.radioCpp.setSelected(false);
        this.selectedLanguage = Language.JAVA;
        
        this.initCodeEditor();
    }//GEN-LAST:event_radioJavaActionPerformed

    private void itemOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOpenFolderActionPerformed
        // TODO add your handling code here:
        
        JnaFileChooser fc = new JnaFileChooser();
        fc.setMode(JnaFileChooser.Mode.Directories);
        
        if (fc.showOpenDialog(this)) {
            // Get the picked directory
            File rootDir = fc.getSelectedFile();
            buildTree(rootDir);
        }
        
    }//GEN-LAST:event_itemOpenFolderActionPerformed

    private void fileTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_fileTreeValueChanged
        // TODO add your handling code here:
        // Obtén el nodo seleccionado
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                fileTree.getLastSelectedPathComponent();
        if (node == null) return;

        // Recupera el objeto asociado (nuestro File)
        Object obj = node.getUserObject();
        if (obj instanceof File) {
            File sel = (File) obj;
            // Carga el fichero en el editor
            if (!(this.openedFiles.contains(sel)))
                this.openedFiles.add(sel); // Add the new opened file
            this.selectedFile = sel; // Set it as selected
            initTabs();
        }
        
    }//GEN-LAST:event_fileTreeValueChanged

    private DefaultMutableTreeNode createNodes(File dir) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    node.add(createNodes(f));              // Subcarpeta
                } else {
                    node.add(new DefaultMutableTreeNode(f)); // Fichero
                }
            }
        }
        return node;
    }
    
    private void buildTree(File rootDir) {
        DefaultMutableTreeNode rootNode = createNodes(rootDir);
        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        
        this.fileTree.setModel(model);

        // Opcional: mostrar líneas de conexión y expandir la primera rama
        fileTree.setShowsRootHandles(true);
        fileTree.setRootVisible(true);
        fileTree.expandRow(0);

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnPLAY;
    private javax.swing.JPanel containerBody;
    private javax.swing.JPanel containerCodeEditor;
    private javax.swing.JPanel containerElements;
    private javax.swing.JPanel containerNavbar;
    private javax.swing.JPanel containerSidebar;
    private javax.swing.JPanel containerTabbar;
    private javax.swing.JPanel containerTerminal;
    private javax.swing.JPanel containerWindow;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTree fileTree;
    private javax.swing.JMenuItem itemOpenFile;
    private javax.swing.JMenuItem itemOpenFolder;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenu menuLanguage;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPopupMenu popupOptions;
    private javax.swing.JRadioButtonMenuItem radioCpp;
    private javax.swing.JRadioButtonMenuItem radioJava;
    private javax.swing.JTabbedPane tabbedPaneTerminal;
    private javax.swing.JTextArea textAreaConverted;
    private javax.swing.JTextArea textAreaOutput;
    // End of variables declaration//GEN-END:variables
}
