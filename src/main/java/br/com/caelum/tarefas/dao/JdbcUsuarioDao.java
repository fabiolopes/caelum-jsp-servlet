package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.caelum.tarefas.model.Tarefa;
import br.com.caelum.tarefas.model.Usuario;

public class JdbcUsuarioDao {
	Connection con;

	public JdbcUsuarioDao() throws SQLException {
		super();
		this.con = ConnectionFactory.getConnection();
	}

	public boolean existeUsuario(Usuario usuario) throws SQLException {
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = con
				.prepareStatement("select * from usuarios where login=? and senha=?");
		stmt.setString(1, usuario.getLogin());
		stmt.setString(2, usuario.getSenha());
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		if (rs.next()) {
			existe = true;
		}
		rs.close();
		stmt.close();
		return existe;

	}

	// public void adiciona(Tarefa tarefa) throws SQLException {
	//
	// try {
	// PreparedStatement stmt = con
	// .prepareStatement("insert into tarefas (descricao,finalizado) values (?,?)");
	// stmt.setString(1, tarefa.getDescricao());
	// stmt.setBoolean(2, false);
	// stmt.execute();
	// stmt.close();
	// System.out.println("Gravado!");
	// con.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	//
	// }
	// }
	//
	// public void altera(Tarefa tarefa) throws SQLException {
	// PreparedStatement stmt = con
	// .prepareStatement("update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?");
	// stmt.setString(1, tarefa.getDescricao());
	// stmt.setBoolean(2, tarefa.isFinalizado());
	// if (tarefa.getDataFinalizacao() != null) {
	// stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao()
	// .getTimeInMillis()));
	// } else {
	// stmt.setDate(3, null);
	// }
	// stmt.setLong(4, tarefa.getId());
	// stmt.execute();
	// stmt.close();
	// }
	//
	// public void finaliza(Long id) throws SQLException {
	// PreparedStatement stmt = con
	// .prepareStatement("update tarefas set finalizado=?, dataFinalizacao=? where id=?");
	// stmt.setBoolean(1, true);
	// stmt.setDate(2, new java.sql.Date(new Date().getTime()));
	// stmt.setLong(3, id);
	// stmt.execute();
	// stmt.close();
	// }
	//
	// public List<Tarefa> lista() throws SQLException {
	// con = ConnectionFactory.getConnection();
	// PreparedStatement stmt = con.prepareStatement("select * from tarefas");
	// ResultSet rs = stmt.executeQuery();
	// List<Tarefa> tarefas = new ArrayList<Tarefa>();
	// while (rs.next()) {
	// // criando o objeto Contato
	// Date data = null;
	// Tarefa tarefa = new Tarefa();
	// tarefa.setId(rs.getLong("id"));
	// tarefa.setDescricao(rs.getString("descricao"));
	// tarefa.setFinalizado(rs.getBoolean("finalizado"));
	// data = rs.getDate("dataFinalizacao");
	// Calendar calendar = Calendar.getInstance();
	// if (data != null) {
	// calendar.setTime(data);
	// tarefa.setDataFinalizacao(calendar);
	// }
	// // adicionando o objeto à lista
	// tarefas.add(tarefa);
	//
	// }
	// rs.close();
	// stmt.close();
	// return tarefas;
	//
	// }
	//
	// public Tarefa buscaPorId(long id) throws SQLException {
	// con = ConnectionFactory.getConnection();
	// PreparedStatement stmt = con
	// .prepareStatement("select * from tarefas where id=?");
	// stmt.setLong(1, id);
	// ResultSet rs = stmt.executeQuery();
	// List<Tarefa> tarefas = new ArrayList<Tarefa>();
	// while (rs.next()) {
	// Tarefa tarefa = new Tarefa();
	// tarefa.setId((long) rs.getInt("id"));
	// tarefa.setDescricao(rs.getString("descricao"));
	// tarefa.setFinalizado(rs.getBoolean("finalizado"));
	// Date data = null;
	// if ((data = rs.getDate("dataFinalizacao")) != null) {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(data);
	// tarefa.setDataFinalizacao(calendar);
	// }
	// tarefas.add(tarefa);
	// }
	// rs.close();
	// stmt.close();
	// return tarefas.get(0);
	//
	// }
	//
	// public void remove(Tarefa tarefa) throws SQLException {
	// PreparedStatement stmt = con
	// .prepareStatement("delete from tarefas where id=?");
	// stmt.setLong(1, tarefa.getId());
	// stmt.execute();
	// stmt.close();
	// }
}
