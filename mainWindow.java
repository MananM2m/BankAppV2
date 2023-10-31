package org.example;

//imports
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
//end of imports

/**
 *
 * @author manan
 */
public class mainWindow extends javax.swing.JFrame {
    private int loggedInPerson; //The id of the current person that is logged in. Stored and retrieved from Bank class (HashCode of the user's username)
    private final Bank bank; //Instance of class Bank. Controls all banking operations.

    //Start of variable declaration for GUI and other components
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton button_account_deposit;
    private javax.swing.JButton button_account_transactions;
    private javax.swing.JButton button_account_withdraw;
    private javax.swing.JButton button_deposit_deposit;
    private javax.swing.JButton button_exampleUser;
    private javax.swing.JButton button_export_export;
    private javax.swing.JButton button_login;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_logout_no;
    private javax.swing.JButton button_logout_yes;
    private javax.swing.JButton button_signup;
    private javax.swing.JButton button_signup_signup;
    private javax.swing.JButton button_withdraw_withdraw;
    private javax.swing.JDialog dialog_deposit;
    private javax.swing.JDialog dialog_export;
    private javax.swing.JDialog dialog_logout;
    private javax.swing.JDialog dialog_logoutb4closing;
    private javax.swing.JDialog dialog_signup;
    private javax.swing.JDialog dialog_transactions;
    private javax.swing.JDialog dialog_withdraw;
    private javax.swing.JFrame frame_account;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_account_checking;
    private javax.swing.JLabel label_account_checking_balance;
    private javax.swing.JLabel label_account_savings;
    private javax.swing.JLabel label_account_savings_balance;
    private javax.swing.JLabel label_account_title;
    private javax.swing.JLabel label_account_title1;
    private javax.swing.JLabel label_deposit_$;
    private javax.swing.JLabel label_deposit_amount;
    private javax.swing.JLabel label_deposit_selectaccount;
    private javax.swing.JLabel label_deposit_title;
    private javax.swing.JLabel label_deposit_toaccount;
    private javax.swing.JLabel label_deposit_validamount;
    private javax.swing.JLabel label_incorrect;
    private javax.swing.JLabel label_logout_title;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_signup_password;
    private javax.swing.JLabel label_signup_title;
    private javax.swing.JLabel label_signup_username;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_username;
    private javax.swing.JLabel label_usertaken;
    private javax.swing.JLabel label_withdraw_$;
    private javax.swing.JLabel label_withdraw_amount;
    private javax.swing.JLabel label_withdraw_insufficient;
    private javax.swing.JLabel label_withdraw_selectaccount;
    private javax.swing.JLabel label_withdraw_title;
    private javax.swing.JLabel label_withdraw_toaccount;
    private javax.swing.JLabel label_withdraw_validamount;
    private javax.swing.JButton ok;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPasswordField passwordfield_password;
    private javax.swing.JTextField passwordfield_signup_password;
    private javax.swing.JRadioButton radiobutton_deposit_checking;
    private javax.swing.JRadioButton radiobutton_deposit_savings;
    private javax.swing.JRadioButton radiobutton_export_checking;
    private javax.swing.JRadioButton radiobutton_export_savings;
    private javax.swing.JRadioButton radiobutton_withdraw_checking;
    private javax.swing.JRadioButton radiobutton_withdraw_savings;
    private javax.swing.JTable table_transactions;
    private javax.swing.JTable table_transactions1;
    private javax.swing.JTextField textfield_deposit_amount;
    private javax.swing.JTextField textfield_signup_username;
    private javax.swing.JTextField textfield_username;
    private javax.swing.JTextField textfield_withdraw_amount;
    private javax.swing.JButton transactions_export;
    //End of variable declaration

