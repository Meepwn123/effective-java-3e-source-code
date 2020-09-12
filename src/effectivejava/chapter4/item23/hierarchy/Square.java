package effectivejava.chapter4.item23.hierarchy;

/**
 * Class hierarchy replacement for a tagged class  (Page 95)
 */
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}
