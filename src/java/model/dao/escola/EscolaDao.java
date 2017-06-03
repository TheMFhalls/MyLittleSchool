package model.dao.escola;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Endereco;
import model.bean.Escola;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class EscolaDao{
    private final String exceptionError;
    protected Dialeto dialeto = null;
    Connection connection = null;

    public EscolaDao(DataBase db){
        this.exceptionError = "Erro: classe EscolaDao - não foi possível fechar o manipulador de BD!";
        this.connection = db.getConexao();
        this.dialeto = new DialetoEscola();
    }

    public void inserir(Escola el){
        PreparedStatement ps = null;

        try{      
            String sql_insert = dialeto.inserir();
            ps = this.connection.prepareStatement(sql_insert);
            ps.setLong(1, el.getIdEscola());
            
            ps.setLong(1, el.getIdEscola());
            ps.setString(2, el.getCnpj());
            ps.setString(3, el.getNomeFantasia());
            ps.setString(4, el.getRazaoSocial());
            ps.setLong(5, el.getIdPontuacao());
            ps.setLong(6, el.getIdEndereco());      
            ps.setDate(7, (java.sql.Date) el.getData());
            ps.setInt(8, el.getAtivo());

            ps.executeUpdate ();
        }catch(SQLException e){
            System.out.println("Erro: classe EstadoDao - não foi possível inserir o Estado no BD.");
        }finally{
            try{
                if(ps != null)
                    ps.close();
            }catch(SQLException e){
                System.out.println(exceptionError);
            }
        }  
    }

    public List listar () {
        List resp = new LinkedList ();
        Statement stmt = null;
        ResultSet rs = null;

        try {      
            stmt = this.connection.createStatement ();
            String sql_select = dialeto.listar ();
            rs = stmt.executeQuery (sql_select);

            while (rs.next()) {
                Escola el = new Escola ();

                el.setIdEscola(rs.getInt("idEscola"));
                el.setCnpj(rs.getString("cnpj"));
                el.setNomeFantasia(rs.getString("nomeFantasia"));
                el.setRazaoSocial(rs.getString("razaoSocial"));
                el.setIdEndereco(rs.getInt("idEndereco"));
                el.setIdPontuacao(rs.getInt("idPontuacao"));
                el.setData((java.sql.Date) rs.getDate("data"));
                el.setAtivo(rs.getInt("ativo"));
                
                resp.add (el);
            }
        } catch (SQLException e) {
            resp = null;
            System.out.println ("Erro: classe EstadoDao - não foi possível ler os dados dos Estados a partir do BD!");
        } finally {
            try {
                if (rs != null) 
                    rs.close ();      
                if (stmt != null)
                    stmt.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  

        return resp;
    }

    public Escola encontrar (long id) {
        Escola el = new Escola ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {      
            String sql_select = dialeto.encontrar (); 
            ps = this.connection.prepareStatement (sql_select);

            ps.setLong (1, id);

            rs = ps.executeQuery ();

            if (rs.next()) {
                el.setIdEscola(rs.getInt("idEscola"));
                el.setCnpj(rs.getString("cnpj"));
                el.setNomeFantasia(rs.getString("nomeFantasia"));
                el.setRazaoSocial(rs.getString("razaoSocial"));
                el.setIdEndereco(rs.getInt("idEndereco"));
                el.setIdPontuacao(rs.getInt("idPontuacao"));
                el.setData((java.sql.Date) rs.getDate("data"));
                el.setAtivo(rs.getInt("ativo"));
            }
        } catch (SQLException e) {
          el = null;
          System.out.println ("Erro: classe EscolaDao - Escola não encontrada.");
        } finally {
          try {
            if (rs != null) 
                rs.close ();      
            if (ps != null)
                ps.close ();
          } catch (SQLException e) {
            System.out.println (exceptionError);
          }
        }  
        
        return el;
    }

    public void alterar (Escola el) {
        PreparedStatement ps = null;

        try {      
            String sql_update = dialeto.alterar (); 
            ps = this.connection.prepareStatement (sql_update);

            ps.setLong(1, el.getIdEscola());
            ps.setString(2, el.getCnpj());
            ps.setString(3, el.getNomeFantasia());
            ps.setString(4, el.getRazaoSocial());
            ps.setLong(5, el.getIdPontuacao());
            ps.setLong(6, el.getIdEndereco());      
            ps.setDate(7, (java.sql.Date) el.getData());
            ps.setInt(8, el.getAtivo());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println ("Erro: classe EstadoDao - não foi possível atualizar o Estado no BD.");
        } finally {
            try {
                if (ps != null)
                    ps.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  
    }

    public void remover(Escola el) {
        PreparedStatement ps = null;

        try {      
            String sql_delete = dialeto.remover ();
            ps = this.connection.prepareStatement (sql_delete);

            ps.setInt(1, el.getAtivo());
            ps.setLong(2, el.getIdEscola());

            ps.executeUpdate ();
        } catch (SQLException e) {
            System.out.println ("Erro: classe EscolaDao - não foi possível excluir escola  no BD.");
        } finally {
            try {
              if (ps != null)
                ps.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  
    }
    
    public List encontrarEnderecoEscola(long id){
        DialetoEscola dialetoEspecifico = new DialetoEscola();
        List resp = new LinkedList ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {         
            String sql_select = dialetoEspecifico.encontrarEnderecoEscola();

            ps = this.connection.prepareStatement (sql_select);
            ps.setLong(1, id);
            rs = ps.executeQuery ();

            while (rs.next()) {
                Endereco e = new Endereco();

                e.setIdEndereco (rs.getLong ("idEndereco"));
                e.setLogradouro (rs.getString ("logradouro"));
                e.setNumero (rs.getInt ("numero"));
                e.setComplemento (rs.getString ("complemento"));
                e.setIdBairro (rs.getLong ("idBairro"));
                e.setData((java.sql.Date) rs.getDate("data"));
                e.setAtivo(rs.getInt("ativo"));

                resp.add(e);
            }
        } catch (SQLException e) {
            resp = null;
            System.out.println ("Erro: classe EstadoDao - não foi possível ler os dados dos Estados a partir do BD!");
        } finally {
            try {
                if (rs != null) 
                    rs.close ();      
                if (ps != null)
                    ps.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage());
            }
        }  

        return resp;
    }

    public Dialeto getDialeto () {
        return dialeto;
    }

    public void setDialeto (Dialeto dialeto) {
        this.dialeto = dialeto;
    } 
}
