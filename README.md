# SpringDataJpaAndQueryDslSample


![#f03c15](buildscript {
	ext {
		queryDslVersion = "5.0.0"
	}
})

plugins {
	id 'org.springframework.boot' version '2.7.5'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
	id 'java'
	// querydsl 플러그인 추가
	id "com.ewerk.gradle.plugins.querydsl" version "1.0.10"
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'junit:junit:4.12'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.mysql:mysql-connector-j'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'

	// querydsl 디펜던시 추가
	implementation "com.querydsl:querydsl-jpa:${queryDslVersion}"
	implementation "com.querydsl:querydsl-apt:${queryDslVersion}"
}

tasks.named('test') {
	useJUnitPlatform()
}


// querydsl 사용할 경로 지정합니다. 현재 지정한 부분은 .gitignore에 포함되므로 git에 올라가지 않습니다.
def querydslDir = "$buildDir/generated/'querydsl'"

// JPA 사용여부 및 사용 경로 설정
querydsl {
	jpa = true
	querydslSourcesDir = querydslDir
}

// build시 사용할 sourceSet 추가 설정
sourceSets {
	main.java.srcDir querydslDir
}


// querydsl 컴파일 시 사용할 옵션 설정
compileQuerydsl {
	options.annotationProcessorPath = configurations.querydsl
}

// querydsl이 compileClassPath를 상속하도록 설정
configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
	querydsl.extendsFrom compileClasspath
}



gradle에서 compileQueryDsl 누르면 QClass파일 생김
Querydsl의 QClass를 담는 src/main/generated는 자동생성되는 파일들의 디렉토리이니 무조건 .gitignore에 generated를 추가
