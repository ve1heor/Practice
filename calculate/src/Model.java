public class Model {

    public Model(String exp, double result, String date) {
        this.exp = exp;
        this.result = result;
        this.date = date;
    }
    public String getExp() {
        return exp;
    }
    public double getResult() {
        return result;
    }
    public String getDate() {
        return date;
    }

    public void setResult(double result) {
        this.result = result;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setExp(String exp) {
        this.exp = exp;
    }

    public String exp;
    public double result;
    public String date;
}
