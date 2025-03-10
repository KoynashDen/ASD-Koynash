package Lab_4;

class Player {
    String lastName;

    Player(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return lastName;
    }
}
