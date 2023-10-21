import javax.swing.*;
import java.awt.*;

public class WordGUI extends JFrame {
    public void initialize(){
        setSize(200,200);
        setLocation(0,0);
        setLayout(new GridLayout(1,2));
        createFileMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }//GUI initialize

    JTextArea text1 = newText();
    JTextArea text2 = newText();
    public JTextArea newText(){
        JTextArea text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text);
        getContentPane().add(scroll);
        text.setEditable(false);
        return text;
    }//TextArea initialize


    private void createFileMenu( ) {
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();

        JMenu   fileMenu = new JMenu("File");
        FileMenuHandler fmh  = new FileMenuHandler(this,text1,text2);

        JMenu   editMenu = new JMenu("List");

        item = new JMenuItem("Open");    //Open...
        item.addActionListener( fmh );
        fileMenu.add( item );

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( fmh );
        fileMenu.add( item );

        item = new JMenuItem("A");    //Display words starts with a
        item.addActionListener( fmh );
        editMenu.add( item );

        editMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("E");      //Display words starts with e
        item.addActionListener( fmh );
        editMenu.add( item );
        editMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("I");       //Display words starts with i
        item.addActionListener( fmh );
        editMenu.add( item );

        editMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("O");       //Display words starts with o
        item.addActionListener( fmh );
        editMenu.add( item );
        editMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("U");       //Display words starts with u
        item.addActionListener( fmh );
        editMenu.add( item );

        setJMenuBar(menuBar);               //display the menubar with the items
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

    } //createMenu

}
