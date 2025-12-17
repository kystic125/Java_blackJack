# BlackJack

Java로 구현한 콘솔 기반 블랙잭 게임

## 프로젝트 개요

단일책임원칙(SRP)을 중심으로 객체지향 설계 원칙을 학습하고 적용한 프로젝트
테스트 주도 개발(TDD) 방식으로 도메인 로직을 구현하고, 예외 처리 및 입력 검증을 통해 안정적인 게임을 완성

## 학습 목표

- **단일책임원칙(SRP)** 이해 및 적용
- **캡슐화**와 **의존성 설계**
- **테스트 가능한 코드** 작성
- **예외 처리** 및 **입력 검증**

## 게임 규칙

1. 딜러와 플레이어는 각각 2장의 카드를 받는다
2. 플레이어는 카드를 더 받을지(Hit) 멈출지(Stand) 선택할 수 있습니다
3. 카드 합이 21을 초과하면 버스트(패배)입니다
4. 딜러는 16 이하면 카드를 받고, 17 이상이면 멈춥니다
5. 블랙잭은 1.5배 배당입니다

## 프로젝트 구조
```
src/
├── java_BlackJack/
│   ├── BlackJack.java           # 게임 전체 조율
│   └── domain/
│       ├── Card.java             # 카드 (무늬, 숫자, 점수)
│       ├── Rank.java             # 카드 숫자 (A, 2~10, J, Q, K)
│       ├── Shape.java            # 카드 무늬
│       ├── Hand.java             # 손패 (점수 계산, 상태 판단)
│       ├── Deck.java             # 카드 덱 (52장 생성, 섞기)
│       ├── Player.java           # 플레이어
│       ├── Dealer.java           # 딜러
│       ├── Game.java             # 게임 진행 로직
│       ├── ResultCalculator.java # 승패 판정 및 수익 계산
│       ├── InputView.java        # 사용자 입력 처리
│       └── OutputView.java       # 게임 화면 출력
└── test/
    └── java_BlackJack/domain/
        ├── HandTest.java
        ├── DealerTest.java
        ├── PlayerTest.java
        └── ResultCalculatorTest.java
```

## 핵심 설계 원칙

### 1. 단일책임원칙(SRP)

**Hand 클래스 - 데이터와 행동을 함께**
```java
public class Hand {
    private List cards;
    
    // Hand가 자기 카드에 대한 모든 책임
    public int getScore() { ... }      // 점수 계산
    public boolean isBurst() { ... }   // 버스트 판단
    public boolean isBlackJack() { ... } // 블랙잭 판단
}
```

**초기 설계**
- Hand: 카드 보관만
- ScoreCalculator, AceAdjuster, BurstChecker 등 별도 클래스

**개선 후**
- Hand가 점수 계산과 상태 판단 모두 담당
- "변경 이유가 같으면 하나의 책임"

### 2. 캡슐화 - Getter 최소화
```java
List cards = hand.getCards();
int score = cards.stream().mapToInt(Card::getScore).sum();

int score = hand.getScore();
// getxxx를 한 이후 추가 작업이 필요한 경우 getter를 사용하지 않아보기
// getxxx 이후 바로 이용할거면 상관 없음 (필요한 경우가 많음)
```

### 3. 역할 분리

**Dealer의 카드 분배**
```java
// 초기 설계
dealer.deal(player); // Dealer가 Player 내부 메서드 알아야 함

// 개선
Card card = dealer.drawCard();  // 딜러는 카드 꺼내기만
player.receiveCard(card);       // 플레이어가 받기
```

## 테스트

### 테스트 클래스
- Hand: 점수 계산, Ace 조정, 블랙잭, 버스트
- Dealer: shouldHit 로직, 블랙잭, 버스트
- Player: 카드 받기, 블랙잭, 버스트
- ResultCalculator: 승패 판정 8가지 케이스

## 실행 예시
```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
15000

딜러와 pobi, jason에게 2장의 카드를 나누었습니다.
딜러: 하트6
pobi: 스페이드5, 다이아몬드3
jason: 하트7, 클로버9

pobi님, 카드를 더 받으시겠습니까? (y/n)
y
pobi: 스페이드5, 다이아몬드3, 클로버K

pobi님, 카드를 더 받으시겠습니까? (y/n)
n

jason님, 카드를 더 받으시겠습니까? (y/n)
n

딜러는 16이하라 한장의 카드를 더 받았습니다.
딜러: 하트6, 스페이드2, 다이아몬드K

딜러: 하트6, 스페이드2, 다이아몬드K - 결과: 18
pobi: 스페이드5, 다이아몬드3, 클로버K - 결과: 18
jason: 하트7, 클로버9 - 결과: 16

## 최종 수익
딜러: 15000
pobi: 0
jason: -15000
```

## 기술 스택

- **Language:** Java 24
- **Build Tool:** Maven
- **Test:** JUnit 5, AssertJ

## 학습 내용

### 객체지향 설계
- 단일책임원칙(SRP): "변경 이유가 하나"
- 데이터와 행동을 함께 배치
- 의존성 주입을 통한 테스트 용이성 확보

### 코드 품질
- indent depth 2 제한
- else 예약어 제거 (early return방식 사용)
- getter 최소화

### 예외 처리
- 플레이어 이름 검증 (빈 이름, split 처리)
- 배팅 금액 검증 (1 이상 정수)
- 히트 입력 검증 (y/n)
- 재입력 처리

## 리팩토링 과정

### 주요 변경사항
1. **Hand 클래스 책임 통합**
   - 4개의 계산 클래스(AceAdjustor, IsBlackJack, IsBurst, CalculatorScore) → Hand로 통합
   
2. **Players 클래스 제거**
   - 불필요한 래퍼 클래스 삭제 (Players가 aaa,bbb와 같이 입력만 가지고 있었음)
   
3. **Dealer 책임 명확화**
   - `deal(Player)` → `drawCard()` + `receiveCard()`
   
4. **Dealer 생성자 오버로딩**
   - 테스트 가능성을 위한 Hand 주입 생성자 추가

## 커밋 컨벤션
```
feat: 새로운 기능 추가
refactor: 리팩토링
test: 테스트 코드 작성
fix: 버그 수정
```

## 배운 점

1. **단일책임 ≠ 메서드/클래스 개수**
   - 변경 이유가 같으면 하나의 클래스
   - [클래스, 메서드의 개수가 많다고 단일 책임을 잘 지키는게 아님]
   
2. **캡슐화의 진짜 의미**
   - 데이터 숨기기가 아닌 "데이터와 행동 함께 두기"
   
3. **테스트 가능한 코드 = 좋은 설계**
   - 의존성 주입
   - 생성자 오버로딩
   
4. **억지로 쪼개지 말기**
   - 의미 있는 책임이 없으면 클래스 만들지 않기
