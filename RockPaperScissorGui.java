package rps;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class RockPaperScissorGui {
	/**
	 * @wbp.parser.entryPoint
	 */

	public static JFrame frame;
	public static JPanel panel;
	private static JTextField playertextscore;
	private static JTextField aiTextscore;
	public static String playerChoice;
	public static JLabel playerscore;
	public static JLabel aiScore;
	public static int playerscore1;
	public static int aiscore1;
	public static String aiChoice;
	public static JLabel infoText;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		panel = new JPanel();
		panel.setVisible(true);

		frame = new JFrame();

		frame.setBounds(100, 100, 100, 50);
		frame.setSize(493, 450);

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton Rock = new JButton("Rock");
		Rock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerChoice = "rock";
				aiChoice();
				playerRock();
				whoWin();
			}
		});
		Rock.setBounds(337, 293, 89, 60);
		panel.add(Rock);

		JButton Scissors = new JButton("Scissors");
		Scissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aiChoice(); // gets computer choice
				playerScissors(); // player choices scissors
				whoWin();// compares who win
				playerChoice = "scissors";
				;
			}
		});
		Scissors.setBounds(192, 293, 89, 60);
		panel.add(Scissors);

		JButton Paper = new JButton("Paper");
		Paper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aiChoice();// gets ai choice
				// playerScissors();
				playerChoice = "paper"; // sets player choice to paper
				whoWin(); // compares who wins
			}
		});
		Paper.setBounds(53, 293, 89, 60);
		panel.add(Paper);

		JLabel lblNewLabel = new JLabel("Rock Paper Scissors");
		lblNewLabel.setFont(new Font("San Diego", Font.BOLD, 21));
		lblNewLabel.setBounds(114, 21, 249, 60);
		panel.add(lblNewLabel);

		playerscore = new JLabel("Your Score");
		playerscore.setBounds(114, 123, 71, 28);
		panel.add(playerscore);

		JLabel aiScore = new JLabel("Ai score");
		aiScore.setBounds(311, 130, 99, 14);
		panel.add(aiScore);

		playertextscore = new JTextField();
		playertextscore.setEditable(false);
		playertextscore.setBounds(99, 147, 86, 20);
		panel.add(playertextscore);
		playertextscore.setColumns(10);

		aiTextscore = new JTextField();
		aiTextscore.setEditable(false);
		aiTextscore.setBounds(291, 147, 86, 20);
		panel.add(aiTextscore);
		aiTextscore.setColumns(10);

		infoText = new JLabel("");
		infoText.setBounds(164, 72, 117, 40);
		panel.add(infoText);
		frame.setVisible(true);

	}

	public static String aiChoice() {
		// String aiChoice="";
		// String x= "";
		Integer random = (int) (Math.random() * 4);
		System.out.println(random);
		if (random == 0) {
			aiChoice();
		} else if (random.equals(1)) {
			System.out.println("ai picks rock");
			aiChoice = "rock";
		} else if (random.equals(2)) {
			aiChoice = "scissors";
			System.out.println("ai picks scissors");
		} else {
			System.out.println("ai pick paper");
			aiChoice = "paper";
		}

		return aiChoice;
	}

	public static String playerRock() {
		// player picks rock
		String playerChoice = "rock";
		return playerChoice;
	}

	public static String playerScissors() {
		String playerChoice = "scissors";
		return playerChoice;

	}

	public static String playerPaper() {
		String playerChoice = "paper";
		return playerChoice;
	}

	public static void whoWin() {

		if (playerChoice == playerPaper() && aiChoice == "rock") {
			System.out.println("player wins");
			playerScore();

		} else if (playerChoice == playerScissors() && aiChoice == "rock") {
			System.out.println("ai wins");
			aiScore();

		} else if (playerChoice == playerRock() && aiChoice == "paper") {
			System.out.println("Computer Wins");
			aiScore();
		} else if (playerChoice == playerRock() && aiChoice == "rock") {
			System.out.println("you both pick rocks its a tie");
			infoTie();
		} else if (playerChoice == playerPaper() && aiChoice == "paper") {
			System.out.println("you both picked paper its a tie");
			infoTie();
		} else if (playerChoice == playerScissors() && aiChoice == "scissors") {
			System.out.println("you both picked scissors its a tie");
			infoTie();
		} else if (playerChoice == playerPaper() && aiChoice == "scissors") {
			System.out.println("Computer Wins");
			aiScore();
		} else if (playerChoice == playerScissors() && aiChoice == "paper") {
			System.out.println("Computer Wins");
			playerScore();
		} else if (playerChoice == playerRock() && aiChoice == "scissors") {
			System.out.println("Player Wins");
			playerScore();
		} else {
			System.out.println("add this player=" + playerChoice + " add ai= " + aiChoice);
		}
	}

	public static void infoTie() {
		System.out.println("tie");
		infoText.setText(String.valueOf("its a tie"));
	}

	public static void infoPlayerwins() {
		System.out.println("p wins");
		infoText.setText(String.valueOf("Player wins"));
	}

	public static void infoAiWins() {
		System.out.println("ai wins");
		infoText.setText(String.valueOf("Ai wins"));
	}

	public static void playerScore() {

		playerscore1++;
		String x = Integer.toString(playerscore1);

		playertextscore.setText(String.valueOf(x));
		infoPlayerwins();
	}

	public static void aiScore() {
		aiscore1++;
		String x = Integer.toString(aiscore1);

		aiTextscore.setText(String.valueOf(x));
		infoAiWins();

	}
}