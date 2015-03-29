package com.hack.boyko.junitproblems;

public class ObjectsGlueFactory {

    public static ObjectsGlue createObjectsGlueInstance() {
        return new ObjectsGlue();
    }

    public static void main(String[] args) {
        final ObjectsGlue glue = ObjectsGlueFactory.createObjectsGlueInstance();

        System.out.println(glue.concat(" ", "����", "�����", 5, "������", "������", ')', 4, ')'));
        System.out.println(glue.areObjectsEquals("���� ����� 5 ������ ������ ) 4)",
                glue.concat(" ", "����", "�����", 5, "������", "������", ')', 4, ')')));
    }

}
