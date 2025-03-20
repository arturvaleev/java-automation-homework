package module_2.lesson_6.homework;

public abstract class Animal {

    private String name;
    public static int countAnimal;
    private int maxRunDistance;
    private int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        countAnimal++;
    }

    protected String run(int distance){
        if (distance <= maxRunDistance){
            return this.name + " пробежал(а) " + distance + " метров";
        } else {
            return this.name + " пробежал(а) " + maxRunDistance + " метров и устал(а), остальные " + (distance - maxRunDistance) + " метров его пришлось нести на руках.";
        }
    }

    private boolean canSwim(){
        return maxSwimDistance > 0;
    }

    protected String swim(int distance){
        if (!canSwim()){
            return "О чём вы думали, " + this.name + " не умеет плавать, он(а) мог(ла) утонуть.";
        } else if (distance <= maxSwimDistance) {
            return this.name + " проплыл " + distance + " метров.";
        } else {
            return this.name + " проплыл " +  maxSwimDistance + " метров и начал тонуть. Кажется это его максимум. Он не может проплыть " + distance + " метров.";
        }
    }
}
