monitor DiningPhilosophers {
    enum State {THINKING, HUNGRY, EATING};
    State states = new State[5];
    Condition[] self = new Condition[5];
    public DiningPhilosophers {
    for (int i = 0; i < 5; i++)
        state[i] = THINKING;
}

    public void takeForks(int i) {
        state[i] = HUNGRY;
        test[i];
        if (state[i] != State.EATING)
            self[i].wait;
    }

    public void returnForks(int i) {
        state[i] = State.THINKING;
        test((i+4) % 5);
        test((i+1) % 5);
    }

    private void test(int i) {
        if ( (state[(i+4) % 5] != State.EATING) && (state[i] == State.HUNGRY) && (state[(i+1) % 5] != State.EATING) ) {
            state[i] = State.EATING;
            self[i].signal;
        }
    }
}

