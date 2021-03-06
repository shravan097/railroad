import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationQuery {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/F17336Gteam3";
    private  static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private PreparedStatement selectAllStation;
    private PreparedStatement getStationSymbol;



    public StationQuery()
    {
        try
        {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            selectAllStation =  connection.prepareStatement("SELECT * FROM stations");
            getStationSymbol = connection.prepareStatement("Select station_symbol FROM stations WHERE station_name = ?");
        }
        catch (SQLException sqlException)
        {
            System.out.println("Error! Connection cannot be established");
            sqlException.printStackTrace();;
            System.exit(1);
        }
    }

    public String get_station_symbol(String station_name)
    {
        String result = null;
        try
        {
            ResultSet resultSet = null;

            getStationSymbol.setString(1,station_name);
            resultSet= getStationSymbol.executeQuery();
            while(resultSet.next())
                result = resultSet.getString("station_symbol");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }

    public List<Station> getAllStation()
    {
        List<Station> results = null;
        ResultSet resultSet = null;

        try
        {
            resultSet = selectAllStation.executeQuery();
            results = new ArrayList<Station>();

            while(resultSet.next())
            {
                results.add(
                        new Station(
                                resultSet.getInt("station_id"),
                                resultSet.getString("station_name"),
                                resultSet.getString("station_symbol")
                        )
                );
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
                close_connection();
            }
        }

        return results;
    }

    public void close_connection()
    {
        try{ connection.close();}
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }


}

