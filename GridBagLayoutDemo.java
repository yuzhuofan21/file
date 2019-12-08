package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
class MyFrame extends JFrame{
	public MyFrame() {
		 setTitle("Frame");  	 
         setSize(600,600);
         setVisible(true);
	}
}
class MyWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}

public class GridBagLayoutDemo implements ActionListener {
    public static void main(String args[]) throws IOException {
    	GridBagLayoutDemo demo = new GridBagLayoutDemo();
    }
    public GridBagLayoutDemo() {
    	f = new MyFrame();
        j2 = new JButton("选课");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str = { "java", "C#", "HTML5","Math" };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton("取消");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.blue);

        j2.addActionListener(this);
       
        j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nameset=j6.getText();
				    String courseset=j5.getToolTipText();
					j9.setText(nameset+" 课程已退: " +courseset);				
					sb = new StringBuffer(4096);
					temp = null;
					br = new BufferedReader(new FileReader(f1)); 
					while((temp = br.readLine())!= null){ 
					       if ((temp.indexOf(nameset))==-1) {
					    	   sb.append(temp).append("\r\n");
						}       
					} 
					br.close(); 
					bw = new BufferedWriter((new FileWriter(f1))); 
					bw.write(sb.toString()); 
					bw.close();
				} catch (IOException e1) {
					System.out.println("文件传输错误");
				}
				
			}
		});
    	
	  
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);

        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        f.add(j9);
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;s.weightx = 0;s.weighty=0;
       

        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j2, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j3, s);
        s.gridwidth=0;s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j4, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j5, s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        layout.setConstraints(j6, s);
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j7, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j8, s);
        s.gridwidth=5;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j9, s);
        f.addWindowListener(new MyWindow());
    }
    JButton j1;
    JButton j2;
    JButton j3;
    JPanel j4;
    JComboBox j5;
    JTextField j6;
    JButton j7;
    JList j8;
    TextField j9;
    Teacher teacher;
    Course course;
    Student student;
    MyFrame f ;
	File f1= new File(".."+File.separator+"选课.txt"); 
	FileWriter input;
	BufferedReader br;
	BufferedWriter bw ;
	String temp;
	StringBuffer sb ;
	@Override
	public void actionPerformed(ActionEvent a) {
		String name = j6.getText();
		String scourse =(String)j5.getSelectedItem();
		System.out.println(scourse);
		course=new Course(1, scourse, "综合楼",3,3);
		teacher=new Teacher(1, "张世博", "男",course);
		student=new Student(1,name, "男",course,teacher);	   
        j9.setText(" "+student);
    	    try {
      	    	input=new FileWriter(f1,true);
      	    	input.write("  "+student.getName()+"  "+student.getCourse()+"  "+student.getTeather()+"\n");
      	    	input.flush();
      	    	input.close();
			} catch (IOException e) {
				System.out.println("文件传输错误");
			}
		
	}
    
}