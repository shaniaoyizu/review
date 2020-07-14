package com.sunbc.elastic;

import com.sunbc.elastic.bean.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03ElasticApplicationTests {


	@Test
	void contextLoads() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("好消息");
		article.setAuthor("zhangsan");
		article.setContent("To be or not to be");
	}

}
