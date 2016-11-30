package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.service.EMailService;

/**
 * Created by Aspire on 20.11.2016.
 */
public class EMailServiceImpl implements EMailService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EMailServiceImpl.class);

    public void sendEmail() {
        LOGGER.debug("EMailServiceImpl: sendEmail is called");
    }
}
