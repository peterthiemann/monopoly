package monopoly.viewer;

import java.awt.Color;

import monopoly.Group;

public class VGroup {
	static private int[] colors = {
		0x8B4513,
		0x87CEEB,
		0x9932CC,
		0xFFA500,
		0xFF0000,
		0xFFFF00,
		0x00FF00,
		0x0000FF};

	public static Color getColor(Group g) {
		return new Color(colors[g.ordinal()]);
		
	}

}
