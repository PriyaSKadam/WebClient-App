package in.priya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.priya.service.QuoteService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		QuoteService bean=context.getBean(QuoteService.class);
		//bean.getQuoteSyn();
		bean.getQuoteAsyn();
	}

}
