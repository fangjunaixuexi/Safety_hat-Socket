package com.dajingzhu.bean;

public class Location {
	
	private int data_length;
	private int data_number;
	private double north_latitude;
	private double east_longitude;
	private String version;
	private double transmission_speed;
	private double safety_helmet_angle;
	private int satellite_number;
	private double level_factor;
	private String transmission_time;
	private int signal_intensity;
	private int alarm_value;
	private String state;
	private int battery_voltage;
	private int battery_level;
	public int getData_length() {
		return data_length;
	}
	public void setData_length(int data_length) {
		this.data_length = data_length;
	}
	public int getData_number() {
		return data_number;
	}
	public void setData_number(int data_number) {
		this.data_number = data_number;
	}
	public double getNorth_latitude() {
		return north_latitude;
	}
	public void setNorth_latitude(double north_latitude) {
		this.north_latitude = north_latitude;
	}
	public double getEast_longitude() {
		return east_longitude;
	}
	public void setEast_longitude(double east_longitude) {
		this.east_longitude = east_longitude;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public double getTransmission_speed() {
		return transmission_speed;
	}
	public void setTransmission_speed(double transmission_speed) {
		this.transmission_speed = transmission_speed;
	}
	public double getSafety_helmet_angle() {
		return safety_helmet_angle;
	}
	public void setSafety_helmet_angle(double safety_helmet_angle) {
		this.safety_helmet_angle = safety_helmet_angle;
	}
	public int getSatellite_number() {
		return satellite_number;
	}
	public void setSatellite_number(int satellite_number) {
		this.satellite_number = satellite_number;
	}
	public double getLevel_factor() {
		return level_factor;
	}
	public void setLevel_factor(double level_factor) {
		this.level_factor = level_factor;
	}
	public String getTransmission_time() {
		return transmission_time;
	}
	public void setTransmission_time(String transmission_time) {
		this.transmission_time = transmission_time;
	}
	public int getSignal_intensity() {
		return signal_intensity;
	}
	public void setSignal_intensity(int signal_intensity) {
		this.signal_intensity = signal_intensity;
	}
	public int getAlarm_value() {
		return alarm_value;
	}
	public void setAlarm_value(int alarm_value) {
		this.alarm_value = alarm_value;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getBattery_voltage() {
		return battery_voltage;
	}
	public void setBattery_voltage(int battery_voltage) {
		this.battery_voltage = battery_voltage;
	}
	public int getBattery_level() {
		return battery_level;
	}
	public void setBattery_level(int battery_level) {
		this.battery_level = battery_level;
	}
	@Override
	public String toString() {
		return "Location [data_length=" + data_length + ", data_number=" + data_number + ", north_latitude="
				+ north_latitude + ", east_longitude=" + east_longitude + ", version=" + version
				+ ", transmission_speed=" + transmission_speed + ", safety_helmet_angle=" + safety_helmet_angle
				+ ", satellite_number=" + satellite_number + ", level_factor=" + level_factor + ", transmission_time="
				+ transmission_time + ", signal_intensity=" + signal_intensity + ", alarm_value=" + alarm_value
				+ ", state=" + state + ", battery_voltage=" + battery_voltage + ", battery_level=" + battery_level
				+ "]";
	}
	
}

