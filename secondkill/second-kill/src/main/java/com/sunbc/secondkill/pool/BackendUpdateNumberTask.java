package com.sunbc.secondkill.pool;

import com.sunbc.secondkill.pojo.QueueEntity;
import com.sunbc.secondkill.service.SuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by feibabm on 2017/9/11 0011.
 */
@Service
public class BackendUpdateNumberTask implements Runnable {

    @Autowired
    private SuccessKilledService successKilledService;

    @Override
    public void run() {
        while (true) {
            if (!ExecutorPool.queue.isEmpty()) {
                QueueEntity poll = ExecutorPool.queue.poll();
                try {
                    successKilledService.saveSuccessKillBackend(poll.getUserPhone(), poll.getProductId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
