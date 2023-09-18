package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FoolTest {

    @Test
    public void opponentWhen3and4is0ThenFizzBuzz() {
        assertThat(Fool.opponent(15)).isEqualTo("FizzBuzz");
    }
    @Test
    public void opponentWhen3is0ThenFizz() {
        assertThat(Fool.opponent(3)).isEqualTo("Fizz");
    }

    @Test
    public void opponentWhen5is0ThenBuzz() {
        assertThat(Fool.opponent(5)).isEqualTo("Buzz");
    }

    @Test
    public void opponentWhen2Then2() {
        assertThat(Fool.opponent(2)).isEqualTo("2");
    }


    @Test
    public void playerWhen3and4is0andFizzBuzzThen15() {
        assertThat(Fool.player(15, "FizzBuzz")).isEqualTo(15);
    }

    @Test
    public void playerWhen3andFizzThen3() {
        assertThat(Fool.player(3, "Fizz")).isEqualTo(3);
    }

    @Test
    public void playerWhen5andBuzzThen5() {
        assertThat(Fool.player(5, "Buzz")).isEqualTo(5);
    }

    @Test
    public void opponentWhen2and2Then2() {
        assertThat(Fool.player(2, "2")).isEqualTo(2);
    }

}