package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


    @Component
    public class MySQLShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao
    {
        public MySQLShoppingCartDao(DataSource dataSource)
        {
            super(dataSource);
        }

        @Override
        public ShoppingCart getByUserId(int userId)
        {
            ShoppingCart cart = new ShoppingCart();
            Map<Integer, ShoppingCartItem> items = new HashMap<>();

            String sql = """
                SELECT sc.product_id, sc.quantity, p.name, p.price, p.category_id, p.description, p.color, p.stock, p.image_url, p.featured
                FROM shopping_cart sc
                JOIN products p ON sc.product_id = p.product_id
                WHERE sc.user_id = ?
                """;

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();

                while (rs.next())
                {
                    Product product = new Product(
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getBigDecimal("price"),
                            rs.getInt("category_id"),
                            rs.getString("description"),
                            rs.getString("color"),
                            rs.getInt("stock"),
                            rs.getBoolean("featured"),
                            rs.getString("image_url")
                    );

                    int quantity = rs.getInt("quantity");

                    ShoppingCartItem item = new ShoppingCartItem(product, quantity);
                    items.put(product.getProductId(), item);
                }
            }
            catch (SQLException e)
            {
                System.out.println("Could not get product by userid");
                throw new RuntimeException(e);
            }

            cart.setItems(items);
            return cart;
        }

        @Override
        public void addProductToCart(int userId, int productId)
        {
            String checkSql = "SELECT quantity FROM shopping_cart WHERE user_id = ? AND product_id = ?";
            String insertSql = "INSERT INTO shopping_cart(user_id, product_id, quantity) VALUES (?, ?, 1)";
            String updateSql = "UPDATE shopping_cart SET quantity = quantity + 1 WHERE user_id = ? AND product_id = ?";

            try (Connection conn = getConnection())
            {
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, userId);
                checkStmt.setInt(2, productId);

                ResultSet rs = checkStmt.executeQuery();

                if (rs.next())
                {
                    // already exists, update quantity
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setInt(1, userId);
                    updateStmt.setInt(2, productId);
                    updateStmt.executeUpdate();
                }
                else
                {
                    // does not exist, insert
                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                    insertStmt.setInt(1, userId);
                    insertStmt.setInt(2, productId);
                    insertStmt.executeUpdate();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Could not add product to cart");
                throw new RuntimeException(e);
            }
        }

        @Override
        public void updateProductQuantity(int userId, int productId, int quantity)
        {
            String sql = "UPDATE shopping_cart SET quantity = ? WHERE user_id = ? AND product_id = ?";

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, quantity);
                stmt.setInt(2, userId);
                stmt.setInt(3, productId);

                stmt.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Could not update product based on quantity");
                throw new RuntimeException(e);
            }
        }

        @Override
        public void removeAllCartItems(int userId)
        {
            String sql = "DELETE FROM shopping_cart WHERE user_id = ?";

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, userId);
                stmt.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Could not clear/remove all items from shopping cart");
                throw new RuntimeException(e);
            }
        }
    }


