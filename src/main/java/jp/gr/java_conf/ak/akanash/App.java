package jp.gr.java_conf.ak.akanash;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {

	public static void main(final String... args) {
		new SpringApplicationBuilder(App.class).run(args);
	}
}
