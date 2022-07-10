//팩토리 메소드 패턴 적용
abstract class Animal {
    //추상 팩토리 메소드
    abstract AnimalToy getToy();
}
 
//팩토리 메소드가 생성할 객체의 상위 클래스
abstract class AnimalToy {
    abstract void identify();
}
 
class Dog extends Animal {
    //추상 팩토리 메소드
    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}
 
class DogToy extends AnimalToy {
    @Override
    void identify() {
        System.out.println("강아지 장난감");
    }
}
 
class Cat extends Animal {
    //추상 팩토리 메소드
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
 
class CatToy extends AnimalToy {
    @Override
    void identify() {
        System.out.println("고양이 장난감");
    }
}
 
public class Test {
    public static void main(String[] args) {
        //팩토리 메소드를 보유한 객체 생성
        Animal dog = new Dog();
        Animal cat = new Cat();
 
        //팩토리 메소드가 반환하는 객체
        AnimalToy dogToy = dog.getToy();
        AnimalToy catToy = cat.getToy();
 
        //팩토리 메소드가 반환한 객체를 사용
        dogToy.identify();
        catToy.identify();
    }
}


//전략 패턴 적용
interface Strategy {
   void runStrategy();
}
 
class StrategyGun implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("쏘기");
    }
}
 
class StrategySword implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("베기");
    }
}
 
class Soldier {
    void runContext(Strategy strategy) {
        System.out.println("전투 시작");
        strategy.runStrategy();
        System.out.println("전투 끝");
    }
}
 
public class Test {
    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier soldier = new Soldier();
 
        strategy = new StrategyGun();
        soldier.runContext(strategy);
 
        strategy = new StrategySword();
        soldier.runContext(strategy);
    }
}
