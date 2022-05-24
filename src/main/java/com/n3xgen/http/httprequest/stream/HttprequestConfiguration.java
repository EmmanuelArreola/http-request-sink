package com.n3xgen.http.httprequest.stream;

import java.util.function.Consumer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.n3xgen.http.httprequest.bean.HttprequestProperties;
import com.n3xgen.http.httprequest.service.HttprequestService;
import com.n3xgen.http.httprequest.service.HttprequestServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableConfigurationProperties({ HttprequestProperties.class })
@Configuration
public class HttprequestConfiguration {

	@Bean
	public Consumer<String> processTransformation(HttprequestProperties httpProp) {
		return payload -> {
			log.info("Starting method SendingLogs");
			HttprequestService sendingLogs = new HttprequestServiceImpl();
			sendingLogs.sendLogs(payload, httpProp);
		};
	}

}
