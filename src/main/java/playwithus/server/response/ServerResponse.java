package playwithus.server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServerResponse {

  private Response response;

  private String code;

  private String msg;

  public ServerResponse(Response code){
    this.code = String.valueOf(code);
    this.msg = code.getMsg();
  }

  public ServerResponse() {
    this.code = "200";
    this.msg = "OK";
  }

}
