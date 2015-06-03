import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.mju.software.ProfessorController;

public class ProfessorTest {

	String className;
	
	@Before
	public void setUp() throws Exception {
		Random rand = new Random();
		className = "class " + String.valueOf(rand.nextInt());
//		className = "class1";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateClass() {
		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("userid", "2");
		
		ProfessorController uc = new ProfessorController();
		ModelAndView mav = uc.createclassdone(null, null, session, className);
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}

	
	@Test
	public void testDeleteClass() {
		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("userid", "2");
		
		ProfessorController uc = new ProfessorController();
		ModelAndView mav = uc.deleteclass(null, null,"8");
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}
}
