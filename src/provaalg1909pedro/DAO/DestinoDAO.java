package provaalg1909pedro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import provaalg1909pedro.jdbc.ConnectionFactory;
import provaalg1909pedro.model.Destino;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public class DestinoDAO implements GenericDAO<Destino>{
    private Connection connection = null;

    @Override
    public void save(Destino entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into destino(cd_destino, ds_destino, dt_inicio, ")
                    .append("dt_termino, vl_total) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDouble(5, entity.getVlTotal());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Destino");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Destino entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update destino set ds_destino = ?, ")
                    .append("dt_inicio = ?, dt_termino = ?, ")
                    .append("vl_total = ? ")
                    .append("where cd_destino = ?");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setDouble(4, entity.getVlTotal());
            pstm.setInt(5, entity.getCodigo());
            pstm.execute();
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Destino");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from destino where cd_destino = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao deletar Destino");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public Destino getById(int id) throws SQLException {
        Destino destino = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from destino where cd_destino = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destino = new Destino();
            while (rs.next()) {
                destino.setCodigo(rs.getInt("cd_destino"));
                destino.setDescricao(rs.getString("ds_destino"));
                destino.setDtInicio(rs.getDate("dt_inicio"));
                destino.setDtTermino(rs.getDate("dt_termino"));
                destino.setVlTotal(rs.getDouble("vl_total"));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar Destino por Codigo");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destino;
    }

    @Override
    public List<Destino> getByName(String descricao) throws SQLException {
        Destino destino = null;
        List<Destino> destinoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from destino where upper(ds_destino) like upper('%" + descricao + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destinoList = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("cd_destino"));
                destino.setDescricao(rs.getString("ds_destino"));
                destino.setDtInicio(rs.getDate("dt_inicio"));
                destino.setDtTermino(rs.getDate("dt_termino"));
                destino.setVlTotal(rs.getDouble("vl_total"));
                destinoList.add(destino);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar Destinos por Descricao");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destinoList;
    }

    @Override
    public List<Destino> getAll() throws SQLException {
        List<Destino> destinoList = null;
        Destino destino = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select * from destino order by cd_destino";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destinoList = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("cd_destino"));
                destino.setDescricao(rs.getString("ds_destino"));
                destino.setDtInicio(rs.getDate("dt_inicio"));
                destino.setDtTermino(rs.getDate("dt_termino"));
                destino.setVlTotal(rs.getDouble("vl_total"));
                destinoList.add(destino);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar todos Destinos");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destinoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select coalesce(max(cd_destino), 0) + 1 as maior from destino";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("maior");
        }catch (SQLException ex){
            System.out.println("Erro ao maior ID Destino");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
    
}
