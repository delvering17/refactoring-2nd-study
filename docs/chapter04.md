# 테스트 구축하기

- 테스트의 목적은 어디까지나 현재 혹은 향후에 발생하는 버그를 찾는 데 있다.
- 완벽하게 만드느라 테스트를 수행하지 못하느니, 불완전한 테스트라도 작성해 실행하는 게 낫다.
- 일부러 오류를 주입하여 테스트를 실패  시키고 원래로 되돌려서 테스트 성공을 확인하는 방식 사용
- 문제가 생길 가능성이 있는 경계 조건을 생각해보고 그 부분을 집중적으로 테스트하자
    - empty string, empty collection, negative num
- 같은 코드베이스의 모듈 사이에 유효성 검사 코드가 너무 많으면 다른 곳에서 확인한 걸 중복을 검증하여 오히려 문제가 될 수 있다.
- 신뢰할 수 있는 입력 객체는 필요없지만 외부에서 들어온 입력 객체는 유효한지 확인해야한다.
- 테스트가 모든 버그를 걸러주지는 못할지라도, 안심하고 리팩터링할 수 있는 보호막은 되어준다.
- 버그 리포트를 받으면 가장 먼저 그 버그를 들내는 단위 테스트부터 작성하자
- “어느 정도 하면 충분히 테스트했다고 할 수 있나요?”
    - 커버리지는 테스트하지 않은 영역을 찾는데만 도움 준다.
    - 테스트 충분은 주관적
    - “테스트 결과가 초록색인 걸 보고 리팩터링 과정에 버그가 하나도 없다고 확신할 수 있단면”
- 테스트 떄문에 개발 속도가 느려진다고 생각되면 테스트를 과하게 작성한 건 아닌지 의심.
- 하지만 너무 많은 경우보다는 너무 적은 경우가 훨씬 많다.
