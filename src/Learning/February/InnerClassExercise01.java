package Learning.February;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        CellPhone02 cellPhone02 = new CellPhone02();
        cellPhone02.ring();
        Bell bell = new Bell() {
            @Override
            public void ring() {

            }
        };
        System.out.println(bell.getClass());
    }
}

interface Bell {
    void ring();
}

class CellPhone02 implements Bell {
    @Override
    public void ring() {
        System.out.println("小伙伴起床了");
    }
}
class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}