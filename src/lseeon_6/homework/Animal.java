package lseeon_6.homework;

public abstract class Animal {

    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    private static int countAnimal;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        countAnimal++;
    }

    protected abstract int getMaxRunDistance();
    protected abstract int getMaxSwimDistance();

    public void run(int distance){
        if (distance <= getMaxRunDistance()){
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " пробежал " + maxRunDistance + " метров и устал, остальные " + (distance - getMaxRunDistance()) + " метров его пришлось нести на руках.");
        }
    }

    private boolean canSwim(){
        return getMaxSwimDistance() > 0;
    }

    public void swim(int distance){
        if (!canSwim()){
            System.out.println("О чём вы думали, " + name + " не умеет плавать, он(а) мог(ла) утонуть.");
        } else if (distance <= getMaxSwimDistance()) {
            System.out.println(name + " проплыл " + distance + " метров.");
        } else {
            System.out.println(name + " проплыл " +  getMaxSwimDistance() + " метров и начал тонуть. Кажется это его максимум. Он не сможет проплыть " + distance + " метров.");
        }
    }

    public static int getCountAnimal() {
        return countAnimal;
    }
}
