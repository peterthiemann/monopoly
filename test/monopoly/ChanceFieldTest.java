package monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChanceFieldTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		ChanceField field = ChanceField.getInstance();
		ChanceField field2 = ChanceField.getInstance();
		assertEquals(field, field2);
	}

}
