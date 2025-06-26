package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Profile;
import org.yearup.data.ProfileDao;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao
{
    public MySqlProfileDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public Profile create(Profile profile)
    {
        String sql = "INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, profile.getUserId());
            ps.setString(2, profile.getFirstName());
            ps.setString(3, profile.getLastName());
            ps.setString(4, profile.getPhone());
            ps.setString(5, profile.getEmail());
            ps.setString(6, profile.getAddress());
            ps.setString(7, profile.getCity());
            ps.setString(8, profile.getState());
            ps.setString(9, profile.getZip());

            ps.executeUpdate();

            return profile;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Error fetching profile by user ID",e);
        }
    }

    @Override
    public Profile getByUserId(int userId)
    {
        String sql = "SELECT * FROM profiles WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    return mapRow(rs);
                }
                return null;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Error fetching profile by user ID", e);
        }
    }

    @Override
    public void update(int userId, Profile profile)
    {
        String sql = "UPDATE profiles SET first_name = ?, last_name = ?, phone = ?, email = ?, address = ?, city = ?, state = ?, zip = ? " +
                "WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, profile.getFirstName());
            ps.setString(2, profile.getLastName());
            ps.setString(3, profile.getPhone());
            ps.setString(4, profile.getEmail());
            ps.setString(5, profile.getAddress());
            ps.setString(6, profile.getCity());
            ps.setString(7, profile.getState());
            ps.setString(8, profile.getZip());
            ps.setInt(9, userId);

            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Error updating profile", e);
        }
    }

    private Profile mapRow(ResultSet row) throws SQLException
    {
        Profile profile = new Profile();
        profile.setUserId(row.getInt("user_id"));
        profile.setFirstName(row.getString("first_name"));
        profile.setLastName(row.getString("last_name"));
        profile.setPhone(row.getString("phone"));
        profile.setEmail(row.getString("email"));
        profile.setAddress(row.getString("address"));
        profile.setCity(row.getString("city"));
        profile.setState(row.getString("state"));
        profile.setZip(row.getString("zip"));
        return profile;
    }
}



