package com.meti.interpret.type;

public class ArrayType implements Type {
    private final Type child;

    public ArrayType(Type child) {
        this.child = child;
    }

    @Override
    public String[] value() {
        var childValue = child.value();
        var array = new String[childValue.length + 1];
        array[0] = "Array";
        System.arraycopy(childValue, 0, array, 1, childValue.length);
        return array;
    }
}
