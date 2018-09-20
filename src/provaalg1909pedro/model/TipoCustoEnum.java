package provaalg1909pedro.model;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public enum TipoCustoEnum {
    Lazer(1), Alimentacao(2), Transporte(3);
    
    public int tipo;
    
    private TipoCustoEnum(int tipo) {
        this.tipo = tipo;
    }
}
