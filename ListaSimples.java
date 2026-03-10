public class ListaSimples implements ListaOperacoes {
    String [] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }


    public void adicionarElemento(String elemento) {
        if(!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                    break;
                }
            }
        }
        if(removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if(encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }


    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                this.lista[i] = null;
                removidos++;
            }
        }
        return removidos;
    }

    @Override
    public int contar() {
        int total = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                total++;
            }
        }
        return total;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (!this.estaCheia()) {
                this.lista[encontrarPosicao()] = elementos[i];
                adicionados++;
            } else {
                break;
            }
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= this.lista.length) {
            return null;
        }
        return this.lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= this.lista.length || estaCheia()) {
            return false;
        }

        for (int i = this.lista.length - 1; i > indice; i--) {
            this.lista[i] = this.lista[i - 1];
        }
        this.lista[indice] = elemento;
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= this.lista.length || this.lista[indice] == null) {
            return null;
        }
        String removido = this.lista[indice];

        for (int i = indice; i < this.lista.length - 1; i++) {
            this.lista[i] = this.lista[i + 1];
        }
        this.lista[this.lista.length - 1] = null;

        return removido;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < this.lista.length; i++) {
            this.lista[i] = null;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        for (int i = this.lista.length - 1; i >= 0; i--) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contagem = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                contagem++;
            }
        }
        return contagem;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituicoes = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(antigo)) {
                this.lista[i] = novo;
                substituicoes++;
            }
        }
        return substituicoes;
    }
}