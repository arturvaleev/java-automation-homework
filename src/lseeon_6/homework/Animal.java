package lseeon_6.homework;

public abstract class Animal {

    private String name;
    public static int countAnimal;
    protected int MAX_RUN_DISTANCE;
    protected int MAX_SWIM_DISTANCE;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    protected String run(int distance){
        if (distance <= MAX_RUN_DISTANCE){
            return this.name + " пробежал(а) " + distance + " метров";
        } else {
            return this.name + " пробежал(а) " + MAX_RUN_DISTANCE + " метров и устал(а), остальные " + (distance - MAX_RUN_DISTANCE) + " метров его пришлось нести на руках.";
        }
    }

    private boolean canSwim(){
        return MAX_SWIM_DISTANCE > 0;
    }

    protected String swim(int distance){
        if (!canSwim()){
            return "О чём вы думали, " + this.name + " не умеет плавать, он(а) мог(ла) утонуть.";
        } else if (distance <= MAX_SWIM_DISTANCE) {
            return this.name + " проплыл " + distance + " метров.";
        } else {
            return this.name + " проплыл " +  MAX_SWIM_DISTANCE + " метров и начал тонуть. Кажется это его максимум. Он не может проплыть " + distance + " метров.";
        }
    }
}
