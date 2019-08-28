/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.AnswerPojo;
import techquizapp.pojo.AnswerStorePojo;
import techquizapp.pojo.ExamPojo;
import techquizapp.pojo.PerformancePojo;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

public class TakeTestFrame extends javax.swing.JFrame {

   private String subjectName;
   private ExamPojo exam;
   private AnswerStorePojo astore;
   private QuestionStore qstore;
   private int qno,pos=0;
   
    public TakeTestFrame() {
        initComponents();
        
        super.setLocationRelativeTo(this);
        lblUsername.setText("Hello "+UserProfile.getUsername());
        setTitle("THE TECH QUIZ APP");
        qstore=new QuestionStore();
        astore=new AnswerStorePojo();
        qno=1;
        lblQno.setText(lblQno.getText()+qno);
      
    }
    public TakeTestFrame(ExamPojo examPojo)
    {
        this();
        this.exam=examPojo;
        lblTitle.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblQno = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jrOption1 = new javax.swing.JRadioButton();
        jrOption2 = new javax.swing.JRadioButton();
        jrOption3 = new javax.swing.JRadioButton();
        jrOption4 = new javax.swing.JRadioButton();

        lblTime.setBackground(new java.awt.Color(255, 255, 255));
        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUsername.setBackground(new java.awt.Color(0, 0, 0));
        lblUsername.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 102, 0));
        lblUsername.setText("Hello ");

        lblLogout.setBackground(new java.awt.Color(0, 0, 0));
        lblLogout.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 102, 0));
        lblLogout.setText("LogOut");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 102, 0));
        lblTitle.setText("      JAVA  PAPER");

        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        lblQno.setBackground(new java.awt.Color(0, 0, 0));
        lblQno.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 102, 0));
        lblQno.setText("Question No");

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 255, 255));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jrOption1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption1);
        jrOption1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jrOption1.setForeground(new java.awt.Color(255, 102, 0));
        jrOption1.setText("jRadioButton1");

        jrOption2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption2);
        jrOption2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jrOption2.setForeground(new java.awt.Color(255, 102, 0));
        jrOption2.setText("jRadioButton2");

        jrOption3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption3);
        jrOption3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jrOption3.setForeground(new java.awt.Color(255, 102, 0));
        jrOption3.setText("jRadioButton3");

        jrOption4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption4);
        jrOption4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jrOption4.setForeground(new java.awt.Color(255, 102, 0));
        jrOption4.setText("jRadioButton4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnPrevious)
                .addGap(51, 51, 51)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(114, 114, 114)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblQno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(lblLogout))
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQno))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrOption1)
                    .addComponent(jrOption2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrOption3)
                    .addComponent(jrOption4))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnCancel)
                    .addComponent(btnDone)
                    .addComponent(btnPrevious))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed

        String chosenAnswer=getUserAnswer();
         System.out.println("My Chosen Answer "+chosenAnswer+"\n");
         
         //newAnswer=null,answer=null;
        if(chosenAnswer!=null)
        {
            QuestionPojo question=qstore.getQuestion(pos);
            String correctAnswer=question.getCorrectAnswer();
            AnswerPojo newAnswer=new AnswerPojo(exam.getExamId(),exam.getLanguage(),chosenAnswer,correctAnswer,qno);
             //System.out.println("1st Object "+newAnswer);
            AnswerPojo answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
        
        else
        {
            if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newAnswer);
            }
        }
        }
        
        int remaining_questions=0;
          for(QuestionPojo question:qstore.getAllQuestions())
        {
            int qno=question.getQno();
           
            AnswerPojo answer=astore.getAnswerByQno(qno);
              System.out.println(qno+" "+answer);
            if(answer==null)
            remaining_questions++;
        }        
        
          if(remaining_questions>0)
        {
          int ans=JOptionPane.showConfirmDialog(null,"You  have  not  answered "+remaining_questions+" questions\n\nDo you want to continue?","Confirmation!!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(ans==JOptionPane.NO_OPTION)
        {
            return;
        }
       }     
        int right=0,wrong=0;
        for(QuestionPojo question:qstore.getAllQuestions())
        {
            int qno=question.getQno();
           
            AnswerPojo answer=astore.getAnswerByQno(qno);
              System.out.println(qno+" "+answer);
            if(answer==null)
                continue;
            else
            {
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                //System.out.println(chosenAnswer1+" "+correctAnswer);
                if(chosenAnswer1.equals(correctAnswer))
                    ++right;
                else
                    ++wrong;
            }
        }
        System.out.println("Right: "+right+"Wrong: "+wrong);
        String reportCard="Total Questions:"+qstore.getCount();
        reportCard+="\nRight Answers: "+right;
        reportCard+="\nWrong Answers: "+wrong;
        reportCard+="\nUnAttempted: "+(qstore.getCount()-(right+wrong));
        JOptionPane.showMessageDialog(null,reportCard,"Your Result!",JOptionPane.INFORMATION_MESSAGE);
        try{
            PerformancePojo perforance=new PerformancePojo(exam.getExamId(),exam.getLanguage(),UserProfile.getUsername(),right,wrong,qstore.getCount()-(right+wrong),(double)right/qstore.getCount()*100);
            PerformanceDAO.addPerformance(perforance);
            JOptionPane.showMessageDialog(null,"Your performance has been successfully added to database","Performance Added!",JOptionPane.INFORMATION_MESSAGE);
            new PaperSelectionFrame().setVisible(true);
            this.dispose();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error While Connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
      new PaperSelectionFrame().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAnswer=getUserAnswer();
        //AnswerPojo newAnswer=null,answer=null;
        if(chosenAnswer!=null)
        {
            QuestionPojo question=qstore.getQuestion(pos);
            String correctAnswer=question.getCorrectAnswer();
            AnswerPojo newAnswer=new AnswerPojo(exam.getExamId(),exam.getLanguage(),chosenAnswer,correctAnswer,qno);
             System.out.println(newAnswer);
            AnswerPojo answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
        
        else
        {
            if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newAnswer);
            }
        }
            
        }
            pos++;
            if(pos>=qstore.getCount())
              pos=0;
            
            qno++;
            if(qno>qstore.getCount())
                qno=1;
            lblQno.setText("Question No: "+qno);
            showQuestion();
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        lblLogout.setForeground(new Color(255,152,0));
        Font f=new Font("Arial Black",Font.BOLD,14);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setForeground(Color.WHITE);
        Font f=new Font("Tahoma",Font.BOLD,16);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        this.dispose();

        (new LogInFrame()).setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
         String chosenAnswer=getUserAnswer();
       // AnswerPojo newAnswer=null,answer=null;
        if(chosenAnswer!=null)
        {
            QuestionPojo question=qstore.getQuestion(pos);
            String correctAnswer=question.getCorrectAnswer();
            AnswerPojo newAnswer=new AnswerPojo(exam.getExamId(),exam.getLanguage(),chosenAnswer,correctAnswer,qno);
            AnswerPojo  answer=astore.getAnswerByQno(qno);
            if(answer==null)
                astore.addAnswer(newAnswer);
        
        else
        {
            if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newAnswer);
            }
        }
        }
            pos--;
            if(pos<0)
            {
                pos=qstore.getCount()-1;
            }
            qno--;
            if(qno<=0)
            {
                qno=qstore.getCount();
               
            }
         lblQno.setText("Question No: "+qno);
                showQuestion();
    }//GEN-LAST:event_btnPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrOption1;
    private javax.swing.JRadioButton jrOption2;
    private javax.swing.JRadioButton jrOption3;
    private javax.swing.JRadioButton jrOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
    public void loadQuestions()
    {
        try{
            ArrayList<QuestionPojo> questionList=QuestionDAO.getQuestionsByExamId(exam.getExamId());
            
            for(QuestionPojo obj:questionList)
                qstore.addQuestion(obj);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Some Exception Occured while connecting to DB!!","Exception!!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
                   
        }
    }
     public void showQuestion()
     {
         QuestionPojo question=qstore.getQuestion(pos);
         buttonGroup1.clearSelection();
         txtQuestion.setText(question.getQuestion());
         jrOption1.setText(question.getAnswer1());
         jrOption2.setText(question.getAnswer2());
         jrOption3.setText(question.getAnswer3());
         jrOption4.setText(question.getAnswer4());
         AnswerPojo answer=astore.getAnswerByQno(qno);
         if(answer==null)
             return;
         String chosenAnswer=answer.getChosenAnswer();
         switch(chosenAnswer)
         {
             case "Answer1":
                 jrOption1.setSelected(true);
                 break;
                 case "Answer2":
                 jrOption2.setSelected(true);
                 break;
                 case "Answer3":
                 jrOption3.setSelected(true);
                 break;
                 case "Answer4":
                 jrOption4.setSelected(true);
                 break;
                 
         }
     }
     public String getUserAnswer()
     {
         if(jrOption1.isSelected())
             return "Answer1";
         else if(jrOption2.isSelected())
             return "Answer2";
         else if(jrOption3.isSelected())
             return "Answer3";
         else if(jrOption4.isSelected())
             return "Answer4";
         else
             return null;
                     
     }
  private static void runTime()
  {
      
  }

}
