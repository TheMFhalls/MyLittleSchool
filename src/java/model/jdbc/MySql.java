package model.jdbc;

public class MySql extends DataBase {
  public MySql (String usuario, String senha, String banco) {
    super (usuario, senha, banco);
    this.driver = "com.mysql.jdbc.Driver";
    this.url = "jdbc:mysql://instancemls.cb6eepurvhis.us-east-1.rds.amazonaws.com:3306/" + banco;
    this.complementoDialeto = "";
  }  
}
