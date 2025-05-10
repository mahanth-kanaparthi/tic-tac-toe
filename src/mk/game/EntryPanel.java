package mk.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class EntryPanel extends JPanel {
	private JLabel entryText;
	private JButton playButton;

	public EntryPanel(String buttonType) {/*play or replay*/
		setLayout(null);
		setBounds(0, 0, 550, 700);
		setBackground(new Color(25, 25, 25));
		setFocusable(false);
		setOpaque(true);
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(true);
				setVisible(true);
			}
		});

		entryText = new JLabel("Tic-Tac-Toe");
		entryText.setBackground(new Color(25, 25, 25));
		entryText.setForeground(new Color(255, 255, 153));
		entryText.setFont(new Font("Tekton", Font.BOLD, 85));
		entryText.setHorizontalAlignment(JLabel.CENTER);
		entryText.setOpaque(true);
		entryText.setBounds(0, 200, 550, 100);

		// Add an ActionListener to handle Enter key press
		entryText.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed"
				);
		entryText.getActionMap().put("enterPressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getParent().revalidate();
				getParent().repaint();
			}
		});
		playButton = new RoundedButton(buttonType,25);
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				getParent().revalidate();
				getParent().repaint();
			}
		});
		playButton.setBackground(Color.ORANGE);
		playButton.setForeground(Color.WHITE);
		playButton.setBounds(210, 340, 100, 40);
		playButton.setBorder(new RoundedBorder(30));

		add(entryText);
		add(playButton);
	}

	static class RoundedButton extends JButton {
		private int radius;
		public RoundedButton(String text,int radius){
			super(text);
			this.radius = radius;
		}
		@Override
		protected void paintComponent(Graphics g){
			g.setColor(getBackground());
			g.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

			g.setColor(getForeground());
			g.drawString(getText(), 35, 25);
		}
	}

	private class RoundedBorder implements Border {

		private int radius;

		public RoundedBorder(int radius) {
			this.radius = radius;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(radius, radius, radius, radius);
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}
	}


}
