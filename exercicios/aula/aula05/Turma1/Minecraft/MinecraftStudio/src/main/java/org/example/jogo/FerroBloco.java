package org.example.jogo;

public class FerroBloco extends Bloco {
    String ItemNome = "";
    public FerroBloco(String ItemNome){
        this.ItemNome = ItemNome;
    }

    @Override
    public Item destruir() {
        Item item = new Item();
        item.setNome(ItemNome);
        return new Item();
    }
}
