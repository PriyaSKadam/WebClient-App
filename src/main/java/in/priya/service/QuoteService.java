package in.priya.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteService {
	
	private static final String url="https://type.fit/api/quotes";
	
   public Mono<String> getQuoteSyn()
   {
	  System.out.println("Rest Api call started.....");
	   WebClient webClient= WebClient.create();
	   
	  Mono<String> quote= webClient.get()
	             .uri(url)
	             .retrieve()
	             .bodyToMono(String.class);
	   
	  System.out.println(quote.block());
	   System.out.println("Rest Api call Completed....");
	   return quote;
   }
   
   public void getQuoteAsyn()
   {
	   
	   WebClient webClient=WebClient.create();
	   System.out.println("Rest API call started....");
	   webClient.get()
	            .uri(url)
	            .retrieve()
	            .bodyToMono(String.class)
	            .subscribe(QuoteService::handleResponse);
	   System.out.println("Rest API completed...");
	   
   }
   
   public static void handleResponse(String s)
   {
	   System.out.println(s);
   }

}
