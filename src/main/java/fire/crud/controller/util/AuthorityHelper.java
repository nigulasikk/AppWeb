package fire.crud.controller.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorityHelper {

	final static Logger LOGGER = LoggerFactory.getLogger(AuthorityHelper.class);
	
	/**
	 * 判断是否有权限
	 * <b>低效的设计</b>
	 * 
	 * @param rightName
	 * @param rc
	 * @return
	 */
	@Deprecated
	public static boolean hasAuthority(String rightName, String rc) {
		Set<String> rightSet = new HashSet<String>();
		String ss[] = rc.split(",");
		for (String s : ss) {
			if (StringUtils.isNotEmpty(s)) {
				rightSet.add(s);
			}
		}
		LOGGER.debug("rightSet: {}", rightSet.toString());
		return rightSet.contains(rightName);
	}

}
