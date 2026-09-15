/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojasql;
import java.sql.*;
/**
 *
 * @author eduar
 */
public class Produtos {
     
    private int id;
    private String nome;
    private double preco;
    private int stock;

    private Connection conn;

    // Construtor
    public Produtos(String nome, double preco, int stock) {

        this.nome = nome;
        this.preco = preco;
        this.stock = stock;

        // Utiliza a classe LigacaoBD para obter a ligação
        LigacaoBD bd = new LigacaoBD();
        conn = bd.obterLigacao();
    }

    // Adicionar produto
    public void adicionarProduto() {

        try {

            String sql = "INSERT INTO produtos (nome, preco, stock) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, stock);

            stmt.executeUpdate();

            System.out.println("Produto adicionado!");

        } catch (SQLException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
    public void adicionarStock(int id, int quantidade) {

    try {

        String sql = "UPDATE produtos "
                + "SET stock = stock + ? "
                + "WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, quantidade);
        stmt.setInt(2, id);

        int resultado = stmt.executeUpdate();

        if (resultado > 0) {

            System.out.println("Stock atualizado!");

        } else {

            System.out.println("Produto não encontrado.");
        }

    } catch (SQLException e) {

        System.out.println("Erro: " + e.getMessage());
    }
}
    // Realizar venda
    public void venderProduto(int id, int quantidade) {

        try {

            String sql = "UPDATE produtos "
                    + "SET stock = stock - ? "
                    + "WHERE id = ? AND stock >= ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, quantidade);
            stmt.setInt(2, id);
            stmt.setInt(3, quantidade);

            int resultado = stmt.executeUpdate();

            if (resultado > 0) {

                System.out.println("Venda efetuada!");

            } else {

                System.out.println(
                        "Produto não encontrado ou stock insuficiente.");
            }

        } catch (SQLException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Listar produtos
    public void listarProdutos() {

        try {

            String sql = "SELECT * FROM produtos";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                System.out.println(
                        "ID: " + resultado.getInt("id")
                        + " | Nome: " + resultado.getString("nome")
                        + " | Preço: " + resultado.getDouble("preco")
                        + " | Stock: " + resultado.getInt("stock")
                );
            }

        } catch (SQLException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }

}