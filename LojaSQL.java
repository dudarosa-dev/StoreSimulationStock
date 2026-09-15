/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lojasql;

/**
 *
 * @author eduar
 */
public class LojaSQL {


    public static void main(String[] args) {

        // =========================
        // CRIAR PRODUTOS NOVOS
        // =========================

        Produtos p1 = new Produtos("Teclado", 25.50, 10);
        Produtos p2 = new Produtos("Rato", 15.00, 20);

        // Adicionar os produtos à base de dados
        p1.adicionarProduto();
        p2.adicionarProduto();

        // Mostrar os produtos
        System.out.println("\n--- PRODUTOS INICIAIS ---");
        p1.listarProdutos();


        // =========================
        // NOVA COMPRA / REPOSIÇÃO
        // =========================

        System.out.println("\n--- NOVA COMPRA ---");

        // Adicionar 5 teclados ao produto com ID 1
        p1.adicionarStock(1, 5);

        // Adicionar 10 ratos ao produto com ID 2
        p2.adicionarStock(2, 10);


        // Mostrar o stock depois da compra
        System.out.println("\n--- STOCK APÓS NOVA COMPRA ---");
        p1.listarProdutos();


        // =========================
        // FAZER UMA VENDA
        // =========================

        System.out.println("\n--- VENDA ---");

        // Vender 3 teclados do produto com ID 1
        p1.venderProduto(1, 3);


        // Mostrar o stock depois da venda
        System.out.println("\n--- STOCK APÓS VENDA ---");
        p1.listarProdutos();
    }
}



