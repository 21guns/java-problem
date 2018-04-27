package com.guns21.hikari.job;

import com.guns21.hikari.repository.OperationRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class Jobs {

    @Autowired
    private OperationRecordRepository operationRecordRepository;

    private ExecutorService executorService  = Executors.newFixedThreadPool(10);

    public final static long ONE_Minute =  60 * 1000;
    
    @Scheduled(fixedDelay=ONE_Minute)
    @Transactional
    public void fixedDelayJob(){
        for (int i = 0; i < 10; i++) {
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            operationRecordRepository.listAll();
                            log.info(LocalDateTime.now() +" >>fixedDelay执行....");
                        }
                    }
            );
        }



    }
    
    @Scheduled(fixedRate=ONE_Minute)
    @Transactional
    public void fixedRateJob(){
        operationRecordRepository.listAll();
        log.info(LocalDateTime.now()+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    @Transactional
    public void cronJob(){
        log.info(LocalDateTime.now()+" >>cron执行....");
    }
}

