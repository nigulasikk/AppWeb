package fire.crud.creator;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





import fire.crud.entity.User;

public class MultiCreator extends CreatorBase {

	final private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testCreateDB() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		logger.info("Creating Task ...");

		configuration.addAnnotatedClass(User.class);
	/*	configuration.addAnnotatedClass(Task.class);
		configuration.addAnnotatedClass(TaskCooperator.class);*/
//		configuration.addAnnotatedClass(Notice.class);
//		configuration.addAnnotatedClass(Document.class);
/*		configuration.addAnnotatedClass(Technology.class);*/
//		configuration.addAnnotatedClass(Paper.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
		session.getTransaction().commit();
		session.close();

		//
		session = sessionFactory.openSession();
		session.beginTransaction();

		// for(int i=0;i<1000;i++)
		User user = new User("u", "{SSHA}pL0UiQNll/fhmNDD+peECuQ8kZkuEuBoUMcOIg==", null, "张三", "13945342656", "342353254", "2342@163.com", 4, new Date(),
				"192.168.0.23", "被的是的发送到", User.EnableEnum.启用, "增删改查员工,增删改查书籍,增删改查任务");
		session.save(user);
		for (String ss[] : getList()) {
			user = new User();
			user.setLoginName(ss[0]);
			user.setPswd(ss[1]);
			user.setName(ss[2]);
			user.setEmail(ss[0] + "@ccntgrid.org");
			user.setEnable(User.EnableEnum.启用);
			session.save(user);
		}

/*		Task task = new Task("修改dis提供给54所接口", "", 240, new Date(), Task.StateEnum.已完成, 1, 2);

		session.save(task);

		session.save(new TaskCooperator(1, 1));*/

/*		Notice notice = new Notice("测试规范", "测试组分工", user.getId(), user.getId(), new Date(), new Date());
		session.save(notice);
		notice = new Notice("测试规范", "测试组分工", user.getId(), user.getId(), new Date(), new Date());
		session.save(notice);
		notice = new Notice("测试规范", "测试组分工", user.getId(), user.getId(), new Date(), new Date());
		session.save(notice);
		notice = new Notice("测试规范", "测试组分工", user.getId(), user.getId(), new Date(), new Date());
		session.save(notice);*/

	/*	Document document = new Document("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(document);
		document = new Document("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(document);
		document = new Document("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(document);
		document = new Document("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(document);*/
/*
		Technology technology = new Technology("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(technology);
		technology = new Technology("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(technology);
		technology = new Technology("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(technology);
		technology = new Technology("测试规范", "士大夫收到收到发生地方收到", user.getId(), user.getId(), new Date(), new Date());
		session.save(technology);*/
		
	/*	Paper paper = new Paper("样例", "样例内容", user.getId(), user.getId());
			session.save(paper);*/