    /**
     * Creates new form mainWindow
     * Sets beginning parameters for windows and some components
     * @throws java.io.FileNotFoundException
     */
    public mainWindow() throws FileNotFoundException, IOException {

        //variables init
        bank = new Bank();
        loggedInPerson = -1;
        initComponents();

        //all error messages are set invisible
        label_usertaken.setForeground(Color.white);
        label_incorrect.setForeground(new Color(153,255,255));
        label_deposit_selectaccount.setForeground(Color.white);
        label_deposit_validamount.setForeground(Color.white);
        label_withdraw_selectaccount.setForeground(Color.white);
        label_withdraw_validamount.setForeground(Color.white);
        label_withdraw_insufficient.setForeground(Color.white);

        //all windows are centered
        this.setLocationRelativeTo(null);
        dialog_signup.setLocationRelativeTo(null);
        frame_account.setLocationRelativeTo(null);
        dialog_deposit.setLocationRelativeTo(null);
        dialog_logout.setLocationRelativeTo(null);
        dialog_withdraw.setLocationRelativeTo(null);
        dialog_transactions.setLocationRelativeTo(null);
        dialog_logoutb4closing.setLocationRelativeTo(null);
        dialog_export.setLocationRelativeTo(null);
    }


    /**
     * Initializes all GUI components and sets their position and properties
     */
    private void initComponents() {
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dialog_signup = new javax.swing.JDialog();
        label_signup_title = new javax.swing.JLabel();
        label_signup_username = new javax.swing.JLabel();
        textfield_signup_username = new javax.swing.JTextField();
        label_signup_password = new javax.swing.JLabel();
        button_signup_signup = new javax.swing.JButton();
        label_usertaken = new javax.swing.JLabel();
        passwordfield_signup_password = new javax.swing.JTextField();
        frame_account = new javax.swing.JFrame();
        label_account_title = new javax.swing.JLabel();
        label_account_checking = new javax.swing.JLabel();
        label_account_savings = new javax.swing.JLabel();
        label_account_checking_balance = new javax.swing.JLabel();
        label_account_savings_balance = new javax.swing.JLabel();
        button_account_deposit = new javax.swing.JButton();
        button_account_withdraw = new javax.swing.JButton();
        button_account_transactions = new javax.swing.JButton();
        button_logout = new javax.swing.JButton();
        dialog_deposit = new javax.swing.JDialog();
        label_deposit_title = new javax.swing.JLabel();
        label_deposit_toaccount = new javax.swing.JLabel();
        radiobutton_deposit_checking = new javax.swing.JRadioButton();
        radiobutton_deposit_savings = new javax.swing.JRadioButton();
        label_deposit_amount = new javax.swing.JLabel();
        textfield_deposit_amount = new javax.swing.JTextField();
        label_deposit_$ = new javax.swing.JLabel();
        button_deposit_deposit = new javax.swing.JButton();
        label_deposit_validamount = new javax.swing.JLabel();
        label_deposit_selectaccount = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        dialog_logout = new javax.swing.JDialog();
        label_logout_title = new javax.swing.JLabel();
        button_logout_yes = new javax.swing.JButton();
        button_logout_no = new javax.swing.JButton();
        dialog_withdraw = new javax.swing.JDialog();
        label_withdraw_title = new javax.swing.JLabel();
        label_withdraw_toaccount = new javax.swing.JLabel();
        radiobutton_withdraw_checking = new javax.swing.JRadioButton();
        radiobutton_withdraw_savings = new javax.swing.JRadioButton();
        label_withdraw_amount = new javax.swing.JLabel();
        textfield_withdraw_amount = new javax.swing.JTextField();
        label_withdraw_$ = new javax.swing.JLabel();
        button_withdraw_withdraw = new javax.swing.JButton();
        label_withdraw_validamount = new javax.swing.JLabel();
        label_withdraw_selectaccount = new javax.swing.JLabel();
        label_withdraw_insufficient = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        dialog_transactions = new javax.swing.JDialog();
        label_account_title1 = new javax.swing.JLabel();
        transactions_export = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_transactions = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_transactions1 = new javax.swing.JTable();
        dialog_logoutb4closing = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        dialog_export = new javax.swing.JDialog();
        radiobutton_export_checking = new javax.swing.JRadioButton();
        radiobutton_export_savings = new javax.swing.JRadioButton();
        button_export_export = new javax.swing.JButton();
        buttonGroup3 = new javax.swing.ButtonGroup();
        label_title = new javax.swing.JLabel();
        panel_login = new javax.swing.JPanel();
        textfield_username = new javax.swing.JTextField();
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        button_signup = new javax.swing.JButton();
        label_incorrect = new javax.swing.JLabel();
        passwordfield_password = new javax.swing.JPasswordField();
        button_exampleUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialog_signup.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_signup.setAlwaysOnTop(true);
        dialog_signup.setBackground(new java.awt.Color(153, 255, 255));
        dialog_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialog_signup.setLocationByPlatform(true);
        dialog_signup.setMinimumSize(new java.awt.Dimension(258, 210));
        dialog_signup.setResizable(false);

        label_signup_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_signup_title.setText("Sign up");

        label_signup_username.setText("Username");

        label_signup_password.setText("Password");

        button_signup_signup.setBackground(new java.awt.Color(51, 153, 255));
        button_signup_signup.setText("Sign up");
        button_signup_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signup_signupActionPerformed(evt);
            }
        });

        label_usertaken.setForeground(new java.awt.Color(255, 51, 51));
        label_usertaken.setText("Username is taken");
        label_usertaken.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                label_usertakenComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout dialog_signupLayout = new javax.swing.GroupLayout(dialog_signup.getContentPane());
        dialog_signup.getContentPane().setLayout(dialog_signupLayout);
        dialog_signupLayout.setHorizontalGroup(
                dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                .addGroup(dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(label_signup_title))
                                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label_signup_username)
                                                        .addComponent(label_signup_password))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(textfield_signup_username, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordfield_signup_password, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(label_usertaken))
                                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(button_signup_signup)))
                                .addGap(59, 59, 59))
        );
        dialog_signupLayout.setVerticalGroup(
                dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_signupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_signup_title)
                                .addGap(18, 18, 18)
                                .addGroup(dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_signup_username)
                                        .addComponent(textfield_signup_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordfield_signup_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_signup_password))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_usertaken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_signup_signup)
                                .addGap(21, 21, 21))
        );

        frame_account.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frame_account.setBackground(new java.awt.Color(204, 255, 102));
        frame_account.setMinimumSize(new java.awt.Dimension(500, 400));
        frame_account.setResizable(false);
        frame_account.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                frame_accountWindowClosing(evt);
            }
        });

        label_account_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_account_title.setText("Hello, ");

        label_account_checking.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_account_checking.setText("Checking");

        label_account_savings.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_account_savings.setText("Savings");

        label_account_checking_balance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_account_checking_balance.setText("$");

        label_account_savings_balance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_account_savings_balance.setText("$");

        button_account_deposit.setBackground(new java.awt.Color(102, 153, 255));
        button_account_deposit.setText("Deposit");
        button_account_deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_account_depositActionPerformed(evt);
            }
        });

        button_account_withdraw.setBackground(new java.awt.Color(102, 153, 255));
        button_account_withdraw.setText("Withdraw");
        button_account_withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_account_withdrawActionPerformed(evt);
            }
        });

        button_account_transactions.setBackground(new java.awt.Color(102, 153, 255));
        button_account_transactions.setText("Transactions");
        button_account_transactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_account_transactionsActionPerformed(evt);
            }
        });

        button_logout.setBackground(new java.awt.Color(255, 102, 102));
        button_logout.setText("LOG OUT");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_accountLayout = new javax.swing.GroupLayout(frame_account.getContentPane());
        frame_account.getContentPane().setLayout(frame_accountLayout);
        frame_accountLayout.setHorizontalGroup(
                frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frame_accountLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(label_account_savings)
                                                                        .addComponent(label_account_checking))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(label_account_checking_balance)
                                                                        .addComponent(label_account_savings_balance)))
                                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addComponent(button_account_deposit)
                                                                .addGap(76, 76, 76)
                                                                .addComponent(button_account_withdraw)
                                                                .addGap(74, 74, 74)
                                                                .addComponent(button_account_transactions)))
                                                .addContainerGap(52, Short.MAX_VALUE))
                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                .addComponent(label_account_title, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27))))
        );
        frame_accountLayout.setVerticalGroup(
                frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(frame_accountLayout.createSequentialGroup()
                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(label_account_title))
                                        .addGroup(frame_accountLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(89, 89, 89)
                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_account_checking)
                                        .addComponent(label_account_checking_balance))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_account_savings_balance)
                                        .addComponent(label_account_savings))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addGroup(frame_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(button_account_deposit)
                                        .addComponent(button_account_withdraw)
                                        .addComponent(button_account_transactions))
                                .addGap(57, 57, 57))
        );

        dialog_deposit.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_deposit.setMinimumSize(new java.awt.Dimension(250, 250));
        dialog_deposit.setResizable(false);

        label_deposit_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_deposit_title.setText("Deposit");

        label_deposit_toaccount.setText("To account:");

        buttonGroup1.add(radiobutton_deposit_checking);
        radiobutton_deposit_checking.setText("Checking");
        radiobutton_deposit_checking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_deposit_checkingActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiobutton_deposit_savings);
        radiobutton_deposit_savings.setText("Savings");
        radiobutton_deposit_savings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_deposit_savingsActionPerformed(evt);
            }
        });

        label_deposit_amount.setText("Amount:");

        textfield_deposit_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_deposit_amountActionPerformed(evt);
            }
        });

        label_deposit_$.setText("$");

        button_deposit_deposit.setBackground(new java.awt.Color(102, 153, 255));
        button_deposit_deposit.setText("Deposit");
        button_deposit_deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deposit_depositActionPerformed(evt);
            }
        });

        label_deposit_validamount.setForeground(new java.awt.Color(255, 51, 51));
        label_deposit_validamount.setText("Enter a valid amount");

        label_deposit_selectaccount.setForeground(new java.awt.Color(255, 51, 51));
        label_deposit_selectaccount.setText("Select an account");

        javax.swing.GroupLayout dialog_depositLayout = new javax.swing.GroupLayout(dialog_deposit.getContentPane());
        dialog_deposit.getContentPane().setLayout(dialog_depositLayout);
        dialog_depositLayout.setHorizontalGroup(
                dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                .addGroup(dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(label_deposit_title))
                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label_deposit_toaccount)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radiobutton_deposit_checking)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radiobutton_deposit_savings))
                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(label_deposit_selectaccount))
                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label_deposit_validamount)
                                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                                .addComponent(label_deposit_amount)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(label_deposit_$)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(textfield_deposit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(button_deposit_deposit)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_depositLayout.setVerticalGroup(
                dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_depositLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(label_deposit_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_deposit_toaccount)
                                        .addComponent(radiobutton_deposit_checking)
                                        .addComponent(radiobutton_deposit_savings))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_deposit_selectaccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_depositLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_deposit_amount)
                                        .addComponent(textfield_deposit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_deposit_$))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_deposit_validamount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_deposit_deposit)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        dialog_logout.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_logout.setMinimumSize(new java.awt.Dimension(174, 150));
        dialog_logout.setResizable(false);

        label_logout_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_logout_title.setText("Log out?");

        button_logout_yes.setBackground(new java.awt.Color(153, 255, 153));
        button_logout_yes.setText("Yes");
        button_logout_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logout_yesActionPerformed(evt);
            }
        });

        button_logout_no.setText("No");
        button_logout_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logout_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_logoutLayout = new javax.swing.GroupLayout(dialog_logout.getContentPane());
        dialog_logout.getContentPane().setLayout(dialog_logoutLayout);
        dialog_logoutLayout.setHorizontalGroup(
                dialog_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_logoutLayout.createSequentialGroup()
                                .addGroup(dialog_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dialog_logoutLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(button_logout_yes)
                                                .addGap(18, 18, 18)
                                                .addComponent(button_logout_no))
                                        .addGroup(dialog_logoutLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(label_logout_title)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_logoutLayout.setVerticalGroup(
                dialog_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_logoutLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(label_logout_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(button_logout_yes)
                                        .addComponent(button_logout_no))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        dialog_withdraw.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_withdraw.setMinimumSize(new java.awt.Dimension(300, 250));
        dialog_withdraw.setResizable(false);

        label_withdraw_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_withdraw_title.setText("Withdraw");

        label_withdraw_toaccount.setText("From account:");

        buttonGroup2.add(radiobutton_withdraw_checking);
        radiobutton_withdraw_checking.setText("Checking");
        radiobutton_withdraw_checking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_withdraw_checkingActionPerformed(evt);
            }
        });

        buttonGroup2.add(radiobutton_withdraw_savings);
        radiobutton_withdraw_savings.setText("Savings");
        radiobutton_withdraw_savings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_withdraw_savingsActionPerformed(evt);
            }
        });

        label_withdraw_amount.setText("Amount:");

        textfield_withdraw_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_withdraw_amountActionPerformed(evt);
            }
        });

        label_withdraw_$.setText("$");

        button_withdraw_withdraw.setBackground(new java.awt.Color(102, 153, 255));
        button_withdraw_withdraw.setText("Withdraw");
        button_withdraw_withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_withdraw_withdrawActionPerformed(evt);
            }
        });

        label_withdraw_validamount.setForeground(new java.awt.Color(255, 51, 51));
        label_withdraw_validamount.setText("Enter a valid amount");

        label_withdraw_selectaccount.setForeground(new java.awt.Color(255, 51, 51));
        label_withdraw_selectaccount.setText("Select an account");

        label_withdraw_insufficient.setForeground(new java.awt.Color(255, 51, 51));
        label_withdraw_insufficient.setText("Insufficient funds");

        javax.swing.GroupLayout dialog_withdrawLayout = new javax.swing.GroupLayout(dialog_withdraw.getContentPane());
        dialog_withdraw.getContentPane().setLayout(dialog_withdrawLayout);
        dialog_withdrawLayout.setHorizontalGroup(
                dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                                                .addComponent(label_withdraw_amount)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(label_withdraw_$)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(textfield_withdraw_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(label_withdraw_validamount)))
                                        .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                                .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label_withdraw_selectaccount)
                                                        .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(label_withdraw_toaccount)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(radiobutton_withdraw_checking))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_withdrawLayout.createSequentialGroup()
                                                                        .addGap(70, 70, 70)
                                                                        .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(label_withdraw_insufficient)
                                                                                .addComponent(button_withdraw_withdraw))))
                                                        .addComponent(label_withdraw_title))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radiobutton_withdraw_savings)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_withdrawLayout.setVerticalGroup(
                dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_withdrawLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_withdraw_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_withdraw_toaccount)
                                        .addComponent(radiobutton_withdraw_checking)
                                        .addComponent(radiobutton_withdraw_savings))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_withdraw_selectaccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialog_withdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_withdraw_amount)
                                        .addComponent(textfield_withdraw_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_withdraw_$))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_withdraw_validamount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_withdraw_insufficient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_withdraw_withdraw)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        dialog_transactions.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_transactions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialog_transactions.setLocation(new java.awt.Point(0, 0));
        dialog_transactions.setMinimumSize(new java.awt.Dimension(865, 400));
        dialog_transactions.setResizable(false);

        label_account_title1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_account_title1.setText("Transactions");

        transactions_export.setBackground(new java.awt.Color(153, 255, 255));
        transactions_export.setText("Export");
        transactions_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactions_exportActionPerformed(evt);
            }
        });

        table_transactions.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Checkings"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_transactions);

        table_transactions1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Savings"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table_transactions1);

        javax.swing.GroupLayout dialog_transactionsLayout = new javax.swing.GroupLayout(dialog_transactions.getContentPane());
        dialog_transactions.getContentPane().setLayout(dialog_transactionsLayout);
        dialog_transactionsLayout.setHorizontalGroup(
                dialog_transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_transactionsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(dialog_transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_transactionsLayout.createSequentialGroup()
                                                .addComponent(label_account_title1)
                                                .addGap(234, 234, 234)
                                                .addComponent(transactions_export)
                                                .addGap(47, 47, 47))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_transactionsLayout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        dialog_transactionsLayout.setVerticalGroup(
                dialog_transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_transactionsLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(dialog_transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(transactions_export)
                                        .addComponent(label_account_title1))
                                .addGap(15, 15, 15)
                                .addGroup(dialog_transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_logoutb4closing.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_logoutb4closing.setMinimumSize(new java.awt.Dimension(200, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Must log-out before closing");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_logoutb4closingLayout = new javax.swing.GroupLayout(dialog_logoutb4closing.getContentPane());
        dialog_logoutb4closing.getContentPane().setLayout(dialog_logoutb4closingLayout);
        dialog_logoutb4closingLayout.setHorizontalGroup(
                dialog_logoutb4closingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_logoutb4closingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dialog_logoutb4closingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ok)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_logoutb4closingLayout.setVerticalGroup(
                dialog_logoutb4closingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_logoutb4closingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(ok)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_export.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog_export.setMinimumSize(new java.awt.Dimension(238, 200));

        buttonGroup3.add(radiobutton_export_checking);
        radiobutton_export_checking.setText("Checking");
        radiobutton_export_checking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_export_checkingActionPerformed(evt);
            }
        });

        buttonGroup3.add(radiobutton_export_savings);
        radiobutton_export_savings.setText("Savings");
        radiobutton_export_savings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobutton_export_savingsActionPerformed(evt);
            }
        });

        button_export_export.setText("Export");
        button_export_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_export_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_exportLayout = new javax.swing.GroupLayout(dialog_export.getContentPane());
        dialog_export.getContentPane().setLayout(dialog_exportLayout);
        dialog_exportLayout.setHorizontalGroup(
                dialog_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_exportLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(radiobutton_export_checking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(radiobutton_export_savings)
                                .addGap(28, 28, 28))
                        .addGroup(dialog_exportLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(button_export_export)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_exportLayout.setVerticalGroup(
                dialog_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialog_exportLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(dialog_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radiobutton_export_checking)
                                        .addComponent(radiobutton_export_savings))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_export_export)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setForeground(new java.awt.Color(153, 255, 255));
        setMinimumSize(new java.awt.Dimension(310, 401));
        setResizable(false);

        label_title.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        label_title.setText("Bank");

        panel_login.setBackground(new java.awt.Color(153, 255, 255));
        panel_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textfield_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textfield_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_usernameActionPerformed(evt);
            }
        });

        label_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_username.setText("Username");

        label_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_password.setText("Password");

        button_login.setBackground(new java.awt.Color(51, 153, 255));
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        button_signup.setBackground(new java.awt.Color(51, 153, 255));
        button_signup.setText("Sign up");
        button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signupActionPerformed(evt);
            }
        });

        label_incorrect.setForeground(new java.awt.Color(255, 51, 51));
        label_incorrect.setText("Username/Password incorrect");

        button_exampleUser.setBackground(new java.awt.Color(51, 153, 255));
        button_exampleUser.setText("Example user");
        button_exampleUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exampleUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
                panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                                .addContainerGap(56, Short.MAX_VALUE)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel_loginLayout.createSequentialGroup()
                                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label_password)
                                                        .addComponent(label_username))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(textfield_username, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                        .addComponent(passwordfield_password)))
                                        .addGroup(panel_loginLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(label_incorrect)))
                                .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(button_signup)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_login)
                                .addGap(17, 17, 17))
                        .addGroup(panel_loginLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(button_exampleUser)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_loginLayout.setVerticalGroup(
                panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_loginLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_username)
                                        .addComponent(textfield_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_password)
                                        .addComponent(passwordfield_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(button_exampleUser)
                                .addGap(38, 38, 38)
                                .addComponent(label_incorrect)
                                .addGap(109, 109, 109)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(button_signup)
                                        .addComponent(button_login))
                                .addGap(136, 136, 136))
        );

        jLabel1.setText("made by Manan Mishra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(label_title)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panel_login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Runs when log in button is pressed
     * Checks if Username and password match- if they do, sets the loggedInPerson's ID and creates the account window
     * Else sets wrong password error message visible
     * @param evt
     */
    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {
        int p = bank.login(textfield_username.getText(), passwordfield_password.getText());
        if (p != -1) {
            label_incorrect.setForeground(new Color(153,255,255));

            loggedInPerson = p;
            this.dispose();
            dialog_signup.dispose();
            renderAccountWindow();

        } else {
            label_incorrect.setForeground(Color.red);

        }
    }

    /**
     * runs when sign up button is pressed
     * Creates the sign up window
     * @param evt
     */
    private void button_signupActionPerformed(java.awt.event.ActionEvent evt) {
        textfield_signup_username.setText("");
        passwordfield_signup_password.setText("");
        dialog_signup.setVisible(true);
    }


    /**
     *runs when sign up button is pressed
     * calls the Bank.newUser method, which creates a new user if current username isn't take. else sets username taken error message visible
     * @param evt
     */
    private void button_signup_signupActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!bank.newUser(textfield_signup_username.getText(), passwordfield_signup_password.getText())) {
                label_usertaken.setForeground(Color.red);
                return;
            }
        } catch (IOException ex) {

        }
        dialog_signup.setVisible(false);
    }

    private void textfield_usernameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void label_usertakenComponentHidden(java.awt.event.ComponentEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * runs when transactions button is pressed
     * gets the logged in person with bank.getPerson then gets the hashmaps of transactions for that person with Person.getTransactions.
     * Using defaultTableModels and formatters, formats the date and money amount and puts it in the tables
     * @param evt
     */
    private void button_account_transactionsActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel checkingTable = (DefaultTableModel) table_transactions.getModel();
        DefaultTableModel savingsTable = (DefaultTableModel) table_transactions1.getModel();

        int numRows = checkingTable.getRowCount();
        for(int i = 0; i < numRows;i++){
            checkingTable.removeRow(0);
        }
        numRows = savingsTable.getRowCount();
        for(int i = 0; i < numRows;i++){
            savingsTable.removeRow(0);
        }


        String[] row = new String[2];

        HashMap<LocalDateTime, Double> trans = bank.getPerson(loggedInPerson).getTransactions(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM/dd/yyyy, hh:mm a");
        DecimalFormat DecFor = new DecimalFormat("#,###.##");

        for (LocalDateTime x : trans.keySet()) {
            row[1] = DecFor.format(trans.get(x)) + "";
            row[0] = x.format(formatter);
            checkingTable.addRow(row);
        }
        trans = bank.getPerson(loggedInPerson).getTransactions(2);
        row[1] = null;
        row[0] = null;

        for (LocalDateTime x : trans.keySet()) {
            row[1] = DecFor.format(trans.get(x)) + "";
            row[0] = x.format(formatter);
            savingsTable.addRow(row);
        }

        dialog_transactions.setVisible(true);
    }

    /**
     * runs when deposit button is pressed
     * sets the deposit window visible and initial properties
     * @param evt
     */
    private void button_account_depositActionPerformed(java.awt.event.ActionEvent evt) {

        radiobutton_deposit_checking.setSelected(true);
        radiobutton_deposit_savings.setSelected(false);
        textfield_deposit_amount.setText("");
        label_deposit_selectaccount.setForeground(Color.white);
        label_deposit_validamount.setForeground(Color.white);
        dialog_deposit.setVisible(true);
    }

    private void radiobutton_deposit_checkingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radiobutton_deposit_savingsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void textfield_deposit_amountActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * runs when deposit button in the deposit window is pressed
     * deposits the inputted amount in appropriate account with bank.deposit
     * @param evt
     */
    private void button_deposit_depositActionPerformed(java.awt.event.ActionEvent evt) {

        Scanner scanner = new Scanner(textfield_deposit_amount.getText());
        if (scanner.hasNextDouble()) {
            Double amnt = scanner.nextDouble();
            if(amnt >= 0){
                if (radiobutton_deposit_checking.isSelected()) {
                    bank.deposit(loggedInPerson, amnt, 1);
                    dialog_deposit.setVisible(false);
                    renderAccountWindow();
                    return;
                }
                if (radiobutton_deposit_savings.isSelected()) {
                    bank.deposit(loggedInPerson, amnt, 2);
                    dialog_deposit.setVisible(false);
                    renderAccountWindow();
                    return;
                }
                label_deposit_selectaccount.setForeground(Color.red);
                return;
            }
            label_deposit_validamount.setForeground(Color.red);}

    }

    /**
     * runs when log out button is pressed
     * sets the logout confirmations window visible
     * @param evt
     */
    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {
        dialog_logout.setVisible(true);
    }

    /**
     * runs when yes button on logout screen is pressed
     * logs the user out by closing account window and writes all data to database with bank.write
     * @param evt
     */
    private void button_logout_yesActionPerformed(java.awt.event.ActionEvent evt) {
        frame_account.dispose();
        dialog_transactions.dispose();
        dialog_export.dispose();
        dialog_deposit.dispose();
        dialog_withdraw.dispose();

        textfield_username.setText("");
        passwordfield_password.setText("");

        dialog_logout.setVisible(false);
        try {
            bank.write();
        } catch (IOException ex) {

        }
        this.setVisible(true);
    }

    /**
     * runs when no button is pressed on logout window
     * closes the logout window
     * @param evt
     */
    private void button_logout_noActionPerformed(java.awt.event.ActionEvent evt) {
        dialog_logout.dispose();
    }

    private void radiobutton_withdraw_checkingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radiobutton_withdraw_savingsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void textfield_withdraw_amountActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * runs when withdraw button in withdraw screen is pressed
     * checks if textbox contains a valid double, if not sets valid amount error message visible
     * if it does, uses the bank.withdraw method to withdraw amount, which returns true of amount is in bounds
     * if amount is greater than balance, sets insufficient funds error message visible
     * @param evt
     */
    private void button_withdraw_withdrawActionPerformed(java.awt.event.ActionEvent evt) {
        Scanner scanner = new Scanner(textfield_withdraw_amount.getText());
        if (scanner.hasNextDouble()) {

            double amount = scanner.nextDouble();
            if(amount >= 0){
                if (radiobutton_withdraw_checking.isSelected()) {
                    if (!bank.withdraw(loggedInPerson, amount, 1)) {
                        label_withdraw_insufficient.setForeground(Color.red);
                        return;
                    }

                    dialog_withdraw.setVisible(false);
                    renderAccountWindow();
                    return;
                }
                if (radiobutton_withdraw_savings.isSelected()) {
                    if (!bank.withdraw(loggedInPerson, amount, 2)) {
                        label_withdraw_insufficient.setForeground(Color.red);
                        return;
                    }

                    dialog_withdraw.setVisible(false);
                    renderAccountWindow();
                    return;
                }
                label_withdraw_selectaccount.setForeground(Color.red);
                return;
            }
        }
        label_withdraw_validamount.setForeground(Color.red);
    }

    /**
     * runs when withdraw button is pressed
     * sets basic parameters and sets withdraw window visible
     * @param evt
     */
    private void button_account_withdrawActionPerformed(java.awt.event.ActionEvent evt) {
        radiobutton_withdraw_checking.setSelected(true);
        radiobutton_withdraw_savings.setSelected(false);
        textfield_withdraw_amount.setText("");
        label_withdraw_selectaccount.setForeground(Color.white);
        label_withdraw_validamount.setForeground(Color.white);
        label_withdraw_insufficient.setForeground(Color.white);
        dialog_withdraw.setVisible(true);
    }

    /**
     * runs if user tries to close account window
     * shows message "must log out before closing"
     * @param evt
     */
    private void frame_accountWindowClosing(java.awt.event.WindowEvent evt) {
        dialog_logoutb4closing.setVisible(true);
    }

    /**
     * runs when ok button on logout before closing screen is pressed
     * closes the window
     * @param evt
     */
    private void okActionPerformed(java.awt.event.ActionEvent evt) {
        dialog_logoutb4closing.dispose();
    }

    /**
     * runs when export button on transactions window is pressed
     * sets the export window visible
     * @param evt
     */
    private void transactions_exportActionPerformed(java.awt.event.ActionEvent evt) {
        dialog_export.setVisible(true);
        radiobutton_export_checking.setSelected(true);
    }

    private void radiobutton_export_checkingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radiobutton_export_savingsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * runs when export button on export window is pressed
     * exports the selected account transactions through bank.export
     * @param evt
     */
    private void button_export_exportActionPerformed(java.awt.event.ActionEvent evt) {
        if (radiobutton_export_checking.isSelected()) {
            try {
                bank.export(loggedInPerson, 1);
            } catch (IOException ex) {

            }
        } else {
            try {
                bank.export(loggedInPerson, 2);
            } catch (IOException ex) {

            }
        }


    }

    /**
     * runs when example user button on log in screen is pressed
     * autofills an example user's info into username and password
     * @param evt
     */
    private void button_exampleUserActionPerformed(java.awt.event.ActionEvent evt) {
        textfield_username.setText("manan");
        passwordfield_password.setText("password");
    }

    /**
     * sets initial parameters and creates account window
     * called when user logs in
     */
    private void renderAccountWindow() {
        DecimalFormat formatter = new DecimalFormat("#,###.##");

        frame_account.setVisible(false);
        label_account_title.setText("Hello, " + bank.getPerson(loggedInPerson).getUser());
        label_account_checking_balance.setText("$" + formatter.format(bank.getPerson(loggedInPerson).getBalance1()));
        label_account_savings_balance.setText("$" + formatter.format(bank.getPerson(loggedInPerson).getBalance2()));
        frame_account.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mainWindow().setVisible(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
