package Calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * <简易计算器>
 * 1、构建外部框架；
 * 2、构建按钮、文本框等相关组件；
 * 3、为数字写入点击事件；
 * 4、为计算运算符加入点击事件；
 * 5、为清空，退格等控件加入点击事件；
 * 
 * 运算过程：
 * 点击数字x ——> 判断数字x ——> 方法获取x ——>  判断文本框初始是否为"" ——>  向文本框butto(底)加入数字
 * ——> 点击运算符y ——> 判断运算符y ——> 判断文本框内容 butto是否有值，中央是否为 "" ——> 中央文本框获取butto框的值，并且butto文本框获取运算符y
 * ——> 点击数字z ——>判断数字z ——> 判断butto是否为运算符，且top为"" ——>  文本框top获取 中央文本框的值，中央获取butto运算符，文本框butto获取z 
 * ——> 点击运算符 = ——>判断运算符= ——>  判断文本框中央是否为运算符  ——> 将 top 文本框 和 butto文本框内容 转换为 整型 并计算结果 Sum，且将结果Sum转为字符型并赋值给S
 * ——> 文本框top获取 S的值  ，且设置 其他文本框为null；
 * @author Administrator
 *
 */
public class Calculator_Frame_demo extends JFrame {
	JTextField jt = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JButton jb = new JButton();
	String[] a = { "C", "÷", "X", "←", "7", "8", "9", "+", "4", "5", "6", "-",
			"1", "2", "3" };
	int i;
	String s = "";
	int t1, t2, t3;
	int sum;

	String[] fu = { "÷", "X", "+", "-" };
	Font f = new Font("黑体", Font.PLAIN, 40);

	public void setT4(String s) {
		int t1 = Integer.parseInt(jt.getText());
		int t2 = Integer.parseInt(jt3.getText());
		switch (jt2.getText()) {
		case "+":
			sum = t1 + t2;
			break;
		case "-":
			sum = t1 - t2;
			break;
		case "X":
			sum = t1 * t2;
			break;
		case "÷":
			sum = t1 / t2;
			break;
		}
		String t3 = "" + sum;
		jt.setText(t3);
		jt2.setText(null);
		jt3.setText(null);
	}

	public void setT3(String s) {
		int t1 = Integer.parseInt(jt.getText());
		int t2 = Integer.parseInt(jt3.getText());
		switch (jt2.getText()) {
		case "+":
			sum = t1 + t2;
			break;
		case "-":
			sum = t1 - t2;
			break;
		case "X":
			sum = t1 * t2;
			break;
		case "÷":
			sum = t1 / t2;
			break;
		}
		String t3 = "" + sum;
		jt.setText(t3);
		jt2.setText("");
		jt3.setText("");
	}

	public void pd() {
		if (jt2.getText().equals("+") || jt2.getText().equals("-")
				|| jt2.getText().equals("÷") || jt2.getText().equals("X")) {
			System.out.println("pd");
			setT4(s);
		}
	}

	public void setT2(String s) {
		if (jt.getText().equals("")) {
			jt.setText(jt2.getText());
			jt2.setText(jt3.getText());
			jt3.setText("");
			System.out.println("setT2");
		}
	}

	public void setT1(String s) {
		if (jt2.getText().equals("")) {
			jt2.setText(jt3.getText());
			jt3.setText("");
			System.out.println("setT1");
		}

	}

	// 判断jt3是否为默认值，是否为第一次输入状态。
	public void setText(String s) {
		System.out.println("setText");
		if (jt3.getText().equals("")) {
			this.s = s;
		} else {
			this.s = this.s + s;
		}

	}
//获取Text框的内容
	public String getText() {
		return this.s;
	}
//构造方法
	public Calculator_Frame_demo() {
//框架的相关变量		
		this.setTitle("计算器");
		this.setSize(400, 600);
		;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// this.setResizable(false);

		this.setLayout(null);
		Container c = getContentPane();

		// =============================top文本框
		jt.setEditable(false);
		jt.setBorder(null);
		jt.setFont(new Font("黑体", Font.PLAIN, 30));
		jt.setBackground(Color.white);
		jt.setBounds(10, 10, 365, 33);
		jt.setText("");
		c.add(jt);
		// =============================中央文本框
		jt2.setEditable(false);
		jt2.setBorder(null);
		jt2.setFont(new Font("黑体", Font.PLAIN, 30));
		jt2.setBackground(Color.white);
		jt2.setBounds(10, 43, 365, 33);
		jt2.setText("");
		c.add(jt2);
		// =============================butto文本框并且设计点击事件
		jt3.setEditable(false);
		jt3.setBorder(null);
		jt3.setFont(new Font("黑体", Font.PLAIN, 30));
		jt3.setBackground(Color.white);
		jt3.setBounds(10, 76, 365, 33);
		jt3.setText("");
		c.add(jt3);

		// =============================

		for (int Y = 120; Y < 450; Y += 90) {
			for (int X = 10; X < 320; X += 95) {
				if (i < a.length) {
					final JButton jb = new JButton(a[i]);
					jb.setFont(f);
					jb.setBounds(X, Y, 80, 80);
					i++;
					jb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if (jb.getText().equals("+")
									|| jb.getText().equals("-")
									|| jb.getText().equals("÷")
									|| jb.getText().equals("X")) {
								pd();
								setT1(jb.getText());
							} else if (jt3.getText().equals("+")
									|| jt3.getText().equals("-")
									|| jt3.getText().equals("X")
									|| jt3.getText().equals("÷")) {
								setT2(jb.getText());
							}
							if (jt2.getText().equals("")
									&& jt3.getText().equals("+")
									|| jt3.getText().equals("-")
									|| jt3.getText().equals("X")
									|| jt3.getText().equals("÷")) {
								System.out.println("000");
								jt2.setText(jt3.getText());
								jt3.setText(null);

							}

							setText(jb.getText());
							jt3.setText(getText());

							if (jb.getText().equals("C")) {
								jt.setText("");
								jt2.setText("");
								jt3.setText("");
							}
						}
					});
					c.add(jb);
					System.out.println(jb.getText());
				}
			}
		}
		//数字0的相关项
		final JButton jb1 = new JButton("0");
		jb1.setFont(f);
		jb1.setBounds(10, 480, 175, 80);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setText(jb1.getText());
				jt3.setText(getText());
			}
		});
		c.add(jb1);
		//数字.的相关项
		final JButton jb2 = new JButton(".");
		jb2.setFont(f);
		jb2.setBounds(200, 480, 80, 80);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setText(jb2.getText());
				jt3.setText(getText());
			}
		});
		c.add(jb2);
		//运算符=的相关项
		final JButton jb6 = new JButton("=");
		jb6.setFont(f);
		jb6.setBounds(295, 390, 80, 170);
		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setT3(s);
			}
		});
		c.add(jb6);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator_Frame_demo();
	}
}
