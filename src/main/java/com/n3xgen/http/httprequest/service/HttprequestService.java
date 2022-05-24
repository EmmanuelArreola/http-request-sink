package com.n3xgen.http.httprequest.service;

import com.n3xgen.http.httprequest.bean.HttprequestProperties;

public interface HttprequestService {
	public void sendLogs(String input, HttprequestProperties httpProp);
}
