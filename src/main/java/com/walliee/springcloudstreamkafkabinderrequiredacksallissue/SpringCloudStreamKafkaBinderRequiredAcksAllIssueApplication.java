package com.walliee.springcloudstreamkafkabinderrequiredacksallissue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class SpringCloudStreamKafkaBinderRequiredAcksAllIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaBinderRequiredAcksAllIssueApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(@Qualifier(Source.OUTPUT) MessageChannel channel) {
		return args -> {
			channel.send(MessageBuilder.withPayload("payload").build());
		};
	}

}
