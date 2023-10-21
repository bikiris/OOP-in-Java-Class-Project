import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FileMenuHandler implements ActionListener {
    WordGUI jframe;
    JTextArea text1;
    JTextArea text2;

    public FileMenuHandler (WordGUI jf, JTextArea a, JTextArea b) {
        jframe = jf;
        text1 = a;
        text2 = b;
    }
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            OpenFile();
        }// opens the file and set left text area with original text
        else if (menuName.equals("Quit")) //exit when pressed quit
            System.exit(0);
        else if (menuName.equals("A")) //set right area with words starts with a
            text2.setText(""+a);
        else if (menuName.equals("E")) //set right area with words starts with e
            text2.setText(""+e);
        else if (menuName.equals("I")) //set right area with words starts with i
            text2.setText(""+ii);
        else if (menuName.equals("O")) //set right area with words starts with o
            text2.setText(""+o);
        else if (menuName.equals("U")) //set right area with words starts with u
            text2.setText(""+u);
    } //actionPerformed



    WordLineList list = new WordLineList(); //stores words
    WordLineList a = new WordLineList();//stores a
    WordLineList e = new WordLineList();//stores e
    WordLineList ii = new WordLineList();//stores i
    WordLineList o = new WordLineList();//stores o
    WordLineList u = new WordLineList();//stores u
    public void OpenFile(){
        JFileChooser j = new JFileChooser(); //opens file chooser
        j.showSaveDialog(null);
        ReadFile(j.getSelectedFile().getAbsolutePath()); //pass the path to read the file
    }
    public void ReadFile(String filename){
        text1.setText(" ");
        TextFileInput file = new TextFileInput(filename);
        String line = file.readLine();
        for (int i = 1; line != null; i++) {
            try {
                text1.append(line + "\n");
                StringTokenizer tokens = new StringTokenizer(line, ",. ():\'’”‘“\"");
                while (tokens.hasMoreTokens()) {
                    String s = tokens.nextToken();
                    if (s.charAt(0) == 'a' || s.charAt(0) == 'A') a.add(s, i);
                    else if (s.charAt(0) == 'e' || s.charAt(0) == 'E') e.add(s, i);
                    else if (s.charAt(0) == 'i' || s.charAt(0) == 'I') ii.add(s, i);
                    else if (s.charAt(0) == 'o' || s.charAt(0) == 'O') o.add(s, i);
                    else if (s.charAt(0) == 'u' || s.charAt(0) == 'U') u.add(s, i);
                    list.add(s,i);

                }//store the words to appropriate linked list
                line = file.readLine();
            }catch (InvalidWordLineException e){
                JOptionPane.showMessageDialog(null, "invalid line number");
            }//catch exception when line is less than 1
        }

        //set the text
        text2.setText(list + "");
    }

}
