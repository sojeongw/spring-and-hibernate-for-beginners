package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	// enables auto configuration, component scanning, additional configuration
// behind the scenes, this creates application context and registers all beans.
// and starts the embedded server Tomcat etc...
// 이전에는 sub-package를 다 지정해줬지만 이젠 자동으로 root 아래의 모든 패키지를 scan한다.
// 하지만 아예 다른 패키지, 예를 들어 org.acme.iot.utils와 같다면 직접 명시해줘야 한다.
public class MycoolappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

}
