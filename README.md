### 서비스의 종류

##### 1. Started Service

##### 생명주기

##### 서비스 시작 -> onCreate() -> onStartCommand() -> 서비스 동작 -> onDestroy() -> 서비스 끝

##### onStartCommand()에서 원하는 동작 처리해줌

##### 무한루프의 경우 서비스에서 실행한다 하더라도 멈추기 때문에 작업 스레드를 생성하여 무한루프를 돌려야 한다.

##### 2. Bound Service

##### 생명주기

##### 서비스 연결 시작 -> onCreate() -> onBind() -> 클라이언트 서비스 인터페이스 사용 가능 -> onUnbind() -> onDestroy() -> 서비스 연결 끝

##### 액티비티와의 상호작용을 위함이며 값을 다시 받을 때 사용한다.
