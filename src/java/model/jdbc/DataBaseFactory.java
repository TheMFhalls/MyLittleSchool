package model.jdbc;

public class DataBaseFactory {
  public static DataBase getDataBase (String SGBD, String usuario, String senha, String banco){ 
    DataBase db;
    
    if("MySql".equals(SGBD)) {
        db = new MySql (usuario, senha, banco);
    }else if("SqlServer".equals(SGBD)){
        db = new SqlServer (usuario, senha, banco);
    }else{
        db = null;
    }
    return db;
  }
}
