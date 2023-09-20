package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled

class GreetingGeneratorTest {
    @Test
    public void WhenNoKeysInTemplate() {
      Map<String, String> key = new HashMap<>();
      key.put("name", "Sasha");
      key.put("subject", "you");
      String template = "I am a ${name}, Who are ${lastname}? ";
      Generator generator = new GreetingGenerator();
      assertThatThrownBy(() -> generator.produce(template, key)).
              isInstanceOf(IllegalArgumentException.class);
  }

    @Test
    public void WhenExtraKeysInMap() {
        Map<String, String> key = new HashMap<>();
        key.put("name", "Sasha");
        key.put("subject", "you");
        key.put("lastname", "Ivanov");
        String template = "I am a ${name}, Who are ${subject}?";
        Generator generator = new GreetingGenerator();
        assertThatThrownBy(() -> generator.produce(template, key)).
                isInstanceOf(IllegalArgumentException.class);
    }


}