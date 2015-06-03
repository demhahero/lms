import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import com.mju.software.LoginController;
import com.mju.software.StudentController;


public class StudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegisterclass() {
		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("userid", "1");
		
		StudentController uc = new StudentController();
		ModelAndView mav = uc.registerclassdone(null, null, "5", session);
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}
	
	@Test
	public void testUnRegisterclass() {
		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("userid", "5");
		
		StudentController uc = new StudentController();
		ModelAndView mav = uc.deleteclass(null, null, "2", session);
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}
}
