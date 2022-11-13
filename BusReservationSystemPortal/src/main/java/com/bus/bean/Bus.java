package com.bus.bean;


import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	
	@NotNull(message = "Bus name cannot be null!")
	private String busName;
	
	
	@NotNull(message = "Bus driver name cannot be null!")
	private String driverName;
	
	
	private String busType;
	
	
	@NotNull(message = "Start place cannot be null!")
	private String routeFrom;
	
	@NotNull(message = "Destination place cannot be null!")
	private String routeTo;
	
	@NotNull(message = "Arrival time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime arrivalTime;
	
	@NotNull(message = "Departure time cannot be null!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime departureTime;
	
	@NotNull(message = "Seats cannot be null!")
	private Integer seats;
	
	@NotNull(message = "Available seats cannot be null!")
	private Integer availableSeats;
	
	
	@ManyToOne
	private Route route;
	
	
}
