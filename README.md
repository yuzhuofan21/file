班级：计G191，学号：2019322029， 姓名：余卓凡
---
综合性实验  学生选课系统设计
===
实验目的
---
分析学生选课系统<br/>
使用GUI窗体及其组件设计窗体界面<br/>
完成学生选课过程业务逻辑编程<br/>
基于文件保存并读取数据<br/>
处理异常<br/>

实验内容
---
一、简单选课
---
1.了解实验要求，做出初步构架<br/>
2. 编写Person类<br/>
声明编号、姓名、性别变量；<br/>
3. 编写Teacher类和Student类<br/>
Teacher类和Student类分别继承Person类，获得编号、姓名、性别变量，调用Course类。<br/>
class Student extends Person{}
class Teacher extends Person{}
在Course类和Student类中重写toString（）方法。在Course类使用toString() 方法将id+","+name+","+address+","+time+","+score转为字符串返回结果.在Student类调用Course类和Teacher类,在Student类使用toString() 方法将id+","+name+","+gender+","+scourse+","+teacher.getName()转为字符串返回结果。<br/>
4.编写Course类
声明变量，Course类重写toString（）方法。使用toString() 方法将“ id+","+name+","+address+","+time+","+score转为字符串返回结果.<br/>
5.测试类
将Teacher、Student、Course实例化，打印学生选课信息，打印老师对应的课程信息，退课，打印退课后的信息。<br/>

二、选课GUI界面
---

1、接实验一的操作部分，实现GUI界面<br/>
2、根据老师所给组件进行编辑<br/>
3、实现监听器接口,实例化所有组件和学生类,并把组件放入布局界面<br/>
4、运行程序实现选课界面<br/>



三、选课输入/输出file
---
1、实行GUI选课界面<br/>
2、学生选课退课<br/>
3、创建一个选课TXT<br/>
4、写入选课后的信息<br/>
5、添加按行排列<br/>

核心代码
---

```java
public Student(int id,String name,String  gender,Course scourse,Teacher teacher){
			super(id,name,gender);
			this.scourse = scourse;
			this.teacher=teacher;
			
		}
		
		public void setScourse(Course scourse){
			this.scourse = scourse;	
		}	
		
		public Course getScourse(){
			return scourse;	
		}
		public void delete(){
			scourse=null;
		}
		public void put(){
			if (scourse==null){
				 System.out.println("不选课");
			}else{
				this.toString();
			}
		}
		public String toString(){
return id+","+name+","+gender+","+scourse+","+teacher.getName();
		}
 ```
 界面布局代码,选课退课按钮
 ```java
  public GridBagLayoutDemo() {
    	f = new MyFrame();
        j2 = new JButton("选课");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str = { "java", "C#", "HTML5" };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton("取消");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.RED);
        myActionListener =new MyActionListener(j9);
        j2.addActionListener(this);
       
        j3.addActionListener(myActionListener);
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
 ```
 gui组件调用侦听器里的抽象方法actionPerformed
 ```java
 public void actionPerformed(ActionEvent e) {
		String name = j6.getText();
调用下拉列表框内容
String scourse =(String)j5.getSelectedItem();

		System.out.println(scourse);
实例化
		course=new Course(1, scourse, "综合楼",3,3);
		teacher=new Teacher(1, "张世博", "男",course);
	student=new Student(1,name, "男",course,teacher);	   
      j9.setText(" "+student);	
```
输入输出选课
```java
	public void actionPerformed(ActionEvent a) {
		String name = j6.getText();
		String scourse =(String)j5.getSelectedItem();
		System.out.println(scourse);
		course=new Course(1, scourse, "综合楼",3,3);
		teacher=new Teacher(1, "张世博", "男",course);
		student=new Student(1,name, "男",course,teacher);	   
        j9.setText(" "+student);
###选课后的信息输入到文件中    	   
	   try {
      	    	input=new FileWriter(f1,true);
      	    	input.write("  "+student.getName()+"  "+student.getCourse()+"  "+student.getTeather()+"\n");
      	    	input.flush();
      	    	input.close();
			} catch (IOException e) {
				System.out.println("文件传输错误");
			}
		
	}
  ```


声明输入文本的类
```java
File f1= new File(".."+File.separator+"选课.txt"); 
	FileWriter input;
	BufferedReader br;
	BufferedWriter bw ;
	String temp;
	StringBuffer sb ;
```





输入输出退课
```java
 j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
###将文件中的每一行数据放入缓存，与退课信息对比，相同则不输入文件，不同则输入文件				
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
```

流程图
---
![image](https://github.com/yuzhuofan21/file/blob/master/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

运行结果
---
![image](https://github.com/yuzhuofan21/file/blob/master/%E9%80%89%E8%AF%BE%E8%BE%93%E5%85%A5%E6%96%87%E4%BB%B6.png)
![image](https://github.com/yuzhuofan21/file/blob/master/%E9%80%89%E8%AF%BE%E6%96%87%E4%BB%B6.png)

实验感想
---

   这次综合实验把之前所学的选课以及GUI，还有这次所学的file文件输入输出流的方法综合运用，实现了一个可以将获得的选课信息写入文件，并且退课。这次实验主要是在原GUI基础上实现文件输入输出的方法，通过结合老师上课所讲和课下复习，勉强做出了这次程序，不足之处依旧很多，还需要在以后的学习中多多巩固。
