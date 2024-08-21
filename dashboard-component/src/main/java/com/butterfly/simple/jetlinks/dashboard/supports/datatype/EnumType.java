package com.butterfly.simple.jetlinks.dashboard.supports.datatype;

import com.butterfly.simple.jetlinks.dashboard.metadata.AbstractType;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanasida
 * @date 2024/8/21 13:54
 */
@Getter
@Setter
public class EnumType extends AbstractType {

    private volatile List<Element> elements;

    public EnumType() {
        super("enum", "枚举");
    }

    @Override
    public String format(Object value) {
        String stringVal = String.valueOf(value);
        if (elements == null) {
            return stringVal;
        }
        return elements
                .stream()
                .filter(ele -> ele.value.equals(String.valueOf(value)))
                .findFirst()
                .map(Element::getText)
                .orElse(stringVal);
    }

    public EnumType addElement(Element element) {
        if (elements == null) {
            synchronized (this) {
                if (elements == null) {
                    elements = new ArrayList<>();
                }
            }
        }
        elements.add(element);
        return this;
    }

    @Getter
    @Setter
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    public static class Element {
        private String value;

        private String text;

        private String description;


        public static Element of(String value, String text) {
            return of(value, text, null);
        }

        public static Element of(Map<String, String> map) {
            return Element.of(map.get("value"), map.get("text"), map.get("description"));
        }

        public Map<String, Object> toMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("value", value);
            map.put("text", text);
            map.put("description", description);

            return map;
        }
    }
}
