package lseeon_6.homework;

public abstract class Animal {

    private String name;
    private static int countAnimal;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    protected abstract int getMaxRunDistance();
    protected abstract int getMaxSwimDistance();

    protected void run(int distance){
        if (distance <= getMaxRunDistance()){
            System.out.println(this.name + " пробежал(а) " + distance + " метров");
        } else {
            System.out.println(this.name + " пробежал " + getMaxRunDistance() + " метров и устал, остальные " + (distance - getMaxRunDistance()) + " метров его пришлось нести на руках.");
        }
    }

    private boolean canSwim(){
        return getMaxSwimDistance() > 0;
    }

    protected void swim(int distance){
        if (!canSwim()){
            System.out.println("О чём вы думали, " + this.name + " не умеет плавать, он(а) мог(ла) утонуть.");
        } else if (distance <= getMaxSwimDistance()) {
            System.out.println(this.name + " проплыл " + distance + " метров.");
        } else {
            System.out.println(this.name + " проплыл " +  getMaxSwimDistance() + " метров и начал тонуть. Кажется это его максимум. Он не может проплыть " + distance + " метров.");
        }
    }

    public static int getCountAnimal() {
        return countAnimal;
    }
}
