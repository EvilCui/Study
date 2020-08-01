package Visitor;

/**
 * 包含接受操作的接口
 */
public interface Element {
    void accept(Visitor visitor);
}
