package lseeon_6.homework;

public abstract class Animal {

    private String name;
    public static int countAnimal;

    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }

    protected abstract int getMaxRunDistance();
    protected abstract int getMaxSwimDistance();

    protected String run(int distance){
        if (distance <= getMaxRunDistance()){
            return this.name + " пробежал(а) " + distance + " метров";
        } else {
            return this.name + " пробежал(а) " + getMaxRunDistance() + " метров и устал(а), остальные " + (distance - getMaxRunDistance()) + " метров его пришлось нести на руках.";
        }
    }

    private boolean canSwim(){
        return getMaxSwimDistance() > 0;
    }

    protected String swim(int distance){
        if (!canSwim()){
            return "О чём вы думали, " + this.name + " не умеет плавать, он(а) мог(ла) утонуть.";
        } else if (distance <= getMaxSwimDistance()) {
            return this.name + " проплыл " + distance + " метров.";
        } else {
            return this.name + " проплыл " +  getMaxSwimDistance() + " метров и начал тонуть. Кажется это его максимум. Он не может проплыть " + distance + " метров.";
        }
    }
}
