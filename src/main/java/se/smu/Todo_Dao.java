package se.smu;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Todo_Dao {
	 
    private static final String DRIVER
        = "org.mariadb.jdbc.Driver";
    private static final String URL
        = "jdbc:mariadb://211.253.25.2:3306/Mixharmony";
   
    private static final String USER = "user"; //DB ID
    private static final String PASS = "1234"; //DB 패스워드
    Todo_List TList;
   
    public Todo_Dao() {
   
    }
   
    public Todo_Dao(Todo_List TList){
        this.TList = TList;
        System.out.println("DAO=>"+TList);
    }
   
    /**DB연결 메소드*/
    public Connection getConn(){
        Connection con = null;
       
        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL,USER,PASS); //2. 드라이버 연결
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return con;
    }

    /**한사람의 회원 정보를 얻는 메소드*/
    public Todo_Dto getTodo_DtO(String itemname){
        
    	Todo_Dto dto = new Todo_Dto();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from tododb where itemname";
            ps = con.prepareStatement(sql);
            ps.setString(1, itemname);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setItemname(rs.getString("itemname"));
                dto.setDeadline(rs.getString("deadline"));
                dto.setRdeadline(rs.getString("rdeadline"));
                dto.setImportance(rs.getString("importance"));
                dto.setSubject(rs.getString("subject"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
   
    /**멤버리스트 출력*/
    public Vector getTodo_List(){
       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
           
            con = getConn();
            String sql = "select * from tododb order by itemname asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String itemname = rs.getString("itemname");
                String deadline = rs.getString("deadline");
                String rdeadline = rs.getString("rdeadline");
                String importance = rs.getString("importance");
                String subject = rs.getString("subject");

                Vector row = new Vector();
                row.add(itemname);
                row.add(deadline);
                row.add(rdeadline);
                row.add(importance);
                row.add(subject);
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getTodo_List()
   
 
 
    /**회원 등록*/
    public boolean Insert_Todo(Todo_Dto dto){
       
        boolean ok = false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "insert into tododb(" +
                        "itemname,deadline,rdeadline,importance,subject)" +
                        "values(?,?,?,?,?)";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getItemname());
            ps.setString(2, dto.getDeadline());
            ps.setString(3, dto.getRdeadline());
            ps.setString(4, dto.getImportance());
            ps.setString(5, dto.getSubject());  
            int r = ps.executeUpdate(); //실행 -> 저장
           
           
            if(r>0){
                System.out.println("등록 성공");   
                ok=true;
            }else{
                System.out.println("등록 실패");
            }
           
               
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return ok;
    }//insertMmeber
   
      /**회원정보 수정*/
public boolean Change_Todo(Todo_Dto vTo){
    System.out.println("dto="+vTo.toString());
    boolean ok = false;
    Connection con = null;
    PreparedStatement ps = null;
    try{
       
        con = getConn();           
        String sql = "update tododb set itemname=?, deadline=?, rdeadline=?, importance=?, subject=?";
        ps = con.prepareStatement(sql);
       
        ps.setString(1, vTo.getItemname());
        ps.setString(2, vTo.getDeadline());
        ps.setString(3, vTo.getRdeadline());
        ps.setString(4, vTo.getImportance());
        ps.setString(5, vTo.getSubject());
       
        int r = ps.executeUpdate(); //실행 -> 수정
        if(r>0){
            System.out.println("등록 성공");   
            ok=true;
        }else{
            System.out.println("등록 실패");
        // 1~n: 성공 , 0 : 실패
        }

       
    }catch(Exception e){
        e.printStackTrace();
    }
   
    return ok;
}

/////////////////삭제 :
//public boolean Delete_Todo(String itemname, String deadline, String rdeadline, String importance){
//   
//    boolean ok = false ;
//    Connection con = null;
//    PreparedStatement ps = null;
//   
//    try {
//        con = getConn();
//        String sql = "delete from tododb where itemname=? and deadline=? and rdeadline=? and importance=?";
//       
//        ps = con.prepareStatement(sql);
//        ps.setString(1, itemname);
//        ps.setString(2, deadline);
//        ps.setString(3, rdeadline);
//        ps.setString(4, importance);
//        int r = ps.executeUpdate(); // 실행 -> 삭제
//       
//        if (r>0) ok=true; //삭제됨;
//       
//    } catch (Exception e) {
//        System.out.println(e + "-> 오류발생");
//    }      
//    return ok;
//}
//////////////////

/**DB데이터 다시 불러오기*/   
public void userSelectAll(DefaultTableModel model) {
   
   
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    try {
        con = getConn();
        String sql = "select * from tododb order by itemname asc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
       
        // DefaultTableModel에 있는 데이터 지우기
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
        }

        while (rs.next()) {
            Object data[] = { rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                   rs.getString(5)
                    };

            model.addRow(data);                
        }

    } catch (SQLException e) {
        System.out.println(e + "=> userSelectAll fail");
    } finally{
       
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        if(ps!=null)
            try {
                ps.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        if(con!=null)
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}

//sort 메소드
public void userSelectAll1(DefaultTableModel model,int z) {
	   
	   
  Connection con = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
 
  try {
  	if(z == 1) //중요도순
  	{
          con = getConn();
          String sql = "select * from tododb order by importance desc";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
  		
  	}
  	else if(z == 2) //마감기한순
  	{
  		con = getConn();
  		String sql = "select * from tododb order by deadline asc";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
  	}
  	else //실제마감일순
  	{
  		con = getConn();
  		String sql = "select * from tododb order by rdeadline asc";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
  	}

     
      // DefaultTableModel에 있는 데이터 지우기
      for (int i = 0; i < model.getRowCount();) {
          model.removeRow(0);
      }

      while (rs.next()) {
          Object data[] = { rs.getString(1), rs.getString(2),
                  rs.getString(3), rs.getString(4),
                 rs.getString(5)
                  };

          model.addRow(data);                
      }

  } catch (SQLException e) {
      System.out.println(e + "=> userSelectAll fail");
  } finally{
     
      if(rs!=null)
          try {
              rs.close();
          } catch (SQLException e2) {
              // TODO Auto-generated catch block
              e2.printStackTrace();
          }
      if(ps!=null)
          try {
              ps.close();
          } catch (SQLException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
          }
      if(con!=null)
          try {
              con.close();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
  }
}

}
