/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example.views;

import java.awt.Color;
import java.io.File;


public class PanelTab extends javax.swing.JPanel {

    private File file;
    private HomeWindow homeWindow;
    private boolean isSelected;
    
    /**
     * Creates new form PanelTab
     */
    public PanelTab() {
        initComponents();
    }
    
    public PanelTab(File file, HomeWindow homeWindow, boolean isSelected) {
        initComponents();
        this.isSelected = isSelected;
        this.file = file;
        this.homeWindow = homeWindow;
        initData();
    }
    
    private void initData() {
        
        this.labelFileName.setText(this.file.getName());
        
        if(this.isSelected) {
            this.setBackground(new Color(102,102,102));
            this.buttonClose.setBackground(new Color(102,102,102));
        }
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFileName = new javax.swing.JLabel();
        buttonClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(79, 78, 78));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        labelFileName.setForeground(new java.awt.Color(204, 204, 204));
        labelFileName.setText("NombreArchivo");
        labelFileName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFileName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFileNameMouseClicked(evt);
            }
        });

        buttonClose.setBackground(new java.awt.Color(79, 78, 78));
        buttonClose.setForeground(new java.awt.Color(204, 204, 204));
        buttonClose.setText("X");
        buttonClose.setBorderPainted(false);
        buttonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonClose))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // TODO add your handling code here:
        
        this.homeWindow.closeFile(this.file);
        
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void labelFileNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFileNameMouseClicked
        // TODO add your handling code here:
        this.homeWindow.setSelectedFile(file);
    }//GEN-LAST:event_labelFileNameMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JLabel labelFileName;
    // End of variables declaration//GEN-END:variables
}
