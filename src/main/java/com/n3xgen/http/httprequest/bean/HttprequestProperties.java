package com.n3xgen.http.httprequest.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "httpprocessor")
@Validated
public class HttprequestProperties {

	private String requesturl;

	private String requestmethod;

	private String requestheaders;

	private String requestbody;

	private String requestusername;

	private String requestpassword;

	private Boolean savepayload;

	private String uniquetransactionid;

	private String integrationid;

	private String integrationname;

	private String logmsg;

	public HttprequestProperties(String requesturl, String requestmethod, String requestheaders, String requestbody,
			String requestusername, String requestpassword, Boolean savepayload, String uniquetransactionid,
			String integrationid, String integrationname, String logmsg) {
		this.requesturl = "";
		this.requestmethod = "";
		this.requestheaders = "";
		this.requestbody = "";
		this.requestusername = "";
		this.requestpassword = "";
		this.savepayload = Boolean.valueOf(false);
		this.uniquetransactionid = "";
		this.integrationid = "";
		this.integrationname = "";
		this.logmsg = "";
		this.requesturl = requesturl;
		this.requestmethod = requestmethod;
		this.requestheaders = requestheaders;
		this.requestbody = requestbody;
		this.requestusername = requestusername;
		this.requestpassword = requestpassword;
		this.savepayload = savepayload;
		this.uniquetransactionid = uniquetransactionid;
		this.integrationid = integrationid;
		this.integrationname = integrationname;
		this.logmsg = logmsg;
	}

