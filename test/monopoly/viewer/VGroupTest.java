package monopoly.viewer;

import static org.junit.Assert.*;

import java.awt.Color;

import monopoly.Group;

import org.junit.Before;
import org.junit.Test;

public class VGroupTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetColor() {
		assertEquals(VGroup.getColor(Group.BLUE), new Color(0x0000FF));
		assertEquals(VGroup.getColor(Group.DARKORCHID), new Color(0x9932CC));
		assertEquals(VGroup.getColor(Group.GREEN), new Color(0x00FF00));
		assertEquals(VGroup.getColor(Group.ORANGE), new Color(0xFFA500));
		assertEquals(VGroup.getColor(Group.RED), new Color(0xFF0000));
		assertEquals(VGroup.getColor(Group.SADDLEBROWN), new Color(0x8B4513));
		assertEquals(VGroup.getColor(Group.SKYBLUE), new Color(0x87CEEB));
		assertEquals(VGroup.getColor(Group.YELLOW), new Color(0xFFFF00));
	}

}
