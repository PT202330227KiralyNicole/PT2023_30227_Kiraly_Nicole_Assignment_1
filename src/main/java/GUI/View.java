package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton derivButton;
    private JButton integrButton;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JTextField firstTextField;
    private JTextField secondTextField;
    private JLabel resLabel;
    private JLabel result;


    public View() {

        this.addButton = new JButton(" ADDITION ");
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        this.subButton = new JButton(" SUBTRACT ");
        subButton.setBackground(Color.BLACK);
        subButton.setForeground(Color.WHITE);
        this.mulButton = new JButton(" MULTIPLY ");
        mulButton.setBackground(Color.BLACK);
        mulButton.setForeground(Color.WHITE);
        this.divButton = new JButton(" DIVISION ");
        divButton.setBackground(Color.BLACK);
        divButton.setForeground(Color.WHITE);
        this.derivButton = new JButton("DERIVATIVE");
        derivButton.setBackground(Color.BLACK);
        derivButton.setForeground(Color.WHITE);
        this.integrButton = new JButton(" INTEGRAL ");
        integrButton.setBackground(Color.BLACK);
        integrButton.setForeground(Color.WHITE);

        this.firstLabel = new JLabel("First polynom:");
        this.secondLabel = new JLabel("Second polynom:");

        this.firstTextField = new JTextField();
        this.firstTextField.setPreferredSize(new Dimension(150,20));
        this.secondTextField = new JTextField();
        this.secondTextField.setPreferredSize(new Dimension(150,20));


        this.resLabel = new JLabel("RESULT:");
        this.result = new JLabel();
        this.result.setPreferredSize(new Dimension(300,20));




        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.add(Box.createRigidArea(new Dimension(0, 35)));
        p1.add(this.firstLabel);
        p1.add(Box.createRigidArea(new Dimension(0, 35)));
        p1.add(this.secondLabel);
        p1.add(Box.createRigidArea(new Dimension(0, 35)));
        p1.add(this.resLabel);


        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(Box.createRigidArea(new Dimension(0, 35)));
        p2.add(this.firstTextField);
        p2.add(Box.createRigidArea(new Dimension(0, 35)));
        p2.add(this.secondTextField);
        p2.add(Box.createRigidArea(new Dimension(0, 35)));
        p2.add(this.result);


        JPanel panelUp = new JPanel();
        panelUp.add(p1);
        panelUp.add(p2);


        JPanel verticalContent1 = new JPanel();
        verticalContent1.setLayout(new BoxLayout(verticalContent1, BoxLayout.Y_AXIS));
        verticalContent1.add(this.addButton);
        verticalContent1.add(Box.createRigidArea(new Dimension(0, 30)));
        verticalContent1.add(this.mulButton);
        verticalContent1.add(Box.createRigidArea(new Dimension(0, 30)));
        verticalContent1.add(this.derivButton);

        JPanel verticalContent2 = new JPanel();
        verticalContent2.setLayout(new BoxLayout(verticalContent2, BoxLayout.Y_AXIS));
        verticalContent2.add(Box.createRigidArea(new Dimension(0, 30)));
        verticalContent2.add(this.subButton);
        verticalContent2.add(Box.createRigidArea(new Dimension(0, 30)));
        verticalContent2.add(this.divButton);
        verticalContent2.add(Box.createRigidArea(new Dimension(0, 30)));
        verticalContent2.add(this.integrButton);

        JPanel auxiliar = new JPanel();
        auxiliar.add(verticalContent1);
        auxiliar.add(Box.createRigidArea(new Dimension(0, 30)));
        auxiliar.add(verticalContent2);

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
        finalPanel.add(panelUp);
        verticalContent2.add(Box.createRigidArea(new Dimension(0, 30)));
        finalPanel.add(auxiliar);



        this.pack();
        this.setContentPane(finalPanel);
        this.setSize(500, 500);
        this.setTitle("Polynomial calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public String getFirstInput() {
        return this.firstTextField.getText();
    }
    public String getSecondInput() {
        return this.secondTextField.getText();
    }
    public void addAddButtonListener(ActionListener actionListener) {
        this.addButton.addActionListener(actionListener);
    }

    public void addSubButtonListener(ActionListener actionListener) {
        this.subButton.addActionListener(actionListener);
    }
    public void addMulButtonListener(ActionListener actionListener) {
        this.mulButton.addActionListener(actionListener);
    }
    public void addDivButtonListener(ActionListener actionListener) {
        this.divButton.addActionListener(actionListener);
    }
    public void addDerivButtonListener(ActionListener actionListener) {
        this.derivButton.addActionListener(actionListener);
    }

    public void addIntegrButtonListener(ActionListener actionListener) {
        this.integrButton.addActionListener(actionListener);
    }

    public void setResult(String message) {
        this.result.setText(message);
    }

}
