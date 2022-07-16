import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-06-16 16:58:40
 */
public class Exercise {
    public static void main(String[] args) {
        // 测试
        Student studentTest = null;
        Student student = new Student(204180200, "信计200", "test1");
        addStudent(student);
        studentTest = queryStudent(204180200);
        System.out.println("添加学生信息的结果（测试样例：{204180200, \"信计200\", \"test1\"}）：" +" "+studentTest);
        deleteStudent(204180200);
        // 其他测试略




    }

    //增加学生记录
    public static void addStudent(Student stu){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into student(id,grade,name) values(?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, stu.getId());
            pst.setString(2, stu.getClassName());
            pst.setString(3, stu.getName());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn, pst);
        }
    }

    // 通过学号删除学生记录
    public static void deleteStudent(int id){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from student where id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn, pst);
        }
    }


    // 修改学生记录
    public static void updateStudent(Student stu){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update student set grade = ?, name = ? where id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, stu.getClassName());
            pst.setString(2, stu.getName());
            pst.setInt(3, stu.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn, pst);
        }
    }

    // 查询学生记录
    public static Student queryStudent(int id){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student stu = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from student where id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setClassName(rs.getString("grade"));
                stu.setName(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn, pst, rs);
        }

        return stu;
    }

}
