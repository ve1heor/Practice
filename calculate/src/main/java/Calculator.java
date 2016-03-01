import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class Calculator implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double first;
	private Double second;
	private Double result;

	private Statement st = null;
	private ResultSet rs = null;

	private DateFormat dformat;
	private String exp;
	private String cinDate;
	private ArrayList<Model> list;
	private Model model = null;

	public void init() throws ClassNotFoundException, SQLException {
		Class.forName ("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/calculator", "postgres", "1234");
		st = con.createStatement();
		 dformat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	}

	public Double getFirst() {
		return first;
	}
	public void setFirst(Double first) {
		this.first = first;
	}
	public Double getSecond() {
		return second;
	}
	public void setSecond(Double second) {
		this.second = second;
	}
	public Double getResult() {
		return result;
	}
	public ArrayList<Model> getList() {
		return list;
	}
	public void addition() throws SQLException {
		result = first + second;
		exp = String.valueOf(first).concat("+".concat(String.valueOf(second)));
		workWithDataBase();
	}
	public void subtraction() throws SQLException {
		result = first - second;
		exp = String.valueOf(first).concat("-".concat(String.valueOf(second)));
		workWithDataBase();
	}
	public void multiply()  throws SQLException {
		result = first * second;
		exp = String.valueOf(first).concat("*".concat(String.valueOf(second)));
		workWithDataBase();
	}
	public void divide()  throws SQLException {
		result = first / second;
		exp = String.valueOf(first).concat("/".concat(String.valueOf(second)));
		workWithDataBase();
	}

	public void workWithDataBase() throws SQLException {
		list = new ArrayList<Model>();
		cinDate = dformat.format(Calendar.getInstance().getTime());
		st.execute("INSERT INTO tb_result(\"Выражение\", \"Результат\", \"Дата\")\n" +
				"VALUES ('"+exp+"',"+result+",'"+cinDate+"');");
		rs = st.executeQuery("SELECT COUNT(*) \n" +
				"FROM tb_result ");
		rs.next();
		Integer count = rs.getInt(1);
		if(count>=5){
			rs = st.executeQuery("SELECT tb_result.\"Выражение\",tb_result.\"Результат\",tb_result.\"Дата\"\n" +
					"FROM public.tb_result\n" +
					"OFFSET(\n" +
					"\tSELECT count(\"id\")\n" +
					"\tFROM public.tb_result)-5");
		}
		else
		{
			rs = st.executeQuery("SELECT tb_result.\"Выражение\",tb_result.\"Результат\",tb_result.\"Дата\"\n" +
					"FROM public.tb_result\n" +
					"OFFSET(\n" +
					"\tSELECT count(\"id\")\n" +
					"\tFROM public.tb_result)-" + count);
		}
		while (rs.next()){
			model = new Model(rs.getString(1),rs.getDouble(2),rs.getString(3));
			list.add(model);
		}
	}
}