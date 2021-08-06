package com.sawan.springboot.reactive;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sawan.springboot.reactive.vaccine.VaccineProvider;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactivedemoApplicationTests {
	
	@Autowired
	public VaccineProvider provider;
	
	@Test
	void testVaccineProvider() {
		provider.provideVaccines().subscribe(new VaccineConsumer());
	}

	// Mono publish single data
	@Test
	void testMono() {
		Mono.just("MackBook Pro")
		.log()
		.map(data -> data.toUpperCase())
		.subscribe(System.out::println);
		// .subscribe(data -> System.out.println(data));
	}
	
	// Flux publish multiple data
	@Test
	void testFlux() {
		
		Flux.fromIterable(Arrays.asList("MackBook Pro", "IPhone", "Samsung", 
				"MackBook Pro", "IPhone", "Samsung", 
				"MackBook Pro", "IPhone", "Samsung"))
		.log()
		.map(data -> data.toUpperCase())
		.subscribe(new Subscriber<String>() {
			
			private long count = 0;
			private Subscription subscription;

			@Override
			public void onSubscribe(Subscription subs) {
				this.subscription = subs;
				subs.request(3);
			}

			@Override
			public void onNext(String data) {
				count++;
				if(count >= 3) {
					count = 0;
					subscription.request(3);
				}
				System.out.println(data);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Successfully Completed!");
			}
		});
		
	}

}
