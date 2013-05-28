package monopoly.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
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
	private static final int STREET_HEADER_HEIGHT = 40;
	private static final int STREET_FOOTER_HEIGHT = 30;

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
		spane.add(Box.createVerticalGlue());
		spane.add(makeStreetFooter());
		return spane;
	}

	private static Component makeStreetHeader(Street s) {
		JPanel header = new JPanel(new BorderLayout());
		Color streetColor = VGroup.getColor(s.getColorGroup());
		Color textColor = chooseColorForText(streetColor);

		header.setBackground(streetColor);
		header.setPreferredSize(new Dimension(STREET_WIDTH, STREET_HEADER_HEIGHT));
		header.setMaximumSize(new Dimension(STREET_WIDTH, STREET_HEADER_HEIGHT));
		
		JLabel line1 = new JLabel("TITLE DEED");
		JLabel line2 = new JLabel(s.getName());
		line1.setHorizontalAlignment(SwingConstants.CENTER);
		line2.setHorizontalAlignment(SwingConstants.CENTER);
		line1.setForeground(textColor);
		line2.setForeground(textColor);
		header.add(line1, BorderLayout.NORTH);
		header.add(line2, BorderLayout.SOUTH);
		
		return header;
	}

	private static Color chooseColorForText(Color bgColor) {
		// choose color for text based on luminance / gray value of background color
		float[] components = bgColor.getColorComponents(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		float luminance = components[0];
		return luminance > 0.5 ? Color.BLACK : Color.WHITE;
	}

	private static Component makeStreetFooter() {
		Font smallfont = Font.decode("dialog-plain-6");
		JPanel footerpane = new JPanel();
		footerpane.setLayout(new BoxLayout(footerpane, BoxLayout.Y_AXIS));
		footerpane.setBackground(Color.WHITE);
		footerpane.setPreferredSize(new Dimension(STREET_WIDTH, STREET_FOOTER_HEIGHT));
		footerpane.setMaximumSize(new Dimension(STREET_WIDTH, STREET_FOOTER_HEIGHT));
		
		String footer1 = "If a player owns ALL the lots of any Color-Group, the";
		String footer2 = "rent is Doubled on Unimproved Lots in that group.";
		JLabel footline1 = new JLabel(footer1);
		JLabel footline2 = new JLabel(footer2);
		footline1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		footline2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		footline1.setFont(smallfont);
		footline2.setFont(smallfont);
		footline1.setForeground(Color.BLACK);
		footline2.setForeground(Color.BLACK);
		footline1.setPreferredSize(new Dimension(STREET_WIDTH, STREET_FOOTER_HEIGHT/2));
		footline2.setPreferredSize(new Dimension(STREET_WIDTH, STREET_FOOTER_HEIGHT/2));
		footerpane.add(footline1);
		footerpane.add(footline2);
		return footerpane;
	}

}
