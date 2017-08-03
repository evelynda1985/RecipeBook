package recipe.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import recipe.logic.Ingredient;
import recipe.logic.Recipe;

public class DBFacade {

	private DBConnection dbConnection;

	public DBFacade() {
		this.dbConnection = DBConnection.getInstance();
	}

	// Query to insert ingredients to the Database
	public void registerNewIngredient(Ingredient ingredient, long recipeId, Connection conn) {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(
					"insert into APP.TBL_INGREDIENTS (NAME, AMOUNT, MEASURE,TBL_RECIPES_ID) values (?, ?, ?,?)");
			pstmt.setString(1, ingredient.getName());
			pstmt.setString(2, ingredient.getAmount());
			pstmt.setString(3, ingredient.getMeasure());
			pstmt.setLong(4, recipeId);

			pstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (SQLException sqle) {
				printSQLException(sqle);
			}
		}
	}

	public static void printSQLException(SQLException e) {
		while (e != null) {
			System.err.println("\n----- SQLException -----");
			System.err.println("  SQL State:  " + e.getSQLState());
			System.err.println("  Error Code: " + e.getErrorCode());
			System.err.println("  Message:    " + e.getMessage());
			e = e.getNextException();
		}
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException sqle) {
			printSQLException(sqle);
		}
	}

	// Query to insert recipes to the Database
	public long registerNewRecipe(Recipe recipe, long id) {
		Connection conn = this.dbConnection.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into APP.TBL_RECIPES (NAME,  INSTRUCTIONS) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, recipe.getName());
			pstmt.setString(2, recipe.getDescription());

			int affectedRows = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				long recipeId = rs.getLong(1);
				List<Ingredient> ingredientList = recipe.getIngredientList();
				for (Ingredient ingredient : ingredientList) {
					this.registerNewIngredient(ingredient, recipeId, conn);
				}
			}

		} catch (SQLException sqlEx) {
			printSQLException(sqlEx);
			return id;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (SQLException sqle) {
				printSQLException(sqle);
			}
		}
		return id;
	}

	// Query to display my recipes
	public List<Recipe> getRecepies() {
		Connection conn = this.dbConnection.getConnection();
		PreparedStatement pstmt = null;
		List<Recipe> recipeList = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement("SELECT REC_ID, NAME, INSTRUCTIONS FROM APP.TBL_RECIPES");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Recipe re = new Recipe(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3));

				recipeList.add(re);
			}

		} catch (SQLException sqlEx) {
			printSQLException(sqlEx);

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (SQLException sqle) {
				printSQLException(sqle);
			}
		}
		return recipeList;
	}

}
