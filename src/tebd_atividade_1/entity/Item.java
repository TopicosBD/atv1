package tebd_atividade_1.entity;
// Generated 15/08/2017 17:13:13 by Hibernate Tools 4.3.1



/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer id;
     private Pedido pedido;
     private String descricao;
     private int quantidade;
     private double valorUnitario;

    public Item() {
    }

    public Item(Pedido pedido, String descricao, int quantidade, double valorUnitario) {
       this.pedido = pedido;
       this.descricao = descricao;
       this.quantidade = quantidade;
       this.valorUnitario = valorUnitario;
    }
   
    public Item(String descricao, int quantidade, double valor) {
       this.descricao = descricao;
       this.quantidade = quantidade;
       this.valorUnitario = valor; 
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValorUnitario() {
        return this.valorUnitario;
    }
    
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotalItem() {
        return this.quantidade * this.valorUnitario;
    }
    
    public String toString() {
        return "Descricao: " + this.descricao + " - " + "Qtd:"
                + this.quantidade + " - " + "Valor: " + this.valorUnitario + "\n";
    }

}

