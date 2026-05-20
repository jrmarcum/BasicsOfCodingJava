enum ServerState {
    IDLE, CONNECTED, ERROR, RETRYING;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

ServerState transition(ServerState s) {
    return switch (s) {
        case IDLE -> ServerState.CONNECTED;
        case CONNECTED, RETRYING -> ServerState.IDLE;
        case ERROR -> ServerState.ERROR;
    };
}

void main() {
    ServerState ns = transition(ServerState.IDLE);
    System.out.println(ns);

    ServerState ns2 = transition(ns);
    System.out.println(ns2);
}
