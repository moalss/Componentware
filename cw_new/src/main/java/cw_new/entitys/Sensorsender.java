package cw_new.entitys;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Sensorsender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String location;
	
	@Column
	private float wasserStand;
	@Column
	private LocalDateTime timestamp;
	@Column 
	private String info;
	@Column 
	private String type;
	
//	// One-to-Many relationship with Nachricht
//	@OneToMany(mappedBy = "sensorsender", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Nachricht> nachrichten = new ArrayList<>();

	

	

	
	

	public Sensorsender(String location, float wasserStand, LocalDateTime timestamp, String type) {
	super();
	this.location = location;
	this.wasserStand = wasserStand;
	this.timestamp = timestamp;
	
	this.type = type;
}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	

	public float getWasserStand() {
		return wasserStand;
	}

	public void setWasserStand(float wasserStand) {
		this.wasserStand = wasserStand;
	}

	public Long getId() {
		return id;
	}



	public LocalDateTime getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
