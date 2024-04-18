package Frontend;

import Backend.Book;
import Backend.BookDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ViewBooks extends javax.swing.JFrame {

    
    public ViewBooks() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnCreate.setText("Create Book");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnRead.setText("List Books");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnUpdate.setText("Update Book");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnDelete.setText("Delete Book");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(976, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // String userInput = JOptionPane.showInputDialog(frame, "Enter your name:");
        String title = JOptionPane.showInputDialog(null, "Books title:");
        int pages = Integer.valueOf(JOptionPane.showInputDialog(null, "Number of pages:"));
        int chapters = Integer.valueOf(JOptionPane.showInputDialog(null, "Number of chapters:"));
        String summary = JOptionPane.showInputDialog(null, "Enter summary:");
        String author = JOptionPane.showInputDialog(null, "Enter author's name:");
        
        System.out.println(title);
        System.out.println(pages);
        System.out.println(chapters);
        System.out.println(summary);
        System.out.println(author);
        
        Book book = new Book(title, pages, chapters, summary, author);
        System.out.println(book);
        
        BookDAO bookDAO = new BookDAO();
        int result = bookDAO.insertBook(book);
        if(result == 1){
            System.out.println("Book has been inserted successfully");
        }else{
            System.out.println("Unable to create book");
        }
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.selectAllBooks();
        ArrayList<String> temporalBooks = new ArrayList<>();
        
        for(Book book : books){
            temporalBooks.add(book.getTitle());
            System.out.println(book);
        }
        System.out.println(temporalBooks);
        // JOptionPane.showMessageDialog(null, books);
        JOptionPane.showMessageDialog(null, temporalBooks);
        
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.selectAllBooks();
        ArrayList<String> temporalBooks = new ArrayList<>();
        
        for(Book book : books){
            temporalBooks.add(book.getIdBook() + ". " + book.getTitle() + "\n");
            System.out.println(book);
        }
        System.out.println(temporalBooks);
        // JOptionPane.showMessageDialog(null, books);
        //JOptionPane.showMessageDialog(null, temporalBooks);
        int idBook = Integer.valueOf(JOptionPane.showInputDialog(null, temporalBooks +  "\nID Book:"));
        
        String title = JOptionPane.showInputDialog(null, "Books title:");
        int pages = Integer.valueOf(JOptionPane.showInputDialog(null, "Number of pages:"));
        int chapters = Integer.valueOf(JOptionPane.showInputDialog(null, "Number of chapters:"));
        String summary = JOptionPane.showInputDialog(null, "Enter summary:");
        String author = JOptionPane.showInputDialog(null, "Enter author's name:");
        
        System.out.println(title);
        System.out.println(pages);
        System.out.println(chapters);
        System.out.println(summary);
        System.out.println(author);
        
        Book book = new Book(title, pages, chapters, summary, author);
        System.out.println(book);
        
        int result = bookDAO.updateBook(book, idBook);
        if(result == 1){
            System.out.println("Book has been updated successfully");
        }else{
            System.out.println("Unable to update book");
        } 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.selectAllBooks();
        ArrayList<String> temporalBooks = new ArrayList<>();
        
        for(Book book : books){
            temporalBooks.add(book.getIdBook() + ". " + book.getTitle() + "\n");
            System.out.println(book);
        }
        System.out.println(temporalBooks);
        // JOptionPane.showMessageDialog(null, books);
        //JOptionPane.showMessageDialog(null, temporalBooks);
        int idBook = Integer.valueOf(JOptionPane.showInputDialog(null, temporalBooks +  "\nID Book:"));
        
        int result = bookDAO.deleteBook(idBook);
        if(result == 1){
            System.out.println("Book has been deleted successfully");
        }else{
            System.out.println("Unable to delete book");
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    // End of variables declaration//GEN-END:variables
}