	public HttprequestProperties() {
		this.requesturl = "";
		this.requestmethod = "";
		this.requestheaders = "";
		this.requestbody = "";
		this.requestusername = "";
		this.requestpassword = "";
		this.savepayload = Boolean.valueOf(false);
		this.uniquetransactionid = "";
		this.integrationid = "";
		this.integrationname = "";
		this.logmsg = "";
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof com.n3xgen.http.httprequest.bean.HttprequestProperties))
			return false;
		com.n3xgen.http.httprequest.bean.HttprequestProperties other = (com.n3xgen.http.httprequest.bean.HttprequestProperties) o;
		if (!other.canEqual(this))
			return false;
		Object this$savepayload = getSavepayload(), other$savepayload = other.getSavepayload();
		if ((this$savepayload == null) ? (other$savepayload != null) : !this$savepayload.equals(other$savepayload))
			return false;
		Object this$requesturl = getRequesturl(), other$requesturl = other.getRequesturl();
		if ((this$requesturl == null) ? (other$requesturl != null) : !this$requesturl.equals(other$requesturl))
			return false;
		Object this$requestmethod = getRequestmethod(), other$requestmethod = other.getRequestmethod();
		if ((this$requestmethod == null) ? (other$requestmethod != null)
				: !this$requestmethod.equals(other$requestmethod))
			return false;
		Object this$requestheaders = getRequestheaders(), other$requestheaders = other.getRequestheaders();
		if ((this$requestheaders == null) ? (other$requestheaders != null)
				: !this$requestheaders.equals(other$requestheaders))
			return false;
		Object this$requestbody = getRequestbody(), other$requestbody = other.getRequestbody();
		if ((this$requestbody == null) ? (other$requestbody != null) : !this$requestbody.equals(other$requestbody))
			return false;
		Object this$requestusername = getRequestusername(), other$requestusername = other.getRequestusername();
		if ((this$requestusername == null) ? (other$requestusername != null)
				: !this$requestusername.equals(other$requestusername))
			return false;
		Object this$requestpassword = getRequestpassword(), other$requestpassword = other.getRequestpassword();
		if ((this$requestpassword == null) ? (other$requestpassword != null)
				: !this$requestpassword.equals(other$requestpassword))
			return false;
		Object this$uniquetransactionid = getUniquetransactionid(),
				other$uniquetransactionid = other.getUniquetransactionid();
		if ((this$uniquetransactionid == null) ? (other$uniquetransactionid != null)
				: !this$uniquetransactionid.equals(other$uniquetransactionid))
			return false;
		Object this$integrationid = getIntegrationid(), other$integrationid = other.getIntegrationid();
		if ((this$integrationid == null) ? (other$integrationid != null)
				: !this$integrationid.equals(other$integrationid))
			return false;
		Object this$integrationname = getIntegrationname(), other$integrationname = other.getIntegrationname();
		if ((this$integrationname == null) ? (other$integrationname != null)
				: !this$integrationname.equals(other$integrationname))
			return false;
		Object this$logmsg = getLogmsg(), other$logmsg = other.getLogmsg();
		return !((this$logmsg == null) ? (other$logmsg != null) : !this$logmsg.equals(other$logmsg));
	}

	protected boolean canEqual(Object other) {
		return other instanceof com.n3xgen.http.httprequest.bean.HttprequestProperties;
	}

	public int hashCode() {
		// int PRIME = 59;
		int result = 1;
		Object $savepayload = getSavepayload();
		result = result * 59 + (($savepayload == null) ? 43 : $savepayload.hashCode());
		Object $requesturl = getRequesturl();
		result = result * 59 + (($requesturl == null) ? 43 : $requesturl.hashCode());
		Object $requestmethod = getRequestmethod();
		result = result * 59 + (($requestmethod == null) ? 43 : $requestmethod.hashCode());
		Object $requestheaders = getRequestheaders();
		result = result * 59 + (($requestheaders == null) ? 43 : $requestheaders.hashCode());
		Object $requestbody = getRequestbody();
		result = result * 59 + (($requestbody == null) ? 43 : $requestbody.hashCode());
		Object $requestusername = getRequestusername();
		result = result * 59 + (($requestusername == null) ? 43 : $requestusername.hashCode());
		Object $requestpassword = getRequestpassword();
		result = result * 59 + (($requestpassword == null) ? 43 : $requestpassword.hashCode());
		Object $uniquetransactionid = getUniquetransactionid();
		result = result * 59 + (($uniquetransactionid == null) ? 43 : $uniquetransactionid.hashCode());
		Object $integrationid = getIntegrationid();
		result = result * 59 + (($integrationid == null) ? 43 : $integrationid.hashCode());
		Object $integrationname = getIntegrationname();
		result = result * 59 + (($integrationname == null) ? 43 : $integrationname.hashCode());
		Object $logmsg = getLogmsg();
		return result * 59 + (($logmsg == null) ? 43 : $logmsg.hashCode());
	}

	public String toString() {
		return "HttprequestProperties(requesturl=" + getRequesturl() + ", requestmethod=" + getRequestmethod()
				+ ", requestheaders=" + getRequestheaders() + ", requestbody=" + getRequestbody() + ", requestusername="
				+ getRequestusername() + ", requestpassword=" + getRequestpassword() + ", savepayload="
				+ getSavepayload() + ", uniquetransactionid=" + getUniquetransactionid() + ", integrationid="
				+ getIntegrationid() + ", integrationname=" + getIntegrationname() + ", logmsg=" + getLogmsg() + ")";
	}

	public String getRequesturl() {
		return this.requesturl;
	}

	public Boolean getSavepayload() {
		return this.savepayload;
	}

	public void setSavepayload(Boolean savepayload) {
		this.savepayload = savepayload;
	}

	public String getIntegrationid() {
		return this.integrationid;
	}

	public void setIntegrationid(String integrationid) {
		this.integrationid = integrationid;
	}

	public String getIntegrationname() {
		return this.integrationname;
	}

	public String getUniquetransactionid() {
		return this.uniquetransactionid;
	}

	public void setUniquetransactionid(String uniquetransactionid) {
		this.uniquetransactionid = uniquetransactionid;
	}

	public void setIntegrationname(String integrationname) {
		this.integrationname = integrationname;
	}

	public String getLogmsg() {
		return this.logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public void setRequesturl(String requesturl) {
		this.requesturl = requesturl;
	}

	public String getRequestmethod() {
		return this.requestmethod;
	}

	public void setRequestmethod(String requestmethod) {
		this.requestmethod = requestmethod;
	}

	public String getRequestheaders() {
		return this.requestheaders;
	}

	public void setRequestheaders(String requestheaders) {
		this.requestheaders = requestheaders;
	}

	public String getRequestbody() {
		return this.requestbody;
	}

	public void setRequestbody(String requestbody) {
		this.requestbody = requestbody;
	}

	public String getRequestusername() {
		return this.requestusername;
	}

	public void setRequestusername(String requestusername) {
		this.requestusername = requestusername;
	}

	public String getRequestpassword() {
		return this.requestpassword;
	}

	public void setRequestpassword(String requestpassword) {
		this.requestpassword = requestpassword;
	}
}
