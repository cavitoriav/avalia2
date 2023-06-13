import java.time.LocalDate;
import java.util.Date;

public class Venda {
    private Produto ptdVendido;
    private int qtdVendida;
    private LocalDate dataDaVenda; 
    
        public Venda(Produto ptdVendido, int qtdVendida, LocalDate dataDaVenda) {
        this.ptdVendido = ptdVendido;
        this.qtdVendida = qtdVendida;
        this.dataDaVenda = dataDaVenda;
    }

        public Produto getPtdVendido() {
        return ptdVendido;
    }

    public void setPtdVendido(Produto ptdVendido) {
        this.ptdVendido = ptdVendido;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

        @Override
    public String toString() {
        return "Venda [ptdVendido=" + ptdVendido + ", qtdVendido=" + qtdVendida + ", dataDaVenda=" + dataDaVenda + "]";
    }

   
}