		session.getTransaction().commit();
		session.close();

	}

	private List<String[]> getList() {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "postmaster", "{SSHA}jn7D055+mkaxM5Ejku0Pa+nFpLtQTPJh", "postmaster" });
		list.add(new String[] { "www", "{SSHA}TKi1WjW0jD4oijvIo17abQ/8z7UtJ1lxuQmQaw==", "www" });
		list.add(new String[] { "l", "{SSHA}VoxXDRzSruHxfYHnCFKOue2x+2xoiN8br5E4FA==", "胡磊" });
		list.add(new String[] { "flying", "{SSHA}h/pjQxZVIQuYB8RwnqwO8aLyfy2Bof1QuLvStg==", "商任翔" });
		list.add(new String[] { "g", "{SSHA}Kqr1OM+nwxpNF9EYBgj9lxev77Nge0HIQ8G7Bg==", "高啸" });
		list.add(new String[] { "ml", "{SSHA}JytGPObdymffXDhJWtNQCfi8nQOzYeedKErV8g==", "黄梅龙" });
		list.add(new String[] { "fangkyo", "{SSHA}ptDhTFCKNHKwj54iZGx+KIoR8XnbGqskLH6TpQ==", "方聪" });
		list.add(new String[] { "sgkwww", "{SSHA}bJEH8hXLz6RbiE2r0fz4Cc/JYzivTcrmi+crmQ==", "孙庚宽" });
		list.add(new String[] { "guofeng", "{SSHA}seM1Yk5dwEpB7dm2ETFy0ckCehLZ5Xd1oZc+/Q==", "郭凤" });
		list.add(new String[] { "790042744", "{SSHA}0cwUX682oBHZyMBC3i8nrMfeyxhD9gdny8kgCA==", "黄鹏" });
		list.add(new String[] { "zpc", "{SSHA}FTtCU/JusX0nTh4LOmpBKgdL9ly4qQ5e5mKXBg==", "邹鹏程" });
		list.add(new String[] { "fire", "{SSHA}pL0UiQNll/fhmNDD+peECuQ8kZkuEuBoUMcOIg==", "陶金火" });
		list.add(new String[] { "linfujun", "{SSHA}RT8nDtiySUoRmtqxlGLqNGiAmIcoX1XVbLs3rA==", "林福军" });
		list.add(new String[] { "colarzhao", "{SSHA}bM5sear9Ko5l8TZDj7YN41pYeOv+dRzrH33vvA==", "赵艳波" });
		list.add(new String[] { "burningcl", "{SSHA}ra8FfwmrjP3/Kwswp2GC668o1SO4Bh09aCTRIw==", "陈亮" });
		list.add(new String[] { "cciv79", "{SSHA}gaH6IUtSRAFJA1FnD4w9YtbqZ1tUMuddQ4XJvw==", "刘东" });
		list.add(new String[] { "nansonzhu", "{SSHA}txMC8OYKw7hBv9wuht/+IhftOC/8EaMFuNb8/w==", "朱双龙" });
		list.add(new String[] { "jiangxingbo", "{SSHA}S7fkmNLZJZPkw6b0J0TZY8o0z0s9hLQ64keCtA==", "江兴波" });
		list.add(new String[] { "panxuanfan", "{SSHA}eARMRYJNWHmDwJdwAEWJXCITGHlTLIn2uXnbTA==", "潘炫帆" });
		list.add(new String[] { "tsforce", "{SSHA}zPA2G0MC+RZST9QN4djNFLiGakXZAo181b8ONw==", "田帅" });
		list.add(new String[] { "smingming", "{SSHA}LCa6448xmV/4GwipDJ4dD7c9kHo3pWAjv/CGyg==", "施明明" });
		list.add(new String[] { "chenmx", "{SSHA}prWE+BiHocdgs0JFfiJbUVizzringdZ43k3BNQ==", "陈妙鑫" });
		list.add(new String[] { "lixiang", "{SSHA}yZenwXgZg0kiuMuE6T7M0ydB2AnQzkOvJ/bjQw==", "李翔" });
		list.add(new String[] { "zhangjunquan", "{SSHA}avyObf4fS/BDo9mHxS7mSpZScMeDvQiaME90DQ==", "张军权" });
		list.add(new String[] { "linzhanghui", "{SSHA}ectnK/kRYELzjPJ6GHmEyROW9lqr9vBilNFM0Q==", "林张慧" });
		list.add(new String[] { "limchiang", "{SSHA}A0wlqKIFnSMtrF1W4DyrbN+4L2c1wPRMRR2Pkg==", "江琳" });
		list.add(new String[] { "zgf", "{SSHA}AItj9/9HCSRbSv0+/OBkiivK5VVVbRipypWQEA==", "朱桂锋" });
		list.add(new String[] { "tom", "{SSHA}sG+3FlsoGx+fKxUBiKw3R0nyQZCOJJIBbXfx+w==", "陈云路" });
		list.add(new String[] { "zzzgz", "{SSHA}9CkcXOa8Yaf9Iy4h70Y4xfrQLycW+hUmPXx37A==", "郑国轴" });
		list.add(new String[] { "oyyt", "{SSHA}niYt5w8DI+InSHyUlx2Jbo7KO89Dw3/2OU3uEQ==", "欧阳宇彤" });
		list.add(new String[] { "liuyunchao", "{SSHA}YojN5ChhMau3Oz9tUDYIAgU7oxlpTGRV85dAKQ==", "柳云超" });
		list.add(new String[] { "yujj", "{SSHA}Mfws3CTMN4aULyIaOek74NXshqWSRSJMmUcLEQ==", "余晶晶" });
		list.add(new String[] { "dongkuizhou", "{SSHA}p4RVJ44+upAkGF7VTl2dhI7nEcbh4uadc4FoBg==", "周冬奎" });
		list.add(new String[] { "mudaoming", "{SSHA}bfQH2yVMYE+QB6MfUNELsql6jGmMEWqaAYYvXQ==", "穆道明" });
		list.add(new String[] { "tianjunjh", "{SSHA}PrZXqsjo9vFpJDBvNnwocb9Chj/xwzMv3YylDQ==", "田军" });
		list.add(new String[] { "ocsen", "{SSHA}I0hc8GjF+fPIhhgl75zfJ2LmvB1wIHTSEbmmRQ==", "王雄兵" });
		list.add(new String[] { "yeweirab0", "{SSHA}FBLu+OrihAGmfWxajTRZUbtJ6kuP4CrJHdsHHw==", "王晓江" });
		list.add(new String[] { "wn", "{SSHA}iNPoyM2c03OvwIF6QI+R08CATN5eNDCd2QmlRA==", "王娜" });
		list.add(new String[] { "erics", "{SSHA}GS35LhmR1oP8sb3oGN4oYPXUVRqJEbB9qFkDSw==", "杨望暑" });
		list.add(new String[] { "lizhuoling", "{SSHA}yTioezko5g4TGG57zIIgxnaeQbJDDPusgQW/lw==", "李灼灵" });
		list.add(new String[] { "chenyunlu", "{SSHA}Ey+0uz8h8Aa5FvanJYqusBXtUoaHC/i+QiaRuw==", "陈云路" });
		list.add(new String[] { "chenhui", "{SSHA}V6ysmHLgFdsT5bLLvOdZTqYB8gqMVoseWehuqQ==", "陈辉" });
		list.add(new String[] { "weibin", "{SSHA}I2JoCg7GBYob16jWuxyhGNyd7bedYlfVnNIuIg==", "魏彬" });
		list.add(new String[] { "nineright", "{SSHA}AFZjR74Y52nk6ezt3FbHHSdpfXWtPKKtTxPJWQ==", "林久对" });
		list.add(new String[] { "huajunsir", "{SSHA}jccQVLpOTt3eNpDstrrAdeCmDh8OnSQLZpn7MA==", "陈华钧" });
		list.add(new String[] { "zhangliang", "{SSHA}Sii+F7Funx2a/n6box8Y8Yuds106p0V+ksuz+g==", "张梁" });
		list.add(new String[] { "fanchenxi", "{SSHA}PlM4zgYlXpMZt3iMiHB9HlPwQ1/qyZXMxMcyDQ==", "范晨熙" });
		list.add(new String[] { "lvsajun", "{SSHA}frKsnWOWg/ZXm548AkHfb7UyBMmO+H+kR3ZW8w==", "吕洒俊" });
		list.add(new String[] { "346670414", "{SSHA}WDWjpTr64pxBz5v9T0KzP0aSszqd+q3uChBT1Q==", "曾明宇" });
		list.add(new String[] { "liuna", "{SSHA}TvcTokYHmo0Ay7IV42pcmuEeEWoMFfmf7kNREw==", "刘娜" });
		list.add(new String[] { "obgnehz", "{SSHA}9FOUIFxqDAFI/5xt8qOf/o/OlFPY/qUpwTDX1g==", "郑波" });
		list.add(new String[] { "jl", "{SSHA}+yVaLo+sDag7flOiwLBw5ZUc2nW/EBA2hRrCfQ==", "王佳丽" });
		list.add(new String[] { "zhulina", "{SSHA}9IDfqRT0XkNbDcZp6xU0++eq7JnEU21aRFTKwQ==", "朱莉娜" });
		list.add(new String[] { "zhangke", "{SSHA}qlQ1uVQG1QoUrfdT7C+RyUnCmvmTLAoRt87YfA==", "张科" });
		list.add(new String[] { "zhangxiaobing", "{SSHA}5mqjmsQbcrMrsJj7WCUEF7cJdRWWf4Vd3cRqTw==", "张晓兵" });
		list.add(new String[] { "qiankaijie", "{SSHA}y3M6jqmkSl64egB3lLkPxAMDYNt8h55Bv7sDbQ==", "钱凯杰" });
		list.add(new String[] { "wangjun", "{SSHA}AFuiDf0Y2CujzQ6G8NZ+8xAFhAWGYC9H4MgAjg==", "王骏" });
		list.add(new String[] { "fire1", "{SSHA}APgksyoq1Y64KSjN5KqGnEvnhBCDgEbRLnTWCA==", "fire1" });
		return list;
	}

}
