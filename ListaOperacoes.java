public interface ListaOperacoes {
    int removerTodas(String elemento);
    int contar();
    int adicionarVarios(String[] elementos);

    String obter(int indice);

    boolean inserir(int indice, String elemento);

    String removerPorIndice(int indice);

    void limpar();
    int ultimoIndiceDe(String elemento);
    int contarOcorrencias(String elemento);
    int substituir(String antigo, String novo);
}
