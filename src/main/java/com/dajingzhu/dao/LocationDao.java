package com.dajingzhu.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.dajingzhu.bean.Location;
 
@Repository
public class LocationDao {
	
/*
		public int insertLocation(Location location) {
			 ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			 JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("JdbcTemplate");
			  String sql="insert into location(data_length,data_number,north_latitude,east_longitude,version,transmission_speed,safety_helmet_angle,satellite_number,level_factor,transmission_time,signal_intensity,alarm_value,state,battery_voltage,battery_level) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
		        //执行插入  
		        int result=jdbcTemplate.update(sql, new Object[]{location.getData_length(),location.getData_number(),
		        													location.getNorth_latitude(),location.getEast_longitude(),location.getVersion(),
		        													location.getTransmission_speed(),location.getSafety_helmet_angle(),
		        													location.getSatellite_number(),location.getLevel_factor(),location.getTransmission_time(),
		        													location.getSignal_intensity(),location.getAlarm_value(),location.getState(),
		        													location.getBattery_voltage(),location.getBattery_level()});  
			return result;
		}
*/

    
	public int insertLocation(Location location) {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/safety_hat");
	        dataSource.setUsername("root");
	        dataSource.setPassword("123");
	        //2、创建jdbcTemplate对象，设置数据源
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  String sql="insert into location(data_length,data_number,north_latitude,east_longitude,version,transmission_speed,safety_helmet_angle,satellite_number,level_factor,transmission_time,signal_intensity,alarm_value,state,battery_voltage,battery_level) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
	        //执行插入  
	        int result=jdbcTemplate.update(sql, new Object[]{location.getData_length(),location.getData_number(),
	        													location.getNorth_latitude(),location.getEast_longitude(),location.getVersion(),
	        													location.getTransmission_speed(),location.getSafety_helmet_angle(),
	        													location.getSatellite_number(),location.getLevel_factor(),location.getTransmission_time(),
	        													location.getSignal_intensity(),location.getAlarm_value(),location.getState(),
	        													location.getBattery_voltage(),location.getBattery_level()});  
		return result;
	}

}
