package ysw;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        //日志级别由低到高
        logger.trace(() -> "reace日志信息！！");
        logger.debug(() -> "debug日志信息！！");
        logger.info(() -> "info日志信息！！");
        logger.warn(() -> "warn日志信息！！");
        logger.error(() -> "error日志信息！！");
    }
}
