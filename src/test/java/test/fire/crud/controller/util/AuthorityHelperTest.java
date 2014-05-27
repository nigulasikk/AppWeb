package test.fire.crud.controller.util;

import org.junit.Test;

import fire.crud.controller.util.AuthorityHelper;

public class AuthorityHelperTest {

	@Test
	public void testHasAuthority() {
		System.out.println(AuthorityHelper.hasAuthority("苹", "苹果，香蕉"));
		System.out.println(AuthorityHelper.hasAuthority("苹果", "苹果,句子"));
		
	}

}
