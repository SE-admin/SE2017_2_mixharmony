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
    Subject_Management sList;
    String Clickdata =sList.Clickdata;
    
   

   
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
    public Todo_Dto getTodo_Dto(String itemname){
        
    	Todo_Dto dto = new Todo_Dto();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from tododb where itemname=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, itemname);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setItemname(rs.getString("itemname")); // 항목명
                dto.setDeadliney(rs.getString("deadliney")); // deadline 년
                dto.setDeadlinem(rs.getString("deadlinem")); // deadline 월
                dto.setDeadlined(rs.getString("deadlined")); // deadline 일
                dto.setDeadline_ampm(rs.getString("deadline_ampm")); //오전 오후
                dto.setDeadlinet(rs.getString("deadlinet")); // deadline 시
                dto.setRdeadliney(rs.getString("rdeadliney")); // rdeadline 년
                dto.setRdeadlinem(rs.getString("rdeadlinem")); // rdeadline 월
                dto.setRdeadlined(rs.getString("rdeadlined")); // redadline 일
                dto.setRdeadline_ampm(rs.getString("rdeadline_ampm")); //오전 오후
                dto.setRdeadlinet(rs.getString("rdeadlinet")); // deadline 시
                dto.setImportance(rs.getString("importance")); // 중요도
                dto.setComment(rs.getString("comment")); // 코멘트
                dto.setSubject(rs.getString("subject")); // sujbect저장소
                dto.setComplete(rs.getString("complete"));//완료여부
                
                //추가
                dto.setDeadline(rs.getString("deadliney"), rs.getString("deadlinem"), rs.getString("deadlined"), rs.getString("deadline_ampm"), rs.getString("deadlinet"));
                dto.setRdeadline(rs.getString("rdeadliney"), rs.getString("rdeadlinem"), rs.getString("rdeadlined"), rs.getString("rdeadline_ampm"), rs.getString("rdeadlinet"));
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
            String sql = "select * from tododb where subject=?" + "order by itemname asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            
            
           
            while(rs.next()){
                String itemname = rs.getString("itemname");
                String deadliney = rs.getString("deadliney");
                String deadlinem = rs.getString("deadlinem");
                String deadlined = rs.getString("deadlined");
                String deadline_ampm = rs.getString("deadline_ampm");
                String deadlinet = rs.getString("deadlinet");
                String rdeadliney = rs.getString("rdeadliney");
                String rdeadlinem = rs.getString("rdeadlinem");
                String rdeadlined = rs.getString("rdeadlined");
                String rdeadline_ampm = rs.getString("rdeadline_ampm");
                String rdeadlinet = rs.getString("rdeadlinet");
                String importance = rs.getString("importance");
                String comment = rs.getString("comment");
                String subject = rs.getString("subject");
                String complete = rs.getString("complete");
                
                //추가
                String deadline  = deadliney+"년 "+deadlinem+"월 "+deadlined+"일 "+deadline_ampm+" "+deadlinet + "시";
                String rdeadline  = rdeadliney+"년 "+rdeadlinem+"월 "+rdeadlined+"일 "+rdeadline_ampm+" "+rdeadlinet + "시";

                Vector row = new Vector();
                row.add(itemname);
                row.add(deadline);
                row.add(rdeadline);
                row.add(importance);
                row.add(comment);
                //row.add(subject);
                row.add(complete);
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
            
//            String sql = "insert into tododb(itemname,deadline,rdeadline,importance,comment,complete)"
//                    + "values(?,?,?,?,?,?)";
            
            String sql = "insert into tododb(" +"itemname,"
            		+ "deadliney,deadlinem,deadlined,deadline_ampm,deadlinet,"
                    + "rdeadliney,rdeadlinem,rdeadlined,rdeadline_ampm,rdeadlinet,"
                    + "importance,comment,subject,complete,deadline,rdeadline)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getItemname());
//            ps.setString(2, dto.getDeadline());
            ps.setString(2, dto.getDeadliney());
            ps.setString(3, dto.getDeadlinem());
            ps.setString(4, dto.getDeadlined());
            ps.setString(5, dto.getDeadline_ampm());
            ps.setString(6, dto.getDeadlinet());           
//            ps.setString(3, dto.getRdeadline());
            ps.setString(7, dto.getRdeadliney());
            ps.setString(8, dto.getRdeadlinem());
            ps.setString(9, dto.getRdeadlined());
            ps.setString(10, dto.getRdeadline_ampm());
            ps.setString(11, dto.getRdeadlinet());
//            ps.setString(4, dto.getImportance());
//            ps.setString(5, dto.getComment());
            //ps.setString(6, dto.getSubject());
            ps.setString(12, dto.getImportance());
            ps.setString(13, dto.getComment());
            ps.setString(14, dto.getSubject());
            ps.setString(15, dto.getComplete());
            ps.setString(16, dto.getDeadline());
            ps.setString(17, dto.getRdeadline());
            

            
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
        //where문 추가//
        String sql = "update tododb set "
        		+ "deadliney=?, deadlinem=?, deadlined=?, deadline_ampm=?, deadlinet=?, "
        		+ "rdeadliney=?, rdeadlinem=?, rdeadlined=?, rdeadline_ampm=?, rdeadlinet=?,"
        		+ "importance=?, comment=?, subject=?, complete=?, deadline=?, rdeadline=? where itemname=?";
        ps = con.prepareStatement(sql);
       
        ps.setString(17, vTo.getItemname());
        ps.setString(1, vTo.getDeadliney());
//        ps.setString(2, vTo.getDeadline());
        ps.setString(2, vTo.getDeadlinem());
        ps.setString(3, vTo.getDeadlined());
        ps.setString(4, vTo.getDeadline_ampm());
        ps.setString(5, vTo.getDeadlinet());
//        ps.setString(3, vTo.getRdeadline());
        ps.setString(6, vTo.getRdeadliney());
        ps.setString(7, vTo.getRdeadlinem());
        ps.setString(8, vTo.getRdeadlined());
        ps.setString(9, vTo.getRdeadline_ampm());
        ps.setString(10, vTo.getRdeadlinet());
        ps.setString(11, vTo.getImportance());
        ps.setString(12, vTo.getComment());
        ps.setString(13, vTo.getSubject());
        ps.setString(14, vTo.getComplete());
        ps.setString(15, vTo.getDeadline());
        ps.setString(16, vTo.getRdeadline());
      
        
       
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

///////////////삭제 추가
public boolean Delete_Todo(String itemname){
   
    boolean ok = false ;
    Connection con = null;
    PreparedStatement ps = null;
   
    try {
        con = getConn();
        String sql = "delete from tododb where itemname=?";
       
        ps = con.prepareStatement(sql);
        ps.setString(1, itemname);
        int r = ps.executeUpdate(); // 실행 -> 삭제
       
        if (r>0)
    	{
    	//수정//
    		System.out.println("삭제 성공");
    		ok=true; //삭제됨;
    	}
       
    } catch (Exception e) {
        System.out.println(e + "-> 오류발생");
    }      
    return ok;
}
////////////////

/**DB데이터 다시 불러오기*/   
public void userSelectAll(DefaultTableModel model) {
   
   
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    try {
        con = getConn();
        System.out.println(Clickdata);
        String sql = "select * from tododb where subject=? and complete not like '%O%'"+"order by itemname asc";
        ps = con.prepareStatement(sql);
        ps.setString(1, Clickdata);
        rs = ps.executeQuery();
        
       
        // DefaultTableModel에 있는 데이터 지우기
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
        }

        while (rs.next()) {
            Object data[] = { rs.getString(1), rs.getString(2), rs.getString(8), 
            		rs.getString(14), rs.getString(15), rs.getString(17), 
            		//rs.getString(7)
                    };//db위치에 맞게 수정

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
//정렬 기준? deadline, rdeadline 수정 필요
public void userSelectAll1(DefaultTableModel model,int z) {  
  
	Connection con = null;  
	PreparedStatement ps = null;  
	ResultSet rs = null;  

	try {  
		if(z == 1) //완료여부순
		{  
			con = getConn();  
			String sql = "select * from tododb where subject=? order by complete asc";  
			ps = con.prepareStatement(sql);  
			ps.setString(1, Clickdata);
			rs = ps.executeQuery();
			
		}  
		else if(z == 2) //마감기한순  
		{  
			con = getConn();  
			String sql = "select * from tododb where subject = ?order by deadline asc";  
			ps = con.prepareStatement(sql);  
			ps.setString(1, Clickdata);
			rs = ps.executeQuery();  
		}  
		else if(z == 3 ) //실제마감일순  
		{  
			con = getConn();  
			String sql = "select * from tododb where subject=? order by rdeadline asc";  
			ps = con.prepareStatement(sql);  
			ps.setString(1, Clickdata);
			rs = ps.executeQuery();  
		}
		else if(z == 4) //중요도순
		{
			con = getConn();  
			String sql = "select * from tododb where subject=?order by importance desc";  
			ps = con.prepareStatement(sql);  
			ps.setString(1, Clickdata);
			rs = ps.executeQuery();
		}
		else //전체출력
		{
			con = getConn();  
			String sql = "select * from tododb where subject =?";  
			ps = con.prepareStatement(sql);  
			ps.setString(1, Clickdata);
			rs = ps.executeQuery();
		}

		// DefaultTableModel에 있는 데이터 지우기  
		for (int i = 0; i < model.getRowCount();) {  
			model.removeRow(0);  
		}  
		while (rs.next()) {  
            Object data[] = { rs.getString(1), rs.getString(2), rs.getString(8), 
            		rs.getString(14), rs.getString(15), rs.getString(17), 
            		//rs.getString(7)
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
