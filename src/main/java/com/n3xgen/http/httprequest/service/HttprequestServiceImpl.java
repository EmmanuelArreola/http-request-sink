package com.n3xgen.http.httprequest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import org.json.JSONObject;

import com.n3xgen.http.httprequest.bean.HttprequestProperties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HttprequestServiceImpl implements HttprequestService {

	public void sendLogs(String input, HttprequestProperties httpProp) {
		StringBuffer outputPayload = new StringBuffer();
		try {
			log.info("Out here " + httpProp.getRequesturl());
			URL url = new URL(httpProp.getRequesturl());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(httpProp.getRequestmethod());
			if (null != httpProp.getRequestpassword() && !httpProp.getRequestpassword().isEmpty()
					&& null != httpProp.getRequestusername() && !httpProp.getRequestusername().isEmpty()) {
				String encoding = Base64.getEncoder().encodeToString(
						(httpProp.getRequestusername() + ":" + httpProp.getRequestpassword()).getBytes());
				String authHeaderValue = "Basic " + encoding;
				conn.setRequestProperty("Authorization", authHeaderValue);
			}
			if (null != httpProp.getRequestheaders() && !httpProp.getRequestheaders().isEmpty()) {
				log.info(httpProp.getRequestheaders());
				String[] reqProps = httpProp.getRequestheaders().split(",");
				for (int i = 0; i < reqProps.length; i++) {
					log.info("" + i + " ---> " + i);
					String[] props = reqProps[i].split(":");
					conn.setRequestProperty(props[0], props[1]);
				}
			}
			if (!httpProp.getRequestbody().equalsIgnoreCase("payload"))
				input = httpProp.getRequestbody();
			
			JSONObject json = new JSONObject(input);
			String uniqueTransID = getJsonValue(json, httpProp.getUniquetransactionid());
			StringBuffer logMsg = new StringBuffer("Integration ID:" + httpProp.getIntegrationid());
			if (null != httpProp.getIntegrationname() && !httpProp.getIntegrationname().isEmpty()) {
				logMsg.append(System.lineSeparator());
				logMsg.append("Integration Name:" + httpProp.getIntegrationname());
			}
			if (null != httpProp.getLogmsg() && !httpProp.getLogmsg().isEmpty()) {
				logMsg.append(System.lineSeparator());
				logMsg.append(httpProp.getLogmsg());
			} else {
				logMsg.append(System.lineSeparator());
				logMsg.append("This is the default message");
			}
			if (null != uniqueTransID && !uniqueTransID.isEmpty()) {
				logMsg.append(System.lineSeparator());
				logMsg.append("Unique Transaction ID:" + uniqueTransID);
			}
			if (httpProp.getSavepayload().booleanValue()) {
				logMsg.append(System.lineSeparator());
				logMsg.append(json);
			}
			OutputStream os = conn.getOutputStream();
			os.write(json.toString().getBytes());
			os.flush();
			if (conn.getResponseCode() != 200 && conn.getResponseCode() != 202 && conn.getResponseCode() != 201)
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			log.info("Output from Server .... \n");
			String output;
			while ((output = br.readLine()) != null)
				outputPayload.append(output);
			conn.disconnect();
		} catch (MalformedURLException e) {
			throw new ExceptionPath("Malformed URL not supported: " + e.getMessage());
		} catch (IOException e) {
			throw new ExceptionPath("Can't reach URL " + e.getMessage());
		} catch (Exception e) {
			throw new ExceptionPath("General exception: " + e.getMessage());
		}
		log.info("Final output: " + outputPayload.toString());
	}

	public String getJsonValue(JSONObject json, String path) {
		String value = "";
		if (null != path && !path.isEmpty() && null != json) {
			Object obj = json.get(path);
			value = obj.toString();
		}
		return value;
	}
}
