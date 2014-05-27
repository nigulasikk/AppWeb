package fire.crud;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @author Administrator
 *
 */
@Component("config")
public class Config {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${timeMonitor}")
	public boolean timeMonitor;
	
	@PostConstruct
	private void init(){
		logger.info("是否统计运行时间:{}", timeMonitor);
	}
	
}
