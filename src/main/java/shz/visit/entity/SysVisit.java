package shz.visit.entity;

import shz.jdbc.record.JdbcConsistentHashRecordEntity;
import shz.orm.annotation.Id;
import shz.orm.annotation.Table;
import shz.visit.hash.VisitConsistentHash;

import java.time.LocalDateTime;

@Table("sys_visit")
public class SysVisit extends JdbcConsistentHashRecordEntity<SysVisit, VisitConsistentHash> {
    @Id
    private Long id;
    private LocalDateTime createTime;
    private String appName;
    private LocalDateTime destroyedTime;
    private Long elapsedTime;
    private Boolean login;
    private Long userid;
    private String username;
    private String ip;
    private Integer port;
    private String mac;
    private String path;
    private String method;
    private String referer;
    private Boolean exception;
    private Integer exceptionCode;
    private String exceptionMsg;
    private String browser;
    private String browserVersion;
    private String os;
    private Boolean ajax;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public LocalDateTime getDestroyedTime() {
        return destroyedTime;
    }

    public void setDestroyedTime(LocalDateTime destroyedTime) {
        this.destroyedTime = destroyedTime;
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public Boolean getException() {
        return exception;
    }

    public void setException(Boolean exception) {
        this.exception = exception;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Boolean getAjax() {
        return ajax;
    }

    public void setAjax(Boolean ajax) {
        this.ajax = ajax;
    }

    @Override
    public String toString() {
        return "SysVisit{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", appName='" + appName + '\'' +
                ", destroyedTime=" + destroyedTime +
                ", elapsedTime=" + elapsedTime +
                ", login=" + login +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", mac='" + mac + '\'' +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", referer='" + referer + '\'' +
                ", exception=" + exception +
                ", exceptionCode=" + exceptionCode +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                ", browser='" + browser + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", os='" + os + '\'' +
                ", ajax=" + ajax +
                '}';
    }
}
