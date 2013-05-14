package monopoly.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import monopoly.Street;

public class VMain {

	static private class ContentMaster {
		private static String[] contents =
			{"ein furchtbar langer String, der das Layout sprengt",
			"Draussen", "ist", "schoenes", "Wetter,", "aber", "das Bier ist alle" };
		private int index;
		ContentMaster() {
			this.index = 0;
		}
		String getPrevious() {
			index -= 1;
			if (index<0) { index += contents.length; }
			return contents[index];
		}
		String getNext() {
			index = (index + 1) % contents.length;
			return contents[index];
		}

	}

	private static final int STREET_WIDTH = 200;
	private static final int STREET_HEIGHT = 300;
	private static final int HEADER_HEIGHT = 40;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Monopoly Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addContents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	private static void addContents(Container vmain) {
		// vmain has layout BorderLayout
		JButton close = new JButton("close");
		JButton previous = new JButton("<-");
		JButton next = new JButton("->");
		
		vmain.add(previous, BorderLayout.WEST);
		vmain.add(next, BorderLayout.EAST);
		vmain.add(close, BorderLayout.SOUTH);
		
		final JLabel content = new JLabel("content");
		content.setPreferredSize(new Dimension(100, 30));
		content.setHorizontalAlignment(SwingConstants.CENTER);
		
		vmain.add(content, BorderLayout.NORTH);
		
		vmain.add(makeStreetPanel(Street.makeBaltic()), BorderLayout.CENTER);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		final ContentMaster cm = new ContentMaster();
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content.setText(cm.getPrevious());
				
			}
			
		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content.setText(cm.getNext());
			}
			
		});
	}

	private static Component makeStreetPanel(Street s) {
		JPanel spane = new JPanel();
		spane.setLayout(new BoxLayout(spane, BoxLayout.Y_AXIS));
		spane.setPreferredSize(new Dimension(STREET_WIDTH, STREET_HEIGHT));
		spane.setBackground(Color.WHITE);
		spane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		spane.add(makeStreetHeader(s));
		return spane;
	}

	private static Component makeStreetHeader(Street s) {
		JPanel header = new JPanel(new BorderLayout());
		header.setPreferredSize(new Dimension(STREET_WIDTH, HEADER_HEIGHT));
		header.setBackground(VGroup.getColor(s.getColorGroup()));
		header.setMaximumSize(new Dimension(STREET_WIDTH, HEADER_HEIGHT));
		
		JLabel line1 = new JLabel("TITLE DEED");
		JLabel line2 = new JLabel(s.getName());
		line1.setForeground(Color.WHITE);
		line2.setForeground(Color.WHITE);
		header.add(line1, BorderLayout.NORTH);
		header.add(line2, BorderLayout.SOUTH);
		
		return header;
	}

}
