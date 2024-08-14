import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClass extends JDialog {
    private String otpInput;

    public NewClass(Frame owner, String message) {
        super(owner, "Enter OTP", true);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message);
        JTextField textField = new JTextField(10);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otpInput = textField.getText();
                setVisible(false);
            }
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        setLayout(new FlowLayout());
        add(panel);
        pack();
        setLocationRelativeTo(owner);
    }

    public String getOTPInput() {
        return otpInput;
    }
}

