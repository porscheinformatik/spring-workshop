package workshop.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class StateBean implements InitializingBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StateBean.class);
	private static boolean iAmAlive = false;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (iAmAlive)
			LOGGER.warn("I am already alive");
		else {
			LOGGER.info("I am alive!");
			iAmAlive = true;
		}
		
	}
}
