1. docker 설정
2. docker에서 sonarqube pull
3. root gradle에서 아래와 같이 추가
``xml
buildscript {
    dependencies {
        // sonar
        classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.1"
    }
}

apply plugin: "org.sonarqube"
sonarqube {
    properties {
        property "sonar.host.url", "http://localhost:9000/"
        property "sonar.login", "토큰 넣는 자리"
        property "sonar.password", ""	// 인증 토큰 을 사용 하므로 공백처리 한다
        property "sonar.projectKey", "프로젝트 Key 이름"
        property "sonar.projectVersion", "1.0"
        property 'sonar.sourceEncoding', "UTF-8"
        property "sonar.scm.provider", "svn"
        property "sonar.profile", "Sonar way"
    }
}

``
4. terminal에서 ./gradlew sonarqube 실행

주의사항
1. Gradle은 최신버전
2. jdk도 11버전 이상
3. multi module도 가능하나, 내가 다니는 곳은 테블릿 keystore인증이 필요해서 해당 모듈 제외.
