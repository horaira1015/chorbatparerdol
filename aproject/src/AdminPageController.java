import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
	@FXML
	public TableView tableAlltr;
	public TableView tableallcust;
	@FXML
	TableView depoTable;

	public void refreshedAllTr(ActionEvent actionEvent) {
		try {
			String selectQuery = "SELECT CustomerName, AccountNumber,Transactiontype,Amount FROM transactions";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			tableAlltr.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(tableAlltr.widthProperty().divide(4));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				tableAlltr.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			tableAlltr.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void refreshallcust(ActionEvent actionEvent) {
		try {
			String selectQuery = "SELECT  username, accountNumber,balance FROM useraccounts";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			tableallcust.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(tableallcust.widthProperty().divide(3));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				tableallcust.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			tableallcust.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public void refreshdepo(ActionEvent actionEvent) {
		try {
			String selectQuery = "SELECT  customername, accountNumber,amount FROM transactions where transactiontype = 'deposit';";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			depoTable.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(depoTable.widthProperty().divide(3));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				depoTable.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			depoTable.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@FXML
	TableView withdrawTable;

	public void refreshwithdraw(ActionEvent actionEvent) {

		try {
			String selectQuery = "SELECT  customername, accountNumber,amount FROM transactions where transactiontype = 'withdraw';";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			withdrawTable.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(withdrawTable.widthProperty().divide(3));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				withdrawTable.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			withdrawTable.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	TableView transferTable;

	public void refreshtransfer(ActionEvent actionEvent) {
		try {
			String selectQuery = "SELECT  accountNumber,toAccountNumber,amount FROM transactions where transactiontype = 'transfer';";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			transferTable.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(transferTable.widthProperty().divide(3));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				transferTable.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			transferTable.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	TextField customerName;
	@FXML
	TableView table1;
	@FXML
	TableView table2;
	public void searchCustomer(){
		try {
			String customername = customerName.getText();
			String selectQuery = "SELECT  accountNumber,balance FROM useraccounts where username  ='"+customername +"';";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			table1.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(table1.widthProperty().divide(2));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				table1.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			table1.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String customername = customerName.getText();
			String selectQuery = "SELECT  accountNumber, transactiontype,amount FROM transactions where customername  ='"+customername +"';";
			PreparedStatement pstmt = Bank.con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			table2.getColumns().clear(); // Clear existing columns

			// Create TableColumn instances for each column in the ResultSet
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1)); // Column index starts from 1
				col.prefWidthProperty().bind(table2.widthProperty().divide(3));
				col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param ->
						new SimpleStringProperty(param.getValue().get(j).toString()));

				table2.getColumns().add(col);
			}

			ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}

			table2.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}

	public void backTomainMenu(ActionEvent actionEvent) {
		new Bank().changeScene("adminLogin.fxml", "Admin - Login", 553, 457);
	}

	public void gotohome(ActionEvent actionEvent) {
		new Bank().changeScene("adminPage.fxml", "Option Menu", 682, 402);
	}
}
