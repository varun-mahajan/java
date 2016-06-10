package org.bytegeeks.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestMethods {
    private static final Logger LOG = LoggerFactory.getLogger(TestMethods.class);

    public void testOneArg(String str) {
        LOG.info(str);
    }

    public void testTwoArg(String str1, String str2) {
        LOG.info(str1 + " - " + str2);
    }
}
