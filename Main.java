public class Main {
    public static void main(String[] args) {
        String[] compras = {"Maçã", "Banana", "Maçã", "Laranja", "Uva"};

        System.out.println("=========================================");
        System.out.println("      TESTANDO A LISTA SIMPLES (VETOR)   ");
        System.out.println("=========================================");

        ListaSimples listaSimples = new ListaSimples(10);

        System.out.println("\n--- Testando adicionarVarios e contar ---");
        listaSimples.adicionarVarios(compras);
        listaSimples.exibirElementos();
        System.out.println("Total de elementos válidos: " + listaSimples.contar());

        System.out.println("\n--- Testando inserir por índice ---");
        System.out.println("Inserindo 'Morango' no índice 2...");
        listaSimples.inserir(2, "Morango");
        listaSimples.exibirElementos();

        System.out.println("\n--- Testando removerTodas ---");
        System.out.println("Removendo todas as ocorrências de 'Maçã'...");
        int removidosSimples = listaSimples.removerTodas("Maçã");
        System.out.println("Quantidade removida: " + removidosSimples);
        listaSimples.exibirElementos();


        System.out.println("\n\n=========================================");
        System.out.println("      TESTANDO A LISTA DINÂMICA (NÓS)    ");
        System.out.println("=========================================");

        ListaDinamica listaDinamica = new ListaDinamica();

        System.out.println("\n--- Testando adicionarVarios e contar ---");
        listaDinamica.adicionarVarios(compras);
        listaDinamica.exibir();
        System.out.println("Total de elementos válidos: " + listaDinamica.contar());

        System.out.println("\n--- Testando substituir ---");
        System.out.println("Substituindo 'Maçã' por 'Abacaxi'...");
        int substituidos = listaDinamica.substituir("Maçã", "Abacaxi");
        System.out.println("Quantidade de substituições: " + substituidos);
        listaDinamica.exibir();

        System.out.println("\n--- Testando remover por índice ---");
        System.out.println("Removendo o elemento do índice 1...");
        String itemRemovido = listaDinamica.removerPorIndice(1);
        System.out.println("Elemento removido: " + itemRemovido);
        listaDinamica.exibir();
    }
}