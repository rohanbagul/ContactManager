package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Contacts;
import utils.JDBCutils;


public class ContactDaoImpl implements ContactsDao {

    private static final String INSERT_TODOS_SQL = "INSERT INTO todos" +
        "  (title, username, description, target_date,  is_done) VALUES " + " (?, ?, ?, ?, ?);";

    private static final String SELECT_TODO_BY_ID = "select id,title,username,description,target_date,is_done from todos where id =?";
    private static final String SELECT_ALL_TODOS = "select * from todos";
    private static final String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
    private static final String UPDATE_TODO = "update todos set title = ?, username= ?, description =?, target_date =?, is_done = ? where id = ?;";

    public void ContactDaoImpl() {}

    @Override
    public void insertContacts(Contacts contacts) throws SQLException {
        System.out.println(INSERT_TODOS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBCutils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
            preparedStatement.setString(1, contacts.getFirstName());
            preparedStatement.setString(2, contacts.getLastName());
            preparedStatement.setDate(4, JDBCutils.getSQLDate(contacts.getTargetDate()));
            preparedStatement.setInt(5, contacts.getMobileNo());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCutils.printSQLException(exception);
        }
    }

    @Override
    public Contacts selectContact(long todoId) {
        Contacts contact = null;
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCutils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);) {
            preparedStatement.setLong(1, todoId);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                int mobileNo = rs.getInt("mobile no.");
                contact = new Contacts(id, firstName, lastName,targetDate, mobileNo);
            }
        } catch (SQLException exception) {
            JDBCutils.printSQLException(exception);
        }
        return contact;
    }

    @Override
    public List < Contacts > selectAllContacts() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Contacts > contacts = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCutils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                int mobileNo = rs.getInt("mobile no.");
                contacts.add(new Contacts(id, firstName, lastName, targetDate, mobileNo));
            }
        } catch (SQLException exception) {
            JDBCutils.printSQLException(exception);
        }
        return contacts;
    }

    @Override
    public boolean deleteContact(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCutils.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateTodo(Contacts contacts) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCutils.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
            statement.setString(1, contacts.getFirstName());
            statement.setString(2, contacts.getLastName());
            statement.setDate(4, JDBCutils.getSQLDate(contacts.getTargetDate()));
            statement.setInt(5, contacts.getMobileNo());
            statement.setLong(6, contacts.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
