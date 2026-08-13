package org.example.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        System.out.println(this);
    }

    @Test
    void sort() {
        // given

        // when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa"));
    }

    @Test
    void sortItems() {
        // given

        // when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        // given

        // when
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));

        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }


}