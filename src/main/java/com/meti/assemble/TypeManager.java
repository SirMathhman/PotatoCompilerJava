package com.meti.assemble;

import java.util.Map;

interface TypeManager {
    Map.Entry<String, Type> lookup(Map.Entry<String, String> entry);
}
