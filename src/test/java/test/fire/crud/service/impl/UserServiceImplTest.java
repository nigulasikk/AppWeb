package test.fire.crud.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fire.crud.entity.User;
import fire.crud.service.IUserService;

import test.SpringBaseTest;

public class UserServiceImplTest extends SpringBaseTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testVerify() {
		User u = userService.verify("u", "123456");
		System.out.println(u);
	}

	@Test
	public void testAddLoginCount() {
		User u = userService.findByID(User.class, 1);
		System.out.println(u.toString());
		System.out.println(userService.addLoginCount(1));
		u = userService.findByID(User.class, 1); 
		System.out.println(u.toString());
	}

	@Test
	public void testDoLastLoginInfo() {
		User u = userService.findByID(User.class, 1);
		System.out.println(u.toString());
		System.out.println(userService.doLastLoginInfo(1, "1.2.3.4", new Date()));
		u = userService.findByID(User.class, 1); 
		System.out.println(u.toString());
	}

}
