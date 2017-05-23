package se.smu;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Subject_Dao {
	 
    private static final String DRIVER
        = "org.mariadb.jdbc.Driver";
    private static final String URL
        = "jdbc:mariadb://211.253.25.2:3306/Mixharmony";
   
    private static final String USER = "user"; //DB ID
    private static final String PASS = "1234"; //DB 패스워드
    Subject_List SList;
   
    public Subject_Dao() {
   
    }
   
    public Subject_Dao(Subject_List SList){
        this.SList = SList;
        System.out.println("DAO=>"+SList);
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
    public Subject_Dto getSubject_DtO(String subject){
        
    	Subject_Dto dto = new Subject_Dto();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from subjectdb where subject";
            ps = con.prepareStatement(sql);
            ps.setString(1, subject);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setSubject(rs.getString("subject"));
                dto.setProfessor(rs.getString("professor"));
                dto.setDayofweek(rs.getString("dayofweek"));
                dto.setPeriod(rs.getString("period"));
                dto.setYear(rs.getString("year"));
                dto.setSemester(rs.getString("semester"));
                dto.setDivclass(rs.getString("divclass"));

               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
   
    /**멤버리스트 출력*/
    public Vector getSubject_List(){
       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
           
            con = getConn();
            String sql = "select * from subjectdb order by subject asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String subject = rs.getString("subject");
                String professor = rs.getString("professor");
                String dayofweek = rs.getString("dayofweek");
                String period = rs.getString("period");
                String year = rs.getString("year");
                String semester = rs.getString("semester");
                String divclass = rs.getString("divclass");

                Vector row = new Vector();
                row.add(subject);
                row.add(professor);
                row.add(dayofweek);
                row.add(period);
                row.add(year);
                row.add(semester);
                row.add(divclass);
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getSubject_List()
   
 
 
    /**회원 등록*/
    public boolean Insert_Subject(Subject_Dto dto){
       
        boolean ok = false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "insert into subjectdb(" +
                        "subject,professor,dayofweek,period,year,semester,divclass)" +
                        "values(?,?,?,?,?,?,?)";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getSubject());
            ps.setString(2, dto.getProfessor());
            ps.setString(3, dto.getDayofweek());
            ps.setString(4, dto.getPeriod());
            ps.setString(5, dto.getYear());
            ps.setString(6, dto.getSemester());
            ps.setString(7, dto.getDivclass());     
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
public boolean Change_Subject(Subject_Dto vSub){
    System.out.println("dto="+vSub.toString());
    boolean ok = false;
    Connection con = null;
    PreparedStatement ps = null;
    try{
       
        con = getConn();           
        String sql = "update subjectdb set subject=?, professor=?, dayofweek=?, period=?, year=?, semester=?,divclass=?";
        ps = con.prepareStatement(sql);
       
        ps.setString(1, vSub.getSubject());
        ps.setString(2, vSub.getProfessor());
        ps.setString(3, vSub.getDayofweek());
        ps.setString(4, vSub.getPeriod());
        ps.setString(5, vSub.getYear());
        ps.setString(6, vSub.getSemester());
        ps.setString(7, vSub.getDivclass());
       
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

/**회원정보 삭제 :
 *tip: 실무에서는 회원정보를 Delete 하지 않고 탈퇴여부만 체크한다.
public boolean Delete_Subject(String Subject, String pwd){
   
    boolean ok =false ;
    Connection con =null;
    PreparedStatement ps =null;
   
    try {
        con = getConn();
        String sql = "delete from tb_member where Subject=? and pwd=?";
       
        ps = con.prepareStatement(sql);
        ps.setString(1, Subject);
        ps.setString(2, pwd);
        int r = ps.executeUpdate(); // 실행 -> 삭제
       
        if (r>0) ok=true; //삭제됨;
       
    } catch (Exception e) {
        System.out.println(e + "-> 오류발생");
    }      
    return ok;
}
*/

/**DB데이터 다시 불러오기*/   
public void userSelectAll(DefaultTableModel model) {
   
   
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    try {
        con = getConn();
        String sql = "select * from subjectdb order by subject asc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
       
        // DefaultTableModel에 있는 데이터 지우기
        for (int i = 0; i < model.getRowCount();) {
            model.removeRow(0);
        }

        while (rs.next()) {
            Object data[] = { rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                   rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
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