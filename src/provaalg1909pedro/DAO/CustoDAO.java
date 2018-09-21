package provaalg1909pedro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import provaalg1909pedro.jdbc.ConnectionFactory;
import provaalg1909pedro.model.Custo;
import provaalg1909pedro.model.Destino;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public class CustoDAO implements GenericDAO<Custo>{
    private Connection connection = null;

    @Override
    public void save(Custo entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into custo(cd_custo, cd_destino, ds_custo, ")
                    .append("tp_custo, vl_custo) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getDestino().getCodigo());
            pstm.setString(3, entity.getDescricao());
            pstm.setInt(4, entity.getTipo());
            pstm.setDouble(5, entity.getValor());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Custo");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Custo entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update custo set cd_destino = ?, ")
                    .append("ds_custo = ?, tp_custo = ?, ")
                    .append("vl_custo = ? ")
                    .append("where cd_custo = ?");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getDestino().getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setInt(3, entity.getTipo());
            pstm.setDouble(4, entity.getValor());
            pstm.setInt(5, entity.getCodigo());
            pstm.execute();
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Custo");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from custo where cd_custo = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao deletar Custo");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public Custo getById(int id) throws SQLException {
        Custo custo = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select c.cd_custo, c.ds_custo, c.tp_custo, "
                    + "c.vl_custo, d.cd_destino, d.ds_destino, "
                    + "d.dt_inicio, d.dt_termino, d.vl_total "
                    + "from custo as c "
                    + "inner join destino as d on (d.cd_destino = c.cd_destino) "
                    + "where c.cd_custo = " + id
                    + "order by c.cd_custo";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custo = new Custo();
            while (rs.next()) {
                custo.setCodigo(rs.getInt("cd_destino"));
                custo.setDestino(carregaDestino(rs.getInt("cd_destino"), rs.getString("ds_destino"), 
                        rs.getDate("dt_inicio"), rs.getDate("dt_termino"), rs.getDouble("vl_total")));
                custo.setDescricao(rs.getString("ds_custo"));
                custo.setTipo(rs.getInt("tp_custo"));
                custo.setValor(rs.getDouble("vl_custo"));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar Destino por Codigo");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custo;
    }

    @Override
    public List<Custo> getByName(String descricao) throws SQLException {
        Custo custo = null;
        List<Custo> custoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select c.cd_custo, c.ds_custo, c.tp_custo, "
                    + "c.vl_custo, d.cd_destino, d.ds_destino, "
                    + "d.dt_inicio, d.dt_termino, d.vl_total "
                    + "from custo as c "
                    + "inner join destino as d on (d.cd_destino = c.cd_destino) "
                    + "where upper(c.ds_custo) like upper('%" + descricao + "%') "
                    + "order by c.cd_custo";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custoList = new ArrayList<>();
            while (rs.next()) {
                custo = new Custo();
                custo.setCodigo(rs.getInt("cd_destino"));
                custo.setDestino(carregaDestino(rs.getInt("cd_destino"), rs.getString("ds_destino"), 
                        rs.getDate("dt_inicio"), rs.getDate("dt_termino"), rs.getDouble("vl_total")));
                custo.setDescricao(rs.getString("ds_custo"));
                custo.setTipo(rs.getInt("tp_custo"));
                custo.setValor(rs.getDouble("vl_custo"));
                custoList.add(custo);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar Custos por Descricao");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custoList;
    }

    @Override
    public List<Custo> getAll() throws SQLException {
        List<Custo> custoList = null;
        Custo custo = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select c.cd_custo, c.ds_custo, c.tp_custo, "
                    + "c.vl_custo, d.cd_destino, d.ds_destino, "
                    + "d.dt_inicio, d.dt_termino, d.vl_total "
                    + "from custo as c "
                    + "inner join destino as d on (d.cd_destino = c.cd_destino) "
                    + "order by c.cd_custo";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custoList = new ArrayList<>();
            while (rs.next()) {
                custo = new Custo();
                custo.setCodigo(rs.getInt("cd_custo"));
                custo.setDestino(carregaDestino(rs.getInt("cd_destino"), rs.getString("ds_destino"), 
                        rs.getDate("dt_inicio"), rs.getDate("dt_termino"), rs.getDouble("vl_total")));
                custo.setDescricao(rs.getString("ds_custo"));
                custo.setTipo(rs.getInt("tp_custo"));
                custo.setValor(rs.getDouble("vl_custo"));
                custoList.add(custo);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Consultar todos Custos");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "select coalesce(max(cd_custo), 0) + 1 as maior from custo";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("maior");
        }catch (SQLException ex){
            System.out.println("Erro ao maior ID Custo");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }
    
    private Destino carregaDestino(int cdDestino, String dsDestino,
            Date dtInicio, Date dtTermino, Double vlTotal) {
        Destino destino = new Destino();
        destino.setCodigo(cdDestino);
        destino.setDescricao(dsDestino);
        destino.setDtInicio(dtInicio);
        destino.setDtTermino(dtTermino);
        destino.setVlTotal(vlTotal);
        return destino;
    }
    
}
