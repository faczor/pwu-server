package playwithus.server.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ServerLogs")
@NoArgsConstructor
public class ServerLog {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ServerLogId", nullable = false)
  public Long serverLogId;

  @Column(name = "Context", nullable = false)
  public String context;

  @Column(name = "LogTime", nullable = false)
  public Timestamp logTime;

  @Column(name = "LogType")
  public String logType;

  public ServerLog(Type logType, String context) {
    this.logType = decodeType(logType);
    this.context = context;
    this.logTime = new Timestamp(System.currentTimeMillis());
  }

  private String decodeType(Type logType) {
    switch (logType) {
      case ERROR:
        return "Error";
      case INFO:
        return "Info";
      case FATAL:
        return "Fatal";
      default:
        return "LogType error";
    }
  }

  public enum Type {
    ERROR,
    INFO,
    FATAL
  }
}
