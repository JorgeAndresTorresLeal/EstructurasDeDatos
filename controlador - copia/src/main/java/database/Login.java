package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    public Connection connectionDb;
    public Login(Connection connectionDb) {
        this.connectionDb = connectionDb;
    }

    public boolean[] loguear(String user, String password){
        boolean[] booleans = new boolean[2];
        String sql = "select password from usuarios where usuario=?";
        try{
            PreparedStatement statement = this.connectionDb.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                booleans[1] = (resultSet.getString(1).equals(password))?true:false;
            }
            sql = "select jefe from usuarios where usuario=?";
            statement = this.connectionDb.prepareStatement(sql);
            statement.setString(1,user);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                booleans[0]=resultSet.getBoolean(1);
            }



        }catch (Exception e){
            System.out.println(e);
        }
        return booleans;
    }


    public boolean existeUser(){
        String sql = "select count(*) from usuarios;";
        boolean bool = false;
        try {
            Statement statement = connectionDb.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            bool = (resultSet.getInt(1)>=1)?true:false;
        }catch (Exception e){
            System.out.println(e);
        }
       return bool;
    }
}
