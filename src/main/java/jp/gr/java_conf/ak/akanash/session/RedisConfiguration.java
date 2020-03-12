package jp.gr.java_conf.ak.akanash.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.embedded.RedisServer;

@Configuration
public class RedisConfiguration {

	@Bean(initMethod = "start", destroyMethod = "stop")
	public RedisServer embeddedRedisServer(@Value("${spring.redis.port}") final int port) {
		return new RedisServer(port);
	}
}
