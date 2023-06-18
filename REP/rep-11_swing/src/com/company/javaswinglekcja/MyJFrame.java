package com.company.javaswinglekcja;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class MyJFrame extends JFrame implements ActionListener {
    private JButton bPodajDate;
    private JLabel jLabel;
    private JButton bWyjscie;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    private LoginDialog loginDlg;

    private JTabbedPane tabbedPane;

    private ButtonTabComponent btc;
    // private String[] timezones;
    private JList list = new JList();


    public MyJFrame(){
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        menuItem = new JMenuItem("Login",
                KeyEvent.VK_L);
        menuItem.addActionListener(this);


        menu.add(menuItem);

        bPodajDate =  new JButton("Podaj date");
        jLabel =  new JLabel("data");
        Font font = new Font(jLabel.getFont().getName(),jLabel.getFont().getStyle(),12);
        jLabel.setFont(font);


        tabbedPane= new JTabbedPane();

        JPanel jpanel = new JPanel(new BorderLayout());
        JPanel jpanel2 = new JPanel(new BorderLayout());


        //jpanel.setLayout(null);

        //bPodajDate.setBounds(60,50,140,20);
        bPodajDate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("z anonimowej klasy");
            }
        });
        bWyjscie = new JButton("wyjscie");
        //bWyjscie.setActionCommand("w");
        bWyjscie.addActionListener(this);
        bPodajDate.addActionListener(this);

        //String array to store weekdays
        list= new JList();
       // timezones = new String[]{"Warszawa", "Nowy York"};
        DefaultListModel model = new DefaultListModel();
        model.addElement("Warszawa");
        model.addElement("Nowy York");
        list.setModel(model);

        list.setSelectedIndex(0);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {

                    if (list.getSelectedIndex() == -1) {
                        //No selection

                    } else {
                        System.out.println(list.getSelectedValue());
                    }
                }
            }
        });


        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("MOUSE CLICKED!");
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Object o = list.getModel().getElementAt(index);
                        System.out.println("Double clicked: "+o);
                        JPanel jpanel = new JPanel(new BorderLayout());
                        tabbedPane.add(o+"",jpanel);
                        initTabComponent(tabbedPane.getTabCount()-1,tabbedPane);
                    }
                }
            }
        });

        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                int l=0;
                while((!this.isCancelled()) ) {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String[] timezones;
                    if (l == 0) {
                        timezones = new String[]{"Warszawa", "Nowy York", "Taipei"};
                        l++;
                    } else {
                        timezones = new String[]{"Berlin", "Auckland", "Singapur"};
                        l--;
                    }

                    updateList(list, timezones);

                }
                    return null;

            }
        };
        sw.execute();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int l=0;
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String[] timezones;
                    if (l == 0) {
                        timezones = new String[]{"Warszawa", "Nowy York", "Taipei"};
                        l++;
                    } else {
                        timezones = new String[]{"Berlin", "Auckland", "Singapur"};
                        l--;
                    }
                    updateList(list, timezones);
                }
            }
        });
        //th1.start();
        jpanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
       // jpanel.add(bPodajDate,BorderLayout.WEST);
       // jpanel.add(bWyjscie,BorderLayout.EAST);
       // jpanel.add(jLabel,BorderLayout.NORTH);

        c.fill=GridBagConstraints.HORIZONTAL;
       // c.weightx=3;
        //c.weighty=0;
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=0;
        jpanel.add(jLabel,c);
       // c.fill=GridBagConstraints.HORIZONTAL;
       // c.weightx=0;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=2;
        jpanel.add(bPodajDate,c);
        // c.weightx=0;
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=2;
        jpanel.add(bWyjscie,c);

        //add list to panel
       // c.fill=GridBagConstraints.HORIZONTAL;
        //c.weightx=3;
        c.gridwidth=1;
        c.gridx=2;
        c.gridy=0;
        jpanel.add(scrollPane,c);

        tabbedPane.add(jpanel,"DATA");
        tabbedPane.add(jpanel2,"KALKULATOR");
        this.add(tabbedPane);
        initTabComponent(0,tabbedPane);
        initTabComponent(1,tabbedPane);


        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("First desktop app");
        setVisible(true);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("z JFramea");

        Object source = actionEvent.getSource();

        if ( source.equals(bWyjscie)) {
            System.out.println(actionEvent.getActionCommand());
            dispose();
        }
        else if (source.equals(bPodajDate)){
            jLabel.setText(new Date().toString());
        }
        if(source.equals(menuItem)){
            System.out.println(menuItem);
            loginDlg = new LoginDialog(this);
            loginDlg.setVisible(true);
        }
    }

    public void updateList( JList list, String[] timezones)
    {
        DefaultListModel listModel = (DefaultListModel)list.getModel();
        listModel.clear();

        for(int i=0; i<timezones.length; i++)
        {
            listModel.addElement(timezones[i]);
        }
    }

    private void initTabComponent(int i,JTabbedPane pane) {
        pane.setTabComponentAt(i,
                new ButtonTabComponent(pane));
    }
}
