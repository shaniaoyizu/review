package com.sunbc.secondkill;

import com.sunbc.secondkill.pool.BackendUpdateNumberTask;
import com.sunbc.secondkill.pool.ExecutorPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SecondKillApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SecondKillApplication.class, args);
		BackendUpdateNumberTask bean = run.getBean(BackendUpdateNumberTask.class);
		ExecutorPool.submit(bean);
	}

}
