package study.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import study.mvc.controller.HomeApiController;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    private final static Logger logger = LoggerFactory.getLogger(HomeApiController.class);

    public void async(DeferredResult<String> result) {
        new Thread(() -> {
            logger.info("start");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ignore) {}
            logger.info("end");
            result.setResult(String.valueOf("async Result"));
        }).start();
    }

}
