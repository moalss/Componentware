package cw_new.entitys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class Nachricht {

	@Column
	private LocalDateTime timestamp;
	@Column 
	private String info;
	@Column 
	private String type;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false) // Foreign key to Sensorsender
    private Sensorsender sensorsender;
	
	
	public Nachricht(LocalDateTime timestamp, String info, String type, Sensorsender sensorsender) {
		super();
		this.timestamp = timestamp;
		this.info = info;
		this.type = type;
		
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

	public Sensorsender getSensorsender() {
		return sensorsender;
	}

	public void setSensorsender(Sensorsender sensorsender) {
		this.sensorsender = sensorsender;
	}
	
	
	
	
	
	
	

}
