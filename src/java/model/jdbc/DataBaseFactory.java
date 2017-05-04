package model.jdbc;

public class DataBaseFactory {
  public static DataBase getDataBase (String SGBD, String usuario, String senha, String banco){ 
    DataBase db;
    
    switch (SGBD) {
      case "MySql": 
        db = new MySql (usuario, senha, banco);
        break;
      case "SqlServer":
        db = new SqlServer (usuario, senha, banco);
        break;
      default:
        db = null;
    }
    return db;
  }
}
