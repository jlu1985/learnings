package jlu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pojo {

    private static final Logger logger = LoggerFactory.getLogger(Pojo.class);
    
    private String name;
    private int id;
    public String getName() {
        logger.trace("Get name");;
        return name;
    }
    public void setName(String name) {
        logger.trace("Set name {}", name);
        this.name = name;
    }
    public int getId() {
        logger.trace("Get id");
        return id;
    }
    public void setId(int id) {
        logger.trace("Set id {}",id);
        this.id = id;
    }
    
    public void doWork(){
        logger.debug("Doing working");
        getId();
        getName();
    }
    public void doFail(){
        logger.error("throwing exception here");
        throw new RuntimeException("I failed");
        
    }
}
