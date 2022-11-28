package database;

import java.sql.*;
import java.time.LocalDate;

public class CrudInsert {


    private Connection conexionDb ;

    public CrudInsert(Connection conexionDb) {
        this.conexionDb = conexionDb;
    }

    public void insertarPr(String name,String codigo, float preciodecompra,float cantidad, LocalDate fechaVencimiento,float preciodeventa,int lote){
        String sql = "INSERT INTO productos(\n" +
                "\t name, codigo, precioc, cantidad, vencimiento, precio,lote)\n" +
                "\tVALUES ( ?, ?, ?, ?, ?, ?, ?);";

        try{
            PreparedStatement statement = this.conexionDb.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,codigo);
            statement.setFloat(3,preciodecompra);
            statement.setFloat(4, cantidad);
            statement.setDate(5,Date.valueOf(fechaVencimiento));
            statement.setFloat(6,preciodeventa);
            statement.setFloat(7, lote);
            int rowInsertd = statement.executeUpdate();
            System.out.println((rowInsertd>0)?"inserccion exitosa!":"inserccion fallida!");
        }catch (SQLException e){
            System.out.println("error al conectarse: "+e);
        }
    }

    public void insertarUs(String user, String pass,boolean cargo){
        try {
            String sql ="INSERT INTO usuarios(\n" +
                    "\tusuario, password, jefe)\n" +
                    "\tVALUES (?, ?, ?);";
            PreparedStatement statement = conexionDb.prepareStatement(sql);
            statement.setString(1,user);
            statement.setString(2,pass);
            statement.setBoolean(3,cargo);
            int rowInserted=statement.executeUpdate();
            System.out.println((rowInserted>0)?"inserccion exitosa!":"inserccion fallida!");
        }catch (SQLException e){
            System.out.println(e);
        }

    }


}
