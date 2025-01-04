package service.gerenciador;

import java.util.HashSet;
import java.util.Set;

public class Gerenciador<T> {  // Usando Generics
    private Set<T> itens;

    public Gerenciador() {
        itens = new HashSet<>();
    }

    public void adicionarItem(T item) {
        itens.add(item);
        System.out.println(item.getClass().getSimpleName() + " adicionado com sucesso!");
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item registrado.");
        } else {
            for (T item : itens) {
                System.out.println(item);
            }
        }
    }
}

