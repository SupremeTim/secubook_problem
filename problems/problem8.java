public class Test 
{
    public static void main(String args[])
    {
        try {
		Connection conn = null;
        conn = DBConnection.getConnection();
						
		// 코딩할 부분

	    // --------

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
