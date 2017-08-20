package anglutestas.ENLT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AngluTestas extends JFrame implements ActionListener {
	// version 0.301
	private static final long serialVersionUID = 8522662740187087515L;

	private int taskai = 0;
	private int i = 0;

	JButton check = new JButton("Patikrinti");
	JButton next = new JButton("Sekantis");
	JButton end = new JButton("Pabaigti");

	JTextArea question = new JTextArea(4, 25);
	JLabel ql = new JLabel("Klausimas");
	JTextArea answer = new JTextArea(4, 25);
	JLabel al = new JLabel("Atsakymas");

	JTextArea correctAnswer = new JTextArea(2, 25);

	JLabel tsk = new JLabel(taskai + "");

	String response = "";

	Color[] color = { Color.WHITE, Color.RED, Color.GREEN };

	String[] q1 = { "Jo namas", "His house", "His house" };
	String[] q2 = { "Jos eina namo", "They go home", "They are going home" };
	String[] q3 = { "Oliveris skaito savo knygas", "Oliver reads his books", "Oliver is reading his books" };
	String[] q4 = { "Jie valgo savo pietus", "They eat their dinner", "They  are eating their lunch" };
	String[] q5 = { "Koks tavo vardas?", "What is your name?", "What's your name?" };
	String[] q6 = { "Olis zaidzia su savo traukiniais", "Ollie plays with his trains",
			"Ollie is playing with his trains" };

	String[][] kk = { q1, q2, q3, q4, q5, q6 };

	public AngluTestas() {
		super("Anglu Testas");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// create new Font
		Font font = new Font("Courier", Font.BOLD, 22);
		
		
		 question.setFont(font);
		 answer.setFont(font);
		 correctAnswer.setFont(font);

		Collections.shuffle(Arrays.asList(kk));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.add(ql);
		panel.add(question);
		question.setColumns(20);
		question.setEditable(false);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.add(al);
		panel_1.add(answer);
		answer.setColumns(20);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.add(tsk);

		end.setVisible(false);
		next.setVisible(false);
		correctAnswer.setVisible(false);
		panel_2.add(correctAnswer);

		panel_2.add(check);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				response = answer.getText();
				if (response.length() > 0) {
					next.setVisible(true);
					correctAnswer.setVisible(true);
					correctAnswer.setText(kk[i][1]);

					if (response.equalsIgnoreCase(kk[i][1]) || response.equals(kk[i][2])) {
						taskai++;
						tsk.setText(taskai + "");
						answer.setBackground(color[2]);
					} else {
						answer.setBackground(color[1]);
					}
					i++;
					if (i == kk.length) {
						end.setVisible(true);
						next.setVisible(false);
					}
					check.setEnabled(false);
				}

			}
		});
		panel_2.add(next);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				check.setEnabled(true);
				answer.setBackground(color[0]);
				question.setText(kk[i][0]);
				next.setVisible(false);
				correctAnswer.setVisible(false);
				answer.setText("");

			}
		});

		panel_2.add(end);
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		setContentPane(contentPane);
		setVisible(true);

		question.setText(kk[i][0]);

	}

	public static void main(String[] arguments) {
		AngluTestas at = new AngluTestas();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
