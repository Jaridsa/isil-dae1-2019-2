package pe.isil.dao;

import pe.isil.util.DatabaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class AccountDao {

    public static boolean transfer( Integer id1, Integer id2, Double amount ){

        try(Connection connection = DatabaseUtil.getConnection()) {

            String sql = "{ ? = call transfer(?,?,?)}";

            try(CallableStatement cs = connection.prepareCall(sql)) {

                cs.registerOutParameter(1, Types.BOOLEAN);
                cs.setInt(2, id1);
                cs.setInt(3, id2);
                cs.setDouble(4, amount);

                cs.execute();

                return cs.getBoolean(1);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
