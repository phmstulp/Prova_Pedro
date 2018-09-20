package provaalg1909pedro.model;

import java.util.Date;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public class Destino {
    private int codigo;
    private String descricao;
    private Date dtInicio;
    private Date dtTermino;
    private double vlTotal;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(Date dtTermino) {
        this.dtTermino = dtTermino;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
    
    
}
