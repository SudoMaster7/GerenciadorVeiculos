package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SUDO
 */
public class Cliente {
    private String nome;
    private String cpf;
    private String contato;

    public Cliente(String nome, String cpf, String contato) {
        this.nome = nome;
        setCpf(cpf);  // Já valida o CPF aqui
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // Validação do CPF
        if (cpf != null && cpf.length() == 11 && cpf.matches("\\d+")) {
            this.cpf = formatarCpf(cpf); // Formata o CPF
        } else {
            throw new IllegalArgumentException("CPF inválido! O CPF deve ter 11 dígitos numéricos.");
        }
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        if (isContatoValido(contato)) {
            this.contato = contato;
        } else {
            throw new IllegalArgumentException("Contato inválido! O número de contato deve ter apenas dígitos numéricos.");
        }
    }

    private String formatarCpf(String cpf) {
        // Formata o CPF no padrão xxx.xxx.xxx-xx
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    private boolean isContatoValido(String contato) {
        // Validação simples para o contato (apenas números)
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(contato);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
