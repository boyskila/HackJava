package com.hack.boyko.junitproblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectsGlueTest {

    private final ObjectsGlue glue = ObjectsGlueFactory.createObjectsGlueInstance();

    @Test
    public void concat() {

        assertEquals("���� ����� 5 ������ ������ � ���� ����� ���� �� ����:)",
                glue.concat(" ", "����", "�����", 5, "������", "������", "� ����", "�����", "����", "��", "����:)"));
        assertEquals("���� ����� 5 ������ ������ ) 4 )",
                glue.concat(" ", "����", "�����", 5, "������", "������", ')', 4, ')'));
    }

}
