package test.fire.crud.controller.util;

import org.junit.Test;

import fire.crud.controller.util.WebBeanHelper;

public class WebBeanHelperTest {

	@Test
	public void testExpress() {
		WebBeanHelper wbh = new WebBeanHelper();
		Object o = wbh.express("@fire.crud.controller.util.AuthorityType@values()");
		System.out.println(o);
		
	}

}
