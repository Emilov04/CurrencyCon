package org.example;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class Frame extends JFrame{
    JFrame frame;
    JTextField amount;
    JButton convert;
    JComboBox<String> from, to;
    Frame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        from = new JComboBox<>();to = new JComboBox<>();

        from.addItem("KGS");
        from.addItem("USD");
        from.addItem("EUR");
        to.addItem("KGS");
        to.addItem("USD");
        to.addItem("EUR");
        to.setBounds(340,30,200,50);

        convert = new JButton("Convert");
        convert.setBounds(230,80,100,50);
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String response = Main.main(String.valueOf(from.getSelectedItem()), String.valueOf(to.getSelectedItem()), Integer.parseInt(amount.getText()));
                    System.out.println(response);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        amount = new JTextField();
        amount.setBounds(230,40,100,30);
        amount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(amount);
        add(to);
        add(convert);
        from.setBounds(20,30,200,50);

        setBounds(0,0,550,250);
        add(from);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }

}
