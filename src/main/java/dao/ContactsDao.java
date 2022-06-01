package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contacts;

public interface ContactsDao {

 void insertContacts(Contacts contacts) throws SQLException;

 Contacts selectContact(long todoId);

 List<Contacts> selectAllContacts();

 boolean deleteContact(int id) throws SQLException;

 boolean updateTodo(Contacts Contacts) throws SQLException;

}