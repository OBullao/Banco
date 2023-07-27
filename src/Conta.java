import java.math.BigDecimal;

public class Conta {
    private String nome;
    private BigDecimal saldo = new BigDecimal(100);
    private BigDecimal investido = new BigDecimal(0);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getInvestido() {
        return investido;
    }

    public void setInvestido(BigDecimal investido) {
        this.investido = investido;
    }

    public BigDecimal retirar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(valor);
            return valor;
        } else {
            return BigDecimal.ZERO;
        }
    }

    public void deposito(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
        }
    }

    private static final BigDecimal AUMENTO_INVESTIMENTO = new BigDecimal("0.05");

    public void investir(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(valor);
            investido = investido.add(valor);

        }
    }
}
