import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double first;
	private Double second;
	private Double result;

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

	public void addition() {
		result = first + second;
	}
	public void subtraction() {
		result = first - second;
	}
	public void multiply() {
		result = first * second;
	}
	public void divide() {
		result = first / second;
	}
}