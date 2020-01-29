import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.util.Random;
import org.junit.Test;


public class NodeTest{

	@Test
	public void testConstructor(){
		int result = 6;
		Node test_1 = new Node(result);
		assertEquals("d is not right after basic constructor",result, test_1.key);
	}


}