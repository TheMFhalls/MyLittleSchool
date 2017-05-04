package model.jdbc;

public class SqlServer extends DataBase {
  public SqlServer (String usuario, String senha, String banco) {
    super (usuario, senha, banco);
    this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    this.url = "jdbc:sqlserver://dbmls.cb6eepurvhis.us-east-1.rds.amazonaws.com:1433;databaseName=" + banco;
    this.complementoDialeto = ".dbo";
  }  
}
  