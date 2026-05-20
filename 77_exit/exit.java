// Exits immediately with status 3; unlike Go's defer, Java shutdown hooks
// DO run on System.exit(), but none are registered here to match Go behavior.

void main() {
    System.exit(3);
}
