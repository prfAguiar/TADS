public class Main {
    public static void main(String[] args){
        System.out.println("TESTANDO ELEMENTOS E FUNCOES COM LISTA");
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.inserirNoFinal(1);
        
        System.out.println("Depois da inserção do primeiro valor: " + lista);
        System.out.println("Tamanho da lista: " + lista.retornaTamanho());
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(3);
        lista.inserirNoFinal(4);
        lista.inserirNoFinal(5);
        lista.inserirNoFinal(6);
        lista.inserirNoFinal(7);
        lista.inserirNoFinal(8);
        lista.inserirNoFinal(9);
        lista.inserirNoFinal(10);
        System.out.println("Lista depois das inserções: " + lista);

        lista.removerItemEspecifico(5);
        lista.removerItemInicio();
        System.out.println("Remoção da posição 5 e do início da lista: " + lista);
        lista.removerItemFinal();
        System.out.println("Remoção do final da lista: " + lista);
        System.out.println("Tamanho da lista: " + lista.retornaTamanho());

        lista.inserirEmPosicaoEspecifica(24, 6);
        System.out.println("Depois da inserção em uma posição específica: " + lista);
        System.out.println("Tamanho da lista: " + lista.retornaTamanho());

        lista.inserirNoInicio(0);
        System.out.println("Inserção no início: " + lista);
        System.out.println("Tamanho da lista: " + lista.retornaTamanho() + "\n"); 

        System.out.println("Clonando lista");
        ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
        lista2 = lista.clone();
        System.out.println("Lista clonada:" + lista2);

        Integer array [] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        lista.inserirDoArray(array);
        System.out.println("Depois da inserção do array para lista: " + lista);
        
        lista2.inserirNoInicio(3);
        lista2.inserirNoFinal(7);
        lista2.inserirNoFinal(21);
        lista2.inserirNoFinal(22);
        lista2.inserirNoFinal(23);
        lista2.inserirNoFinal(24);
        lista2.inserirNoFinal(10);
        System.out.println("Depois da inserção de valores para lista 2: " + lista2);

        System.out.print("Array que recebeu valores da lista: ");
        Object[] array2 = lista.inserirNoArray(lista2);
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }

        System.out.println("\nLista 1: " + lista);
        System.out.println("Lista 2: " + lista2);
        System.out.print("\nIntersecao: ");
        System.out.println(lista.intercecao(lista2));

        System.out.print("Pertencimento: ");
        System.out.println(lista.pertencimento(7));
        
        ListaEncadeada<Integer> lista3;
        lista3 = lista.diferenca(lista2);
        System.out.print("Diferenca: ");
        System.out.println(lista3);

        System.out.println("======================================");
        System.out.println("\nTESTANDO ELEMENTOS E FUNCOES COM A FILA");

        Fila<String> fila = new Fila<>();
        fila.inserir("Iago");
        fila.inserir("Samuel");
        fila.inserir("Pedro Rangel");
        System.out.println("Depois da inserção dos nomes: " + fila);
        fila.remover();
        System.out.println("Depois da Remoção: " + fila);

        System.out.println("Pertencimento: " + fila.pertencimento("Pedro Rangel"));
        Fila<String> fila2 = new Fila<>();
        fila2.inserir("Alisson");
        fila2.inserir("Pedro Rangel");
        fila2.inserir("Igor");
        System.out.println("Depois da inserção dos nomes na fila2: " + fila2);
        Fila<String> fila3 = new Fila<>();
        fila3 = fila.diferenca(fila2);
        System.out.print("Diferenca: " + fila3);
        Fila<String> fila5 = new Fila<>();
        fila5 = fila.intersecao(fila2);
        System.out.println("\nInterseção: " + fila5);
    }
}
