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
public class LigacaoBD {
    public Connection obterLigacao() {

        System.out.println("Teste de Acesso a Base de Dados.");

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/loja",
                    "root",
                    ""
            );

            System.out.println("Ligacao efetuada.");

        } catch (ClassNotFoundException cnfe) {

            System.out.println(
                    "Erro: Driver do MySQL nao encontrado.");
            System.out.println(cnfe.getMessage());

        } catch (SQLException sqle) {

            System.out.println(
                    "Erro na ligacao a base de dados.");
            System.out.println(sqle.getMessage());
        }

        return conn;
    }
}

