package com.dajingzhu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.Socket;

import com.dajingzhu.bean.Location;
import com.dajingzhu.dao.LocationDao;

public class ServerSocketThread extends Thread {
	private Socket socket;

	public ServerSocketThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;

		System.out.println("进入线程");
		while (true) {
			// socket获取字节输入流
			try {
				LocationDao locationdao = new LocationDao();
				//创建socket套接字通道，等到输入流
				is = socket.getInputStream();
				//创建byte数组存放数据
				byte[] bytes = new byte[1024];
				//read（byte []）方法,以整数形式返回实际读取的字节数。
				int n = is.read(bytes);
				//这种不能输入 
				//System.out.println(new String(bytes, 0, n));
				String coordinate=null;
				//读取0-n位字节转换为String存放到coordinnate
				coordinate= new String(bytes, 0, n);
				//输出得到的数据
				System.out.println("得到数据：");
				System.out.println(coordinate);
				//根据“，”号分割
				String[] splits = coordinate.split(",");
				System.out.println("=====split======");
				//客户端第一次发送的是请求注册包，分割数组长度小于四，不用存入
				if (splits.length > 4) {
					//new一个location对象，将风格的数组转换成相应的格式存放进对象封装，之后通过方法存入数据库
					Location location = new Location();
					/*检测分割结果
					 * for (int i = 0; i < splits.length; i++) {
						System.out.println(splits[i]);
					}*/
					//分割的第一位代表数据长度
					//System.out.println(data_length);
					String str = splits[0];
					int data_length = Integer.parseInt(str.substring(1));
					location.setData_length(data_length);
					
					//数据编号
					//System.out.println(splits[2]);
					String str1 = splits[2];
					int data_number = Integer.parseInt(str1);
					location.setData_number(data_number);
					

					//北纬
					//System.out.println(north_latitude);
					String str2 = splits[4];
					BigDecimal bdi = new BigDecimal(str2);
					BigDecimal divide = bdi.divide(new BigDecimal("100"));
					double north_latitude = divide.doubleValue();
					location.setNorth_latitude(north_latitude);
					
					//System.out.println("东经");
					//System.out.println(east_longitude);
					String str3 = splits[6];
					BigDecimal bdi1 = new BigDecimal(str3);
					BigDecimal divide1 = bdi1.divide(new BigDecimal("100"));
					double east_longitude = divide1.doubleValue();
					location.setEast_longitude(east_longitude);
					
					//System.out.println("版本号");
					//System.out.println(splits[9]);
					String version = splits[9];
					location.setVersion(version);
					
					//System.out.println("传输速度");
					//System.out.println(splits[7]);
					String str4 = splits[7];
					double transmission_speed = Double.parseDouble(str4);
					location.setTransmission_speed(transmission_speed);
					
					//System.out.println("安全帽角度");
					//System.out.println(splits[8]);
					String str5 = splits[8];
					double safety_helmet_angle = Double.parseDouble(str5);
					location.setSafety_helmet_angle(safety_helmet_angle);
					
					//System.out.println("卫星数量");
					//System.out.println(splits[10]);
					String str6 = splits[10];
					int satellite_number = Integer.parseInt(str6);
					location.setSatellite_number(satellite_number);
					
					//System.out.println("水平因子");
					//System.out.println(splits[11]);
					String str7 = splits[11];
					double level_factor = Double.parseDouble(str7);
					location.setLevel_factor(level_factor);
					
					//System.out.println("传输时间");
					//System.out.println(transmission_time);
					ToDateTime testDateTime = new ToDateTime();
					String transmission_time = testDateTime.Time_conversion(splits[12]);
					location.setTransmission_time(transmission_time);
					
					//System.out.println("信号强度");
					//System.out.println(splits[13]);
					String str8 = splits[13];
					int signal_intensity = Integer.parseInt(str8);
					location.setSignal_intensity(signal_intensity);
					
					//System.out.println("报警值");
					//System.out.println(splits[14]);
					String str9 = splits[14];
					int alarm_value = Integer.parseInt(str9);
					location.setAlarm_value(alarm_value);
					
					//System.out.println("状态值");
					//System.out.println(splits[15]);
					String state = splits[15];
					location.setState(state);
					
					//System.out.println("电池电压");
					//System.out.println(splits[16]);
					String str11 = splits[16];
					int battery_voltage = Integer.parseInt(str11);
					location.setBattery_voltage(battery_voltage);
					
					//System.out.println("电池电量");
					//System.out.println(splits[17]);
					String str12 = splits[17];
					int battery_level = Integer.parseInt(str12);
					location.setBattery_level(battery_level);
					
					
					if ("".equals(location) || location != null) {
						// 插入location数据
						int insertLocation = locationdao.insertLocation(location);
						// 查看插入数据是否成功,>=1
						if(insertLocation>=1) {
							System.out.println("数据已存入数据库");
							System.out.println();
						}else {
							System.out.println("数据插入数据库失败");
						}
						
					}
				}

				

				//System.out.println("向客户端发送消息");
				String sendClient = "$08,RA,0,1,#\n";
				socket.getOutputStream().write(sendClient.getBytes());
				
			} catch (Exception e3) {
				try {
					is.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("socket连接异常");
					e3.printStackTrace();
					System.out.println("传入数据失败");
				}
			
				
		

			}
				
					
				}
				

	}
}