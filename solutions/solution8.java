public class Test 
{
    public static void main(String args[])
    {
        try {
		Connection conn = null;
        conn = DBConnection.getConnection();
						
		PreparedStatement pstm = null; 

        String sql = "SELECT firstname FROM user WHERE firstname = ?"; 
        pstm = conn.prepareStatement(sql); 
        pstm.setString(1, "Manager"); 

        pstm.executeQuery();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}


