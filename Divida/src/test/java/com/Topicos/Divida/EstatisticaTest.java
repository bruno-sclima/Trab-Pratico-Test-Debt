package com.Topicos.Divida;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EstatisticaTest {
    @Test
    void MediaTest1() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        assertEquals(2.0d, (new Estatistica(integerList)).media());
    }

    @Test
    void MediaTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        assertEquals(2.0d, (new Estatistica(integerList)).media());
    }

    @Test
    void OrdenaTest() {
        assertTrue((new Estatistica(new ArrayList<>())).ordena().isEmpty());
    }

    @Test
    void OrdenaTest1() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        List<Integer> actualOrdenaResult = (new Estatistica(integerList)).ordena();
        assertEquals(2, actualOrdenaResult.size());
        assertEquals(2, actualOrdenaResult.get(0));
        assertEquals(2, actualOrdenaResult.get(1));
    }

    @Test
    void OrdenaTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);
        List<Integer> actualOrdenaResult = (new Estatistica(integerList)).ordena();
        assertEquals(3, actualOrdenaResult.size());
        assertEquals(2, actualOrdenaResult.get(0));
        assertEquals(2, actualOrdenaResult.get(1));
        assertEquals(2, actualOrdenaResult.get(2));
    }

    @Test
    void MedianaTest1() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        assertEquals(2, (new Estatistica(integerList)).mediana());
    }

    @Test
    void MedianaTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        assertEquals(3, (new Estatistica(integerList)).mediana());
    }

    @Test
    void MedianaTest3() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        assertEquals(3.5, (new Estatistica(integerList)).mediana());
    }

    @Test
    void FrequenciaTest() {
        assertTrue((new Estatistica(new ArrayList<>())).frequencia().isEmpty());
    }

    @Test
    void FrequenciaTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        Map<Integer, Long> actualFrequenciaResult = (new Estatistica(integerList)).frequencia();
        assertEquals(1, actualFrequenciaResult.size());
        Long expectedGetResult = 1L;
        assertEquals(expectedGetResult, actualFrequenciaResult.get(2));
    }

    @Test
    void FrequenciaTest3() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        Map<Integer, Long> actualFrequenciaResult = (new Estatistica(integerList)).frequencia();
        assertEquals(1, actualFrequenciaResult.size());
        Long expectedGetResult = 2L;
        assertEquals(expectedGetResult, actualFrequenciaResult.get(2));
    }

    @Test
    void ModaTest1() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        Map<Integer, Long> actualModaResult = (new Estatistica(integerList)).moda();
        assertEquals(1, actualModaResult.size());
        Long expectedGetResult = 1L;
        assertEquals(expectedGetResult, actualModaResult.get(2));
    }

    @Test
    void ModaTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        Map<Integer, Long> actualModaResult = (new Estatistica(integerList)).moda();
        assertEquals(1, actualModaResult.size());
        Long expectedGetResult = 2L;
        assertEquals(expectedGetResult, actualModaResult.get(2));
    }

    @Test
    void ModaTest3() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(6);
        integerList.add(2);
        Map<Integer, Long> actualModaResult = (new Estatistica(integerList)).moda();
        assertEquals(2, actualModaResult.size());
        Long expectedGetResult = 1L;
        assertEquals(expectedGetResult, actualModaResult.get(2));
        Long expectedGetResult1 = 1L;
        assertEquals(expectedGetResult1, actualModaResult.get(6));
    }

    @Test
    void ModaTest4() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        Map<Integer, Long> actualModaResult = (new Estatistica(integerList)).moda();
        assertEquals(1, actualModaResult.size());
        Long expectedGetResult = 2L;
        assertEquals(expectedGetResult, actualModaResult.get(2));
    }

    @Test
    void AmplitudeTest1() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        assertEquals(0, (new Estatistica(integerList)).amplitude().intValue());
    }

    @Test
    void AmplitudeTest2() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        assertEquals(0, (new Estatistica(integerList)).amplitude().intValue());
    }
}


