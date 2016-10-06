package excerciseFour;

public class Connection {
	private String type;
	private Integer distance;
	private String status;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString(){
		return "Type: " + type + " Distance: " + distance + " Status: " + status;
	}

}
