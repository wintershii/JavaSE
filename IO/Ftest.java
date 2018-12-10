package swing.com;

import file.com.FileInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ftest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;         //创建面板对象
    private JTextArea jTextArea = null;
    private JPanel controlPanel = null;
    private JButton openButton = null;
    private JButton closeButton = null;

    private JButton getOpenButton(){
        if(openButton == null){
            openButton = new JButton();
            openButton.setText("写入文件");
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("d:\\word.txt");
                    try(
                            FileWriter out = new FileWriter(file);
                            ){

                        String s = jTextArea.getText();
                        out.write(s);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }
    private JButton getCloseButton(){
        if(closeButton == null){
            closeButton = new JButton();
            closeButton.setText("读取文件");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("d:\\word.txt");
                    try(
                            FileReader in = new FileReader(file);
                            ){
                        char byt[] = new char[1024];
                        int len = in.read(byt);
                        jTextArea.setText(new String(byt,0,len));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }

    public Ftest(){
        super();
        initialize();
    }
    private void initialize(){
        this.setSize(300,200);
        this.setContentPane(getContentPane());
        this.setTitle("师东璇");
    }
    public Component getJTextArea(){
        Component s = null;
        return s;
    }
    public Component getControlPanel(){
        Component s = null;
        return s;
    }
    private JPanel getjContentPane(){
        if(jContentPane == null){
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getJTextArea(),BorderLayout.CENTER);
            jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
        }
        return jContentPane;
    }
    public static void main(String[] args){
        Ftest thisClass = new Ftest();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisClass.setVisible(true);
    }
}
