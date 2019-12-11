package playwithus.server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Getter
@AllArgsConstructor
public class ServerResponse {

  private String code;

  private String msg;

  @Lazy
  @Autowired
  private ServerResponseConstrains serverResponseConstrains;

  public ServerResponse(){
    code = "200";
    msg = "OK";
  }

  public ServerResponse(String code){
    this.code = code;
    this.msg = "FATAL";
  }
}
