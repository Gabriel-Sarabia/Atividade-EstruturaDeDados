public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }


    public void adicionarElemento(String elemento) {
        if(inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    public void exibir() {
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    private boolean inicioEstaVazio() {
        if(this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removerElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if(procurarElemento(elemento)) {
                if(this.inicio.getProx() == null) {
                    System.out.println("Elemento " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while(aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return;
                        } else if(aux.getProx() != null && aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean procurarElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                if(aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
    }


    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        while (procurarElemento(elemento)) {
            removerElemento(elemento);
            removidos++;
        }
        return removidos;
    }

    @Override
    public int contar() {
        if (inicioEstaVazio()) return 0;

        int contagem = 0;
        No aux = this.inicio;
        while (aux != null && aux.getConteudo() != null) {
            contagem++;
            aux = aux.getProx();
        }
        return contagem;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            adicionarElemento(elementos[i]);
        }
        return elementos.length;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || inicioEstaVazio()) return null;

        No aux = this.inicio;
        for (int i = 0; i < indice; i++) {
            if (aux.getProx() == null) return null;
            aux = aux.getProx();
        }
        return aux.getConteudo();
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) return false;

        if (inicioEstaVazio() && indice == 0) {
            this.inicio.setConteudo(elemento);
            return true;
        }

        No novoNo = new No(elemento);

        if (indice == 0) {
            novoNo.setProx(this.inicio);
            this.inicio = novoNo;
            return true;
        }

        No aux = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            if (aux.getProx() == null) return false;
            aux = aux.getProx();
        }

        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || inicioEstaVazio()) return null;

        String removido;

        if (indice == 0) {
            removido = this.inicio.getConteudo();
            if (this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
            } else {
                this.inicio = this.inicio.getProx();
            }
            return removido;
        }

        No aux = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            if (aux.getProx() == null) return null;
            aux = aux.getProx();
        }

        if (aux.getProx() == null) return null;

        removido = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());
        return removido;
    }

    @Override
    public void limpar() {
        this.inicio = new No(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (inicioEstaVazio()) return -1;

        int ultimoIndice = -1;
        int indiceAtual = 0;
        No aux = this.inicio;

        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                ultimoIndice = indiceAtual;
            }
            aux = aux.getProx();
            indiceAtual++;
        }
        return ultimoIndice;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        if (inicioEstaVazio()) return 0;

        int contagem = 0;
        No aux = this.inicio;

        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                contagem++;
            }
            aux = aux.getProx();
        }
        return contagem;
    }

    @Override
    public int substituir(String antigo, String novo) {
        if (inicioEstaVazio()) return 0;

        int substituicoes = 0;
        No aux = this.inicio;

        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                substituicoes++;
            }
            aux = aux.getProx();
        }
        return substituicoes;
    }
}