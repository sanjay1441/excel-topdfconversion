package otsi.voter;

public class Voter {
	private String id;
	private String name;
	private String relname;
	private String agedet;
	private String sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelname() {
		return relname;
	}
	public void setRelname(String relname) {
		this.relname = relname;
	}
	public String getAgedet() {
		return agedet;
	}
	public void setAgedet(String agedet) {
		this.agedet = agedet;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", relname=" + relname + ", agedet=" + agedet + ", sex=" + sex
				+ "]";
	}
	
	
	

}
