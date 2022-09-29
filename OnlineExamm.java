package javacourselearning;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class OnlineExamm extends JFrame implements ActionListener{

	                                                                                        //ONLINE EXAM APP JAVA PROJECT USING ECLIPSE
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, question = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineExamm(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(800, 450);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			question++;
			set();
			if (question == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = question;
			x++;
			question++;
			set();
			if (question == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = question;
				question = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				question = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			question++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (question == 0) {
			label.setText("Que1:  Which of the following is not introduced with Java 8?");
			radioButton[0].setText("Stream API");
			radioButton[1].setText("Serialization");
			radioButton[2].setText("Spliterator");
			radioButton[3].setText("Lambda Expression");
		}
		if(question==1) {
			label.setText("Que2:Who invented Java Programming?");
			radioButton[0].setText("Guido van Rossum");
			radioButton[1].setText("James Gosling");
			radioButton[2].setText("Dennis Ritchie");
			radioButton[3].setText("Bjarne Stroustrup");
			
		}
		if(question==2) {
			label.setText("Que3: What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
			
		}
		if(question==3) {
			label.setText("Que4:What is not the use of “this” keyword in Java?");
			radioButton[0].setText("Referring to the instance variable when a local variable has the same name");
			radioButton[1].setText("Passing itself to the method of the same class");
			radioButton[2].setText("Passing itself to another method");
			radioButton[3].setText("Calling another constructor in constructor chaining");
			
		}
		if(question==4) {
			label.setText("Que5:Which of the following is a type of polymorphism in Java Programming?");
			radioButton[0].setText("Multiple polymorphism");
			radioButton[1].setText("Compile time polymorphism");
			radioButton[2].setText("Multilevel polymorphism");
			radioButton[3].setText("Execution time polymorphism");
			
		}
		if(question==5) {
			label.setText("Que6:Which of these keywords is used to define interfaces in Java?");
			radioButton[0].setText(" intf");
			radioButton[1].setText("Intf");
			radioButton[2].setText("interface");
			radioButton[3].setText(" Interface");
			
		}
		if(question==6) {
			label.setText("Que7:Which of the following is a superclass of every class in Java?");
			radioButton[0].setText(" ArrayList");
			radioButton[1].setText("Abstract class");
			radioButton[2].setText("Object class");
			radioButton[3].setText("String");
			
		}
		if(question==7) {
			label.setText("Que8:Which of the following is not an OOPS concept in Java?");
			radioButton[0].setText("Polymorphism");
			radioButton[1].setText("Inheritance");
			radioButton[2].setText("Compilation");
			radioButton[3].setText("Encapsulation");
			
		}
		if(question==8) {
			label.setText("Que9: Which one of the following is not an access modifier?");
			radioButton[0].setText("Protected");
			radioButton[1].setText("Void");
			radioButton[2].setText(" Public");
			radioButton[3].setText("Private");
			
		}
		if(question==9) {
			label.setText("Que10:Which of these packages contains the exception Stack Overflow in Java?");
			radioButton[0].setText("java.io");
			radioButton[1].setText("java.system");
			radioButton[2].setText("java.lang");
			radioButton[3].setText("java.util");
			
		}
	
		
		
	}
	// declare right answers.
	boolean check() {
		if(question==0) 
			return (radioButton[1].isSelected());
		if(question==1) 
			return (radioButton[1].isSelected());
		if(question==2) 
			return (radioButton[3].isSelected());
		if(question==3) 
			return (radioButton[0].isSelected());
		if(question==4) 
			return (radioButton[1].isSelected());
		
		if(question==5) 
			return (radioButton[2].isSelected());
		if(question==6) 
				return (radioButton[2].isSelected());
		if(question==7) 
				return (radioButton[2].isSelected());
		if(question==8) 
			return (radioButton[1].isSelected());
		if(question==9) 
			return (radioButton[2].isSelected());
		return false;
		}

	public static void main(String s[]) {
		new OnlineExamm("Online Test App");
	}

}


