package com.n3xgen.http.httprequest.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ConfigurationProperties(prefix = "httpprocessor")
@Validated
public class HttprequestProperties {

	private String requesturl = "";	
	private String requestmethod = "";
	private String requestheaders = "";
	private String requestbody = "";
	private String requestusername = "";
	private String requestpassword = "";
	
}
