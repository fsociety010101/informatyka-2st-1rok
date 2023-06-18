import java.net.InetAddress;

public class ClientObject {
    private Integer port;
    private InetAddress ip;
    private String username;
    private String text;
    private Integer count;

    public ClientObject(Integer port, InetAddress ip, String username, Integer count) {
        this.port = port;
        this.ip = ip;
        this.username = username;
        this.text = "";
        this.count = count;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = this.text + " " + text;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void incCount() {
        this.count++;
    }
}
