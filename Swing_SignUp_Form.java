import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener {
    Container c;
    JLabel label1, label2, label3;
    JTextField user;
    JPasswordField pass;
    JButton login, signup;

    public Login() {
        c = getContentPane();
        prepareGUI();
        addActionEvent();
    }

    public void prepareGUI() {
        setTitle("Login Form");
        setSize(420, 420);
        setLocation(100, 100);
        c.setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setLayout(null);

        label1 = new JLabel("Username");
        label1.setBounds(40, 50, 70, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        c.add(label1);
        user = new JTextField();
        user.setBounds(110, 55, 90, 20);
        user.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        c.add(user);

        label2 = new JLabel("Password");
        label2.setBounds(40, 80, 70, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        c.add(label2);
        pass = new JPasswordField();
        pass.setBounds(110, 88, 90, 20);
        pass.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        c.add(pass);

        login = new JButton("Login");
        login.setBounds(120, 120, 70, 20);
        login.setFont(new Font("Arial", Font.BOLD, 12));
        c.add(login);

        label3 = new JLabel("Create your account");
        label3.setBounds(30, 200, 200, 20);
        c.add(label3);
        signup = new JButton("SignUp");
        signup.setBounds(150, 200, 85, 20);
        signup.setFont(new Font("Arial", Font.BOLD, 12));
        c.add(signup);
        setVisible(true);
    }

    public void addActionEvent() {
        login.addActionListener(this);
        signup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            if (user.getText().isEmpty() || new String(pass.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the details.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                login.setBackground(Color.GREEN);
                this.dispose();
                new WelcomeWindow();
                System.out.println("Login Successful");
            }
        } else if (e.getSource() == signup) {
            this.dispose();
            new SignUp();
        }
    }
}

class SignUp extends JFrame implements ActionListener {
    Container container;
    JLabel label1, label2, label3, label4;
    JTextField name, phoneNum;
    JPasswordField password;
    JButton createAccount, loginbackButton;
    JRadioButton radioButton1, radioButton2, radioButton3;
    ButtonGroup genderGroup;

    public SignUp() {
        container = getContentPane();
        prepareGUISignUp();
    }

    public void prepareGUISignUp() {
        setTitle("Sign Up Form");
        setSize(420, 420);
        setLocation(100, 100);
        container.setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container.setLayout(null);

        label1 = new JLabel("Enter Name");
        label1.setBounds(30, 50, 100, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(label1);
        name = new JTextField();
        name.setBounds(160, 55, 120, 20);
        name.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        container.add(name);

        label2 = new JLabel("Enter Password");
        label2.setBounds(30, 82, 100, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(label2);
        password = new JPasswordField();
        password.setBounds(160, 88, 120, 20);
        password.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        container.add(password);

        label3 = new JLabel("Enter Phone Number");
        label3.setBounds(30, 120, 120, 20);
        label3.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(label3);
        phoneNum = new JTextField();
        phoneNum.setBounds(160, 120, 120, 20);
        phoneNum.setFont(new Font("Arial", Font.BOLD, 12));
        phoneNum.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        container.add(phoneNum);

        // Gender Radio Buttons
        radioButton1 = new JRadioButton("Male");
        radioButton2 = new JRadioButton("Female");
        radioButton3 = new JRadioButton("Other");
        radioButton1.setBounds(80, 160, 80, 20);
        radioButton2.setBounds(160, 160, 80, 20);
        radioButton3.setBounds(240, 160, 80, 20);
        container.add(radioButton1);
        container.add(radioButton2);
        container.add(radioButton3);

        genderGroup = new ButtonGroup();
        genderGroup.add(radioButton1);
        genderGroup.add(radioButton2);
        genderGroup.add(radioButton3);

        // Create account button
        createAccount = new JButton("Create Account");
        createAccount.setBounds(120, 190, 130, 20);
        createAccount.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(createAccount);

        // Back to login
        label4 = new JLabel("Already have an account ? ");
        label4.setBounds(30, 250, 200, 20);
        label4.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(label4);

        loginbackButton = new JButton("Login");
        loginbackButton.setBounds(183, 250, 75, 20);
        container.add(loginbackButton);

        // Action Listener
        createAccount.addActionListener(this);
        loginbackButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbackButton) {
            Login login1 = new Login();
        }

        if (e.getSource() == createAccount) {
            if (name.getText().isEmpty() || new String(password.getPassword()).isEmpty()
                    || phoneNum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the details.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                createAccount.setBackground(Color.GREEN);
                System.out.println("Account Created Successfully :)");
                this.dispose();
            }
        }
    }
}

class WelcomeWindow extends JFrame {
    Container container;
    JLabel label1;

    public WelcomeWindow() {
        prepareGUI();
    }

    public void prepareGUI() {
        setSize(420, 420);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(null);

        label1 = new JLabel("Welcome Back");
        label1.setBounds(30, 50, 100, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        container.add(label1);

        setVisible(true);
    }
}

public class Swing_SignUp_Form {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}
