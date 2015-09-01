package jlu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PojoUser {
    private Logger logger = LoggerFactory.getLogger(PojoUser.class);
    public void usePojo(){
        logger.debug("using pojo");
        Pojo p = new Pojo();
        logger.debug("calling getId");
        p.getId();
        logger.debug("calling getName()");
        p.getName();
        logger.debug("calling doWork()");
        p.doWork();
        logger.debug("calling doFail()");
        try {
            p.doFail();
        } catch (RuntimeException e){
            logger.error("caught a failure",e);
        }
        logger.debug("finished");
    }
    
}
