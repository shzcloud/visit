package shz.visit.vo;

import shz.orm.annotation.Where;
import shz.orm.enums.Condition;

import java.time.LocalDateTime;
import java.util.List;

public class QueryVisitVo {
    @Where(condition = Condition.BETWEEN)
    private List<LocalDateTime> createTime;
    @Where
    private String appName;
    @Where(condition = Condition.BETWEEN)
    private List<LocalDateTime> destroyedTime;
    @Where(condition = Condition.BETWEEN)
    private List<Long> elapsedTime;
    @Where
    private Boolean login;
    @Where
    private Long userid;
    @Where(condition = Condition.LIKE)
    private String username;
    @Where
    private String ip;
    @Where
    private Integer port;
    @Where
    private String mac;
    @Where(condition = Condition.LIKE)
    private String path;
    @Where
    private String method;
    @Where(condition = Condition.LIKE)
    private String referer;
    @Where
    private Boolean exception;
    @Where
    private Integer exceptionCode;
    @Where(condition = Condition.LIKE)
    private String exceptionMsg;
    @Where(condition = Condition.LIKE)
    private String browser;
    @Where(condition = Condition.LIKE)
    private String browserVersion;
    @Where(condition = Condition.LIKE)
    private String os;
    @Where
    private Boolean ajax;

    public List<LocalDateTime> getCreateTime() {
        return createTime;
    }

    public void setCreateTime(List<LocalDateTime> createTime) {
        this.createTime = createTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<LocalDateTime> getDestroyedTime() {
        return destroyedTime;
    }

    public void setDestroyedTime(List<LocalDateTime> destroyedTime) {
        this.destroyedTime = destroyedTime;
    }

    public List<Long> getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(List<Long> elapsedTime) {
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
        return "QueryVisitVo{" +
                "createTime=" + createTime +
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
