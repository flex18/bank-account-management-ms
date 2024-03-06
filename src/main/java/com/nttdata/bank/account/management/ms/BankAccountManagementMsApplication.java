package com.nttdata.bank.account.management.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**import io.reactivex.rxjava3.core.Observable;*/

@EnableDiscoveryClient
@SpringBootApplication
public class BankAccountManagementMsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountManagementMsApplication.class, args);
	/**	Observable<String> observableStrings = Observable.create(
				emmiter -> {
					System.out.println("Hilo Observable: " + Thread.currentThread().getName());
					emmiter.onNext("Maria");
					emmiter.onNext("Aron");
					emmiter.onNext("Jose");
					emmiter.onNext("amalia");
					emmiter.onNext("Anthony");
					emmiter.onNext("Marcelo");
					emmiter.onNext("Carmen");
					emmiter.onNext("AMERICO");
					emmiter.onNext("Karina");
					emmiter.onNext("Isela");
					emmiter.onNext("Christina");
					emmiter.onNext("Carolina");
					emmiter.onComplete();
				}
		);

		observableStrings
	 			//.filter(nombre -> nombre.length() == 4)
				.filter(nombre -> nombre.toLowerCase().startsWith("a"))
				.subscribe(
						nombre ->   println("onNext: " + nombre.toUpperCase()),
						error -> println(error.getMessage()),
						() -> println("onComplete")
				);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}*/

	}
/**
	public static void println(String cadena) {
		System.out.println(cadena);
	}
*/

}
