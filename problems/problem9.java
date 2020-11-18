// 예상 공격 ["입력 변수: 값"] 
// ID: admin 
// PWD: ' OR '1' = '1 

// A의 코드 
Connection conn = null; 
Statement stm = null; 

conn = DBConnection.getConnection(); 
stm = conn.createStatement(); 

String query = "SELECT * FROM user WHERE ID=" + ID + " AND PWD=" + PWD; 
int success = stm.executeUpdate(query);
