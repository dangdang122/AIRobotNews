# 🤖 AI Robot News Platform

인공지능 및 로봇 기술 트렌드를 다루는 지능형 뉴스 플랫폼입니다. 최신 AI 기술 소식을 사용자에게 직관적으로 전달하고, 사용자 맞춤형 세션 기능을 제공합니다.

---

## 🚀 프로젝트 개요
* **주제**: 초지능 AI와 로봇 기술 뉴스 큐레이션 웹 플랫폼
* **개발 배경**: 인공지능소프트웨어과 전공자로서 실무적인 웹 아키텍처 설계 및 풀스택 개발 역량 강화
* **개발 환경**: Java 17, Spring Boot, Thymeleaf, HTML5/CSS3

## 🛠 주요 기술 스택
- **Backend**: Spring Boot, Jakarta Servlet API, Lombok
- **Frontend**: Thymeleaf, CSS3 (Responsive Design)
- **Tool**: IntelliJ IDEA, Git/GitHub

## 💡 핵심 기능 및 차별화 전략

### 1. 동적 뉴스 큐레이션
`Collections.shuffle()`을 활용한 랜덤 알고리즘을 적용하여, 사용자가 접속할 때마다 항상 새로운 로봇 기술 뉴스를 접할 수 있도록 재방문 가치를 높였습니다.

### 2. 제목 기반 정밀 라우팅 (@PathVariable)
인덱스 번호가 아닌 기사 '제목(Title)'을 식별자로 사용하는 정밀 라우팅을 설계하였습니다. 셔플로 인해 리스트 순서가 바뀌어도 데이터와 이미지가 항상 정확하게 매칭됩니다.

### 3. 세션 기반 개인화 UX
로그인 여부를 실시간으로 세션에서 감지합니다. 이메일 전송 기능 사용 시 로그인된 회원의 이메일을 자동으로 입력(Pre-fill)하여 사용자 편의성을 극대화하였습니다.

### 4. 이미지 동기화 시스템
뉴스 기사 객체 구조(Array)에 이미지 파일명을 포함하여 데이터와 시각 자료를 논리적으로 결합하였습니다. 이를 통해 상세 페이지 및 카드 UI에서 일관된 이미지 노출을 보장합니다.

### 5. 상태 관리 로직
`history.replaceState`를 적용하여 알림(alert) 출력 후 페이지 새로고침 시 중복 알림이 발생하는 현상을 방지, 쾌적한 UX를 구축하였습니다.

---

## 📂 프로젝트 구조 (참고)
```text
src/main/java/kr/ac/kopo/jong/airobotnews/
├── controller/
│   └── WebController.java  # 핵심 로직 및 라우팅
├── domain/
│   └── Member.java         # 사용자 정보 모델
└── service/
    └── MemberService.java  # 로그인/회원가입 비즈니스 로직
