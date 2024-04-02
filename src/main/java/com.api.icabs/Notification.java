package com.api.icabs;

public class Notification {

  private String id;
  private String file;
  private String username;
  private String url;
  private String status;
  public Notification(String id, String file, String username, String url, String status) {
    this.id = id;
    this.file = file;
    this.username = username;
    this.url = url;
    this.status = status;
  }

  public Notification() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Notification{" + "id='" + id + '\'' + ", file='" + file + '\'' + ", username='"
        + username + '\'' + ", url='" + url + '\'' + ", status='" + status + '\'' + '}';
  }

}
