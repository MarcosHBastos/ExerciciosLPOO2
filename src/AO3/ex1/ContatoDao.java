/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AO3.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ContatoDao {

    private Calendar toCalendar(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar;
    }

    public void insere(Contato contato) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = "insert into contatos(nome, email, endereco, dataNascimento) values (?,?,?,?)";
        try {
            connection = new ConnectionFactoryComProperties().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public void remove(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = "DELETE * FROM contatos WHERE id = ?";
        try {
            connection = new ConnectionFactoryComProperties().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public void altera(String atributo, String newValue, int id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE contatos SET ? = ? WHERE id = ?";
        try {
            connection = new ConnectionFactoryComProperties().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, atributo);
            stmt.setString(2, newValue);
            stmt.setInt(3, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public List<Contato> lista() throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM contatos";
        try {
            connection = new ConnectionFactoryComProperties().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet stmtResult = stmt.executeQuery();
            List<Contato> lista = new ArrayList();
            while (stmtResult.next()) {
                Contato c = new Contato();
                c.setId(stmtResult.getLong("id"));
                c.setNome(stmtResult.getString("nome"));
                c.setEmail(stmtResult.getString("email"));
                c.setEndereco(stmtResult.getString("endereco"));
                c.setDataNascimento(toCalendar(stmtResult.getDate("dataNascimento")));
                lista.add(c);

            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            connection.close();
        }
    }
}