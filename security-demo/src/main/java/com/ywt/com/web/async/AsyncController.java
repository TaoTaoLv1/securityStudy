package com.ywt.com.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/order")
    public Callable<String> order() throws InterruptedException {
        logger.info("主线程开始");
        // Callable 在开一个线程 做业务逻辑处理
        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "成功";
            }
        };
        logger.info("主线程返回");
        return stringCallable;
    }
}
